;
(function($) {
	$.fn.extend({
		honmeli2 : function() {
			return $(this).each(
					function(index) {
						$(this).attr('x', index);
						$(this).click(function() {
									var de = $(this).attr('x');
									var a=$.trim($(".x1").attr("x"));
									var url;
									if (de == 0) {
										url='../xmw/' +"ContactsServlet?id="+a;
									} else if (de == 1) {
										url ='../home2/' + 'branch.html';
									} else if (de == 2) {
										url = '../home2/' +'DeptInqServlet?curpage=1&pagesize=4';
									} else if (de == 3) {
										url =  '../home2/' +'DetpLookServlet';
									} else if (de == 4) {
										url = '../home2/' +'UserInqsServlet?curpage=1&pagesize=4';
									}
									window
											.open(url,
													'newwindow',
													'height=500,width=400,top=100,left=100,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no');
								});
		
					});}
	});
})(jQuery);