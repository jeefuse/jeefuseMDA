/* 日期时间脚本库方法列表   
 Date.prototype.isLeapYear 判断闰年   
 Date.prototype.FormatString 日期格式化   
 Date.prototype.DateAdd 日期计算   
 Date.prototype.DateDiff 比较日期差   
 Date.prototype.toString 日期转字符串   
 Date.prototype.toArray 日期分割为数组   
 Date.prototype.DatePart 取日期的部分信息   
 Date.prototype.MaxDayOfDate 取日期所在月的最大天数   
 Date.prototype.WeekNumOfYear 判断日期所在年的第几周   
 StringToDate 字符串转日期型   
 IsValidDate 验证日期有效性   
 CheckDateTime 完整日期时间检查   
 daysBetween 日期天数差   

 js 代码  */
// ---------------------------------------------------
Date.prototype.isLeapYear = function() {
	return (0 == this.getYear() % 4 && ((this.getYear() % 100 != 0) || (this
			.getYear() % 400 == 0)));
};

// ---------------------------------------------------
// 日期格式化
// 格式 YYYY/yyyy/YY/yy 表示年份
// MM/M 月份
// W/w 星期
// dd/DD/d/D 日期
// hh/HH/h/H 时间
// mm/m 分钟
// ss/SS/s/S 秒
// ---------------------------------------------------
Date.prototype.FormatString = function(formatStr) {
	var str = formatStr;
	var Week = [ '日', '一', '二', '三', '四', '五', '六' ];

	str = str.replace(/yyyy|YYYY/, this.getFullYear());
	str = str.replace(/yy|YY/,
			(this.getYear() % 100) > 9 ? (this.getYear() % 100).toString()
					: '0' + (this.getYear() % 100));

	str = str.replace(/MM/, this.getMonth() > 9 ? this.getMonth().toString()
			: '0' + this.getMonth());
	str = str.replace(/M/g, this.getMonth());

	str = str.replace(/w|W/g, Week[this.getDay()]);

	str = str.replace(/dd|DD/, this.getDate() > 9 ? this.getDate().toString()
			: '0' + this.getDate());
	str = str.replace(/d|D/g, this.getDate());

	str = str.replace(/hh|HH/, this.getHours() > 9 ? this.getHours().toString()
			: '0' + this.getHours());
	str = str.replace(/h|H/g, this.getHours());
	str = str.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes()
			.toString() : '0' + this.getMinutes());
	str = str.replace(/m/g, this.getMinutes());

	str = str.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds()
			.toString() : '0' + this.getSeconds());
	str = str.replace(/s|S/g, this.getSeconds());

	return str;
};

// +---------------------------------------------------
// | 求两个时间的天数差 日期格式为 YYYY-MM-dd
// +---------------------------------------------------
function daysBetween(DateOne, DateTwo) {
	var OneMonth = DateOne.substring(5, DateOne.lastIndexOf('-'));
	var OneDay = DateOne
			.substring(DateOne.length, DateOne.lastIndexOf('-') + 1);
	var OneYear = DateOne.substring(0, DateOne.indexOf('-'));

	var TwoMonth = DateTwo.substring(5, DateTwo.lastIndexOf('-'));
	var TwoDay = DateTwo
			.substring(DateTwo.length, DateTwo.lastIndexOf('-') + 1);
	var TwoYear = DateTwo.substring(0, DateTwo.indexOf('-'));

	var cha = ((Date.parse(OneMonth + '/' + OneDay + '/' + OneYear) - Date
			.parse(TwoMonth + '/' + TwoDay + '/' + TwoYear)) / 86400000);
	return Math.abs(cha);
};

// +---------------------------------------------------
// | 日期计算
// +---------------------------------------------------
Date.prototype.DateAdd = function(strInterval, Number) {
	var dtTmp = this;
	switch (strInterval) {
	case 's':
		return new Date(Date.parse(dtTmp) + (1000 * Number));
	case 'n':
		return new Date(Date.parse(dtTmp) + (60000 * Number));
	case 'h':
		return new Date(Date.parse(dtTmp) + (3600000 * Number));
	case 'd':
		return new Date(Date.parse(dtTmp) + (86400000 * Number));
	case 'w':
		return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
	case 'q':
		return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number * 3,
				dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp
						.getSeconds());
	case 'm':
		return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp
				.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp
				.getSeconds());
	case 'y':
		return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp
				.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp
				.getSeconds());
	}
};

// +---------------------------------------------------
// | 比较日期差 dtEnd 格式为日期型或者 有效日期格式字符串
// +---------------------------------------------------
Date.prototype.DateDiff = function(strInterval, dtEnd) {
	var dtStart = this;
	if (typeof dtEnd == 'string')// 如果是字符串转换为日期型
	{
		dtEnd = StringToDate(dtEnd);
	}
	switch (strInterval) {
	case 's':
		return parseInt((dtEnd - dtStart) / 1000);
	case 'n':
		return parseInt((dtEnd - dtStart) / 60000);
	case 'h':
		return parseInt((dtEnd - dtStart) / 3600000);
	case 'd':
		return parseInt((dtEnd - dtStart) / 86400000);
	case 'w':
		return parseInt((dtEnd - dtStart) / (86400000 * 7));
	case 'm':
		return (dtEnd.getMonth() + 1)
				+ ((dtEnd.getFullYear() - dtStart.getFullYear()) * 12)
				- (dtStart.getMonth() + 1);
	case 'y':
		return dtEnd.getFullYear() - dtStart.getFullYear();
	}
};

// +---------------------------------------------------
// | 日期输出字符串，重载了系统的toString方法
// +---------------------------------------------------
//Date.prototype.toString = function(showWeek) {
//	var myDate = this;
//	var str = myDate.toLocaleDateString();
//	if (showWeek) {
//		var Week = [ '日', '一', '二', '三', '四', '五', '六' ];
//		str += ' 星期' + Week[myDate.getDay()];
//	}
//	return str;
//};
 /**   
  * 对Date的扩展，将 Date 转化为指定格式的String   
  * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符   
  * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
  * eg:   
  * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
  * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04   
  * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04   
  * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04   
  * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18   
  */    
Date.prototype.pattern=function(fmt) {     
     var o = {     
     "M+" : this.getMonth()+1, //月份     
     "d+" : this.getDate(), //日     
     "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时     
     "H+" : this.getHours(), //小时     
     "m+" : this.getMinutes(), //分     
     "s+" : this.getSeconds(), //秒     
     "q+" : Math.floor((this.getMonth()+3)/3), //季度     
     "S" : this.getMilliseconds() //毫秒     
     };     
     var week = {     
     "0" : "\u65e5",     
     "1" : "\u4e00",     
     "2" : "\u4e8c",     
     "3" : "\u4e09",     
     "4" : "\u56db",     
     "5" : "\u4e94",     
     "6" : "\u516d"    
     };     
     if(/(y+)/.test(fmt)){     
         fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));     
     }     
     if(/(E+)/.test(fmt)){     
         fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);     
     }     
     for(var k in o){     
         if(new RegExp("("+ k +")").test(fmt)){     
             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));     
         }     
     }     
     return fmt;     
 };