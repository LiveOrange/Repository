;
(function($) {
	$.fn.extend({
		messageinp6 : function() {
			return $(this).click(function() {
				$("#table_1 tbody tr").remove();
				var tbody=$("#table_1 tbody");	
				$.ajax({
					type : "get",
					url : "ContachupdatServlet",
					data : {
						id : $.trim($(".span").attr("x")),
					},
					success : function(data, textStatus) {
						var objs = eval(data);
						for(var i=0;i<objs.length;i++){
							var tr=$("<tr></tr>");
								tr.appendTo(tbody);	
							for(var j = 0 ;j<1;j++){
								var td=$("<td>"+objs[i].data+"</td>");
								    td.appendTo(tr);
							    var td=$("<td>"+objs[i].clientName+"</td>");
							    td.appendTo(tr);
							    var td=$("<td>"+objs[i].clientPhone+"</td>");
							    td.appendTo(tr);
							    var td=$("<td>"+objs[i].maturity+"</td>");
							    td.appendTo(tr);
							    var td=$("<td>"+objs[i].attribute+"</td>");
							    td.appendTo(tr);
							    var td=$("<td>"+objs[i].chWay+"</td>");
							    td.appendTo(tr);
							    var td=$("<td>"+"未定"+"</td>");
							    td.appendTo(tr);
							}
						}
					}
				});
			});
		}
	});
})(jQuery);