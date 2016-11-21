;
(function($) {
	$.fn.extend({
		messageinp2 : function() {
			return	$(this).click(function() {
				$.ajax({
					type : "get",
					url : "ContachupdatServlet",
					data : {
						id : $.trim($(".span").attr("x")),
					},
					success : function(data, textStatus) {
						var objs = eval(data);
						$("#select_1 option").remove();
						for(var i=0;i<objs.length;i++){
							$("<option>").html(objs[i].clientName).attr("x",objs[i].clientId).appendTo($("#select_1"));
							$(".clientName").text("");
							 $(".context").text("");
							 $(".attribute").text("");
							 $(".clientIm").text("");
							 $(".clientPhone").text("");
							 $(".clientCall").text("");
							 $(".clientFax").text("");
						 	 $(".email").text("");
						}
					}
				});
			});
		}
	});
})(jQuery);