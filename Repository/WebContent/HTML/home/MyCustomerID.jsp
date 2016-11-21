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
}

.qwe {
	margin-left: 15px;
	width: 98%;
	font-size: 12px;
	margin-top: 18px;
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
	border: 1px solid #ccc;
}

.table2 tr {
	height: 32px;
}

.table2 {
	margin-top: -12px;
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

.zxc {
	position: absolute;
}

a {
	margin-left: 48px;
	font-size: 12px;
	color: #FFA500
}

table {
	border: 0px solid #969696;
}
</style>

<title>客户ID搜索</title>
<script src="../../JS/mydate.js"></script>
<script src="../../jqery/jquery-3.1.0.js"></script>
<script src="../../jqery/jquery.animate-colors.js"></script>
<script src="../../JS/province.js"></script>
<script src="../../JS/city.js"></script>
<link href="../../CSS/dzx/mcid.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
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
	});
</script>
</head>
<body>
	<div>
		<div class="qwe">

			<table border="1" width="98.5%" class="table1 table2"
				cellspacing="0px">
				<tr>
					<td width=10% class="logx"  x=<%=session.getAttribute("id")%>>LoginID：</td>
					<td name="LoginID" class="table2_td"
						ondblclick="this.contentEditable=true;" width="30%"></td>
					<td width=10%>客户ID：</td>
					<td width=30% name="LoginID" class="table2_td"
						ondblclick="this.contentEditable=true;"></td>
				</tr>
				<tr>
					<td>区号：</td>
					<td name="LoginID" class="table2_td"
						ondblclick="this.contentEditable=true;"></td>
					<td>公司名（模糊）：</td>
					<td name="LoginID" class="table2_td"
						ondblclick="this.contentEditable=true;"></td>
				</tr>
				<tr>
					<td>成熟度：</td>
					<td><select style="width: 99.5%">
							<option value="0">暂未确定成熟度</option>
							<option value="A">确定合作，3天内办</option>
							<option value="B">确定合作，7天内合作</option>
							<option value="C">KP确定，意向不确定</option>
							<option value="D">KP确定，明确不搞</option>
					</select></td>
					<td>售卖集合：</td>
					<td><select style="width: 99.5%">
							<option value="0">诚信托管</option>
							<option value="1">设计</option>
							<option value="2">培训</option>
							<option value="3">其他一</option>
							<option value="3">其他二</option>
					</select></td>
				</tr>
				<tr>
					<td>入库来源：</td>
					<td><select style="width: 99.5%">
							<option value="0">纯新录入</option>
							<option value="1">转介绍</option>
							<option value="2">外部合作</option>
							<option value="3">转移机会</option>
					</select></td>
					<td>安排联系时间：</td>
					<td><input type="text" name="starttime"
						onfocus="MyCalendar.SetDate(this)" value="2008-08-05"
						style="width: 99.5%"></td>
				</tr>
				<tr>
					<td>是否TP:</td>
					<td><select style="width: 99.5%">
							<option value="0" selected>是
							<option value="1">否
					</select></td>
					<td>最后有效联系时间：</td>
					<td><input type="text" name="starttime"
						onfocus="MyCalendar.SetDate(this)" value="2008-08-05"
						style="width: 99.5%"></td>
				</tr>
				<tr>
					<td>是否到单：</td>
					<td><select style="width: 99.5%">
							<option value="0" selected>是
							<option value="1">否
					</select></td>
					<td>最近联系时间：</td>
					<td><input type="text" name="starttime"
						onfocus="MyCalendar.SetDate(this)" value="2008-08-05"
						style="width: 99.5%"></td>
				</tr>
				<tr>
					<td>客户标签：</td>
					<td name="LoginID" class="table2_td"
						ondblclick="this.contentEditable=true;"></td>
					<td>入库时间：</td>
					<td><input type="text" name="starttime"
						onfocus="MyCalendar.SetDate(this)" value="2008-08-05"
						style="width: 99.5%"></td>
				</tr>
				<tr>
					<td>地区：</td>
					<td class="table2_td"><select id="provincs" style="width: 46%"></select>ad<select
						id="citys" style="width: 45.5%"></select></td>
					<td>地址（模糊）：</td>
					<td name="LoginID" class="table2_td"
						ondblclick="this.contentEditable=true;"></td>
				</tr>
				<tr>
					<td>是否为重点客户：</td>
					<td><input type="checkbox" name="ZD"></td>
					<td>是否续签：</td>
					<td><select style="width: 99.5%">
							<option value="0" selected>是
							<option value="1">否
					</select></td>
				</tr>
				<tr>
					<td>近七天达到A级：</td>
					<td><select style="width: 99.5%">
							<option value="0" selected>是
							<option value="1">否
					</select></td>
					<td>近30天达到A级：</td>
					<td><select style="width: 99.5%">
							<option value="0" selected>是
							<option value="1">否
					</select></td>
				</tr>
				<tr>
					<td>产业带优质客户：</td>
					<td><select style="width: 99.5%">
							<option value="0" selected>是
							<option value="1">否
					</select></td>
					<td>当前交易勋章：</td>
					<td><select style="width: 99.5%">
							<option value="0" selected>荣耀黄金
							<option value="1">不屈白银
							<option value="1">英勇黄铜
							<option value="1">华贵白金
							<option value="1">钻石
					</select></td>
				</tr>
				<tr>
					<td>加入买家保障：</td>
					<td><select style="width: 99.5%">
							<option value="0" selected>是
							<option value="1">否
					</select></td>
					<td>绑定支付宝验证：</td>
					<td><select style="width: 99.5%">
							<option value="0" selected>是
							<option value="1">否
					</select></td>
				</tr>
				<tr>
					<td>报名专场：</td>
					<td name="LoginID" class="table2_td"
						ondblclick="this.contentEditable=true;"></td>
					<td>推荐的专场：</td>
					<td name="LoginID" class="table2_td"
						ondblclick="this.contentEditable=true;"></td>
				</tr>
				<tr>
					<td>客户满意度：</td>
					<td><select style="width: 99.5%">
							<option value="0" selected>不满意
							<option value="1">一般
							<option value="1">满意
							<option value="1">非常满意
					</select></td>
					<td>主营行业：</td>
					<td><select style="width: 99.5%">
							<option value="0" selected>女装
							<option value="1">男装
							<option value="2">童装
							<option value="3">内衣
							<option value="4">鞋
							<option value="5">箱包皮具
							<option value="6">母婴用品
							<option value="7">服饰配件、饰品
							<option value="8">工艺品、礼品
							<option value="9">运动户外+
							<option value="10">日用百货
							<option value="11">美妆日化
							<option value="12">LED
							<option value="13">纸业
							<option value="14">照明工业
							<option value="15">印刷 、
							<option value="16">仪器仪表
							<option value="17">医药
							<option value="18">保养
							<option value="19">冶金矿产
							<option value="20">眼镜及配件
							<option value="21">橡塑
							<option value="22">项目合作
							<option value="23">五金
							<option value="24">工具
							<option value="25">玩具
							<option value="26">通信产品
							<option value="27">数码
							<option value="28">电脑
							<option value="29">食品
							<option value="30">饮料
							<option value="31">生鲜
							<option value="32">商务服务
							<option value="33">汽摩及配件
							<option value="34">汽车用品
							<option value="36">农业
							<option value="37">能源
							<option value="38">库存积压
							<option value="39">精细化学品
							<option value="40">家装
							<option value="41">建材
							<option value="42">家用电器
							<option value="43">家纺家饰
							<option value="44">加工
							<option value="45">机械及行业
							<option value="46">设备
							<option value="47">机床
							<option value="48">环保
							<option value="49">个人防护
							<option value="50">钢铁
							<option value="51">纺织
							<option value="52">皮革
							<option value="53">二手设备转让
							<option value="54">电子元器件
							<option value="55">电工电气
							<option value="56">代理
							<option value="57">传媒
							<option value="58">宠物及园艺
							<option value="59">餐饮
							<option value="60">包装 办公
							<option value="61">文教 安全
							<option value="62">防护
					</select></td>
				</tr>
				<tr>
					<td>高意愿时间：</td>
					<td><input type="text" name="starttime"
						onfocus="MyCalendar.SetDate(this)" value="2008-08-05"
						style="width: 99.5%"></td>
				</tr>
			</table>
		</div>

	</div>
	<div class="zxc">
		<table>
			<tr>
				<td>&nbsp;&ensp;<input type=submit value=搜索
					class="input input1"></td>
				<td><input type="reset" value=清空 class="input input2"></td>
			</tr>
		</table>
		<a>请选择适当的条件后再进行查询</a>
	</div>
	<div class="zxc">
		<table>
			<tr>
				<td>&nbsp;&ensp;<input type=submit value=搜索
					class="input input1"></td>
				<td><input type="reset" value=清空 class="input input2"></td>
			</tr>
		</table>
		<a>请选择适当的条件后再进行查询</a>
	</div>
</body>
</html>