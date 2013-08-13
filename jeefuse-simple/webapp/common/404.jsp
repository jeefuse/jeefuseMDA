<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>404 - 页面不存在&mdash;jeefuse</title>

<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('site', ctx, theme);
</script>
<style type="text/css">
.user-action{margin-top: 15px;margin-bottom: 30px;clear: both;font-size: 13px}
.user-action .title{float: left;font-weight: bold;}
.user-action ul{list-style: none;margin: 0px;margin-left: 10px}
.user-action ul li{float: left;margin-left: 10px;}
.error-wrap{color: red;}
</style>
<script type="text/javascript">
</script>
</head>
<body>
	<div id="header" style="margin-top: 20px;">
		 <h1 id="logo">
	          <img src="${ctx}/resources/style/base/images/jeefuse_logo.png" width="160" height="56"/>
	     </h1>
	</div>
	<div id="bd"><!-- bd start -->
		<div id="content">
		    	<div class="v-notice-wrap v-notice-error" style="margin: 30px auto 50px;">
			    		<div class="hd error">
				    		<div class="title">很抱歉,您访问的页面不存在.</div>
				    		<div class="subTitle">
				    			<c:if test="${null!=actionErrorsOrNull}">
					    			<div class="error-wrap">
							    		<c:forEach items="${actionErrors}" var="error">
							    			${error}
							    		</c:forEach>
					    			</div>
					    		</c:if>
				    			若您操作中遇到困难，或有什么需求及建议,欢迎您与客服人员联系，
				    			祝您愉快!
				    		</div>
			    		</div>
			    </div>
	    	</div>
	</div><!-- bd end -->
	
</body>
</html>
