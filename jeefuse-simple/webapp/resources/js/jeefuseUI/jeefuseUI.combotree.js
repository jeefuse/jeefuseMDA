/*
 * combotree v1.1- jQuery combotree widget
 * Copyright (c) 2010 congenlv@gmail.com
 * Depends:
 *	jquery.tree.js
 */
(function($) {
	$.fn.comboTree = function(options) {
		var settings = {
			url : null,
			param:null,
			data:null,
			textCss:null,
			theme:'bbit-tree-lines',
			readOnly:true,
			minHeight:30,
			keyEl:null,
			width:null,
			height:null,
			needClearBtn:false,
			iconspath:'images/',
			onSelect:null
		};
		if (options) {
			jQuery.extend(settings, options);
		}
		var needLoadData=true,
			mouseDownOnSelect,
			needsInit=true;
		var $cbtText = $(this);
		if(!$cbtText.hasClass("v_combo_text")){
			$cbtText.addClass("v_combo_text");
		}
		$cbtText.click(function(){
			if (!$cbtContent.is(":visible")) {
				showContent();
			}else {
				hideContent();
			}
		}).blur(function() {
			if (!mouseDownOnSelect) {
				if ($cbtContent.is(":visible")) {
					hideContent();
				}
			}
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
			if (!$cbtContent.is(":visible")) {
				showContent();
			}else{
				needLoadData=true;
				loadData();
			}
		});
		$cbtArrow.mouseover(function(){
			mouseDownOnSelect=true;
		}).mouseout(function(){
			mouseDownOnSelect=false;
		});
		var cbtContentId=cbtWrapId+"_content";
		var $cbtContent = $('<div class="v-combo-content" id='+cbtContentId+'></div>');
		$cbtContent.hide().appendTo(document.body);
		function initContent(){
			if(needsInit){
				var w=settings.width ? settings.width : $cbtText.innerWidth()+$cbtArrow.innerWidth();
				var h=settings.height?settings.height:200;
				$cbtContent.width(w);
				$cbtContent.height(settings.height?settings.height:200);
				if($cbtContent.height()<settings.minHeight){
					$cbtContent.height(settings.minHeight);
				}
				$cbtContent.mouseover(function(){
					mouseDownOnSelect=true;
				}).mouseout(function(){
					mouseDownOnSelect=false;
				});
				if ($.fn.bgiframe)
					$cbtContent.bgiframe();
				needsInit = false;
			}
		}
		function showContent() {
			initContent();
			var offset = $cbtText.offset();
			$cbtContent.css({
				position : 'absolute',
				zIndex : new Date().getTime(),
				top : (offset.top+$cbtText.outerHeight()) + "px",
				left : offset.left + "px"
			});
			$cbtContent.show();
			loadData();
		}
		function hideContent() {
			$cbtContent.hide();
		}
		function loadData(){
			if(needLoadData){
				var options = {showcheck: false,iconspath:settings.iconspath,onnodeclick:comboTreeNodeClick};
				if(settings.data){
					options.data=settings.data;
					options.param=settings.param;
					$cbtContent.treeview(options);
				}else if(settings.url){
					options.url=settings.url;
					$cbtContent.ajaxTree(options);
				}
				needLoadData=false;
			}
		}
		function comboTreeNodeClick(item){
		    if(!item.id||'root'==item.id){
		    	if(settings.keyEl){
		    		$('#'+settings.keyEl).val('');
		    	}
		    	$cbtText.val(item.text);
		    }else{
		    	if(settings.keyEl){
		    		$('#'+settings.keyEl).val(item.id);
		    	}
		    	$cbtText.val(item.text);
		    }
		    hideContent();
		    if(settings.onSelect){
		    	settings.onSelect();
		    }
		}
		function clearField(){
	    	if(settings.keyEl){
	    		$('#'+settings.keyEl).val('');
	    	}
	    	$cbtText.val('');
		}
	};
})(jQuery);