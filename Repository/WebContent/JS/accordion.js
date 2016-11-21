;
(function($) {
	$.fn.extend({
		accordion : function() {
			// 样式 
			return $(this).each(function() {
				var datas = $(this);
				datas.find('li').each(function(index) {
					$(this).attr("x", index);
					datas.find('li').eq(0).css("background-color", " #3399FF");
					$("#iframe_02").hide();iframe1
					$("#iframe_03").hide();
					$("#iframe_04").hide();
				}).click(function() {
					$(this).siblings().css("background-color", " #4B6EA8");
					$(this).css("background-color", " #3399FF");
					var a = parseInt($(this).attr('x')) + 1;
					if (a == 1) {
						$("#iframe_01").show();
						$("#iframe_02").hide();
						$("#iframe_03").hide();
						$("#iframe_04").hide();
						$("#iframe_10").show();
						$.ajax({
							type : "get",
							url : "ContachupdatServlet",
							data : {
								id : $.trim($(".x1").attr("x")),
							},
							success : function(data, textStatus) {
								var iframe = $("#iframe1").contents().find("#table_1");
								var objs = eval(data);
								var tbody=	$(iframe).find("tbody");
								tbody.empty();
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
					} else if (a == 2) {
						$("#iframe_01").hide();
						$("#iframe_02").show();
						$("#iframe_03").hide();
						$("#iframe_04").hide();
						$("#iframe_10").show();
					} else if (a == 3) {
						$("#iframe_01").hide();
						$("#iframe_02").hide();
						$("#iframe_03").show();
						$("#iframe_04").hide();
						$("#iframe_10").hide();
						$.ajax({
							type : "get",
							url : "ContachupdatServlet",
							data : {
								id : $.trim($(".x1").attr("x")),
							},
							success : function(data, textStatus) {
								var iframe = $("#iframe4").contents();
								var tbody=	$(iframe).find(".rea_table_1").find("tbody");
								tbody.empty();
								var objs = eval(data);
								for(var i=0;i<objs.length;i++){
									var tr=$("<tr></tr>");
										tr.appendTo(tbody);	
									for(var j = 0 ;j<1;j++){
										var td=$("<td>"+objs[i].data+"</td>");
										    td.appendTo(tr);
									    var td=$("<td>"+objs[i].clientName+"/"+objs[i].clientPhone+"</td>");
									    td.appendTo(tr);
									    var td=$("<td>"+objs[i].clientProd+"</td>");
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
						
					} else if (a == 4) {
						$("#iframe_01").hide();
						$("#iframe_02").hide();
						$("#iframe_03").hide();
						$("#iframe_04").show();
						$("#iframe_10").hide();
						alert("");
						$.ajax({
							type : "post",
							url : "CustomerInqServlet",
							data : {
								id : $.trim($(".x1").attr("x")),
							},
							success : function(data, textStatus) {
								var iframe = $("#iframe5").contents();
								var tbody=	$(iframe).find(".user_tab tbody");
								var objs = eval(data);
								console.log(objs[0]);
								tbody.empty();
								if(data.length==0){
									$(iframe).find(".a1").text(0);
									$(iframe).find(".a2").text(0);
									$(iframe).find(".a3").text(0);
								}else{
								$(iframe).find(".a1").text(objs[0].curpage);
								$(iframe).find(".a2").text(objs[0].pages);
								$(iframe).find(".a3").text(objs[0].total);
								for(var i=0;i<objs.length;i++){
									var tr=$("<tr></tr>");
										tr.appendTo(tbody);	
									for(var j = 0 ;j<1;j++){
										var td=$("<td>"+objs[i].clientId+"</td>");
										    td.appendTo(tr);
									    var td=$("<td>"+objs[i].clientProd+"</td>");
									    td.appendTo(tr);
									    var td=$("<td>"+objs[i].clientfirm+"</td>");
									    td.appendTo(tr);
									    var td=$("<td>"+objs[i].clientOrder+"</td>");
									    td.appendTo(tr);
									    var td=$("<td>"+objs[i].userName+"</td>");
									    td.appendTo(tr);
									    var td=$("<td>"+objs[i].datas+"</td>");
									    td.appendTo(tr);
										 var td=$("<td>"+ "<input type='button' class='button button1' value='修改'/>" 
												 		+ "<input type='button' class='button button2' value='删除'/>" +"</td>");
										    td.appendTo(tr);
									}
								}
							}
						}});
					}
				});
			});
		}
	});
})(jQuery);