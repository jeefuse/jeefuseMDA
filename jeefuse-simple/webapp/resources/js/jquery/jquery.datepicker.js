(function($) {
    var userAgent = window.navigator.userAgent.toLowerCase();
    $.browser.msie8 = $.browser.msie && /msie 8\.0/i.test(userAgent);
    $.browser.msie7 = $.browser.msie && /msie 7\.0/i.test(userAgent);
    $.browser.msie6 = !$.browser.msie8 && !$.browser.msie7 && $.browser.msie && /msie 6\.0/i.test(userAgent);

    Date.prototype.Format = function(format) {
        var o = {
            "M+": this.getMonth() + 1,
            "d+": this.getDate(),
            "h+": this.getHours(),
            "H+": this.getHours(),
            "m+": this.getMinutes(),
            "s+": this.getSeconds(),
            "q+": Math.floor((this.getMonth() + 3) / 3),
            "w": "0123456".indexOf(this.getDay()),
            "S": this.getMilliseconds()
        };
        if (/(y+)/.test(format)) {
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        }
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(format))
                format = format.replace(RegExp.$1,
          RegExp.$1.length == 1 ? o[k] :
            ("00" + o[k]).substr(("" + o[k]).length));
        }
        return format;
    };
    function DateAdd(interval, number, idate) {
        number = parseInt(number);
        var date;
        if (typeof (idate) == "string") {
            date = idate.split(/\D/);
            eval("var date = new Date(" + date.join(",") + ")");
        }

        if (typeof (idate) == "object") {
            date = new Date(idate.toString());
        }
        switch (interval) {
            case "y": date.setFullYear(date.getFullYear() + number); break;
            case "m": date.setMonth(date.getMonth() + number); break;
            case "d": date.setDate(date.getDate() + number); break;
            case "w": date.setDate(date.getDate() + 7 * number); break;
            case "h": date.setHours(date.getHours() + number); break;
            case "n": date.setMinutes(date.getMinutes() + number); break;
            case "s": date.setSeconds(date.getSeconds() + number); break;
            case "l": date.setMilliseconds(date.getMilliseconds() + number); break;
        }
        return date;
    };
    $.fn.datepicker = function(o) {
        var def = {
            weekStart: 0,
            weekName: ["日", "一", "二", "三", "四", "五", "六"], //星期的格式
            monthName: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"], //月份的格式
            monthp: "月",
            Year: new Date().getFullYear(), //定义年的变量的初始值
            Month: new Date().getMonth() + 1, //定义月的变量的初始值
            Day: new Date().getDate(), //定义日的变量的初始值
            today: new Date(),
            btnOk: " 确定 ",
            btnCancel: " 取消 ",
            btnToday: "今天",
            inputDate: null,
            onReturn: false,
            version: "1.1",
            applyrule: false, //function(){};return rule={startdate,endate};
            showtarget: null,
            picker: '<span class="v-field-trigger x-field-date-trigger"/>'
        };
        $.extend(def, o);
        var cp = $("#BBIT_DP_CONTAINER");
        if (cp.length == 0) {
            var cpHA = [];
            cpHA.push("<div id='BBIT_DP_CONTAINER' class='bbit-dp' style='width:175px;z-index:999;'>");
            if ($.browser.msie6) {
                cpHA.push('<iframe style="position:absolute;z-index:-1;width:100%;height:205px;top:0;left:0;scrolling:no;" frameborder="0" src="about:blank"></iframe>');
            }
            cpHA.push("<table class='dp-maintable' cellspacing='0' cellpadding='0' style='width:175px;'><tbody><tr><td>");
            //头哟
            cpHA.push("<table class='bbit-dp-top' cellspacing='0'><tr><td class='bbit-dp-top-left'> <a id='BBIT_DP_LEFTBTN' href='javascript:void(0);' title='向前一个月'>&nbsp;</a></td><td class='bbit-dp-top-center' align='center'><em><button id='BBIT_DP_YMBTN'>九月 2009</button></em></td><td class='bbit-dp-top-right'><a id='BBIT_DP_RIGHTBTN' href='javascript:void(0);' title='向后一个月'>&nbsp;</a></td></tr></table>");
            cpHA.push("</td></tr>");
            cpHA.push("<tr><td>");
            //周
            cpHA.push("<table id='BBIT_DP_INNER' class='bbit-dp-inner' cellspacing='0'><thead><tr>");
            //生成周
            for (var i = def.weekStart, j = 0; j < 7; j++) {
                cpHA.push("<th><span>", def.weekName[i], "</span></th>");
                if (i == 6) { i = 0; } else { i++; }
            }
            cpHA.push("</tr></thead>");
            //生成tBody,需要重新生成的
            cpHA.push("<tbody></tbody></table>");
            //生成tBody结束
            cpHA.push("</td></tr>");
            cpHA.push("<tr><td class='bbit-dp-bottom' align='center'><button id='BBIT-DP-TODAY'>", def.btnToday, "</button></td></tr>");
            cpHA.push("</tbody></table>");
            //输出下来框
            cpHA.push("<div id='BBIT-DP-MP' class='bbit-dp-mp'  style='z-index:auto;'><table id='BBIT-DP-T' style='width: 175px; height: 193px' border='0' cellspacing='0'><tbody>");
            cpHA.push("<tr>");
            //1月，7月 按钮两个
            cpHA.push("<td class='bbit-dp-mp-month' xmonth='0'><a href='javascript:void(0);'>", def.monthName[0], "</a></td><td class='bbit-dp-mp-month bbit-dp-mp-sep' xmonth='6'><a href='javascript:void(0);'>", def.monthName[6], "</a></td><td class='bbit-dp-mp-ybtn' align='middle'><a id='BBIT-DP-MP-PREV' class='bbit-dp-mp-prev'></a></td><td class='bbit-dp-mp-ybtn' align='middle'><a id='BBIT-DP-MP-NEXT' class='bbit-dp-mp-next'></a></td>");
            cpHA.push("</tr>");
            cpHA.push("<tr>");
            cpHA.push("<td class='bbit-dp-mp-month' xmonth='1'><a href='javascript:void(0);'>", def.monthName[1], "</a></td><td class='bbit-dp-mp-month bbit-dp-mp-sep' xmonth='7'><a href='javascript:void(0);'>", def.monthName[7], "</a></td><td class='bbit-dp-mp-year'><a href='javascript:void(0);'></a></td><td class='bbit-dp-mp-year'><a href='javascript:void(0);'></a></td>");
            cpHA.push("</tr>");
            cpHA.push("<tr>");
            cpHA.push("<td class='bbit-dp-mp-month' xmonth='2'><a href='javascript:void(0);'>", def.monthName[2], "</a></td><td class='bbit-dp-mp-month bbit-dp-mp-sep' xmonth='8'><a href='javascript:void(0);'>", def.monthName[8], "</a></td><td class='bbit-dp-mp-year'><a href='javascript:void(0);'></a></td><td class='bbit-dp-mp-year'><a href='javascript:void(0);'></a></td>");
            cpHA.push("</tr>");
            cpHA.push("<tr>");
            cpHA.push("<td class='bbit-dp-mp-month' xmonth='3'><a href='javascript:void(0);'>", def.monthName[3], "</a></td><td class='bbit-dp-mp-month bbit-dp-mp-sep' xmonth='9'><a href='javascript:void(0);'>", def.monthName[9], "</a></td><td class='bbit-dp-mp-year'><a href='javascript:void(0);'></a></td><td class='bbit-dp-mp-year'><a href='javascript:void(0);'></a></td>");
            cpHA.push("</tr>");

            cpHA.push("<tr>");
            cpHA.push("<td class='bbit-dp-mp-month' xmonth='4'><a href='javascript:void(0);'>", def.monthName[4], "</a></td><td class='bbit-dp-mp-month bbit-dp-mp-sep' xmonth='10'><a href='javascript:void(0);'>", def.monthName[10], "</a></td><td class='bbit-dp-mp-year'><a href='javascript:void(0);'></a></td><td class='bbit-dp-mp-year'><a href='javascript:void(0);'></a></td>");
            cpHA.push("</tr>");

            cpHA.push("<tr>");
            cpHA.push("<td class='bbit-dp-mp-month' xmonth='5'><a href='javascript:void(0);'>", def.monthName[5], "</a></td><td class='bbit-dp-mp-month bbit-dp-mp-sep' xmonth='11'><a href='javascript:void(0);'>", def.monthName[11], "</a></td><td class='bbit-dp-mp-year'><a href='javascript:void(0);'></a></td><td class='bbit-dp-mp-year'><a href='javascript:void(0);'></a></td>");
            cpHA.push("</tr>");
            cpHA.push("<tr class='bbit-dp-mp-btns'>");
            cpHA.push("<td colspan='4'><button id='BBIT-DP-MP-OKBTN' class='bbit-dp-mp-ok'>", def.btnOk, "</button><button id='BBIT-DP-MP-CANCELBTN' class='bbit-dp-mp-cancel'>", def.btnCancel, "</button></td>");
            cpHA.push("</tr>");

            cpHA.push("</tbody></table>");
            cpHA.push("</div>");
            cpHA.push("</div>");

            var s = cpHA.join("");
            $(document.body).append(s);
            cp = $("#BBIT_DP_CONTAINER");

            initevents();
        }
        function initevents() {
            //1 today btn;
            $("#BBIT-DP-TODAY").click(returntoday);
            cp.click(returnfalse);
            $("#BBIT_DP_INNER tbody").click(tbhandler);
            $("#BBIT_DP_LEFTBTN").click(prevm);
            $("#BBIT_DP_RIGHTBTN").click(nextm);
            $("#BBIT_DP_YMBTN").click(showym);
            $("#BBIT-DP-MP").click(mpclick).dblclick(mpdblclick);

            $("#BBIT-DP-MP-PREV").click(mpprevy);
            $("#BBIT-DP-MP-NEXT").click(mpnexty);
            $("#BBIT-DP-MP-OKBTN").click(mpok);
            $("#BBIT-DP-MP-CANCELBTN").click(mpcancel);
        }
        function mpcancel() {
            $("#BBIT-DP-MP").animate({ top: -193 }, { duration: 200, complete: function() { $("#BBIT-DP-MP").hide(); } });
            return false;
        }
        function mpok() {
            def.Year = def.cy;
            def.Month = def.cm + 1;
            def.Day = 1;
            $("#BBIT-DP-MP").animate({ top: -193 }, { duration: 200, complete: function() { $("#BBIT-DP-MP").hide(); } });
            writecb();
            return false;
        }
        function mpprevy() {
            var y = def.ty - 10;
            def.ty = y;
            rryear(y);
            return false;
        }
        function mpnexty() {
            var y = def.ty + 10;
            def.ty = y;
            rryear(y);
            return false;
        }
        function rryear(y) {
            var s = y - 4;
            var ar = [];
            for (var i = 0; i < 5; i++) {
                ar.push(s + i);
                ar.push(s + i + 5);
            }
            $("#BBIT-DP-MP td.bbit-dp-mp-year").each(function(i) {
                if (def.Year == ar[i]) {
                    $(this).addClass("bbit-dp-mp-sel");
                }
                else {
                    $(this).removeClass("bbit-dp-mp-sel");
                }
                $(this).html("<a href='javascript:void(0);'>" + ar[i] + "</a>").attr("xyear", ar[i]);
            });
        }
        function mpdblclick(e) {
            var et = e.target || e.srcElement;
            var td = getTd(et);
            if (td == null) {
                return false;
            }
            if ($(td).hasClass("bbit-dp-mp-month") || $(td).hasClass("bbit-dp-mp-year")) {
                mpok(e);
            }
            return false;
        }
        function mpclick(e) {
            var panel = $(this);
            var et = e.target || e.srcElement;
            var td = getTd(et);
            if (td == null) {
                return false;
            }
            if ($(td).hasClass("bbit-dp-mp-month")) {
                if (!$(td).hasClass("bbit-dp-mp-sel")) {
                    var ctd = panel.find("td.bbit-dp-mp-month.bbit-dp-mp-sel");
                    if (ctd.length > 0) {
                        ctd.removeClass("bbit-dp-mp-sel");
                    }
                    $(td).addClass("bbit-dp-mp-sel")
                    def.cm = parseInt($(td).attr("xmonth"));
                }
            }
            if ($(td).hasClass("bbit-dp-mp-year")) {
                if (!$(td).hasClass("bbit-dp-mp-sel")) {
                    var ctd = panel.find("td.bbit-dp-mp-year.bbit-dp-mp-sel");
                    if (ctd.length > 0) {
                        ctd.removeClass("bbit-dp-mp-sel");
                    }
                    $(td).addClass("bbit-dp-mp-sel")
                    def.cy = parseInt($(td).attr("xyear"));
                }
            }
            return false;
        }
        function showym() {
            var mp = $("#BBIT-DP-MP");
            var y = def.Year;
            def.cy = def.ty = y;
            var m = def.Month - 1;
            def.cm = m;
            var ms = $("#BBIT-DP-MP td.bbit-dp-mp-month");
            for (var i = ms.length - 1; i >= 0; i--) {
                var ch = $(ms[i]).attr("xmonth");
                if (ch == m) {
                    $(ms[i]).addClass("bbit-dp-mp-sel");
                }
                else {
                    $(ms[i]).removeClass("bbit-dp-mp-sel");
                }
            }
            rryear(y);
            mp.css("top", -193).show().animate({ top: 0 }, { duration: 200 });
        }
        function getTd(elm) {
            if (elm.tagName.toUpperCase() == "TD") {
                return elm;
            }
            else if (elm.tagName.toUpperCase() == "BODY") {
                return null;
            }
            else {
                var p = $(elm).parent();
                if (p.length > 0) {
                    if (p[0].tagName.toUpperCase() != "TD") {
                        return getTd(p[0]);
                    }
                    else {
                        return p[0];
                    }
                }
            }
            return null;
        }
        function tbhandler(e) {
            var et = e.target || e.srcElement;
            var td = getTd(et);
            if (td == null) {
                return false;
            }
            var $td = $(td);
            if (!$(td).hasClass("bbit-dp-disabled")) {
                var s = $td.attr("xdate");
                var arrs = s.split("-");
                cp.data("indata", new Date(arrs[0], parseInt(arrs[1], 10) - 1, arrs[2]));
                returndate();
            }
            return false;
        }
        function returnfalse() {
            return false;
        }
        function prevm() {
            if (def.Month == 1) {
                def.Year--;
                def.Month = 12;
            }
            else {
                def.Month--
            }
            writecb();
            return false;
        }
        function nextm() {
            if (def.Month == 12) {
                def.Year++;
                def.Month = 1;
            }
            else {
                def.Month++
            }
            writecb();
            return false;
        }
        function returntoday() {
            cp.data("indata", new Date());
            returndate();
        }
        function returndate() {
            var ct = cp.data("ctarget");
            var ck = cp.data("cpk");
            var re = cp.data("onReturn");
            var ndate = cp.data("indata");
            var ads = cp.data("ads");
            var ade = cp.data("ade");
            var dis = false;
            if (ads && ndate < ads) {
                dis = true;
            }
            if (ade && ndate > ade) {
                dis = true;
            }
            if (dis) {
                return;
            }
            if (re && jQuery.isFunction(re)) {
                re.call(ct[0], cp.data("indata"));
            }
            else {
                ct.val(cp.data("indata").Format("yyyy-MM-dd"));
            }
            ck.attr("isshow", "0");
            cp.removeData("ctarget").removeData("cpk").removeData("indata").removeData("onReturn")
            .removeData("ads").removeData("ade");
            cp.css("visibility", "hidden");
            ct = ck = null;
        }
        function writecb() {
            var tb = $("#BBIT_DP_INNER tbody");
            $("#BBIT_DP_YMBTN").html(def.monthName[def.Month - 1] + def.monthp + " " + def.Year);
            var firstdate = new Date(def.Year, def.Month - 1, 1);

            var diffday = def.weekStart - firstdate.getDay();
            var showmonth = def.Month - 1;
            if (diffday > 0) {
                diffday -= 7;
            }
            var startdate = DateAdd("d", diffday, firstdate);
            var enddate = DateAdd("d", 42, startdate);
            var ads = cp.data("ads");
            var ade = cp.data("ade");
            var bhm = [];
            var tds = def.today.Format("yyyy-MM-dd");
            var indata = cp.data("indata");
            var ins = indata != null ? indata.Format("yyyy-MM-dd") : "";
            for (var i = 1; i <= 42; i++) {
                if (i % 7 == 1) {
                    bhm.push("<tr>");
                }
                var ndate = DateAdd("d", i - 1, startdate);
                var tdc = [];
                var dis = false;
                if (ads && ndate < ads) {
                    dis = true;
                }
                if (ade && ndate > ade) {
                    dis = true;
                }
                if (ndate.getMonth() < showmonth) {
                    tdc.push("bbit-dp-prevday");
                }
                else if (ndate.getMonth() > showmonth) {
                    tdc.push("bbit-dp-nextday");
                }

                if (dis) {
                    tdc.push("bbit-dp-disabled");
                }
                else {
                    tdc.push("bbit-dp-active");
                }

                var s = ndate.Format("yyyy-MM-dd");
                if (s == tds) {
                    tdc.push("bbit-dp-today");
                }
                if (s == ins) {
                    tdc.push("bbit-dp-selected");
                }

                bhm.push("<td class='", tdc.join(" "), "' title='", ndate.Format("yyyy-MM-dd"), "' xdate='", ndate.Format("yyyy-M-d"), "'><a href='javascript:void(0);'><em><span>", ndate.getDate(), "</span></em></a></td>");
                if (i % 7 == 0) {
                    bhm.push("</tr>");
                }
            }
            tb.html(bhm.join(""));
        }
        var dateReg = /^(\d{1,4})(-|\/|.)(\d{1,2})\2(\d{1,2})$/;

        return $(this).each(function() {

            var obj = $(this).addClass("bbit-dp-input");
    		if(obj.hasClass("v_combo_text")){
    			obj.addClass("v_combo_text");
    		}
    		var $cbtWrap = $('<span class="v-combo-Wrap"/>');
    		obj.wrap($cbtWrap);
    		var picker = $(def.picker);
    		def.showtarget == null && obj.after(picker);
            picker.click(function(e) {
                var isshow = $(this).attr("isshow");
                //先隐藏
                var me = $(this);

                if (cp.css("visibility") == "visible") {
                    cp.css(" visibility", "hidden");
                }
                if (isshow == "1") {
                    me.attr("isshow", "0");
                    cp.removeData("ctarget").removeData("cpk").removeData("indata").removeData("onReturn");
                    return false;
                }
                var v = obj.val();
                if (v != "") {
                    v = v.match(dateReg);
                }
                if (v == null || v == "") {
                    def.Year = new Date().getFullYear();
                    def.Month = new Date().getMonth() + 1;
                    def.Day = new Date().getDate();
                    def.inputDate = null
                }
                else {
                    def.Year = parseInt(v[1], 10);
                    def.Month = parseInt(v[3], 10);
                    def.Day = parseInt(v[4], 10);
                    def.inputDate = new Date(def.Year, def.Month - 1, def.Day);
                }
                cp.data("ctarget", obj).data("cpk", me).data("indata", def.inputDate).data("onReturn", def.onReturn);
                if (def.applyrule && $.isFunction(def.applyrule)) {
                    var rule = def.applyrule.call(obj, obj[0].id);
                    if (rule) {
                        if (rule.startdate) {
                            cp.data("ads", rule.startdate);
                        }
                        else {
                            cp.removeData("ads");
                        }
                        if (rule.enddate) {
                            cp.data("ade", rule.enddate);
                        }
                        else {
                            cp.removeData("ade");
                        }
                    }
                }
                else {
                    cp.removeData("ads").removeData("ade")
                }
                writecb();


                $("#BBIT-DP-T").height(cp.height());
                var t = def.showtarget || obj;
                var pos = t.offset();


                var height = t.outerHeight();
                var newpos = { left: pos.left, top: pos.top + height };
                var w = cp.width();
                var h = cp.height();
                var bw = document.documentElement.clientWidth;
                var bh = document.documentElement.clientHeight;
                if ((newpos.left + w) >= bw) {
                    newpos.left = bw - w - 2;
                }
                if ((newpos.top + h) >= bh) {
                    newpos.top = pos.top - h - 2;
                }
                if (newpos.left < 0) {
                    newpos.left = 10;
                }
                if (newpos.top < 0) {
                    newpos.top = 10;
                }
                $("#BBIT-DP-MP").hide();
                newpos.visibility = "visible";
                cp.css(newpos);

                //cp.show();
                $(this).attr("isshow", "1");

                $(document).one("click", function(e) {
                    me.attr("isshow", "0");
                    cp.removeData("ctarget").removeData("cpk").removeData("indata");
                    cp.css("visibility", "hidden");
                });

                return false;
            });
        });
    };
    $.fn.datepickerRange = function(options){
    	 var settings = {
    	            startEl:null,
    	            endEl:null
    	        };
    	 $.extend(settings, options,{applyrule:rangedateRule});
    	 function rangedateRule(id) {
             if (id ==settings.startEl) {
                 var v = $("#"+settings.endEl).val();
                 if (!v||v == "") {
                     return null;
                 }else {
                     var d = v.match(/^(\d{1,4})(-|\/|.)(\d{1,2})\2(\d{1,2})$/);
                     if (d != null) {
                         var nd = new Date(parseInt(d[1], 10), parseInt(d[3], 10) - 1, parseInt(d[4], 10));
                         return { enddate: nd };
                     }else {
                         return null;
                     }
                 }
             } else {
                 var v = $("#"+settings.startEl).val();
                 if (!v||v == "") {
                     return null;
                 }else {
                     var d = v.match(/^(\d{1,4})(-|\/|.)(\d{1,2})\2(\d{1,2})$/);
                     if (d != null) {
                         var nd = new Date(parseInt(d[1], 10), parseInt(d[3], 10) - 1, parseInt(d[4], 10));
                         return { startdate: nd };
                     } else {
                         return null;
                     }
                 }
             }
         }
    	 return $(this).each(function() {
    		 $(this).datepicker(settings);
    	 });
    };
})(jQuery);