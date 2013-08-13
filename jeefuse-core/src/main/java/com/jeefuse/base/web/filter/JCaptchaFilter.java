package com.jeefuse.base.web.filter;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.octo.captcha.service.CaptchaService;
import com.octo.captcha.service.CaptchaServiceException;

/**
 * 集成JCaptcha的Filter.
 * 
 * 可通过配置与SpringSecurity相同的登录表单处理URL与身份验证失败URL,实现与SpringSecurity的集成.
 * 另,本filter主要演示集成的方式，用户可参考本filter将其他验证码方案与SpringSecurity进行集成.
 * 
 * 在web.xml中配置的参数包括：
 * 1.failureUrl -- 身份验证失败后跳转的URL,与SpringSecurity中的配置保持一致,无默认值必须配置.
 * 2.filterProcessesUrl -- 登录表单处理URL,与SpringSecurity中的配置一致,默认为"/j_spring_security_check".
 * 3.captchaServiceId -- captchaService在Spring ApplicationContext中的bean id,默认为"captchaService".
 * 4.captchaParamter -- 登录表单中验证码Input框的名称,默认为"j_captcha".
 * 
 * 
 * @author calvin
 */
public class JCaptchaFilter implements Filter {

	//web.xml中的参数名定义
	private static final String CAPTCHA_PARAMTER_NAME = "captchaParamterName";
	private static final String CAPTCHA_SERVICE_ID_NAME = "captchaServiceId";
	private static final String FILTER_PROCESSES_URL_NAME = "filterProcessesUrl";
	private static final String FAILURE_URL_NAME = "failureUrl";
	private static final int ERROR_CODE = 3;

	//默认值定义
	private static final String DEFAULT_FILTER_PROCESSES_URL = "/goolov_security_check";
	private static final String FILTER_REGISTER_URL = "/site/regist/registerMenberInfo.vhtml";
	private static final String FILTER_REGISTER_SHOP_URL = "/site/regist/shop/registerMenberInfo.vhtml";
	private static final String DEFAULT_CAPTCHA_SERVICE_ID = "captchaService";
	private static final String DEFAULT_CAPTCHA_PARAMTER = "j_captcha";

	private static Logger logger = LoggerFactory.getLogger(JCaptchaFilter.class);

	private String failureUrl;
	private String filterProcessesUrl = DEFAULT_FILTER_PROCESSES_URL;
	private String captchaServiceId = DEFAULT_CAPTCHA_SERVICE_ID;
	private String captchaParamter = DEFAULT_CAPTCHA_PARAMTER;

	private CaptchaService captchaService = null;

	public void init(final FilterConfig fConfig) throws ServletException {
		initParameters(fConfig);
		initCaptchaService(fConfig);
	}

	/**
	 * 初始化web.xml中定义的filter init-param.
	 */
	private void initParameters(final FilterConfig fConfig) {
		if (StringUtils.isBlank(fConfig.getInitParameter(FAILURE_URL_NAME)))
			throw new IllegalArgumentException("CaptchaFilter缺少failureUrl参数");
		failureUrl = fConfig.getInitParameter(FAILURE_URL_NAME);

		if (StringUtils.isNotBlank(fConfig.getInitParameter(FILTER_PROCESSES_URL_NAME))) {
			filterProcessesUrl = fConfig.getInitParameter(FILTER_PROCESSES_URL_NAME);
		}

		if (StringUtils.isNotBlank(fConfig.getInitParameter(CAPTCHA_SERVICE_ID_NAME))) {
			captchaServiceId = fConfig.getInitParameter(CAPTCHA_SERVICE_ID_NAME);
		}

		if (StringUtils.isNotBlank(fConfig.getInitParameter(CAPTCHA_PARAMTER_NAME))) {
			captchaParamter = fConfig.getInitParameter(CAPTCHA_PARAMTER_NAME);
		}
	}

	/**
	 * 从ApplicatonContext获取CaptchaService实例.
	 */
	private void initCaptchaService(final FilterConfig fConfig) {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(fConfig.getServletContext());
		captchaService = (CaptchaService) context.getBean(captchaServiceId);
	}

	public void destroy() {
	}

	public void doFilter(final ServletRequest theRequest, final ServletResponse theResponse, final FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) theRequest;
		HttpServletResponse response = (HttpServletResponse) theResponse;
		String servletPath = request.getServletPath();
		//符合filterProcessesUrl为验证处理请求,其余为生成验证图片请求.
		if (StringUtils.startsWith(servletPath, filterProcessesUrl)
				|| StringUtils.startsWith(servletPath, FILTER_REGISTER_URL)) {
			boolean validated = validateCaptchaChallenge(request);
			if (validated) {
				chain.doFilter(request, response);
			} else {
				redirectFailureUrl(request, response);
			}
		} else {
			genernateCaptchaImage(request, response);
		}
	}

	/**
	 * 生成验证码图片.
	 */
	private void genernateCaptchaImage(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		ServletOutputStream out = response.getOutputStream();
		try {
			String captchaId = request.getSession(true).getId();
			BufferedImage challenge = (BufferedImage) captchaService.getChallengeForID(captchaId, request.getLocale());
			ImageIO.write(challenge, "jpg", out);
			out.flush();
		} catch (CaptchaServiceException e) {
			logger.error(e.getMessage(), e);
		} finally {
			out.close();
		}
	}

	/**
	 * 验证验证码. 
	 */
	private boolean validateCaptchaChallenge(final HttpServletRequest request) {
		if (request.getSession(false) == null)
			return false;

		try {
			String captchaID = request.getSession().getId();
			String challengeResponse = request.getParameter(captchaParamter);
			return captchaService.validateResponseForID(captchaID, challengeResponse);
		} catch (CaptchaServiceException e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}

	/**
	 * 跳转到失败页面.
	 * 
	 * 可在子类进行扩展，比如在session中放入SpringSecurity的Exception.
	 */
	protected void redirectFailureUrl(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		String servletPath = request.getServletPath();
		if (servletPath.startsWith(FILTER_REGISTER_URL)) {
			response.sendRedirect(request.getContextPath() + "/site/regist/register.vhtml?error=" + ERROR_CODE);
		} else if (servletPath.startsWith(FILTER_REGISTER_SHOP_URL)) {
			response.sendRedirect(request.getContextPath() + "/site/regist/shop/register.vhtml?error=" + ERROR_CODE);
		} else {
			response.sendRedirect(request.getContextPath() + failureUrl);
		}
	}
}
