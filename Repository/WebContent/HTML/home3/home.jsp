<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
<link href="../../CSS/xmw/home.css" rel="stylesheet" type="text/css" />
<script src="../../jqery/jquery-3.1.0.js"></script>
<script src="../../JS/home_dao.js"></script>
<script src="../../JS/home.js"></script>
<script src="../../JS/accordion.js"></script>
<script src="../../JS/change.js"></script>
<script src="../../JS/myCust.js"></script>
<script src="../../JS/searchs.js"></script>
<script src="../../JS/home_li2.js"></script>
<script>
	$(function() {
		$(".gation_div1").home_dao();
		$(".tr_1").jump();
		$(".div_div1").hover(function() {
			$(".div_2-1").slideDown();
		});
		$(".ul1").accordion();
		$(".ul2").myCust();
		$("#table1").change();
		$(".gation_div2").searchs();
		$(".div_2-1").mouseleave(function() {
			$(".div_2-1").slideUp();
		});
		$('.div_dl1').hover(function() {
			$(this).children("dd").addClass('dl1_dd1_color');
		}, function() {
			$(this).children("dd").removeClass('dl1_dd1_color');
		});
		$(".div_dl1").honmeli2();
	});
</script>
</head>
<body>
	<%
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -10);
	%>
	<div class="div_home">
		<div>
			<ul class="div1_ul_1">
				<li style="text-align: center; margin-left: 10px;">智能仓储</li>
			</ul>
			<ul class="div1_ul_2">
				<li class="x1" x=<%=session.getAttribute("id")%>>您好！&ensp;[<a><%=session.getAttribute("name")%></a>]&ensp;
				</li>
				<li>修改密码&ensp;</li>
				<li><a class="div_div_a1" href="../home/Enctys.html">注销&ensp;</a></li>
			</ul>
		</div>
		<div class="div_div1">
			<img src="../../IMG/xmw/zbds4.png" width="100%" height="100%" />
			<div></div>
		</div>
		<div class="gation">
			<div class="gation_div1">
				<ul>
					<li id="daohan">仓储查询</li>
					<li>客户查询</li>
				</ul>
			</div>
			<div class="gation_div2">
				<input type="text" class="gation_input1"><input type="image"
					src="../../IMG/xmw/submit1.png" width="37" class="gation_input2">
			</div>
		</div>
		<div class="div_1"></div>
		<div class="div_div2">
			<div class="div_2-1">
				<table style="border-collapse: collapse" class="table" border="0px">
					<tbody id="table1">
						<tr class="tr_1">
							<td class="td_1" id="td1" style="text-align: center;"><img src="../../IMG/xmw/dt1.png"></td>
							<td width="70%"  style="text-align: center;"><a>首页</a></td>
						</tr>
						<tr class="tr_1">
							<td class="td_1" id="td2"  style="text-align: center;"><img src="../../IMG/xmw/dt2.png"></td>
							<td width="70%"  style="text-align: center;"><a>入库登记</a></td>
						</tr>
						<tr class="tr_1">
							<td class="td_1" id="td3"  style="text-align: center;"><img src="../../IMG/xmw/dt3.png"></td>
							<td width="70%"  style="text-align: center;"><a>商品入库</a></td>
						</tr>
						<tr class="tr_1">
							<td class="td_1" id="td4"  style="text-align: center;"><img src="../../IMG/xmw/dt4.png"></td>
							<td width="70%"  style="text-align: center;"><a>商品出库</a></td>
						</tr>
						<tr class="tr_1">
							<td class="td_1" id="td5"  style="text-align: center;"><img src="../../IMG/xmw/dt5.png"></td>
							<td width="70%"  style="text-align: center;"><a>库存管理</a></td>
						</tr>
						<tr class="tr_1">
							<td class="td_1" id="td6"  style="text-align: center;"><img src="../../IMG/xmw/dt6.png"></td>
							<td width="70%"  style="text-align: center;"><a>动态盘点</a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="div3_div1_dl">

				<dl class="div_dl1">
					<dt>
						<img src="../../IMG/xmw/dl_dt1.png" width="35" height="35">
					</dt>
					<dd>数据统计</dd>
				</dl>
				<dl class="div_dl1">
					<dt>
						<img src="../../IMG/xmw/dl_dt5.png" width="35" height="35">
					</dt>
					<dd>部门添加</dd>
				</dl>
				<dl class="div_dl1">
					<dt>
						<img src="../../IMG/xmw/dl_dt4.png" width="35" height="35">
					</dt>
					<dd>部门管理</dd>
				</dl>
				<dl class="div_dl1">
					<dt>
						<img src="../../IMG/xmw/dl_dt3.png" width="35" height="35">
					</dt>
					<dd>员工录入</dd>
				</dl>
				<dl class="div_dl1">
					<dt>
						<img src="../../IMG/xmw/dl_dt2.jpg" width="38" height="38">
					</dt>
					<dd>员工管理</dd>
				</dl>
			</div>
			<div class="div_4_div">
				<div class="div3_div2_ul">
					<ul class="ul1">
						<li id="div3_li-1">智能仓储数据采集处理</li>
					</ul>
				</div>

				<div class="iframe_1_1" id="iframe_01">
					<iframe id="iframe1" name="iframe1" frameborder="0" width="100%"
						height="100%" src="message.jsp" scrolling="yes"></iframe>
				</div>
				<div class="iframe_2" id="iframe_10">
					<iframe id="iframe2" frameborder="0" width="100%" height="100%"
						src="entering.html" scrolling="no"></iframe>
				</div>

				<div id="iframe_2_1" >
					<iframe id="iframe2" frameborder="0" width="100%" height="100%"
						src="weather.html" scrolling="no"></iframe>
				</div>
			</div>
			<div class="div_5_div order">
				<iframe id="iframe7" frameborder="0" width="100%" height="100%"
					src="order.jsp" scrolling="yes"></iframe>
			</div>
			<div class="div_5_div Customer">
				<iframe id="iframe8" frameborder="0" width="100%" height="100%"
					src="userorder.jsp" scrolling="yes"></iframe>
			</div>
			<div class="div_5_div MyCustomer">
				<iframe frameborder="0" width="100%" height="100%"
					src="../home/MyCustomerFollowUp.jsp" scrolling="yes"></iframe>
			</div>
			<div class="div_5_div change">
				<iframe id="iframe6" frameborder="0" width="100%" height="100%"
					src="../home/HighSeasCustomer.jsp" scrolling="yes"></iframe>
			</div>
		</div>
</body>
</html>