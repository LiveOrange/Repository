;
(function($) {
	$.fn.extend({
		messageinp4 : function() {
			return $(this).click(function() {
				var datas = $("#tdName1").attr("x");
				if (datas != null && datas.length > 0) {
					$.ajax({
						type : "post",
						url : "ContachInsertServlet",
						data : {
							clientName : $.trim($(".clientName").text()),
							context : $.trim($(".context").text()),
							attribute : $.trim($(".attribute").text()),
							clientIm : $.trim($(".clientIm").text()),
							clientPhone : $.trim($(".clientPhone").text()),
							clientCall : $.trim($(".clientCall").text()),
							clientFax : $.trim($(".clientFax").text()),
							id : $("#tdName1").attr("x"),
							email : $.trim($(".email").text()),
						},
						success : function(data, textStatus) {
							if (data == "1") {
								alert("联系人修改成功!");
							} else {
								alert("联系人修改失败!");
							}
						}
					});
				} else {
					alert("请选择联系人!");
				}
			});
		}
	});
})(jQuery);