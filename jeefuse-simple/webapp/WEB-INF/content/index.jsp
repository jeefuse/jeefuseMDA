<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>主页-jeefuse快速开发平台</title>
<%@ include file="/common/meta.jsp"%>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('init', ctx, theme);
</script>
<link href="${ctx}/resources/style/default/system/index.css" rel="stylesheet" type="text/css"/>

</head>
<body  class="container">
	  <div id="header">
			<div id="logo">
				<a target="_top" class="logo" href="#" title="jeefuse快速开发平台">
					<img src="${ctx}/resources/style/base/images/jeefuse_logo.png" width="160" height="65"/>
				</a>
			</div>
		</div>	
		<div id="bd" style="">
			<div style="margin-top: 50px;margin-bottom: 200px">
			   <h1>欢迎您使用jeefuse快速开发平台</h1>
   			 	<a href="${ctx}/config-browser/index.vhtml">查看ACTION例表</a>
			</div>
		</div>
		<%@ include file="/common/footer.jsp" %>
</body>		
</html>
