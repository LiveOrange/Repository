;
(function($) {
	$.fn.extend({
		inpute3 : function() {
			return $(this).click(function() {
				var take = $(this).parents('tr').children('td');
				var id = take.eq(0).text();
				$.ajax({
					type : "post",
					url : "../home3/CustomerInqServlet",
					data : {
						data:id,
					},
					success : function(data, textStatus) {
						var tbody=	$(".table3 tbody");
						tbody.empty();
						if(data.length==0){
							$(".a1").text(0);
							$(".a2").text(0);
							$(".a3").text(0);
						}else{
						var objs = eval(data);
						$(".a1").text(objs[0].curpage);
						$(".a2").text(objs[0].pages);
						$(".a3").text(objs[0].total);
						for(var i=0;i<objs.length;i++){
							var tr=$("<tr></tr>");
								tr.appendTo(tbody);	
							for(var j = 0 ;j<1;j++){
							var td=$("<td id='wareh'>"+objs[i].wareh+"</td>");
							    td.appendTo(tr);
							var td=$("<td>"+objs[i].id+"</td>");
							td.appendTo(tr);
						    var td=$("<td>"+objs[i].compName+"</td>");
						    td.appendTo(tr);
						    var td=$("<td>"+objs[i].datas+"</td>");
						    td.appendTo(tr);
							var td=$("<td>"+ "<input type='checkbox' class=list />"+"</td>");
							td.appendTo(tr);
							}
						}
						}}});
			});

		}
	});
})(jQuery);