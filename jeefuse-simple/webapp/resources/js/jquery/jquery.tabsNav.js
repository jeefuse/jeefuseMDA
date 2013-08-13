jQuery.fn.tabsNav = function(options){
	var $me=$(this);
	$(">div.v-tabs-nav li",$me).click(function(e) {
		 var tabs = $(this).parent().children("li");
		 tabs.removeClass("selected");
		 $(this).addClass("selected");
         var panels=$(">div.v-tabs-content>div",$me);
         var rel=$("a",this).attr("rel");
         if(rel){
             if(rel=="all"){
            	 panels.show();
             }else{
            	 panels.hide();
            	 $('#'+rel).show();
             }
         }
         $(this).blur();
         if(options&&options.onclick){
        	 options.onclick(this);
         }
	});
};
jQuery.fn.menuBoxBar=function(){
	var $me=$(this);
	$(">div.menu-box>.menu-box-bar",$me).click(function(e) {
		if($(this).hasClass('menu-open')){
			$(this).removeClass('menu-open').addClass("menu-close");
			$(">.group",$(this).parent()).hide();
		}else{
			$(this).removeClass('menu-close').addClass("menu-open");
			$(">.group",$(this).parent()).show();
		}
	});
//	$("ul.group a",$me).click(function(e) {
////		var container=$(this).parent().parent().parent().parent().parent();
//		$("ul.group li",$me).removeClass("current");
//		$(this).parent().parent().addClass("current");
//	});
};