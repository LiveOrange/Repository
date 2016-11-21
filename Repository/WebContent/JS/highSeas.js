;
(function($) {
	$.fn.extend({
		highSeas : function() {
			return $(this).click(function() {
				var bb = "";
				var inputs = document.querySelectorAll(".list");
				console.log(inputs.length);
				for (var i = 0; i < inputs.length; i++) {
					if (inputs[i].checked) {
						var take = $(inputs[i]).parents('tr').children('td');
						var id = take.eq(1).text();
						bb += id + "+";
						console.log(id);
					}
				}
				if (bb.length <= 0) {
					alert("未选中转移商品！");
				} else {
					var data = $("#order").find("option:selected").text();
					var tbody=	$(".table3 tbody");
					tbody.empty();
					$.ajax({
						type : "get",
						url : "TransferServlet",
						data : {
							data : data,
							id:bb,
						},
						success : function(data, textStatus) {
							if(data=="1"){
								alert("商品转移成功！");
								$.ajax({
									type : "get",
									url : "../home3/OrderSum",
									data : {
										data:data,
									},
									success : function(data, textStatus) {
										var datas=JSON.parse(data); 
											$(".div_dt2").text(datas.Sum);
											$(".cw1").text(datas.Sum1);
											$(".cw1_1").text(100-datas.Sum1);
											$(".cw2").text(datas.Sum2);
											$(".cw2_1").text(100-datas.Sum2);
											$(".cw3").text(datas.Sum3);
											$(".cw3_1").text(100-datas.Sum3);
											$(".cw4").text(datas.Sum4);
											$(".cw4_1").text(100-datas.Sum4);
											$(".cw5").text(datas.Sum5);
											$(".cw5_1").text(100-datas.Sum5);
											$(".cw6").text(datas.Sum6);
											$(".cw6_1").text(100-datas.Sum6);
											var eValue=datas.Sum2;  
									}});
							}else{
								alert("商品转移失败！");	
							}
						}
					});
				}
			});
			$(".input2").click(function() {
				window.location.reload();
			});
		}
	});
})(jQuery);