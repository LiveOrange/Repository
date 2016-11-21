<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../CSS/xmw/message.css" rel="stylesheet" type="text/css" />
<script src="../../jqery/jquery-3.1.0.js"></script>
<script src="../../JS/message_inp1.js"></script>
<script src="../../JS/message_inp2.js"></script>
<script src="../../JS/message_inp3.js"></script>
<script src="../../JS/message_inp4.js"></script>
<script src="../../JS/message_inp5.js"></script>
<script src="../../JS/message_inp6.js"></script>
<script type="text/javascript">
	$(function() {
		$(".div3_a1").messageinp1();
		$(".div3_a2_1").messageinp2();
		$(".div3_a2_2").messageinp3();
		$(".div3_a2_3").messageinp4();
		$(".div3_a2_4").messageinp5();
		$(".button1").messageinp6();
		$(".input").click(function() {
			var a = $(this).attr("x");
			$.ajax({
				type : "get",
				url : "Data",
				data : {
					data : a,
				},
				success : function(data, textStatus) {
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="div1_div1">
		<div style="border: 0px solid #000000" id="div1">
			<div id="div2">
				<div class="div1_div2" x=1>温度检测</div>
			</div>
		</div>

		<table border="1" width="100%" cellspacing="0px"
			style="border-collapse: collapse; border: 1px solid #ccc;">
			<tbody>
				<tr>
					<td width="30%" style="text-align: center;"><img
						src="../../IMG/home/wdbj.png"></td>
					<td width="30%" id="a1" style="text-align: center;">检测温度</td>
					<td width="30%" style="text-align: center;">15°C</td>
				</tr>
				<tr>
					<td colspan="3" style="text-align: center;"><input
						type="button" value="温度获取" class="input input2" x=1><input
						type="button" value="刷新数据" class="input1"></td>
				</tr>
				<tr>
			</tbody>
		</table>
	</div>
	<div class="div1_div1 div1_div2_1">
		<div style="border: 0px solid #000000" id="div1">
			<div id="div2">
				<div class="div1_div2">湿度检测</div>
			</div>
		</div>
		<table border="1" width="100%" cellspacing="0px"
			style="border-collapse: collapse; border: 1px solid #ccc;">
			<tbody>
				<tr>
					<td width="30%" style="text-align: center;"><img
						src="../../IMG/home/sdjc.png"></td>
					<td width="30%" id="a1" style="text-align: center;">检测湿度</td>
					<td width="30%" style="text-align: center;">15°C</td>
				</tr>
				<tr>
					<td colspan="3" style="text-align: center;"><input
						type="button" value="温度获取" class="input" x=2><input
						type="button" value="刷新数据" class="input1"></td>
				</tr>
				<tr>
			</tbody>
		</table>
	</div>
	<div class="div1_div1">
		<div style="border: 0px solid #000000" id="div1">
			<div id="div2">
				<div class="div1_div2">烟雾检测</div>
			</div>
		</div>
		<table border="1" width="100%" cellspacing="0px"
			style="border-collapse: collapse; border: 1px solid #ccc;">
			<tbody>
				<tr>
					<td width="30%" style="text-align: center;"><img
						src="../../IMG/home/ywbj.png"></td>
					<td width="30%" id="a1" style="text-align: center;">检测烟雾</td>
					<td width="30%" style="text-align: center;">无烟</td>
				</tr>
				<tr>
					<td colspan="3" style="text-align: center;"><input
						type="button" value="温度获取" class="input input2" x=3><input
						type="button" value="刷新数据" class="input1"></td>
				</tr>
				<tr>
			</tbody>
		</table>
	</div>
	<div class="div1_div1 div1_div2_1">
		<div style="border: 0px solid #000000" id="div1">
			<div id="div2">
				<div class="div1_div2">人体感应</div>
			</div>
		</div>
		<table border="1" width="100%" cellspacing="0px"
			style="border-collapse: collapse; border: 1px solid #ccc;">
			<tbody>
				<tr>
					<td width="30%" style="text-align: center;"><img
						src="../../IMG/home/rtgy.png"></td>
					<td width="30%" id="a1" style="text-align: center;">检测湿度</td>
					<td width="30%" style="text-align: center;">15°C</td>
				</tr>
				<tr>
					<td colspan="3" style="text-align: center;"><input
						type="button" value="温度获取" class="input" x=4><input
						type="button" value="刷新数据" class="input1"></td>
				</tr>
				<tr>
			</tbody>
		</table>
	</div>

	<div class="div1_div1_1">
		<div class="div1_div1_2">
			<h4>监控状态</h4>
		</div>
		<iframe id="iframe6" frameborder="0" width="100%" height="100%"
			src="baojin.html" scrolling="no"></iframe>
		<div class="div1_div1_3">
			<input type="button" value="监控设置" class="input3">
		</div>
	</div>

</body>
</html>