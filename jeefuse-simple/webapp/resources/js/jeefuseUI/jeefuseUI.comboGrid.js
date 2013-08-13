/*
 * comboGrid v1.1- jQuery comboGrid widget
 * Copyright (c) 2010 congenlv@gmail.com
 * Depends:
 *	jquery.flexigrid.js
 *  显示下拉表格.
 */
(function($) {
	$.fn.comboGrid = function(options) {
		var settings = {
			url : null,
			param : null,
			data : null,// 数据集.如果设置了数据集则变成是本地数据,url无效.
			textCss : null,
			readOnly : true,
			width : null,
			height : null,
			needClearBtn : true,// 是否显示清空按钮
			labelField : null,// 设置显示文本框的属性名称
			valueField : null,// 设置隐藏值文本框的属性名称
			valueEl : null,// 设置隐藏文本框元素ID
			onItemClick:null,//在点击记录行时触发,传入参数(event:当前行事件, item:当前行记录)
			gridSetting : {}
		};
		if (options) {
			jQuery.extend(settings, options);
		}
		var needLoadData = true, mouseDownOnSelect, needsInit = true, $grid;
		var $cbtText = $(this);
		if (!$cbtText.hasClass("v_combo_text")) {
			$cbtText.addClass("v_combo_text");
		}
		if (settings.readOnly && $cbtText.attr("readonly") != true) {
			$cbtText.attr('readonly', 'readonly');
		}
		$cbtText.click(function() {
			if (!$cbtContent.is(":visible")) {
				showContent();
			} else {
				hideContent();
			}
		}).blur(function() {
			if (!mouseDownOnSelect) {
				if ($cbtContent.is(":visible")) {
					hideContent();
				}
			}
		});
		var meId = $cbtText.attr('id');
		var cbtWrapId = meId + "_combo_wrap" + new Date().getTime();
		var $cbtWrap = $('<span class="v-combo-Wrap" id=' + cbtWrapId + '/>');
		$cbtText.wrap($cbtWrap);
		if (settings.needClearBtn) {
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
			} else {
				needLoadData = true;
				loadData();
			}
		});
		$cbtArrow.mouseover(function() {
			mouseDownOnSelect = true;
		}).mouseout(function() {
			mouseDownOnSelect = false;
		});
		var cbtContentId = cbtWrapId + "_content";
		var $cbtContent = $('<div class="v-combo-content" id=' + cbtContentId + '></div>');
		$cbtContent.hide().appendTo(document.body);
		function initContent() {
			if (needsInit) {
				var w = settings.width ? settings.width : $cbtText.outerWidth() + $cbtArrow.outerWidth();
				var h = settings.height ? settings.height : 200;
				var gridId = $cbtText.id + "ComboGrid";
				$grid = $("<div/>").attr('id', gridId).appendTo($cbtContent);
				var gridSetting = $.extend( {
					width : w,
					height : h,
					url : options.url,
					useRp : false,
					autoload : false,
					resizable : false,
					showcheckbox : false,
					usepager : true,
					showseq : true,
					onRowClick : comboItemClick,
					showToggleBtn : true
				}, settings.gridSetting);
				$grid.flexigrid(gridSetting);
				// $cbtContent.width(w);
				$cbtContent.mouseover(function() {
					mouseDownOnSelect = true;
				}).mouseout(function() {
					mouseDownOnSelect = false;
				});
				if ($.fn.bgiframe)
					$cbtContent.bgiframe();
				needsInit = false;
			}
		}
		function showContent() {
			initContent();
			var offset = $cbtText.offset();
			$cbtContent.css( {
				position : 'absolute',
				zIndex : new Date().getTime(),
				top : (offset.top + $cbtText.outerHeight()) + "px",
				left : offset.left + "px"
			});
			$cbtContent.show();
		}
		function hideContent() {
			$cbtContent.hide();
		}
		function loadData() {
			if (needLoadData) {
				$grid.flexReload( {
					newp : 1
				});
			}
			needLoadData = false;
		}
		function comboItemClick(event, item) {
			if (!item) {
				$('#' + settings.valueEl).val('');
				$cbtText.val('');
			} else {
				$('#' + settings.valueEl).val(item[settings.valueField] ? item[settings.valueField] : '');
				$cbtText.val(item[settings.labelField] ? item[settings.labelField] : '');
			}
			if(settings.onItemClick)
				settings.onItemClick(event,item);
			hideContent();
		}
		function clearField() {
			$('#' + settings.valueEl).val('');
			$cbtText.val('');
		}
	};
})(jQuery);