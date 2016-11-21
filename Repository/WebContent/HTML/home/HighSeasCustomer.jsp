<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../JS/mydate.js"></script>
<script src="../../jqery/jquery-3.1.0.js"></script>
<script src="../../jqery/jquery.animate-colors.js"></script>
<script src="../../JS/province.js"></script>
<script src="../../JS/city.js"></script>
<script src="../../JS/highSeas.js"></script>
<script src="../../JS/inpute3.js"></script>
<script src="../../JS/checked.js"></script>
<script>
	$(function() {
		//添加省份
		for (var i = 0; i < province.length; i++) {
			$("<option>").val(province[i].ProID).html(province[i].name)
					.appendTo($("#provincs"));
		}
		//添加城市
		$("#provincs").change(function() {
			//删除城市
			$("#citys option").remove();
			for (var i = 0; i < city.length; i++) {
				if (city[i].ProID == $(this).val()) {
					$("<option>").html(city[i].name).appendTo($("#citys"));
				}
			}

		});
		$("#provincs").trigger("change");
		$(".input1").highSeas();
		$(".input3").inpute3();
		$(".user_div41").checked();
		$(".input2").click(function() {
			window.location.reload();
		});
		$("#box").click(function(){
			var checboxs = $(":checkbox");
		

			if(this.checked){
				checboxs.prop("checked","true");
				$(".list").attr("checked", true); 
			}else{
				$(".list").removeAttr("checked"); 
				checboxs.prop("checked",false);
			}
		});
		
		
	});
</script>
<style type="text/css">
body {
	padding: 0px;
	margin: 0px;
	font-size: 12px;
}

.qwe {
	border: 0px solid #ccc;
	width: 98%;
	position: absolute;
	left: 5px;
}

.table1 {
	white-space: nowrap;
	border-collapse: collapse;
	margin-top: 10px;
	text-align: right;
	border: 1px solid #ccc;
	z-index: 1;
}

.table1_tr1 {
	margin-top: 5px;
	height: 42px;
	border: 1px solid #ccc;
}

.h5 {
	position: absolute;
	top: -18px;
	border: 0px solid #ccc;
	background-color: #F7F7F7;
	z-index: 2;
	left: 2px;
	font-weight: normal;
	font-size: 13px;
}

.h6 {
	position: relative;
	top: -12px;
	font-weight: normal;
	font-size: 13px;
	left: -2px;
}

.table2 tr {
	height: 30px;
}

.table2 {
	margin-top: -25px;
	text-align: center;
}

.table2_td {
	text-align: left;
}

.table2_td_a {
	text-align: right;
	position: absolute;
}

.input {
	border: 0px solid #EAEAEA;
	height: 28px;
	border-radius: 4px;
	margin-right: 6px;
	margin-left: 4px;
	margin-top: 4px;
	width: 100px;
	color: #FFFFFF;
}

.input1 {
	background-color: #E07678;
}

.input2 {
	background-color: #b1d85c;
}

.input3 {
	width: 70px;
	height: 20px;
	background-color: #44c767;
	-moz-border-radius: 28px;
	-webkit-border-radius: 28px;
	border-radius: 28px;
	border: 1px solid #18ab29;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 12px;
	text-decoration: none;
	text-shadow: 0px 1px 0px #2f6627;
}

.input3:hover {
	background-color: #5cbf2a;
}

.input:active {
	position: relative;
	top: 1px;
}

.div_td1 {
	text-align: center;
}

.a1_1, .a1_2, .a1_3, .a1_4 {
	cursor: pointer
}

.user_div41 {
	position: relative;
	padding-left: 5px;
	padding-top: 5px;
	font-size: 12px;
	color: #7C7C7Cs;
	font-size: 12px;
	font-size: 12px
}

th {
	font-weight: normal;
}

option {
	background-color: #F7F7F7;
}
</style>
</head>
<body>

	<div class="div_3">
		<h5 class="h5">库容使用情况</h5>
		<div class="qwe">
			<table border="0" width="100%" class="table1" cellspacing="0px">
				<tbody>
					<tr class="table1_tr1">
						<td width="10%">库容上线：</td>
						<td width="12.5%" style="">600</td>
						<td width="10%">库存已用：</td>
						<td width="12.5%" class="div_td1 div_dt2">0</td>
					</tr>
				</tbody>
			</table>
			<h5 class="h6">库存信息</h5>
			<div>
				<table border="1" width="100%" class="table1 table2"
					cellspacing="0px">
					<tbody>
						<tr style="background-color: #EEEEEE; font-size: 14px">
							<td width="20%">仓位号</td>
							<td width="20%">仓位上线</td>
							<td width="20%">仓位已用</td>
							<td width="20%">仓位剩余</td>
							<td width="20%">操作</td>
						</tr>
						<tr>
							<td>1号仓库</td>
							<td>100</td>
							<td class="cw1">0</td>
							<td class="cw1_1"> 100</td>
							<td><input type="button" value="转移查询" class="input input3" /></td>
						</tr>
						<tr>
							<td>2号仓库</td>
							<td>100</td>
							<td class="cw2">0</td>
							<td class="cw2_1">100</td>
							<td><input type="button" value="转移查询" class="input input3" /></td>
						</tr>
						<tr>
							<td>3号仓库</td>
							<td>100</td>
							<td class="cw3">0</td>
							<td class="cw3_1">100</td>
							<td><input type="button" value="转移查询" class="input input3" /></td>
						</tr>
						<tr>
							<td>4号仓库</td>
							<td>100</td>
							<td class="cw4">0</td>
							<td class="cw4_1">100</td>
							<td><input type="button" value="转移查询" class="input input3" /></td>
						</tr>
						<tr>
							<td>5号仓库</td>
							<td>100</td>
							<td class="cw5">0</td>
							<td class="cw5_1">100</td>
							<td><input type="button" value="转移查询" class="input input3" /></td>
						</tr>
						<tr>
							<td>6号仓库</td>
							<td>100</td>
							<td class="cw6">0</td>
							<td class="cw6_1">100</td>
							<td><input type="button" value="转移查询" class="input input3" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div>
				<h5 class="h6">库存转移</h5>
				<table border="1" class="table1 table2 table3" cellspacing="0px"
					width="100%">
					<thead>
						<tr style="background-color: #EEEEEE; font-size: 14px">
							<th width="20%">仓位号</th>
							<th width="20%">商品ID</th>
							<th width="20%">商品名称</th>
							<th width="20%">预计出库日期</th>
							<th width="10%"><input type="checkbox" id='box' class="check"></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<div class="user_div41">
					<span><a class="a1_1">第一页</a>&ensp;<a class="a1_2">上一页</a>&ensp;<a
						class="a1_3">下一页</a>&ensp;<a class="a1_4">最后一页</a>&ensp;<a
						class="a1">2</a>/<a class="a2">3</a>共<a class="a3">14</a>条记录</span>
				</div>
			</div>
			<table border="1" class="table1" width="100%">

				<tr style="height: 30px;">
					<td width="20%">转移仓库号：</td>
					<td width="80%"><select id="order"
						style="width: 100%; height: 100%; background-color: #F7F7F7">
							<option value="1">1号仓库</option>
							<option value="2">2号仓库</option>
							<option value="3">3号仓库</option>
							<option value="4">4号仓库</option>
							<option value="5">5号仓库</option>
							<option value="6">6号仓库</option>
					</select></td>
				</tr>
				<tr>
					<td style="text-align: right;" width="20%" colspan="2">&nbsp;&ensp;<input
						type=submit value="确认转移" class="input input1"> <input
						type="reset" value="重置" class="input input2"></td>
				</tr>
			</table>
		</div>
		<div></div>
	</div>
</body>
</html>