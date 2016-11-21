<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../CSS/xmw/userorder.css" rel="stylesheet"
	type="text/css" />
<script src="../../jqery/jquery-3.1.0.js"></script>
<script src="../../JS/userorder.js"></script>
<script src="../../JS/userorder2.js"></script>
<script type="text/javascript">
	$(function() {
		$("tr").hover(function() {
			$(this).siblings().removeClass('user_tab_bg');
			$(this).addClass('user_tab_bg');
		}, function() {
			$(this).removeClass('user_tab_bg');
		});
		$(".user_ul1 li").click(function() {
			$(this).attr('id', 'user_ul1_li');
			$(this).siblings().attr('id', '');
		});
		$(".user_dl1 dd").userorder1();
		$(".user_div41").userorder();
	});
</script>
</head>
<body>
	<div class="user_div1">
		<div class="user_div11">
			<ul class="user_ul1">
				<li id="user_ul1_li" class="x1">全部</li>
				<li>订单</li>
			</ul>
		</div>
	</div>

	<div class="user_div2">
		<div class="user_div31">
			<div class="user_div21">
				<dl class="user_dl1">
					<dt>
						<img src="../../IMG/xmw/user_dl1.png" width="12" height="12">&ensp;数据分类
					</dt>
					<dd id="user_dl1_li1">•全部数据</dd>
					<dd>•1号仓库</dd>
					<dd>•2号仓库</dd>
					<dd>•3号仓库</dd>
					<dd>•4号仓库</dd>
					<dd>•5号仓库</dd>
					<dd>•6号仓库</dd>
				</dl>
				<br>
			</div>
			<div class="user_div22">
				<div>
					<dl class="user_dl2">
						<dt>
							<img src="../../IMG/xmw/user_dl2.png" width="12" height="12">&ensp;快速查询
						</dt>
						<dd>&ensp;订单号</dd>

						<dd>
							<input type="text">
						</dd>
						<dd>
							<input type="submit" value="查询">
						</dd>

						<dd>公司名</dd>

						<dd>
							<input type="text">
						</dd>
						<dd>
							<input type="submit" value="查询">
						</dd>

					</dl>
				</div>
				<div class="table_div1">
					<table class="user_tab" border=1>
						<thead>
							<tr style="height: 30px;">
								<th colspan="7">合同/订单</th>
							</tr>
							<tr style="height: 28px;">
								<td width="5%">ID</td>
								<td width="20%">商品名称</td>
								<td width="10%">仓储数量</td>
								<td width="20%">订单号</td>
								<td width="10%">录库人</td>
								<td width="20%">入库时间</td>
								<td width="10%">编辑</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>209</td>
								<td>华为手机</td>
								<td>中泰</td>
								<td>wxd70</td>
								<td>刘东东</td>
								<td>2016-11-12</td>
								<td><input type="button" value="出库" name=a class="button1" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<br>
				<div class="user_div41">
					<span><a class="a1_1">第一页</a>&ensp;<a class="a1_2">上一页</a>&ensp;<a
						class="a1_3">下一页</a>&ensp;<a class="a1_4">最后一页</a>&ensp;<a
						class="a1">2</a>/<a class="a2">3</a>共<a class="a3">14</a>条记录</span>
				</div>
				<br>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('.table_div1').delegate('input[name=a]', 'click', function() {
				if (confirm('确定要将该商品出库吗？')) {
					var take = $(this).parents('tr').children('td');
					var id = take.eq(0).text();
					var datas = take.eq(1).text();
				
					$.ajax({
						type : "get",
						url : "OrdersServlet",
						data : {
							id : id,
						},
						success : function(data, textStatus) {
							if (data== "1") {
								alert(datas+"出库成功！");
								var detas2=$("#user_dl1_li1").text().substr(1);
								if(detas2=="全部数据"){
									console.log("0");
									detas2="";
								}
								$.ajax({
									type : "post",
									url : "CustomerInqServlet",
									data : {
										data:detas2,
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
							}else{
								alert(datas+"出库失败！");
							}
						}
					});
				}

			});
		});
	</script>
</body>
</html>