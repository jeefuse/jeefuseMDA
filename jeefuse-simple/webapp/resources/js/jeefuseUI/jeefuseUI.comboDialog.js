/*
 * comboDialog v1.0- jQuery comboDialog widget
 * Copyright (c) 2010 congenlv@gmail.com
 */
(function($) {
	$.fn.comboDialog = function(options) {
		var settings = {
			url : null,
			readOnly:true,
			keyEl:null,
			width:680,
			height:430,
			title:'new dialog',
			needClearBtn:true,
			alwaysReload:true
		};
		if (options) {
			jQuery.extend(settings, options);
		}
		var needLoadData=true,
			needsInit=true,
			win;
		var $cbtText = $(this);
		if(!$cbtText.hasClass("v_combo_text")){
			$cbtText.addClass("v_combo_text");
		}
		if(settings.readOnly&&$cbtText.attr("readonly")!=true){
			$cbtText.attr('readonly','readonly');
		}
		$cbtText.click(function(){
			show();
		});
		var meId=$cbtText.attr('id');
		var cbtWrapId=meId+"_combo_wrap"+new Date().getTime();
		var $cbtWrap = $('<span class="v-combo-Wrap" id='+cbtWrapId+'/>');
		$cbtText.wrap($cbtWrap);
		if(settings.needClearBtn){
			var $clearBtn = $('<span class="v-field-trigger v-field-clear-trigger"/>');
			$cbtText.parent().append($clearBtn);
			$clearBtn.click(function() {
				clearField();
			}).hover(function() {
						$clearBtn.addClass("v-field-trigger-over");
					}, function() {
						$clearBtn.removeClass("v-field-trigger-over");
			});
		}
		var $cbtArrow = $('<span class="v-field-trigger v-field-search-trigger"/>');
		$cbtText.parent().append($cbtArrow);
		$cbtArrow.hover(function() {
			$cbtArrow.addClass("v-field-trigger-over");
		}, function() {
			$cbtArrow.removeClass("v-field-trigger-over");
		});
		$cbtArrow.click(function() {
			show();
		});
		function init(){
			if(needsInit||null==win){
				win=new goolov.winbox({
					width:goolov.winWidth(settings.width),
					height:goolov.winHeight(settings.height),
					modal:true,
					neeedReLoad:settings.alwaysReload
				});
				needsInit = false;
			}
		}
		function show() {
			init();
			win.open({url:settings.url,title:settings.title});
		}
		function hide() {
			win.hide();
		}
		function clearField(){
	    	if(settings.keyEl){
	    		$('#'+settings.keyEl).val('');
	    	}
	    	$cbtText.val('');
		}
	};
})(jQuery);