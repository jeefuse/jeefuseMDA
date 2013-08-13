/*
 * comboBox v1.0- jQuery comboBox widget
 * Copyright (c) 2010 congenlv@gmail.com
 * 显示为下拉框,包含一个隐藏的输入框(valueEl的ID指定)和一个显示框.
 *   data:[{ key:key_1,label:label_1 },... ]
 *   url:{success:true|false,message:'msg',data:[{key:key_1,label:label_1}]}
 */
(function($) {
	$.fn.comboBox = function(options) {
		var settings = {
			data:null,
			url:null,
			readOnly:true,
			labelField : 'label',// 设置显示Text的属性名称
			valueField : 'key',// 设置隐藏值Text的属性名称
			valueEl:null,//设置隐藏input Text的元素ID
			needClear:true,//是否需要清空,显示一个清空按钮
			onClear:null,//清空时触发
			needReload:false,//是否需要刷新,显示一个刷新按钮
			onReload:null,//刷新时触发
			onSelect:null,//在选择时触发
		    scroll: true,
		    headerKey:"未选择",//若为必填项则设为null
		    headerValue:"",
		    scrollHeight: 180,
		    errorText:"发生错误"
		};
		if (options) {
			jQuery.extend(settings, options);
		}
		var input=this;
		var $input = $(input);
		if(!$input.hasClass("v_combo_text")){
			$input.addClass("v_combo_text");
		}
		if(settings.readOnly&&$input.attr("readonly")!=true){
			$input.attr('readonly','readonly');
		}
		var label_value=$input.val();
		// 设置初始值,如果隐藏域中的值不为空且当前值为空,则在data中查找跟隐藏域中的值匹配的值为当前值
		if(!label_value||""==$.trim(label_value)){
			var key_value=$('#'+settings.valueEl).val();
			var item=lookItemByKeyFromData(key_value);
			if(key_value&&item){
				$input.val(item[settings.labelField]);
			}else{
				if(settings.headerKey){
					$input.val(settings.headerKey);
					$('#'+settings.valueEl).val(settings.headerValue);
				}else if(settings.data&&settings.data.length>0){
					$input.val(settings.data[0][settings.labelField]);
					$('#'+settings.valueEl).val(settings.data[0][settings.valueField]);
				}
			}
		}
		var meId=$input.attr('id');
		var cbtWrapId=meId+"_combo_wrap"+new Date().getTime();
		var $cbtWrap = $('<span class="v-combo-Wrap" id='+cbtWrapId+'/>');
		$input.wrap($cbtWrap);
		//set clear btn
		if(settings.needClear){
			var $clearBtn = $('<span class="v-field-trigger v-field-clear-trigger"/>');
			$cbtWrap.append($clearBtn);
			$clearBtn.hover(function() {
						$clearBtn.addClass("v-field-trigger-over");
				}, function() {
						$clearBtn.removeClass("v-field-trigger-over");
			});
			if(settings.onClear){
				$clearBtn.click(function() {
					clearText();
					settings.onClear.call(this);
				});
			}
		}
		var $cbtArrow = $('<span class="v-field-trigger"/>');
		$input.parent().append($cbtArrow);
		//set reload btn
		var needInited=true;
		if(settings.needReload){
			$cbtArrow.addClass('v-field-search-trigger');
			$cbtArrow.click(function() {
				needInited=true;
				settings.data=null;
				onChange();
				if(settings.onReload){
					settings.onReload.call(this);
				}
			});
		}else{
			$cbtArrow.click(function() {
				if ( select.visible() ) {
					hideResults();
				}else{
					onChange();
				}
			});
		}
		$cbtArrow.hover(function() {
			$cbtArrow.addClass("v-field-trigger-over");
		}, function() {
			$cbtArrow.removeClass("v-field-trigger-over");
		});
		
		var config = {
			mouseDownOnSelect: false
		};
		var select =new $.comboBoxSelect(settings, this, selectCurrent, config);
		var blockSubmit;
		
		// prevent form submit in opera when selecting with return key
		$.browser.opera && $(input.form).bind("submit.autocomplete", function() {
			if (blockSubmit) {
				blockSubmit = false;
				return false;
			}
		});
		var KEY = {
				UP: 38,
				DOWN: 40,
				DEL: 46,
				TAB: 9,
				RETURN: 13,
				ESC: 27,
				COMMA: 188,
				PAGEUP: 33,
				PAGEDOWN: 34,
				BACKSPACE: 8
		};
		var hasFocus = 0;
		// only opera doesn't trigger keydown multiple times while pressed, others don't work with keypress at all
		$input.bind(($.browser.opera ? "keypress" : "keydown") + ".autocomplete", function(event) {
			// a keypress means the input has focus
			// avoids issue where input had focus before the autocomplete was applied
			hasFocus = 1;
			// track last key pressed
			lastKeyPressCode = event.keyCode;
			switch(event.keyCode) {
				case KEY.UP:
					event.preventDefault();
					if ( select.visible() ) {
						select.prev();
					} else {
						onChange();
					}
					break;
					
				case KEY.DOWN:
					event.preventDefault();
					if ( select.visible() ) {
						select.next();
					} else {
						onChange();
					}
					break;
					
				case KEY.PAGEUP:
					event.preventDefault();
					if ( select.visible() ) {
						select.pageUp();
					} else {
						onChange();
					}
					break;
					
				case KEY.PAGEDOWN:
					event.preventDefault();
					if ( select.visible() ) {
						select.pageDown();
					} else {
						onChange();
					}
					break;
				case KEY.TAB:
				case KEY.RETURN:
					if( selectCurrent() ) {
						// stop default to prevent a form submit, Opera needs special handling
						event.preventDefault();
						blockSubmit = true;
						return false;
					}
					break;
				case KEY.ESC:
					select.hide();
					break;
				default:
					onChange();
					break;
			}
		}).focus(function(){
			// track whether the field has focus, we shouldn't process any
			// results if the field no longer has focus
			hasFocus++;
		}).blur(function() {
			hasFocus = 0;
			if (!config.mouseDownOnSelect) {
				hideResults();
			}
		}).click(function() {
			// show select when clicking in a focused field
			if ( select.visible() ) {
				hideResults();
			}else{
				onChange();
			}
		}).bind("uncomboBox", function() {
			select.unbind();
			$input.unbind();
		});
		
		function onChange() {
			if(needInited&&!settings.data&&settings.url){
				reloadData();
			}else{
				showResults();
			}
		};
		function reloadData() {
			if(settings.url){
				var extraParams = {
					timestamp: +new Date()
				};
				if(settings.extraParams){
					$.each(settings.extraParams, function(key, param) {
						extraParams[key] = typeof param == "function" ? param() : param;
					});
				}
				startLoading();
				$.ajax({
					// try to leverage ajaxQueue plugin to abort previous requests
					mode: "abort",
					// limit abortion to this input
					port: "autocomplete" + input.id,
					dataType: 'json',
					url: settings.url,
					data: extraParams,
					success: function(result) {
						if(result&&result.success){
							settings.data=result.data;
						}else{
							var item=new Object();
							item[settings.labelField]=result&&result.message?result.message:settings.errorText;
							item[settings.valueField]=settings.headerValue;
							settings.data=[item];
						}
						stopLoading();
						showResults();
					},
					error:function(){
						var item=new Object();
						item[settings.labelField]=settings.errorText;
						item[settings.valueField]=settings.headerValue;
						settings.data=[item];
						stopLoading();
						showResults();
					}
				});
			}
		}
		function startLoading(){
			select.loading();
		}
		function stopLoading(){
			select.unloading();
		}
		function showResults(){
			if(needInited){
				var items=[];
				if(settings.headerKey){
					var item=new Object();
					item[settings.labelField]=settings.headerKey;
					item[settings.valueField]=settings.headerValue;
					items.push(item);
				}
				var data=settings.data;
				for (var i=0; i < data.length; i++) {
					items.push(data[i]);
				}
				//items.push(settings.data);
				select.display(items);
				needInited=false;
			}
			select.show();
		}
		function hideResults(){
			select.hide();
		}
		function selectCurrent() {
			var data = select.selected();
			if( !data ){
				return false;
			}
			populateText(data);
			if(settings.onSelect){
				settings.onSelect(data);
			}
			hideResults();
			return true;
		}
		function clearText() {
			select.removeCurrent();
			if (settings.valueEl) {
				$('#' + settings.valueEl).val('');
			}
			$input.val('');
		}
		function populateText(data){
			if (settings.valueEl) {
				$('#' + settings.valueEl).val(data[settings.valueField]);
			}
			$input.val(data[settings.labelField]);
		}
		function lookItemByKeyFromData(key){
			if(settings.data&&settings.data.length>0){
				var len=settings.data.length;
				for (var i=0; i < len; i++) {
					var item=settings.data[i];
					if(item[settings.valueField]==key)
						return item;
				}
			}
			return null;
		}
	};
	
	$.comboBoxSelect = function (options, input, select, config) {
		var CLASSES = {
			ACTIVE: "ac_over",
			resultsClass: "ac_results"
		};
		
		var listItems,
			active = -1,
			data,
			needsInit = true,
			element,
			list;
		
		// Create results
		function init() {
			if (!needsInit)
				return;
			element = $("<div/>")
			.hide()
			.addClass(CLASSES.resultsClass)
			.css("position", "absolute")
			.appendTo(document.body);
		
			list = $("<ul/>").appendTo(element).mouseover( function(event) {
				if(target(event).nodeName && target(event).nodeName.toUpperCase() == 'LI') {
		            active = $("li", list).removeClass(CLASSES.ACTIVE).index(target(event));
				    $(target(event)).addClass(CLASSES.ACTIVE);            
		        }
			}).click(function(event) {
				$(target(event)).addClass(CLASSES.ACTIVE);
				select();
				input.focus();
				return false;
			}).mousedown(function() {
				config.mouseDownOnSelect = true;
			}).mouseup(function() {
				config.mouseDownOnSelect = false;
			});
			
			if( options.width > 0 )
				element.css("width", options.width);
				
			needsInit = false;
		} 
		
		function target(event) {
			var element = event.target;
			while(element && element.tagName != "LI")
				element = element.parentNode;
			// more fun with IE, sometimes event.target is empty, just ignore it then
			if(!element)
				return [];
			return element;
		}

		function moveSelect(step) {
			//listItems.slice(active, active + 1).removeClass(CLASSES.ACTIVE);
			listItems.removeClass(CLASSES.ACTIVE);
			movePosition(step);
	        var activeItem = listItems.slice(active, active + 1).addClass(CLASSES.ACTIVE);
	        if(options.scroll) {
	            var offset = 0;
	            listItems.slice(0, active).each(function() {
					offset += this.offsetHeight;
				});
	            if((offset + activeItem[0].offsetHeight - list.scrollTop()) > list[0].clientHeight) {
	                list.scrollTop(offset + activeItem[0].offsetHeight - list.innerHeight());
	            } else if(offset < list.scrollTop()) {
	                list.scrollTop(offset);
	            }
	        }
		};
		
		function movePosition(step) {
			active += step;
			if (active < 0) {
				active = listItems.size() - 1;
			} else if (active >= listItems.size()) {
				active = 0;
			}
		}
		
		function fillList() {
			list.empty();
			var max = data.length;
			for (var i=0; i < max; i++) {
				if (!data[i])
					continue;
				var item=data[i];
				var li = $("<li/>").html( item[options.labelField] ).addClass(i%2 == 0 ? "ac_even" : "ac_odd").appendTo(list)[0];
				$.data(li, "ac_data", data[i]);
			}
			listItems = list.find("li");
			if ( options.selectFirst ) {
				listItems.slice(0, 1).addClass(CLASSES.ACTIVE);
				active = 0;
			}
			// apply bgiframe if available
			if ( $.fn.bgiframe )
				list.bgiframe();
		}
		//初始化
		init();
		return {
			display: function(d) {
//				init();
				data = d;
				fillList();
			},
			next: function() {
				moveSelect(1);
			},
			prev: function() {
				moveSelect(-1);
			},
			pageUp: function() {
				if (active != 0 && active - 8 < 0) {
					moveSelect( -active );
				} else {
					moveSelect(-8);
				}
			},
			pageDown: function() {
				if (active != listItems.size() - 1 && active + 8 > listItems.size()) {
					moveSelect( listItems.size() - 1 - active );
				} else {
					moveSelect(8);
				}
			},
			hide: function() {
				element && element.hide();
				listItems && listItems.removeClass(CLASSES.ACTIVE);
				active = -1;
			},
			visible : function() {
				return element && element.is(":visible");
			},
			removeCurrent:function(){
				listItems && listItems.removeClass(CLASSES.ACTIVE);
				active = -1;
			},
			loading:function(){
				var loadingProgress = '<div class="loading-progress"><div class="loading-progress-content"></div></div>';
				list.empty().before(loadingProgress);
			},
			unloading:function(){
				$(".loading-progress",element).remove();
			},
			current: function() {
				return this.visible() && (listItems.filter("." + CLASSES.ACTIVE)[0] || options.selectFirst && listItems[0]);
			},
			show: function() {
				var offset = $(input).offset();
				element.css({
					width: typeof options.width == "string" || options.width > 0 ? options.width : $(input).innerWidth(),
					top: offset.top + $(input).outerHeight(),
					left: offset.left
				}).show();
	            if(options.scroll) {
	                list.scrollTop(0);
	                list.css({
						maxHeight: options.scrollHeight,
						overflow: 'auto'
					});
	                if($.browser.msie && typeof document.body.style.maxHeight === "undefined") {
						var listHeight = 0;
						listItems.each(function() {
							listHeight += this.offsetHeight;
						});
						var scrollbarsVisible = listHeight > options.scrollHeight;
	                    list.css('height', scrollbarsVisible ? options.scrollHeight : listHeight );
						if (!scrollbarsVisible) {
							// IE doesn't recalculate width when scrollbar disappears
							listItems.width( list.width() - parseInt(listItems.css("padding-left")) - parseInt(listItems.css("padding-right")) );
						}
	                }
	                
	            }
			},
			selected: function() {
				var selected = listItems && listItems.filter("." + CLASSES.ACTIVE);//.removeClass(CLASSES.ACTIVE);
				return selected && selected.length && $.data(selected[0], "ac_data");
			},
			emptyList: function (){
				list && list.empty();
			},
			unbind: function() {
				element && element.remove();
			}
		};
	};
})(jQuery);