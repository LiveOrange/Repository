;
(function($) {
	$.fn.extend({
		change : function() {
			// 样式
			return $(this).each(function() {
				var datas = $(this);
				datas.find('tr').each(function(index) {
					$(this).attr("x", index);
					$(".div_4_div").show();
					$(".change").hide();
					$(".order").hide();
					$(".Customer").hide();
					$(".MyCustomer").hide();
					
				}).click(function() {
					var a = parseInt($(this).attr('x')) + 1;
					if (a == 1) {
						$(".div_4_div").show();
						$(".change").hide();
						$(".order").hide();
						$(".Customer").hide();
						$(".MyCustomer").hide();
					} else if (a == 2) {
						$(".order").show();
						$(".change").hide();
						$(".div_4_div").hide();
						$(".Customer").hide();
						$(".MyCustomer").hide();
					} else if (a == 3) {
						$(".order").hide();
						$(".change").hide();
						$(".div_4_div").hide();
						$(".Customer").hide();
						$(".MyCustomer").show();
					} else if (a == 4) {
						$(".order").hide();
						$(".change").hide();
						$(".div_4_div").hide();
						$(".Customer").show();
						$(".MyCustomer").hide();
						var data="";
						$.ajax({
							type : "post",
							url : "CustomerInqServlet",
							data : {
								data:data,
							},
							success : function(data, textStatus) {
								var iframe = $("#iframe8").contents();
								var tbody=	$(iframe).find(".user_tab tbody");
								var objs = eval(data);
								tbody.empty();
								if(data.length==0){
									console.log("asd");
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
										var td=$("<td>"+objs[i].id+"</td>");
										    td.appendTo(tr);
									    var td=$("<td>"+objs[i].compName+"</td>");
									    td.appendTo(tr);
									    var td=$("<td>"+objs[i].quantity+"</td>");
									    td.appendTo(tr);
									    var td=$("<td>"+objs[i].agency+"</td>");
									    td.appendTo(tr);
									    var td=$("<td>"+objs[i].userName+"</td>");
									    td.appendTo(tr);
									    var td=$("<td>"+objs[i].datas+"</td>");
									    td.appendTo(tr);
										 var td=$("<td>"+ "<input type='button' class='button button1' value='出库'/>"
												 +"</td>");
										    td.appendTo(tr);
									}
								}
							}}});
					} else if (a == 5) {
						$(".change").show();
						$(".order").hide();
						$(".div_4_div").hide();
						$(".Customer").hide();
						$(".MyCustomer").hide();
						$.ajax({
							type : "get",
							url : "OrderSum",
							data : {
								data:data,
							},
							success : function(data, textStatus) {
								var datas=JSON.parse(data); 
								console.log(datas);
								var iframe = $("#iframe6").contents();
									$(iframe).find(".div_dt2").text(datas.Sum);
									$(iframe).find(".cw1").text(datas.Sum1);
									$(iframe).find(".cw1_1").text(100-datas.Sum1);
									$(iframe).find(".cw2").text(datas.Sum2);
									$(iframe).find(".cw2_1").text(100-datas.Sum2);
									$(iframe).find(".cw3").text(datas.Sum3);
									$(iframe).find(".cw3_1").text(100-datas.Sum3);
									$(iframe).find(".cw4").text(datas.Sum4);
									$(iframe).find(".cw4_1").text(100-datas.Sum4);
									$(iframe).find(".cw5").text(datas.Sum5);
									$(iframe).find(".cw5_1").text(100-datas.Sum5);
									$(iframe).find(".cw6").text(datas.Sum6);
									$(iframe).find(".cw6_1").text(100-datas.Sum6);
									var eValue=datas.Sum2;  
							}});
					}
				});
			});
		}
	});
})(jQuery);