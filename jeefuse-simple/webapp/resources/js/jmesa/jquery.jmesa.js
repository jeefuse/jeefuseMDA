(function ($) {

    var tableFacades = new Object();

    var getFormByTableId = function(id) {
        var node = document.getElementById(id);
        var found = false;
        while (!found) {
            if (node.nodeName == 'FORM') {
                found = true;
                return node;
            }
            node = node.parentNode;
        }
        return null;
    }

    var coreapi = {
        addTableFacade : function(id) {
            var tableFacade = new classes.TableFacade(id);
            tableFacades[tableFacade.limit.id] = tableFacade;
        },
        getTableFacade : function(id) {
            return tableFacades[id];
        },
        setSaveToWorksheet : function(id) {
            this.getTableFacade(id).worksheet.save='true';
        },
        setFilterToWorksheet : function(id) {
            this.getTableFacade(id).worksheet.filter='true';
            this.setPageToLimit(id, '1');
        },
        setAddRowToWorksheet : function(id) {
            this.getTableFacade(id).worksheet.addRow='true';
        },
        setRemoveRowToWorksheet : function(id, uniqueProperties) {
            this.getTableFacade(id).worksheet.removeRow = uniqueProperties;
        },
        removeFilterFromWorksheet : function(id) {
            this.getTableFacade(id).worksheet.filter=null;
            this.setPageToLimit(id, '1');
        },
        setPageToLimit : function(id, page) {
            this.getTableFacade(id).limit.setPage(page);
        },
        setMaxRowsToLimit : function(id, maxRows) {
            this.getTableFacade(id).limit.setMaxRows(maxRows);
            this.setPageToLimit(id, '1');
        },
        setTotalRowsToLimit : function(id, totalRows) {
            this.getTableFacade(id).limit.setTotalRows(totalRows);
        },
        addSortToLimit : function(id, position, property, order) {
            /*First remove the sort if it is set on the limit,
               and then set the page back to the first one.*/
            this.removeSortFromLimit(id, property);
            this.setPageToLimit(id, '1');

            var limit = this.getTableFacade(id).limit;
            var sort = new classes.Sort(position, property, order);
            limit.addSort(sort);
        },
        removeSortFromLimit : function(id, property) {
            var limit = this.getTableFacade(id).limit;
            var sortSet = limit.getSortSet();
            $.each(sortSet, function(index, sort) {
                if (sort.property == property) {
                    sortSet.splice(index, 1);
                    return false;
                }
            });
        },
        removeAllSortsFromLimit : function(id) {
            var limit = this.getTableFacade(id).limit;
            limit.setSortSet(new Array());
            this.setPageToLimit(id, '1');
        },
        getSortFromLimit : function(id, property) {
            var limit = this.getTableFacade(id).limit;
            var sortSet = limit.getSortSet();
            $.each(sortSet, function(index, sort) {
                if (sort.property == property) {
                    return sort;
                }
            });
        },
        addFilterToLimit : function(id, property, value) {
            /*First remove the filter if it is set on the limit,
              and then set the page back to the first one.*/
            this.removeFilterFromLimit(id, property);
            this.setPageToLimit(id, '1');

            var limit = this.getTableFacade(id).limit;
            var filter = new classes.Filter(property, value);
            limit.addFilter(filter);
        },
        removeFilterFromLimit : function(id, property) {
            var limit = this.getTableFacade(id).limit;
            var filterSet = limit.getFilterSet();
            $.each(filterSet, function(index, filter) {
                if (filter.property == property) {
                    filterSet.splice(index, 1);
                    return false;
                }
            });
        },
        removeAllFiltersFromLimit : function(id) {
            var tableFacade = this.getTableFacade(id);

            var limit = tableFacade.limit;
            limit.setFilterSet(new Array());
            this.setPageToLimit(id, '1');

            var worksheet = tableFacade.worksheet;
            worksheet.filter = null;
        },
        getFilterFromLimit : function(id, property) {
            var limit = this.getTableFacade(id).limit;
            var filterSet = limit.getFilterSet();
            $.each(filterSet, function(index, filter) {
                if (filter.property == property) {
                    return filter;
                }
            });
        },
        setExportToLimit : function(id, exportType) {
            this.getTableFacade(id).limit.setExport(exportType);
        },
        createHiddenInputFieldsForLimit : function(id) {
            var tableFacade = this.getTableFacade(id);
            var form = getFormByTableId(id);
            tableFacade.createHiddenInputFields(form);
        },
        createHiddenInputFieldsForLimitAndSubmit : function(id) {
            var tableFacade = this.getTableFacade(id);
            var form = getFormByTableId(id);
            var created = tableFacade.createHiddenInputFields(form);
            if (created) {
                form.submit();
            }
        },
        createParameterStringForLimit : function(id) {
            var tableFacade = this.getTableFacade(id);
            return tableFacade.createParameterString();
        },
        setOnInvokeAction : function (id, functionName) {
            var tableFacade = this.getTableFacade(id);
            tableFacade.onInvokeAction = functionName;
        },
        setOnInvokeExportAction : function (id, functionName) {
            var tableFacade = this.getTableFacade(id);
            tableFacade.onInvokeExportAction = functionName;
        },
        setContextPath : function (id, contextPath) {
        	var tableFacade = this.getTableFacade(id);
        	tableFacade.contextPath = contextPath;
        },
        getContextPath : function (id) {
        	var tableFacade = this.getTableFacade(id);
        	return tableFacade.contextPath;
        },
        onInvokeAction : function (id, action) {
            var tableFacade = this.getTableFacade(id);
            var f = window[tableFacade.onInvokeAction];
            if ($.isFunction(f) !== true) {
                throw tableFacade.onInvokeAction + ' is not a global function!';
            } else {
                f(id, action);
            }
        },
        onInvokeExportAction : function (id) {
            var tableFacade = this.getTableFacade(id);
            var f = window[tableFacade.onInvokeExportAction];
            if ($.isFunction(f) !== true) {
                throw tableFacade.onInvokeExportAction + ' is not a global function!';
            } else {
                f(id);
            }
        },
        getFormByTableId : function (id) {
            return getFormByTableId(id);
        }
    };

    /*********** Objects and Prototype Functions ***********/

    var classes = {
        TableFacade : function (id) {
            this.limit = new classes.Limit(id);
            this.worksheet = new classes.Worksheet();
            this.onInvokeAction = 'onInvokeAction';
            this.onInvokeExportAction = 'onInvokeExportAction';
            this.contextPath = '';
        },
        Worksheet : function () {
            this.save = null;
            this.filter = null;
            this.addRow = null;
            this.removeRow = null;
        },
        Limit : function (id) {
            this.id = id;
            this.page = null;
	        this.maxRows = null;
	        this.totalRows = null;
	        this.sortSet = [];
            this.filterSet = [];
            this.exportType = null;
        },
        Sort : function (position, property, order) {
            this.position = position;
            this.property = property;
            this.order = order;
        },
        Filter : function (property, value) {
            this.property = property;
            this.value = value;
        },
        DynFilter : function (filter, id, property) {
            this.filter = filter;
            this.id = id;
            this.property = property;
        },
        WsColumn : function (column, id, uniqueProperties, property) {
            this.column = column;
            this.id = id;
            this.uniqueProperties = uniqueProperties;
            this.property = property;
        }
    };

    $.extend(classes.Limit.prototype, {
        getId : function () {
            return this.id;
        },
        setId : function (id) {
            this.id = id;
        },
        getPage : function () {
            return this.page;
        },
        setPage : function (page) {
            this.page = page;
        },
        getMaxRows : function () {
            return this.maxRows;
        },
        setMaxRows : function (maxRows) {
            this.maxRows = maxRows;
        },
        getTotalRows : function () {
            return this.totalRows;
        },
        setTotalRows : function (totalRows) {
            this.totalRows = totalRows;
        },
        getTotalPages : function () {
	        if (this.maxRows == 0) return 1;
            var pages = this.totalRows / this.maxRows;
	        if ((this.totalRows % this.maxRows) > 0) {
		        ++pages;
	        }
	        return pages;
        },
        getSortSet : function () {
            return this.sortSet;
        },
        addSort : function (sort) {
            this.sortSet[this.sortSet.length] = sort;
        },
        setSortSet : function (sortSet) {
            this.sortSet = sortSet;
        },
        getFilterSet : function () {
            return this.filterSet;
        },
        addFilter : function (filter) {
            this.filterSet[this.filterSet.length] = filter;
        },
        setFilterSet : function (filterSet) {
            this.filterSet = filterSet;
        },
        getExport : function () {
            return this.exportType;
        },
        setExport : function (exportType) {
            this.exportType = exportType;
        }
    });

    $.extend(classes.TableFacade.prototype, {
        createHiddenInputFields : function(form) {
            var limit = this.limit;

            var exists = $(form).find(':hidden[name=' + limit.id + '_p_]').val();
            if (exists) {
                return false;
            }

            if (this.worksheet.save) {
                $(form).append('<input type="hidden" name="' + limit.id + '_sw_" value="true"/>');
            }

            if (this.worksheet.filter) {
                $(form).append('<input type="hidden" name="' + limit.id + '_fw_" value="true"/>');
            }

            if (this.worksheet.addRow) {
                $(form).append('<input type="hidden" name="' + limit.id + '_awr_" value="true"/>');
            }

            if (this.worksheet.removeRow) {
                $.each(this.worksheet.removeRow, function(key, value) {
                    $(form).append('<input type="hidden" name="' + limit.id + '_rwr_" value="' + value + '"/>');
                });
            }

            /* tip the API off that in the loop of working with the table */
            $(form).append('<input type="hidden" name="' + limit.id + '_tr_" value="true"/>');

            /* the current page */
            $(form).append('<input type="hidden" name="' + limit.id + '_p_" value="' + limit.page + '"/>');
            $(form).append('<input type="hidden" name="' + limit.id + '_mr_" value="' + limit.maxRows + '"/>');

            /* the sort objects */
            var sortSet = limit.getSortSet();
            $.each(sortSet, function(index, sort) {
                $(form).append('<input type="hidden" name="' + limit.id + '_s_'  + sort.position + '_' + sort.property + '" value="' + sort.order + '"/>');
            });

            /* the filter objects */
            var filterSet = limit.getFilterSet();
            $.each(filterSet, function(index, filter) {
                $(form).append('<input type="hidden" name="' + limit.id + '_f_' + filter.property + '" value="' + filter.value + '"/>');
            });

            return true;
        },
        createParameterString : function() {
            var limit = this.limit;

            var url = '';

            /* the current page */
            url += limit.id + '_p_=' + limit.page;

            /* the max rows */
            url += '&' + limit.id + '_mr_=' + limit.maxRows;

            /* the sort objects */
            var sortSet = limit.getSortSet();
            $.each(sortSet, function(index, sort) {
                url += '&' + limit.id + '_s_' + sort.position + '_' + sort.property + '=' + sort.order;
            });

            /* the filter objects */
            var filterSet = limit.getFilterSet();
            $.each(filterSet, function(index, filter) {
                url += '&' + limit.id + '_f_' + filter.property + '=' + encodeURIComponent(filter.value);
            });

            /* the export */
            if (limit.exportType) {
                url += '&' + limit.id + '_e_=' + limit.exportType;
            }

            /* tip the API off that in the loop of working with the table */
            url += '&' + limit.id + '_tr_=true';

            if (this.worksheet.save) {
                url += '&' + limit.id + '_sw_=true';
            }

            if (this.worksheet.filter) {
                url += '&' + limit.id + '_fw_=true';
            }

            if (this.worksheet.addRow) {
                url += '&' + limit.id + '_awr_=true';
            }

            if (this.worksheet.removeRow) {
                $.each(this.worksheet.removeRow, function(key, value) {
                    url += '&' + limit.id + '_rwr_=' + value;
                });
            }

            return url;
        }
    });

    /************* Filter ***********/

    var dynFilter = null;

    var filterapi = {
        createDynFilter : function(filter, id, property) {
            if (dynFilter) {
                return;
            }

            dynFilter = new classes.DynFilter(filter, id, property);

            var cell = $(filter);
            var width = cell.width();
            var originalValue = cell.text();

            /* Enforce the width with a style. */
            cell.width(width);
            cell.parent().width(width);
            cell.css('overflow', 'visible');

            cell.html('<div id="dynFilterDiv"><input id="dynFilterInput" name="filter" style="width:' + (width + 2) + 'px" value="" /></div>');

            var input = $('#dynFilterInput');
            input.val(originalValue);
            input.focus();

            $(input).keypress(function(event) {
                if (event.keyCode == 13) { /* Press the enter key. */
                    var changedValue = input.val();
                    cell.text('');
                    cell.css('overflow', 'hidden');
                    cell.text(changedValue);
                    $.jmesa.addFilterToLimit(dynFilter.id, dynFilter.property, changedValue);
                    var id = dynFilter.id;
                    dynFilter = null;
                    $.jmesa.onInvokeAction(id, 'filter');
                }
            });

            $(input).blur(function() {
                var changedValue = input.val();
                cell.text('');
                cell.css('overflow', 'hidden');
                cell.text(changedValue);
                $.jmesa.addFilterToLimit(dynFilter.id, dynFilter.property, changedValue);
                dynFilter = null;
            });
        },
        createDroplistDynFilter : function(filter, id, property, options) {
            if (dynFilter) {
                return;
            }

            dynFilter = new classes.DynFilter(filter, id, property);

            if ($('#dynFilterDroplistDiv').size() > 0) {
                return; /* Filter already created. */
            }

            /* The cell that represents the filter. */
            var cell = $(filter);

            /* Get the original filter value and width. */
            var originalValue = cell.text();
            var width = cell.width();

            /* Need to first get the size of the arrary. */
            var size = 1;
            $.each(options, function() {
                size++;
                if (size > 10) {
                    size = 10;
                    return false;
                }
            });

            /* Enforce the width with a style. */
            cell.width(width);
            cell.parent().width(width);

            /* Create the dynamic select input box. */
            cell.html('<div id="dynFilterDroplistDiv" style="top:17px">');

            var html = '<select id="dynFilterDroplist" name="filter" size="' + size + '">';
            html += '<option value=""> </option>';
            $.each(options, function(key, value) {
                if (key == originalValue) {
                    html += '<option selected="selected" value="' + key + '">' + value + '</option>';
                } else {
                    html += '<option value="' + key + '">' + value + '</option>';
                }
            });

            html += '</select>';

            var div = $('#dynFilterDroplistDiv');
            div.html(html);

            var input = $('#dynFilterDroplist');

            /* Resize the column if it is not at least as wide as the column. */
            var selectWidth = input.width();
            if (selectWidth < width) {
                input.width(width + 5); /* always make the droplist overlap some */
            }

            input.focus();

            var originalBackgroundColor = cell.css("backgroundColor");
            cell.css({backgroundColor:div.css("backgroundColor")});

            /* Something was selected or the clicked off the droplist. */

            $(input).click(function() {
                var changedValue = $("#dynFilterDroplistDiv option:selected").val();
                var changedText = $("#dynFilterDroplistDiv option:selected").text();
                cell.text(changedText);
                $.jmesa.addFilterToLimit(dynFilter.id, dynFilter.property, changedValue);
                var id = dynFilter.id;
                dynFilter = null;
                $.jmesa.onInvokeAction(id, 'filter');
            });

            $(input).blur(function() {
                var changedText = $("#dynFilterDroplistDiv option:selected").text();
                cell.text(changedText);
                $('#dynFilterDroplistDiv').remove();
                cell.css({backgroundColor:originalBackgroundColor});
                dynFilter = null;
            });
        }
    }

    /*********** Worksheet ***********/

    var wsColumn = null;
    var errorMap = {};
    var validatorObject = {};

    var worksheetapi = {
        createWsColumn : function(column, id, uniqueProperties, property) {
            if (wsColumn) {
                return;
            }

            wsColumn = new classes.WsColumn(column, id, uniqueProperties, property);

            var cell = $(column);
            var width = cell.width();
            var originalValue = cell.text();

            /* Enforce the width with a style. */
            cell.width(width);
            cell.parent().width(width);
            cell.css('overflow', 'visible');

            cell.html('<div id="wsColumnDiv"><input id="wsColumnInput" name="' + property + '" style="width:' + (width + 3) + 'px" value=""/></div>');

            var input = $('#wsColumnInput');
            input.val(originalValue);
            input.focus();
            if (jQuery.browser.msie) { /* IE need a second focus */
                input.focus();
            }

            this.wsColumnKeyEvent(cell, input, originalValue);

            $('#wsColumnInput').blur(function() {
                var changedValue = input.val();
                var hasRules;
                $.each($("#wsColumnInput").rules(), function() { hasRules = true; });
                /* validate manually */
                if (changedValue != originalValue) {
                    var validator = validatorObject[wsColumn.id];
                    if (validator) {
                        validator.element($('#wsColumnInput'));
                    }
                }
                cell.text('');
                cell.css('overflow', 'hidden');
                cell.text(changedValue);
                if (changedValue != originalValue) {
                    $.jmesa.submitWsColumn(originalValue, changedValue, hasRules);
                }
                wsColumn = null;
            });
        },
        wsColumnKeyEvent : function(cell, input, originalValue) {
            var keyEvent = function(event) {
                if (event.keyCode == 13 || event.keyCode == 9) { /* Press the enter or tabulation key. */
                    var divToClick = null;

                    if (event.keyCode == 9) { /* Press the tabulation key ==> search last or next cell */
                        var divElements = document.getElementsByTagName('div');
                        var nextCell = false;
                        var lastCell = false;
                        var lastDiv = null;
                        var firstDiv = null;

                        for (i = 0 ; i < divElements.length ; i++){
                            if (divElements[i].className == 'wsColumn' ||
                                divElements[i].className == 'wsColumnChange' ||
                                divElements[i].className == 'wsColumnError'){
                                if (firstDiv == null){
                                    firstDiv = divElements[i];
                                }

                                if (nextCell){
                                    divToClick = divElements[i];
                                    break;
                                } else if (divElements[i].style.overflow == 'visible'){
                                    if (event.shiftKey){ /* shift-tabulation ==> Precedent cell */
                                        if (divElements[i] == firstDiv){ /* shitf-tabulation in first cell */
                                            lastCell = true;
                                        } else {
                                            divToClick = lastDiv;
                                            break;
                                        }
                                    } else { /* tabulation ==> Next cell */
                                        nextCell = true;
                                    }
                                }
                                lastDiv = divElements[i];
                            }
                        }

                        if (divToClick == null){
                            if (nextCell){ /* tabulation in last cell */
                                divToClick = firstDiv;
                            } else if (lastCell) { /* shitf-tabulation in first cell */
                                divToClick = lastDiv;
                            }
                        }
                    }

                    var changedValue = input.val();
                    var hasRules;
                    $.each($("#wsColumnInput").rules(), function() { hasRules = true; });
                    /* validate manually */
                    if (changedValue != originalValue) {
                        var validator = validatorObject[wsColumn.id];
                        if (validator) {
                            validator.element($('#wsColumnInput'));
                        }
                    }
                    cell.text('');
                    cell.css('overflow', 'hidden');
                    cell.text(changedValue);
                    if (changedValue != originalValue) {
                        $.jmesa.submitWsColumn(originalValue, changedValue, hasRules);
                    }
                    wsColumn = null;

                    if (divToClick != null){
                        divToClick.onclick();
                        return false; /* Stop event for IE */
                    }

                }
            };

            if (jQuery.browser.msie || jQuery.browser.safari) { /* IE and Safari don't catch tabulation on keypress */
                $('#wsColumnInput').keydown(keyEvent);
            } else {
                $('#wsColumnInput').keypress(keyEvent);
            }
        },
        submitWsCheckboxColumn : function(column, id, uniqueProperties, property) {
            wsColumn = new classes.WsColumn(column, id, uniqueProperties, property);

            var checked = column.checked;

            var changedValue = 'unchecked';
            if (checked) {
                changedValue = 'checked';
            }

            var originalValue = 'unchecked';
            if (!checked) { /* The first time the original value is the opposite. */
                originalValue = 'checked';
            }

            $.jmesa.submitWsColumn(originalValue, changedValue);

            wsColumn = null;
        },
        setError : function(id, em) {
           errorMap[id] = em;
        },
        setValidator : function(id, vr) {
           validatorObject[id] = vr;
        },
        submitWsColumn : function(originalValue, changedValue, hasRules) {
            var data = '{ "id" : "' + wsColumn.id + '"';

            data += ', "cp_" : "' + wsColumn.property + '"';

            var props = wsColumn.uniqueProperties;
            $.each(props, function(key, value) {
                data += ', "up_' + key + '" : "' + value + '"';
            });

            data += ', "ov_" : "' + encodeURIComponent(originalValue) + '"';
            data += ', "cv_" : "' + encodeURIComponent(changedValue) + '"';

            var cell = $(wsColumn.column);
            var errorMessage;

            if (hasRules) {
               if (errorMap[wsColumn.id]) {
                  errorMessage = errorMap[wsColumn.id][wsColumn.property];
               }
            } else {
               errorMessage = cell.attr('title');
            }

            if (errorMessage) {
               data += ', "em_" : "' + encodeURIComponent(errorMessage) + '"';
            }

            data += '}'

            var contextPath = coreapi.getContextPath(wsColumn.id);
            if (contextPath) {
               contextPath += "/";
            }

            $.post(contextPath + 'jmesa.wrk?', eval('(' + data + ')'), function(columnStatus) {
                  jQuery.jmesa.updateCssClass(columnStatus, cell, errorMessage);
            });
        },
        updateCssClass : function(columnStatus, cell, errorMessage) {
            /* Column status returned from worksheet servlet */
            var classNames = {
               "_rm_" : 'wsColumn',
               "_uu_" : 'wsColumnChange',
               "_ue_" : 'wsColumnError'
            };

            /* Skip other editors, e.g. checkbox etc */
            $.each(classNames, function(key, value) {
              if (cell.attr('class') == value) {
                 cell.attr('class', classNames[columnStatus]);

                 if (errorMessage) {
                    cell.attr('title', errorMessage);
                 } else {
                    cell.removeAttr('title');
                 }
                 return;
              }
            });
        }
    }

    /************* Special Effects ***********/

    var effectsapi = {
        addDropShadow : function(imagesPath, theme) {
            if (!theme) {
                theme = 'jmesa';
            }
            $('div.' + theme + ' .table')
            .wrap("<div class='wrap0'><div class='wrap1'><div class='wrap2'><div class='dropShadow'></div></div></div></div>")
            .css({'background': 'url(' + imagesPath + 'shadow_back.gif) 100% repeat'});

            $('.' + theme + ' div.wrap0').css({'background': 'url(' + imagesPath + 'shadow.gif) right bottom no-repeat', 'float':'left'});
            $('.' + theme + ' div.wrap1').css({'background': 'url(' + imagesPath + 'shadow180.gif) no-repeat'});
            $('.' + theme + ' div.wrap2').css({'background': 'url(' + imagesPath + 'corner_bl.gif) -18px 100% no-repeat'});
            $('.' + theme + ' div.dropShadow').css({'background': 'url(' + imagesPath + 'corner_tr.gif) 100% -18px no-repeat'});

            $('div.' + theme).append('<div style="clear:both">&nbsp;</div>');
        }
    }

    /* Put all the methods under the $.jmesa context. */

    $.extend(coreapi, filterapi);
    $.extend(coreapi, worksheetapi);
    $.extend(coreapi, effectsapi);
    $.jmesa = {};
    $.extend($.jmesa, coreapi);

})(jQuery);
