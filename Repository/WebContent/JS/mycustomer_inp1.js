;
(function($) {
	$.fn.extend({
		mycustomerinp1 : function() {
			return $(this).click(
					function() {
						var data1 = $.trim($(".LoginID").text());
						var data2 = $.trim($(".CompName").text());
						var data3 = $.trim($(".CommoName").text());
						var data4 = $.trim($(".CustName").text());
						var data5 = $.trim($(".CommoSourc").text());
						var data6 = $.trim($(".RegisTime").val());
						if ((data1 != null && data1.length > 0)
								|| (data2 != null && data2.length > 0)
								|| (data3 != null && data3.length > 0)
								|| (data4 != null && data3.length > 0)
								|| (data5 != null && data3.length > 0)
								|| (data6 != null && data3.length > 0)
								
							) {
							console.log(data1+":"+data2+":"+data3+":"+data4);
							$.ajax({
								type : "get",
								url : "MyClientServlet",
								data : {
									LoginID    : data1,
									CompName   : data2,
									CommoName  : data3,
									CustName   : data4,
									CommoSourc : data5,
									RegisTime  : data6,
								},
								success : function(data, textStatus) {
									var objs = eval(data);
									if (objs == "0") {
										$(".CompName2").text("");
										$(".LoginID2").text("");	
										$(".CommoSourc2").text("");
										$(".CustName2").text("");
										$(".MobPhone2").text("");
										$(".CommoName2").text("");
										$(".ProArea2").text("");
										$(".CommoAdd2").text("");
										alert("未找到客户！");	
									} else {
										var sum=objs[0].sum;
										console.log(objs[0]);
										for(var i=0;i<objs.length;i++){
											if(objs[i].id==sum){
												$(".CompName2").text(objs[i].compName);
												$(".LoginID2").text(objs[i].loginID);
												
												$(".CommoSourc2").text(objs[i].commoSourc);
												$(".CustName2").text(objs[i].custName);
												
												$(".MobPhone2").text(objs[i].mobPhone);
												$(".CommoName2").text(objs[i].commoName);
												
												$(".ProArea2").text(objs[i].proArea);
												$(".CommoAdd2").text(objs[i].commoAdd);
												
												$(".CommoAdd2").attr("x",objs[i].id);
											}
										}
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