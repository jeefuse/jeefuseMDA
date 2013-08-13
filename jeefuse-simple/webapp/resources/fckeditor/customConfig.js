FCKConfig.FontNames		= '宋体;黑体;楷体_GB2312;Arial;Comic Sans MS;Courier New;Tahoma;Times New Roman;Verdana' ;
//FCKConfig.FontSizes		= 'smaller/较小;larger/较大;xx-small/极细字;x-small/细字;small/小字体;medium/中字体;large/大字体;x-large/加大字;xx-large/特大字' ;

FCKConfig.AutoDetectLanguage = false ;
FCKConfig.DefaultLanguage = "zh-cn" ;
FCKConfig.StartupFocus = false ;

FCKConfig.LinkBrowser = false ;
FCKConfig.ImageBrowser = false ;
FCKConfig.FlashBrowser = false ;

FCKConfig.LinkUpload = false ;
FCKConfig.ImageUpload = true ;
FCKConfig.FlashUpload = false ;

FCKConfig.Plugins.Add('simplecommands');
FCKConfig.Plugins.Add('Media','en,zh-cn');

//FCKConfig.Plugins.Add('attachment','zh-cn');

FCKConfig.ToolbarSets["mydefault"] = [
	['Source','FitWindow','Preview'],
	['Templates','Print'],
	['Cut','Copy','Paste','PasteText','PasteWord'],
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	['Form','Checkbox','Radio','TextField','Textarea','Select','Button','ImageButton','HiddenField'],
	['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],
	['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote','CreateDiv'],
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
	['Link','Unlink','Anchor'],
	['Image','Flash','Media','Table','Rule','SpecialChar'],
	['StyleSimple','FontFormatSimple','FontNameSimple','FontSizeSimple'],
	['TextColor','BGColor'],
	['PageBreak']
];

FCKConfig.ToolbarSets["template"] = [
	['Source','FitWindow','Preview','Save'],
	['Templates','Print'],
	['Cut','Copy','Paste','PasteText','PasteWord'],
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	['Form','Checkbox','Radio','TextField','Textarea','Select','Button','ImageButton','HiddenField'],
	['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],
	['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote','CreateDiv'],
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
	['Link','Unlink','Anchor'],
	['Image','Flash','Media','Table','Rule','SpecialChar'],
	['StyleSimple','FontFormatSimple','FontNameSimple','FontSizeSimple'],
	['TextColor','BGColor']
];

FCKConfig.ToolbarSets["goolovEdit"] = [
	['FitWindow','Preview','Source','-','Paste','PasteText','PasteWord','-'],
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	['Bold','Italic','Underline','StrikeThrough'],
	['OrderedList','UnorderedList'],
	'/',
	['StyleSimple','FontFormatSimple','FontNameSimple','FontSizeSimple'],
	['TextColor','BGColor'],
	['Outdent','Indent','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
	['Link','Unlink','Image','Flash','SpecialChar','PageBreak']
];
FCKConfig.ToolbarSets["goolovEditTab"] = [
       	['Preview','-','Paste','PasteText','PasteWord','-'],
     	['Undo','Redo','-','-','SelectAll','RemoveFormat'],
     	['Bold','Italic','Underline','StrikeThrough'],
     	['OrderedList','UnorderedList'],
     	'/',
     	['StyleSimple','FontFormatSimple','FontNameSimple','FontSizeSimple'],
     	['TextColor','BGColor'],
     	['Outdent','Indent','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
     	['Link','Unlink','Image','Flash','SpecialChar','PageBreak']
   ];