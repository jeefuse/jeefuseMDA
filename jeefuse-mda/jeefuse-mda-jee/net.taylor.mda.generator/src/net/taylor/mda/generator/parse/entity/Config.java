package net.taylor.mda.generator.parse.entity;


public class Config {
	
	//系统模块代码组件结构
	public static String namespacePrefix="com.jeefuse";

	public static int defaultPropertyGridLength=20;
	public static int defaultTitlePropertyLength_Min=60;
	public static int defaultTitlePropertyLength_Max=129;
	public static int defaultTextAreaPropertyLength_Min=129;
	public static int defaultTextAreaPropertyLength_Max=257;
	public static int defaultContentPropertyLength_min=257;
	public static int defaultPropertyGridPixelScale=7;
	public static int defaultDateGridPixed=120;
	public static int defaultMinPropertyGridPixed=60;
	public static int offsetGridPixel=5;
	public static final String fileDefaultAcceptType="rar|txt|xlsx|xls|doc|docx|zip|cvs|xml|xls";
	public static final String imageDeaultAcceptType="gif|png|jpg";
	
	//默认注释
	public static final String defaultDocumentComments="@todo add comment for javadoc";
	//系统基础包名
	public static final String base_IdEntityQualifiedName = "com.jeefuse.base.model.IdEntity";
	public static final String base_ServiceQualifiedName = "com.jeefuse.base.service.BaseService";
	public static final String base_ServiceGenericQualifiedName = "com.jeefuse.base.service.GenericService";
	public static final String base_ServiceGenericImplQualifiedName = "com.jeefuse.base.service.impl.GenericServiceImpl";
	public static final String base_ActionQualifiedName = "com.jeefuse.base.web.action.BaseAction";
	public static final String base_FieldQualifiedName = "com.jeefuse.base.model.parse.ColumnField";
	public static final String base_PropertyValueGetClassName="com.jeefuse.base.model.parse.PropertyValueGet";
	public static final String base_AbstractModelExcelImport="com.jeefuse.base.modules.imports.excel.AbstractExcelImport";
	public static final String base_ModelExportFactory="com.jeefuse.base.modules.export.ModelExportFactory";
	public static final String base_HibernateDao="com.jeefuse.base.dao.HibernateDao";
	public static final String base_SpringContextUtils="com.jeefuse.base.service.SpringContextUtils";
	public static final String base_Exception_DataNoExistException="com.jeefuse.base.exception.DataNoExistException";
	public static final String base_GenericRTO="com.jeefuse.base.web.rto.GenericRTO";
	public static final String base_ExcelCheck="com.jeefuse.base.modules.imports.excel.utils.ExcelCheck";
	public static final String base_Kindable="com.jeefuse.base.model.Kindable";
	public static final String base_keyLabel="com.jeefuse.base.modules.keyLabel.KeyLabel";
	public static final String base_TreeViewItem="com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem";
	
	//java 变量方法命名规则
	public static final String java_html_selectList_Suffix="SelList";
	public static final String java_html_map_suffix="map";

	//系统资源
	public static String web_root_path="${ctx}";
	public static String web_resources_js_include=web_root_path+"/resources/js/include.js";
	public static String web_action_suffix=".vhtml";


	
	

}
