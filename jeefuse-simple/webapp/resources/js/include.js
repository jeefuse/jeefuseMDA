/*
 * 加载JS及CSS文件.
 * author:yonclv email:yonclv@gmail.com
 */
function loadFile(file, basePath) {
	var includePath = basePath ? basePath : "";
	var files = typeof file == "string" ? [ file ] : file;
	for ( var i = 0; i < files.length; i++) {
		var name = files[i].replace(/^\s|\s$/g, "");
		var att = name.split('.');
		var ext = att[att.length - 1].toLowerCase();
		var isCSS = ext == "css";
		var tag = isCSS ? "link" : "script";
		var attr = isCSS ? " type='text/css' rel='stylesheet' " : " type='text/javascript' ";
		var link = (isCSS ? "href" : "src") + "='" + includePath + name + "'";
		document.write("<" + tag + attr + link + "></" + tag + ">");
	}
};
var importFiles = "";
function importFile(filepath, ctxpath) {
	if (importFiles.indexOf("[" + filepath + "]") == -1) {
		loadFile(filepath, ctxpath);
		importFiles += "[" + filepath + "]";
	}
}
function importJsFile(names, contextPath) {
	var basePath = contextPath ? contextPath : "";
	var fileNames = names.split('|');
	var len = fileNames.length;
	for ( var i = 0; i < len; i++) {
		var name = fileNames[i];
		if (!name || name == "")
			continue;
		switch (name) {
		case 'jquery':// jquery library
			importFile('/resources/js/jquery/jquery-1.4.2.min.js', basePath);
			break;
		case 'common':
			importFile('/resources/js/goolov.common.js', basePath);
			break;
		case 'ui':
			importFile('/resources/js/easyui/jquery.ui.pack.js', basePath);
			// importFile('/resources/js/easyui/custom/jquery.tabs.js',basePath);
			// importFile('/resources/js/easyui/plugins/jquery.layout.js',basePath);
			// importFile('/resources/js/easyui/plugins/jquery.resizable.js',basePath);
			// importFile('/resources/js/easyui/plugins/jquery.panel.js',basePath);
			// importFile('/resources/js/easyui/plugins/jquery.linkbutton.js',basePath);
			// importFile('/resources/js/easyui/custom/jquery.parser.js',basePath);
			break;
		case 'comboBox':
			importFile('/resources/js/jeefuseUI/jeefuseUI.comboBox.js', basePath);
			break;
		case 'comboGrid':
			importFile('/resources/js/jeefuseUI/jeefuseUI.comboGrid.js', basePath);
			break;
		case 'combotree':
			importFile('/resources/js/jeefuseUI/jeefuseUI.combotree.js', basePath);
			break;
		case 'comboDialog':
			importFile('/resources/js/jeefuseUI/jeefuseUI.comboDialog.js', basePath);
			break;
		case 'number':
			importFile('/resources/js/jquery/jquery.number.js', basePath);
			break;
		case 'blockUI':
			importFile('/resources/js/blockUI/jquery.blockUI.js', basePath);
			break;
		case 'flexiGrid':
			importFile('/resources/js/flexiGrid/jquery.flexigrid.js', basePath);
			break;
		case 'flexiTreeGrid':
			importFile('/resources/js/flexiGrid/jquery.flexigridTree.js', basePath);
			break;
		case 'jmesa':
			importFile('/resources/js/jmesa/jmesa.js', basePath);
			importFile('/resources/js/jmesa/jquery.jmesa.js', basePath);
			break;
		case 'validate':
			importFile('/resources/js/validate/jquery.validate.js', basePath);
			importFile('/resources/js/validate/custom.validate.js', basePath);
			importFile('/resources/js/validate/messages_cn.js', basePath);
			importFile('/resources/js/bgiframe/jquery.bgiframe.pack.js', basePath);
			break;
		case 'form':
			importFile('/resources/js/form/jquery.form.js', basePath);
			break;
		case 'treeview':
			importFile('/resources/js/tree/jquery.tree.js', basePath);
			break;
		case 'contextmenu':
			importFile('/resources/js/contextmenu/jquery.contextmenu.js', basePath);
			break;
		case 'autocomplete':
			importFile('/resources/js/autocomplete/jquery.autocompleteCombo.js', basePath);
			break;
		case 'superfish':
			importFile('/resources/js/superfish/superfish.js', basePath);
			importFile('/resources/js/superfish/supersubs.js', basePath);
			break;
		case 'ddsmoothmenu':
			importFile('/resources/js/ddsmoothmenu/ddsmoothmenu.js', basePath);
			break;
		case 'fckeditor':
			importFile('/resources/fckeditor/fckeditor.js', basePath);
			break;
		case 'datePicker':
			importFile('/resources/js/jquery/jquery.datepicker.js', basePath);
			break;
		case 'json':
			importFile('/resources/js/common/json2.js', basePath);
			break;
		case 'uploadify':
			importFile('/resources/js/uploadify/jquery.uploadify.v2.1.4.js', basePath);
			importFile('/resources/js/uploadify/swfobject.js', basePath);
			break;
		case 'math':
			importFile('/resources/js/common/math.js', basePath);
			break;
		case 'date':
			importFile('/resources/js/common/date.js', basePath);
			break;
		case 'fsCharts':
			importFile('/resources/fusionCharts/FusionCharts.js', basePath);
			break;
		case 'encrypt':
			importFile('/resources/js/common/md5.js', basePath);
			break;
		default:
			importFile(name, basePath);
		}
	}
}
function importCssFile(names, contextPath, theme) {
	var basePath = contextPath ? contextPath : "";
	var style = (theme && (theme != '')) ? theme : 'default';
	var fileNames = names.split('|');
	var len = fileNames.length;
	for ( var i = 0; i < len; i++) {
		var name = fileNames[i];
		if (!name || name == "")
			continue;
		switch (name) {
		case 'init':
			importFile('/resources/style/base/init-3.css', basePath);
			break;
		case 'sys':
			importFile('/resources/style/base/init-3.css', basePath);
			importFile('/resources/style/' + style + '/system/sys.css', basePath);
			break;
		case 'form':
			importFile('/resources/style/' + style + '/jeefuseUI/jeefuseUI-form.css', basePath);
			break;
		case 'xform':
			importFile('/resources/style/' + style + '/jeefuseUI/jeefuseUI-xform.css', basePath);
			break;
		case 'button':
			importFile('/resources/style/' + style + '/jeefuseUI/jeefuseUI-button.css', basePath);
			break;
		case 'treeview':// main css
			importFile('/resources/style/' + style + '/tree/tree.css', basePath);
			break;
		case 'ui':
			//importFile('/resources/style/'+style+'/easyui/panel.css', basePath);
			//importFile('/resources/style/'+style+'/easyui/linkbutton.css',basePath);
			//importFile('/resources/style/'+style+'/easyui/layout.css', basePath);
			//importFile('/resources/style/' + style + '/easyui/icon.css', basePath);
			importFile('/resources/style/' + style + '/easyui/jquery.ui.pack.css', basePath);
			break;
		case 'tabs':
			importFile('/resources/style/' + style + '/easyui/tabs.css', basePath);
			break;
		case 'flexiGrid':
			importFile('/resources/style/' + style + '/flexiGrid/css/flexigrid.css', basePath);
			break;
		case 'autocomplete':
			importFile('/resources/style/' + style + '/autocomplete/jquery.autocomplete.css', ctx);
			break;
		case 'comboBox':
			importFile('/resources/style/' + style + '/autocomplete/jquery.autocomplete.css',basePath);
			break;
		case 'jmesa':
			importFile('/resources/style/' + style + '/jmesa/jmesa.css', basePath);
			break;
		case 'validate':
			importFile('/resources/style/' + style + '/validate/jquery.validate.css', basePath);
			break;
		case 'contextmenu':
			importFile('/resources/style/' + style + '/contextmenu/contextmenu.css', basePath);
			break;
		case 'superfish':
			importFile('/resources/style/' + style + '/superfish/superfish.css', basePath);
			break;
		case 'superfish-navbar':
			importFile('/resources/style/' + style + '/superfish/superfish-navbar.css', basePath);
			break;
		case 'superfish-vertical':
			importFile('/resources/style/' + style + '/superfish/superfish-vertical.css', basePath);
			break;
		case 'ddsmoothmenu':
			importFile('/resources/style/' + style + '/ddsmoothmenu/ddsmoothmenu.css', basePath);
			break;
		case 'datePicker':
			importFile('/resources/style/' + style + '/datepicker/datepicker.css', basePath);
			break;
		case 'uploadify':
			importFile('/resources/style/' + style + '/uploadify/uploadify.css', basePath);
			break;
		default:
			importFile(name, basePath);
		}
	}
}