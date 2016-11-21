;(function($){
     $.fn.extend({
    	 messageinp1: function(){
    		return $(this).click(function() {
    				var datas = $(".clientName").text();
    				if (datas != null && datas.length > 0) {
    					$("<option>").html(datas).appendTo($("#select_1"));
    					$.ajax({
    						type : "get",
    						url : "ContachInsertServlet",
    						data : {
    							clientName : $.trim($(".clientName").text()),
    							context : $.trim($(".context").text()),
    							attribute: $.trim($(".attribute").text()),
    							clientIm: $.trim($(".clientIm").text()),
    							clientPhone: $.trim($(".clientPhone").text()),
    							clientCall: $.trim($(".clientCall").text()),
    							clientFax: $.trim($(".clientFax").text()),
    						 	id : $.trim($(".span").attr("x")),
    						 	email : $.trim($(".email").text()),
    						},
    						success : function(data, textStatus) {
    							if(data=="1"){
    								alert("联系人添加成功!");
    							}else{
    								alert("联系人添加失败!");
    							}
    						}
    					});
    				} else {
    					alert("输入不能为空!");
    				}
    			}); 
    	 }
     });
})(jQuery);