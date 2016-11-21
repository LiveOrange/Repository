;
(function($) {
	$.fn.extend({
		messageinp5 : function() {
			return $(this).click(function() {
				if ($("#select_1 option:selected").attr("x") != null) {
					if (confirm('删除该联系人吗？')) {
						$.ajax({
							type : "get",
							url : "ContachDeltServlet",
							data : {
								id : $("#select_1 option:selected").attr("x"),
							},
							success : function(data, textStatus) {
								if (data == "1") {
									alert("联系人删除成功!");
								} else {
									alert("联系人删除失败!");
								}
							}
						});
					}
				} else {
					alert("请选择要删除的联系人!");
				}
			});
		}
	});
})(jQuery);