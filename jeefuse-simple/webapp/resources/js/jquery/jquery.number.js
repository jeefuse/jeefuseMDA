jQuery.fn.validNumber = function(){
	this.keypress(function(e){
	    if(((e.which >= 45 && e.which <= 57) && e.ctrlKey == false && e.shiftKey == false) || e.which == 0 || e.which == 8) {
	        if(e.which == 45){
	            if($(this).val().indexOf("-") == -1) {
	                $(this).val('-'+$(this).val());
	            }
	            return false;
	        } else if(e.which == 46){
	            if($(this).val().indexOf(".") == -1) {
	                return true;
	            } else {
	                return false;
	            }
	        }
	        return true;
	    }
	    return false;
	}).bind("selectstart",function(){return false;}).bind("paste",function(){return false;}).css({'imeMode':"disabled"});
};
jQuery.fn.validDigit = function(){
	this.keypress(function(e) {
		return (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) ? false : true;
	}).bind("selectstart",function(){return false;}).bind("paste",function(){return false;}).css({'imeMode':"disabled"});
};
$(document).ready(function(){
	$('input.validDigit').validDigit();
	$('input.validNumber').validNumber();
});
