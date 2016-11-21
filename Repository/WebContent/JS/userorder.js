;
(function($) {
	$.fn.extend({
		userorder : function() {
			return $(this).each(function() {
				// 首页
				$(".a1_1").click(function() {
					var detas=$("#user_dl1_li1").text().substr(1);
					if(detas=="全部数据"){
						detas="";
					}
					var a =$(".a1").text();
					if(a!="1"){
						a=1;
					}
					$.ajax({
						type : "post",
						url : "CustomerInqServlet",
						data : {
							curpage:a,
							data:detas,
						},
						success : function(data, textStatus) {
							var tbody=	$(".user_tab tbody");
							tbody.empty();
							if(data.length==0){
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
				});
				/// /上一页
			$(".a1_2").click(function() {
					var detas=$("#user_dl1_li1").text().substr(1);
					if(detas=="全部数据"){
						detas="";
					}
					var a =$(".a1").text();
					var a1 =$(".a2").text()
					var a=Number(a);
					if(a!=1){
						a=a-1;
					}
					$.ajax({
						type : "post",
						url : "CustomerInqServlet",
						data : {
							curpage:a,
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
									 var td=$("<td>"+ "<input type='button' class='button button1' value='出库'/>"
											 +"</td>");
									    td.appendTo(tr);
								}
							}
							}}});
				});
				/// /下一页
			$(".a1_3").click(function() {
					var detas=$("#user_dl1_li1").text().substr(1);
					if(detas=="全部数据"){
						detas="";
					}
					var a =$(".a1").text();
					var a1 =$(".a2").text()
					var a=Number(a);
					var a1= Number(a1);
					if(a<a1){
						a=a+1;
					}
					$.ajax({
						type : "post",
						url : "CustomerInqServlet",
						data : {
							id : $.trim($(".x1").attr("x")),
							curpage:a,
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
									 var td=$("<td>"+ "<input type='button' class='button button1' value='出库'/>"
											+"</td>");
									    td.appendTo(tr);
								}
							}
							}}});
				});
			//最后一页
				$(".a1_4").click(function() {
					var detas=$("#user_dl1_li1").text().substr(1);
					if(detas=="全部数据"){
						detas="";
					}
					var a =$(".a1").text();
					var a1 =$(".a2").text()
					if(a!=a1){
						a=a1;
					}	
					$.ajax({
						type : "post",
						url : "CustomerInqServlet",
						data : {
							id : $.trim($(".x1").attr("x")),
							curpage:a,
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
									var td=$("<td>"+ "<input type='button' class='button button1' value='出库'/>"
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