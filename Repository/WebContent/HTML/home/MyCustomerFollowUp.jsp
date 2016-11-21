<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	padding: 0px;
	margin: 0px;
	color: #696969;
}

.qwe {
	border: 0px solid #ccc;
	width: 98%;
	font-size: 12px;
	margin-top: 34px;
}

.table1 {
	white-space: nowrap;
	border-collapse: collapse;
	margin-top: 10px;
	margin-left: 10px;
	text-align: right;
	border: 1px solid #969696;
	z-index: 1;
}

.table1_tr1 {
	margin-top: 5px;
	height: 42px;
	border: 1px solid #969696;
}

.table2 tr {
	height: 32px;
}

.table2 {
	margin-top: -12px;
}

.table3 {
	margin-top: 12px;
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

select, input {
	background-color: #F7F7F7;
}

.input1 {
	background-color: #E07678;
}

input {
	border: 0px solid;
}

.input2 {
	background-color: #b1d85c;
}

.zxc {
	position: absolute;
}

a {
	margin-left: 48px;
	font-size: 12px;
	color: #FFA500;
}

table {
	border: 0px solid #969696;
}

th {
	font-weight: normal;
	font-size: 16px;
	text-align: center;
}
.tds{
text-align: center;
}
</style>
<script src="../../jqery/jquery-3.1.0.js"></script>
<script src="../../JS/mydate.js"></script>
<script src="../../jqery/jquery.animate-colors.js"></script>
<script src="../../JS/mycustomer_inp1.js"></script>
<script src="../../JS/mycustomer_inp2.js"></script>
<script type="text/javascript">
	$(function() {
		$(".input1_1").mycustomerinp1();
		$(".input1_2").mycustomerinp2();
		$(".input1_2_1").click(function() {
			window.location.reload();
		});
	});
</script>

</head>
<body>
	<div class="qwe">
		<table border="1" width="98.5%" class="table1 table2"
			cellspacing="0px">
			<thead>
				<tr>
					<th colspan="4">商品入库</th>
				</tr>
			</thead>
			<tr>
				<td width=10%>LoginID：</td>
				<td class="table2_td LoginID" contentEditable="true"
					style="width: 30%"></td>
				<td width=10%>公司名称：</td>
				<td class="table2_td CompName" contentEditable="true" width=30%></td>
			</tr>

			<tr>
				<td>商品名称：</td>
				<td style="text-align: left;" contentEditable="true" class="CommoName"></td>
				<td>商品状态：</td>
				<td style="text-align: left;" contentEditable="true"  ></td>
			</tr>
			<tr>
				<td>客户姓名：</td>
				<td style="text-align: left;" contentEditable="true" class="CustName"></td>
				<td>商品来源：</td>
				<td style="text-align: left;" contentEditable="true" class="CommoSourc"></td>
			</tr>
			<tr>
				<td>商品类别：</td>
				<td><select style="width: 99%"><option value="nz"
							class="Category">女装</option>
						<option value="lz">男装</option>
						<option value="tz">童装</option>
						<option value="ny">内衣</option>
						<option value="yz">鞋</option>
						<option value="pj">箱包皮具</option>
						<option value="my">母婴用品</option>
						<option value="fz">服饰配件、饰品</option>
						<option value="gy">工艺品、礼品</option>
						<option value="yd">运动户外+</option>
						<option value="ry">日用百货</option>
						<option value="hz">美妆日化</option>
						<option value="le">LED</option>
						<option value="zy">纸业</option>
						<option value="zm">照明工业</option>
						<option value="ys">印刷</option>
						<option value="yb">仪器仪表</option>
						<option value="yl">医药</option>
						<option value="by">保养</option>
						<option value="zj">冶金矿产</option>
						<option value="yj">眼镜及配件</option>
						<option value="sj">橡塑</option>
						<option value="xm">项目合作</option>
						<option value="wj">五金</option>
						<option value="gj">工具</option>
						<option value="wj">玩具</option>
						<option value="tx">通信产品</option>
						<option value="sm">数码</option>
						<option value="dn">电脑</option>
						<option value="sp">食品</option>
						<option value="yl">饮料</option>
						<option value="sx">生鲜</option>
						<option value="sw">商务服务</option>
						<option value="qm">汽摩及配件</option>
						<option value="qc">汽车用品</option>
						<option value="ny">农业</option>
						<option value="en">能源</option>
						<option value="cy">库存积压</option>
						<option value="jx">精细化学品</option>
						<option value="jz">家装</option>
						<option value="jc">建材</option>
						<option value="jy">家用电器</option>
						<option value="jf">家纺家饰</option>
						<option value="jg">加工</option>
						<option value="me">机械及行业</option>
						<option value="eq">设备</option>
						<option value="mt">机床</option>
						<option value="hb">环保</option>
						<option value="gr">个人防护</option>
						<option value="gt">钢铁</option>
						<option value="fz">纺织</option>
						<option value="pg">皮革</option>
						<option value="es">二手设备转让</option>
						<option value="dz">电子元器件</option>
						<option value="dg">电工电气</option>
						<option value="dl">代理</option>
						<option value="cm">传媒</option>
						<option value="pt">宠物及园艺</option>
						<option value="cy">餐饮</option>
						<option value="bz">包装 办公</option>
						<option value="wy">文教 安全</option>
						<option value="fh">防护</option>
						<option value="qt">其它</option>
				</select></td>
				<td>商品登记时间：</td>
				<td><input type="text" name="starttime"
					onfocus="MyCalendar.SetDate(this)" value="2008-08-05"
					style="width: 99%"class="RegisTime"></td>
			</tr>
			<tr>
				<td colspan="4" class="table2_td"></td>
			</tr>
		</table>
		<input type="button" value="搜索" class="input input1 input1_1">
		<input type="button" value="重置" class="input input2 input1_2_1"><br>
		<br> <a>请选择适当的条件后再进行查询</a><br>
		<table border="1" width="98.5%" class="table1 table2 table3">
			<tbody>
				<tr>
					<td colspan="5" style="text-align: center;">商品详情</td>
				</tr>
				<tr>
					<td width=10%>公司名：</td>
					<td width=30% class="CompName2 tds"></td>
					<td width=10%>Login ID：</td>
					<td width=30% class="LoginID2 tds"></td>
				</tr>
				<tr>
					<td>来源：</td>
					<td class="CommoSourc2 tds"></td>
					<td>客户姓名：</td>
					<td class="CustName2 tds"></td>
				</tr>
				<tr>
					<td>客户手机：</td>
					<td class="MobPhone2 tds"></td>
					<td>商品名称：</td>
					<td class="CommoName2 tds"></td>
				</tr>
				<tr>
					<td>客户省份：</td>
					<td class="ProArea2 tds"></td>
					<td>客户地址：</td>
					<td class="CommoAdd2 tds"></td>
				</tr>
			</tbody>
		</table>
		<br>
		<table border="1" width="98.5%" class="table1 table2 table3">
			<tbody>
				<tr>
					<td colspan="5" style="text-align: center;">入库登记</td>
				</tr>
				<tr>
					<td width=10%>订单号：</td>
					<td width=30% style="text-align: left;" contentEditable="true" class="agency"></td>
					<td width=10%>入库时间：</td>
					<td width=30% ><input type="text" name="starttime"
						onfocus="MyCalendar.SetDate(this)" value="2016-11-18"
						style="width: 99%"></td>
				</tr>
				<tr>
					<td width=10%>录库人：</td>
					<td width=30% contentEditable="true" style="text-align: left;" class="userName"></td>
					<td>仓库号：</td>
					<td><select id="order" style="width: 99%">
							<option value="1">1号仓库</option>
							<option value="2">2号仓库</option>
							<option value="3">3号仓库</option>
							<option value="4">4号仓库</option>
							<option value="5">5号仓库</option>
							<option value="6">6号仓库</option>
					</select></td>
				</tr>

				<tr>
					<td>预计出库日期：</td>
					<td><input type="text" name="starttime"
						onfocus="MyCalendar.SetDate(this)" value="2016-11-18"
						style="width: 99%" class="OutTime"></td>
				</tr>
				<tr>
					<td colspan="4"><input type="button" value="入库"
						class="input input1 input1_2"> <input type="button"
						value="重置" class="input input2 input1_2_1"></td>
				</tr>
				<tr>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>