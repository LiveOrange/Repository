;
(function($) {
	$.fn.extend({
		messageinp3 : function() {
		return $(this).click(function (){
			 $.ajax({
					type : "post",
					url : "ContachupdatServlet",
					data : {
						id : $.trim($(".span").attr("x")),
						name:$("#select_1 option:selected").text(),
					},
					success : function(data, textStatus) {
						var objs = eval(data);
						var objsn=objs[0];
						console.log(objsn);
						 $.trim($(".clientName").text(objsn.clientName));
						 $.trim($(".context").text(objsn.context));
						 $.trim($(".attribute").text(objsn.attribute));
						 $.trim($(".clientIm").text(objsn.clientIm));
						 $.trim($(".clientPhone").text(objsn.clientPhone));
						 $.trim($(".clientCall").text(objsn.clientCall));
						 $.trim($(".clientFax").text(objsn.clientFax));
					 	 $.trim($(".email").text(objsn.email));
					 	 $("#tdName1").attr("x",objsn.clientId);
					}
				});
		});

		}
	});
})(jQuery);