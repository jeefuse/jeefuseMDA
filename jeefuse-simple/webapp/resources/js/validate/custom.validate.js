/*
 * Custom jQuery validation plug-in 1.5
 * author luyancan
 */
(function($) {
	    //字符验证 
	    $.validator.addMethod("userName", function(value, element) { 
	     return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value); 
	    }, "只能包括中文字、英文字母、数字和下划线"); 	    
	    //身份证号码验证 
	    $.validator.addMethod("idCardNo", function(value, element) { 
		  return this.optional(element) || isIdCardNo(value); 
		}, "请正确输入您的身份证号码");
		//手机号码或邮箱验证 
		$.validator.addMethod("mobileOrEmail", function(value, element) { 
		  var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[05-9]{1}))+\d{8})$/;
		  return this.optional(element) || (mobile.test(value)|| /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i.test(value));
		}, "输入手机号码,小灵通或邮箱地址,如13188889999,lvyan@gmail.com");
		//手机号码验证 
		$.validator.addMethod("mobile", function(value, element) { 
		  var length = value.length; 
		  var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
		  return this.optional(element) || (length == 11 && mobile.test(value)); 
		}, "填写您的手机号码,如13188889999"); 
		//固定电话验证 
		$.validator.addMethod("phone", function(value, element) { 
		  var tel = /^\d{3,4}-\d{6,10}(-\d{1,6})?$/g; 
		  return this.optional(element) || (tel.test(value)); 
		}, "填写您的电话号码,如021-88889999-123"); 
		//电话验证(手机或固定电话)
		$.validator.addMethod("tel", function(value,element) {   
			var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;   
			var tel = /^\d{3,4}-\d{7,9}(-\d{1,6})?$/;
			var locTel=/^\d{7,9}$/;
			var tels=value.split(',| ');
			for(var i=0;i<tels.length;i++){
				var matchVal=$.trim(tels[i]);
				var length = matchVal.length;   
				if(this.optional(element) || (tel.test(matchVal)||locTel.test(matchVal) || (length == 11 && mobile.test(matchVal)))){
				}else{
					return false;
				}
			}
			return true;
		}, "联系电话格式:010-12345678, 13188889999");
		//邮政编码验证 
		$.validator.addMethod("zipCode", function(value, element) { 
		   var tel = /^[0-9]{6}$/; 
		   return this.optional(element) || (tel.test(value)); 
		}, "请正确填写您的邮政编码"); 	
		//日期格式yy/mm/dd
		$.validator.addMethod("dateCN",function(value, element) {
			return  this.optional(element) ||((/^\d\d\d\d-\d\d?-\d\d?$/).test(value));
		},"请您输入日期格式 :yyyy-mm-dd, 如2001-12-01");
		// jQuery.validator增加IP验证
		$.validator.addMethod("ip", function(value, element) {
		    return this.optional(element) || (/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/.test(value) && (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256));
		 }, "请您输入正确的IP地址.");
		  // 增加只能是字母和数字的验证
		$.validator.addMethod("letterNum", function(value, element) {
		    //return this.optional(element) || (/^([a-zA-Z0-9]+)$/.test(value) && value.length >= 6 && value.length <= 20);
		    return this.optional(element) || (/^([a-zA-Z0-9_]+)$/.test(value));
		}, "请输入字母或数字或下划线(A-Z, a-z, 0-9,_).");
		$.validator.addMethod("letterUnderline", function(value, element) {
		    //return this.optional(element) || (/^([a-zA-Z0-9]+)$/.test(value) && value.length >= 6 && value.length <= 20);
		    return this.optional(element) || (/^([a-zA-Z_]+)$/.test(value));
		}, "请输入字母或下划线(A-Z, a-z,_).");
})(jQuery);
function isIdCardNo(num) {
	var len = num.length, re;
	if (len == 15)
		re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
	else if (len == 18)
		re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d|x)$/);
	else {
		return false;
	}
	var a = num.match(re);
	if (a != null) {
		var D,B;
		if (len == 15) {
			D = new Date("19" + a[3] + "/" + a[4] + "/" + a[5]);
			B = D.getYear() == a[3] && (D.getMonth() + 1) == a[4]&& D.getDate() == a[5];
		} else {
			D = new Date(a[3] + "/" + a[4] + "/" + a[5]);
			B = D.getFullYear() == a[3] && (D.getMonth() + 1) == a[4]&& D.getDate() == a[5];
		}
		if (!B) {
			return false;
		}
	}
	return true;
}