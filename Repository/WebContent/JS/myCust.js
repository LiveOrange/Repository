;
(function($) {
	$.fn.extend({
		myCust : function() {
			// 样式
			return $(this).each(function() {
				var datas = $(this);
				datas.find('li').each(function(index) {
					$(this).attr("x", index);
					datas.find('li').eq(0).css("background-color", " #3399FF");
					$("#iframe_011").show();
					$("#iframe_101").hide();
				}).click(function() {
					$(this).siblings().css("background-color", " #4B6EA8");
					$(this).css("background-color", " #3399FF");
					var a = parseInt($(this).attr('x')) + 1;
					if (a == 1) {
						$("#iframe_011").show();
						$("#iframe_101").hide();
					} else if (a == 2) {
						$("#iframe_011").hide();
						$("#iframe_101").show();
					}
				});
			});
		}
	});
})(jQuery);