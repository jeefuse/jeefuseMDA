<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>您还未登入&mdash;jeefuse/title>

</head>
<body>
	<div style="margin: 50px auto;width: 650px" class="v-content-wrap">
		<h2>由于会话过期或您还未登录.请您登录后操作!</h2>
		<div style="margin-top: 50px;">
			<a href="<c:url value="/system/login.vhtml"/>" target="_top">转到登录</a>
		</div>
	</div>
</body>
</html>
