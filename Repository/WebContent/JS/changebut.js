;
(function($) {
	$.fn.extend({
		submit : function() {
			return $(this).click(
					function() {
						console.log($(".chang_div3_select1 option:selected")
								.text()
								+ "" + $(".input1").val());
						console.log($(".input2").val());
						console.log($("#provincs option:selected").text());
						console.log($("#citys option:selected").text());
						console.log($(".select1 option:selected").text());
						console.log($(".input3").val());
						console.log($(".data1").val());
						console.log($(".data2").val());
						$.ajax({
							type : "post",
							url : "",
							data : {
								userName:$(".chang_div3_select1 option:selected").text(),
								loginID:$(".input1").val(),
								clientName:$(".input2").val(),
								region:$("#provincs option:selected").text()+$("#citys option:selected").text(),
								source:$(".select1 option:selected").text(),
								clientId:$(".input3").val(),
								dataTime:$(".data1").val(),
								data1:$(".data2").val(),
							},
							success : function(data, textStatus) {
								
							}
						});
					});
		}
	});
})(jQuery);
