var Namespace = new Object();
Namespace.register = function(fullNS) {
	var nsArray = fullNS.split('.');
	var sEval = "";
	var sNS = "";
	for ( var i = 0; i < nsArray.length; i++) {
		if (i != 0)
			sNS += ".";
		sNS += nsArray[i];
		sEval += "if (typeof(" + sNS + ") == 'undefined') " + sNS + " = new Object();";
	}
	if (sEval != "")
		eval(sEval);
};
Namespace.register("goolov");
String.prototype.endWith = function(str) {
	if (str == null || str == "" || this.length == 0 || str.length > this.length)
		return false;
	if (this.substring(this.length - str.length) == str)
		return true;
	else
		return false;
	return true;
};

String.prototype.startWith = function(str) {
	if (str == null || str == "" || this.length == 0 || str.length > this.length)
		return false;
	if (this.substr(0, str.length) == str)
		return true;
	else
		return false;
	return true;
};
goolov.winWidth = function(w) {
	var width = w;
	if (width > document.documentElement.clientWidth) {
		width = document.documentElement.clientWidth - 25;
	}
	return width;
};
goolov.winHeight = function(h) {
	var height = h;
	if (height > document.documentElement.clientHeight) {
		height = document.documentElement.clientHeight - 25;
	}
	return height;
};
goolov.addUrlParams = function(url, params) {
	if (!url)
		return null;
	if (-1 != url.indexOf('?')) {
		return url + "&" + params;
	} else {
		return url + "?" + params;
	}
};
goolov.getJsonValue = function(jsonObject, propertyName) {
	if (!jsonObject || !propertyName)
		return null;
	if (propertyName.indexOf('.') != -1) {
		var value = jsonObject;
		var propertyNames = propertyName.split('.');
		for ( var property in propertyNames) {
			var p = propertyNames[property];
			value = value[p];
			if (!value)
				return null;
		}
		return value;
	}
	return jsonObject[propertyName];
};
goolov.getHref = function(url) {
	if (!url)
		return "#";
	if(/^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(url)){
		return url;
	}
	if(url.startWith('/')){
		return ctx+url;
	}
	return ctx+"/"+url;
};
/*
 * 显示消息对话框.
 */
goolov.msgbox = {
	show : function(msg, options) {
		var settings = {
			title : '友情提示',
			msg : msg,
			showType : 'slide'
		};
		if (options) {
			jQuery.extend(settings, options);
		}
		$.messager.show(settings);
	},
	alert : function(msg, fn) {
		$.messager.alert('友情提示', msg, 'info', fn);
	},
	success : function(msg, fn) {
		$.messager.alert('友情提示', msg?msg:'操作成功!', 'success', fn);
	},
	question : function(msg, fn) {
		$.messager.alert('问题提示', msg, 'question', fn);
	},
	error : function(msg, fn) {
		var info = '<div class="error">' + (msg ? msg : '很抱歉,请求出现错误!<br>请检查是否网络中断!') + '</div>';
		$.messager.alert('错误提示', info, 'error', fn);
	},
	warn : function(msg, fn) {
		$.messager.alert('警告提示', msg, 'warning', fn);
	},
	info : function(title, msg, icon, fn) {
		$.messager.alert(title, msg?msg:'未知错误!', icon, fn);
	},
	confirm : function(title, msg, fn) {
		$.messager.confirm(title, msg, fn);
	},
	prompt : function(title, msg, fn) {
		$.messager.prompt(title, msg, fn);
	},
	nologin:function(url){
		var nologinResponse=[];
		nologinResponse.push('<div id="nologinResponseWin" class="v-state-panel v-state-login"  style="display: none;cursor: default">');
		nologinResponse.push('	<div class="content">');
		nologinResponse.push('   	<span class="message">很抱歉,您还未登录或当前会话已过期,需要您重新登录后操作.谢谢!</span>');
		nologinResponse.push('	</div>');
		nologinResponse.push('	<div class="v-button-wrap">');
		nologinResponse.push('		<a  href="javascript:void(0)" id="backToLogin"  rel="nofollow" class="button"><span>转向登录</span></a>');
		nologinResponse.push('		<a  href="javascript:void(0)" id="nologinResponseWinClose" rel="nofollow" class="button"><span>关闭</span></a>');
		nologinResponse.push('	</div>');
		nologinResponse.push('</div>');
		var $nologinResponse=$(nologinResponse.join(""));
		$('#backToLogin',$nologinResponse).click(function(){
				$.unblockUI();
				var href=url?url:ctx+"/site/login/login.vhtml";
				window.open(href);
		});
		$('#nologinResponseWinClose',$nologinResponse).click(function(){
			$.unblockUI();
		});
		$.blockUI({ message: $nologinResponse, fadeIn : 100,fadeOut : 50,
					css: {width: '350px',border : '2px solid #99BBE8',padding : '0px',top: '30%',left : '35%',cursor: 'pointer',opacity : 3,backgroundColor : '#fff' },
					overlayCSS : {backgroundColor : '#000',opacity : 0.3,cursor : 'default'}
		 });
	}
};
/*
 * 显示Growl即时提示信息框. 结合jquery.blockUI.
 */
goolov.growl = {
	waiting : function(msg, options) {
		var $m = $('<div class="waiting_container"></div>');
		$m.append('<div class="message">' + (msg ? msg : '处理中 . . . ') + '</div>');
		var settings = {
			message : $m,
			showOverlay : true,
			fadeIn : 100,
			fadeOut : 100,
			css : {
				zIndex : 120000,
				border : '2px solid #99BBE8',
				color : 'blue',
				padding : '15px 10px',
				width : '250px',
				backgroundColor : '#fff',
				'-webkit-border-radius' : '2px',
				'-moz-border-radius' : '2px',
				cursor : 'default'
			},
			overlayCSS : {
				backgroundColor : '#666',
				opacity : 0.6,
				cursor : 'default'
			}
		};
		if (options) {
			jQuery.extend(settings, options);
		}
		$.blockUI(settings);
	},
	unwaiting : function() {
		$.unblockUI();
	},
	show : function(msg, content, cssClass, timeout, onClose) {
		var $m = $('<div class="growl"></div>');
		if (msg)
			$m.append('<div class="message">' + msg + '</div>');
		if (content)
			$m.append('<div class="content">' + content + '</div>');
		if (cssClass)
			$m.addClass(cssClass);
		if (!timeout)
			timeout = 3000;
		$.blockUI({
			message : $m,
			fadeIn : 200,
			fadeOut : 300,
			timeout : timeout,
			showOverlay : false,
			centerY : false,
			css : {
				width : '185px',
				top : '10px',
				right : '20px',
//				left: '35%',
//				top: '20%',
				color : 'blue',
				'font-weight' : 'bold',
				'font-size' : '108%',
				border : '2px solid #99BBE8',
				padding : '10px 5px',
				backgroundColor : '#FBFBEF',// '#F5F6CE',
				'-webkit-border-radius' : '3px',
				'-moz-border-radius' : '3px',
				opacity : 10,
				color : 'blue',
				cursor : 'default'
			}
		});
	},
	warn : function(msg, content, timeout, onClose) {
		goolov.growl.show(msg, content, 'warn', timeout, onClose);
	},
	info : function(msg, content, timeout, onClose) {
		goolov.growl.show(msg, content, 'info', timeout, onClose);
	},
	success : function(msg, content, timeout, onClose) {
		goolov.growl.show(msg, content, 'success', timeout, onClose);
	},
	error : function(msg, content, timeout, onClose) {
		goolov.growl.show(msg, content, 'error', timeout, onClose);
	},
	notify : function(msg, content, timeout, onClose) {
		goolov.growl.show(msg, content, 'notify', timeout, onClose);
	}
};
/*
 * 创建并加载iframe.用于当前元素下没有Iframe元素.
 * 
 * id 包含Iframe的元素ID , url指向的链接
 */
goolov.loadIframeContent = function(id, url, scrolling, autoAdjustIframHeight) {
	var me = $("#" + id);
	var contentId = id + "Content";
	var iframeId = contentId + "Iframe";
	var html = [];
	html.push('<div id="', contentId, '" style="width:100%;height:100%;">');
	html
			.push(
					'<iframe id="',
					iframeId,
					'" frameborder="0"  src="',
					url,
					'"  width="100%" height="100%" marginwidth="0" marginheight="0" frameborder="0" scrolling="',
					scrolling ? scrolling : "no",
					'" allowtransparency="true"',
					autoAdjustIframHeight ? ' onload="adjustIframeHeight(this);" '
							: "", "></iframe>");
	html.push("</div>");
	me.empty().append(html.join(""));
	goolov.loadIFrame(contentId, url);
};
goolov.loadIFrame = function(contentId, url) {
	var $content = $("#" + contentId);
	var iFrame = $("iframe:first", $content);
	var iframeId = iFrame.attr("id");
	$content
			.block({
				message : '<div class="page-progress" style="display:block"><div class="page-progress-content"></div></div>',
				showOverlay : false,
				fadeIn : 0,
				fadeOut : 0,
				cursor : "pointer",
				css : {
					border : "0px solid #aaceff",
					width : "32px",
					height : "32px"
				},
				overlayCSS : {
					backgroundColor : "#666",
					opacity : 0.3,
					cursor : "default"
				}
			});
	var oFrm = document.getElementById(iframeId);
	oFrm.onload = oFrm.onreadystatechange = function() {
		if (this.readyState && this.readyState != "complete") {
		} else {
			$("#" + contentId).unblock();
		}
	};
	oFrm.src = url;
};
/*
 * winbox wrap jquery.easyui win.
 */
goolov.winbox = function(options) {
	this.settings = {
		icon : 'icon-new',
		width : 560,
		height : 390,
		closed : true,
		minimizable : false,
		maximizable : true,
		resizable : false,
		neeedReLoad : true,// 是否需要重新刷新iframe链接
		id : null,// 元素ID
		contentId : null,// 元素ID包裹的显示内容的元素ID
		title : 'new window'
	};
	if (options) {
		jQuery.extend(this.settings, options);
	}
	var isLoad = false;
	this.win = null;
	this.initWin = function() {
		if (this.settings.id && this.settings.contentId) {
			this.id = this.settings.id;
			this.contentId = this.settings.contentId;
			this.win = $('#' + this.id).window(this.settings);
		} else {
			this.id = "winbox_" + new Date().getTime();
			this.contentId = this.id + "Content";
			this.iframeId = this.contentId + "Iframe";
			var html=[];
			html.push('<div id="',this.id,'" icon="',this.settings.icon,
					'" title="',this.settings.title,
					'" style="width:0px;height:0px;visibility:hidden" >');
			html.push(	'<div id="',this.contentId,'" style="width:100%;height:100%;">');
			html.push(		'<iframe id="',this.iframeId,'" frameborder="0"  src=""  width="100%" height="100%" marginwidth="0" marginheight="0" scrolling="auto"></iframe>');
			html.push(	'</div>' );
			html.push('</div>');
			$("BODY").append(html.join(""));
			this.win = $('#' + this.id).window(this.settings);
//			$('#' + this.id).css('display', 'block');
			$("#" + this.id).css("visibility", "visible");
		}
	};
	this.open = function(paramOptions) {
		var options = paramOptions ? paramOptions : {};
		if (!this.win) {
			this.initWin();
		}
		this.win.window( {
			zIndex : $.fn.window.defaults.zIndex++
		});
		this.win.window('open');
		jQuery.extend(this.settings, options);
		this.win.window('setTitle', this.settings.title);
		if (isLoad && !this.settings.neeedReLoad) {
			return;
		} else {
			$('iframe', this.win).attr('src', '');
			goolov.loadIFrame(this.contentId, this.settings.url);
			isLoad = true;
		}
	};
	this.setTitle = function(title) {
		if (!this.win) {
			this.initWin();
			this.win.window({
				zIndex : $.fn.window.defaults.zIndex++
			});
			this.win.window('open');
		}
		this.win.window('setTitle', title);
	};
	this.refresh = function() {
		this.isLoad = false;
		this.open();
	};
	this.close = function() {
		this.win.window('close');
		$('iframe', this.win).attr('src', '');
		isLoad = false;
	};
	this.destroy = function() {
		$('iframe', this.win).attr('src', '');
		this.win.window('destroy');
		for (var k in this) {
			this[k] = null;
		}
	};
};
/* 文件验证 */
goolov.validete = {
	/* 上传文件验证 */
	file : function(e, paramExtention) {
		var extention = paramExtention ? paramExtention : "rar|txt|xlsx|xls|doc|docx|zip|cvs|xml|xls";
		var fileext = e.value.substring(e.value.lastIndexOf(".") + 1, e.value.length);
		var allowexts = extention.split("|");
		for ( var i = 0; i < allowexts.length; i++) {
			var allowext = allowexts[i];
			if (allowext.toLowerCase() == fileext.toLowerCase()) {
				return true;
			}
		}
		if($.messager){
			goolov.msgbox.warn("文件格式错误,允许上传的文件格式为:<br/>" + allowexts.join(","));
		}else{
			alert("文件格式错误,允许上传的文件格式为:<br/>" + allowexts.join(","));
		}
		goolov.file.clear(e.id);
		// e.focus();
	return false;
},
/* 上传图片验证 */
image : function(e) {
	var fileext = e.value.substring(e.value.lastIndexOf(".") + 1, e.value.length);
	var extention = "jpg|gif|jpeg|png";
	var allowexts = extention.split("|");
	for ( var i = 0; i < allowexts.length; i++) {
		var allowext = allowexts[i];
		if (allowext.toLowerCase() == fileext.toLowerCase()) {
			return true;
		}
	}
	if($.messager){
		goolov.msgbox.warn("图片格式错误,支持的图片格式为:" + allowexts.join(","));
	}else{
		alert("图片格式错误,支持的图片格式为:" + allowexts.join(","));
	}
	goolov.file.clear(e.id);
	return false;
}
};
/* 上传文件清空 */
goolov.file = {
	imageExt : 'jpg|gif|jpeg|png',
	imageExtSemicolon:'*.jpg;*.gif;*.jpeg;*.png',
	imageDesc:'请选择.jpg;.gif;.jpeg;.png类型图片',
	fileExt : 'rar|txt|xlsx|xls|doc|docx|zip|cvs|xml|xls',
	previewImage : function(e, options) {
		var setting = {
			previewWrapId : null,
			maxWidth:null,
			maxHeight:null,
			imgCss:{}
		};
		$.extend(setting, options ? options : {});
		var me = e;
		var previewWrap = document.getElementById(setting.previewWrapId);
		var $previewWrap = $(previewWrap);
		if (!goolov.validete.image(me)) {
			return;
		}
		var $img = $('<img />');
		if ($.browser.msie) {
			$img.attr("src", $(me).val());
		} else {
			$img.attr("src", $(me)[0].files[0].getAsDataURL());
		}
		$img.css(setting.imgCss);
		$img.attr("alt", '图片预览');
		$previewWrap.html($img);
		if(setting.width)
			$img.attr("width", setting.width);
		if(setting.height)
			$img.attr("height", setting.height);
		if(setting.maxWidth){
			if($img.width()>setting.maxWidth){
				$img.attr("width", setting.maxWidth);
			}
		}
		if(setting.maxHeight){
			if($img.height()>setting.maxHeight){
				$img.attr("height", setting.maxHeight);
			}
		}
		if ($.browser.msie && $.browser.version > 6) {
			$img.hide();
			$previewWrap.css({'z-index': '999',
				'filter': 'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)',
				'max-width': setting.width + 'px', 'max-height': setting.height + 'px',
				'width': setting.width + 'px', 'height': setting.height + 'px'
			});
			previewWrap.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = $img.attr("src");
		}
	/* }); */
},
clear : function(id) {
	var up = (typeof id == "string") ? document.getElementById(id) : id;
	if (typeof up != "object")
		return null;
	var tt = document.createElement("span");
	tt.id = "__tt__";
	up.parentNode.insertBefore(tt, up);
	var tf = document.createElement("form");
	tf.appendChild(up);
	document.getElementsByTagName("body")[0].appendChild(tf);
	tf.reset();
	tt.parentNode.insertBefore(up, tt);
	tt.parentNode.removeChild(tt);
	tt = null;
	tf.parentNode.removeChild(tf);
},
clearForm : function() {
	var inputs, frm;
	if (arguments.length == 0) {
		inputs = document.getElementsByTagName("input");
	} else {
		frm = (typeof arguments[0] == "string") ? document.getElementById(arguments[0]) : arguments[0];
		if (typeof frm != "object")
			return null;
		inputs = frm.getElementsByTagName("input");
	}
	var fs = [];
	for ( var i = 0; i < inputs.length; i++) {
		if (inputs[i].type == "file")
			fs[fs.length] = inputs[i];
	}
	var tf = document.createElement("form");
	for ( var i = 0; i < fs.length; i++) {
		var tt = document.createElement("span");
		tt.id = "__tt__" + i;
		fs[i].parentNode.insertBefore(tt, fs[i]);
		tf.appendChild(fs[i]);
	}
	document.getElementsByTagName("body")[0].appendChild(tf);
	tf.reset();
	for ( var i = 0; i < fs.length; i++) {
		var tt = document.getElementById("__tt__" + i);
		tt.parentNode.insertBefore(fs[i], tt);
		tt.parentNode.removeChild(tt);
	}
	tf.parentNode.removeChild(tf);
}
};
goolov.encrypt=function(str){
	return calcMD5(str);
};
goolov.searchPut=function(inputEleId,value,url,formId){
	document.getElementById(inputEleId).value=value;
	var href=goolov.addUrlParams(url,$('#'+formId).serialize());
	window.location.href=href; 
};
function formatFloat(src, pos) {
	return Math.round(src * Math.pow(10, pos)) / Math.pow(10, pos);
}
function formatnumber(value, num) {
	var a, b, c, i;
	a = value.toString();
	b = a.indexOf(".");
	c = a.length;
	if (num == 0) {
		if (b != -1) {
			a = a.substring(0, b);
		}
	} else {
		if (b == -1) {
			a = a + ".";
			for (i = 1; i <= num; i++) {
				a = a + "0";
			}
		} else {
			a = a.substring(0, b + num + 1);
			for (i = c; i <= b + num; i++) {
				a = a + "0";
			}
		}
	}
	return a;
}
// 对数字进行四舍五入计算
function round(num,n){
    var   dd=1;  
    var   tempnum;  
    for(var i=0;i<n;i++){  
        dd*=10;  
    }  
    tempnum=num*dd;  
    tempnum=Math.round(tempnum);
    return formatnumber(tempnum/dd,n);  
}
(function($) {
	$(document).ready(function(){
		$('input:text,input:password,select,textarea').focus(function() {
			$(this).addClass("text-focus");
		}).blur(function() {
			$(this).removeClass("text-focus");
		});
	});
})(jQuery);