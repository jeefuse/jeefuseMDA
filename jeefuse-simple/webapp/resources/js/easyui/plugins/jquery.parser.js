(function($){
	$.parser = {
		auto: true,
		plugins:['linkbutton','menu','menubutton','splitbutton','layout',
				 'tree','window','dialog','datagrid',
				 'combobox','combotree','numberbox','validatebox',
				 'calendar','datebox','panel','tabs','accordion'
		],
		parse: function(context){
			if ($.parser.auto){
				for(var i=0; i<$.parser.plugins.length; i++){
					(function(){
						var name = $.parser.plugins[i];
						var r = $('.easyui-' + name, context);
						if (r.length){
							if (r[name]){
								r[name]();
							} else if (window.easyloader){
								easyloader.load(name, function(){
									r[name]();
								})
							}
						}
					})();
				}
			}
		}
	};
	$(function(){
		$.parser.parse();
	});
})(jQuery);