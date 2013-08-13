package net.taylor.mda.generator.parse.NameRuled.nameRuled;

import net.taylor.mda.generator.parse.entity.WebPageSuffix;
import net.taylor.mda.generator.parse.entity.WebResourcePrefix;
import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.NamedElement;

/**
 * Web url 定义.
 * 
 * @author yonclv
 */
public enum NameRuledWebPathKind implements NameRuledUrlKind<NamedElement> {
	//manager
	jsp_index(WebResourcePrefix.jsp,WebPageSuffix.jsp_index),
	jsp_manager(WebResourcePrefix.jsp,WebPageSuffix.jsp_manager),
	jsp_importExcelFile(WebResourcePrefix.jsp,WebPageSuffix.jsp_importExcelFile),
	jsp_listForSelect(WebResourcePrefix.jsp,WebPageSuffix.jsp_listForSelect),
	jsp_galleryAD(WebResourcePrefix.jsp,WebPageSuffix.jsp_galleryAD),
	jsp_input(WebResourcePrefix.jsp,WebPageSuffix.jsp_input),
	js_input(WebResourcePrefix.js,WebPageSuffix.js_input),
	js_listForSelect(WebResourcePrefix.js,WebPageSuffix.js_listForSelect),
	js_manager(WebResourcePrefix.js,WebPageSuffix.js_manager),
	js_extjs(WebResourcePrefix.js,WebPageSuffix.js_extjs),
	//web site
	jsp_site_list(WebResourcePrefix.jsp_site,WebPageSuffix.jsp_site_list),
	jsp_site_detail(WebResourcePrefix.jsp_site,WebPageSuffix.jsp_site_detail),
	js_site_list(WebResourcePrefix.js_site,WebPageSuffix.js_site_list),
	js_site_detail(WebResourcePrefix.js_site,WebPageSuffix.js_site_detail),
	//web maintain
	maintain_jsp_maintain("/WEB-INF/content","-maintain.jsp"),
	maintain_jsp_edit("/WEB-INF/content","-edit.jsp"),
	maintain_js_maintain("/resources/content","-maintain.js"),
	maintain_js_edit("/resources/content","-edit.js"),
	;

	public String getPreffix() {
		return preffix;
	}

	public String getSuffix() {
		return suffix;
	}

	private String preffix;
	private String suffix;

	private NameRuledWebPathKind(WebResourcePrefix webResourcePrefix, WebPageSuffix webPageSuffix) {
		this.preffix = webResourcePrefix.getValue();
		this.suffix = webPageSuffix.getValue();
	}
	
	private NameRuledWebPathKind(String preffix, String suffix) {
		this.preffix = preffix;
		this.suffix = suffix;
	}

	@Override
	public String getRuleNamed(NamedElement element) {
		return NameHelper.uncapName(this.preffix+NameHelper.getCapName(element)+ this.suffix);
	}
}
