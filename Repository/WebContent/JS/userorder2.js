;
(function($) {
	$.fn.extend({
		userorder1 : function() {
			return $(this).each(function() {
				$(this).click(function (){
					$(this).attr('id', 'user_dl1_li1')
					$(this).siblings().attr('id', '');
					var detas=$("#user_dl1_li1").text().substr(1);
					if(detas=="全部数据"){
						detas="";
					}
					$.ajax({
						type : "post",
						url : "CustomerInqServlet",
						data : {
							data:detas,
						},
						success : function(data, textStatus) {
							var tbody=	$(".user_tab tbody");
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
									 var td=$("<td>"+ "<input type='button' class='button button1' name=a value='出库'/>"
											 +"</td>");
									    td.appendTo(tr);
									  
								}
							}
						}}});
				});
			});
		}
	});
})(jQuery);