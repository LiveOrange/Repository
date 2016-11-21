;
(function($) {
	$.fn.extend({
		mycustomerinp2 : function() {
			return $(this).click(
					function() {
						var data1 = $.trim($(".userName").text());
						var data3 = $.trim($(".CommoAdd2").attr("x"));
					
						if (data3 != null && data3.length > 0) {
							if ((data1 != null && data1.length > 0)) {
								$.ajax({
									type : "get",
									url : "../home/ContachInsertServlet",
									data : {
										id : $.trim($(".CommoAdd2").attr("x")),
										agency : $.trim($(".agency").text()),
										OutTime : $.trim($(".OutTime").val()),
										userName : $.trim($(".userName").text()),
										wareh : $("#order").find(
												"option:selected").text(),
									},
									success : function(data, textStatus) {
										if (data == "1") {
											alert("联系人保存成功!");
											window.location.reload();
										} else {
											alert("联系人保存失败!");
										}
									}
								});
							} else {
								alert("请输入录库人!");
							}
						}else{
							alert("请搜索商品入库!");
						}
						
					});
		}
	});
})(jQuery);