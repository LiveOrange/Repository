<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../jqery/jquery-3.1.0.js"></script>
<script src="../../JS/province.js"></script>
<script src="../../JS/city.js"></script>
<script src="../../JS/order.js"></script>
<script type="text/javascript" src="../../JS/laydate.js"></script>
<script type="text/javascript">
	!function() {
		laydate.skin('molv');
		laydate({
			elem : '#demo'
		});
	}();
	var start = {
		elem : '#start',
		format : 'YYYY-MM-DD',
		min : laydate.now(),
		max : '2099-06-16',
		istime : true,
		istoday : false,
		choose : function(datas) {
			end.min = datas;
			end.start = datas
		}
	};
	var end = {
		elem : '#end',
		format : 'YYYY-MM-DD',
		min : laydate.now(),
		max : '2099-06-16',
		istime : true,
		istoday : false,
		choose : function(datas) {
			start.max = datas;
		}
	};
	laydate(start);
	laydate(end);
	laydate({
		elem : '#test1',
		format : 'YYYY年MM月DD日',
		festival : true,
		choose : function(datas) {
			alert('得到：' + datas);
		}
	});
	laydate({
		elem : '#hello3',
		min : laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
		max : laydate.now(+1)
	});
</script>
<script>
	$(function() {
		//添加省份
		for (var i = 0; i < province.length; i++) {
			$("<option>").val(province[i].ProID).html(province[i].name).attr(
					"provi", province[i].name).appendTo($("#provincs"));
			;
		}
		//添加城市
		$("#provincs").change(
				function() {
					//删除城市
					$("#citys option").remove();
					for (var i = 0; i < city.length; i++) {
						if (city[i].ProID == $(this).val()) {
							$("<option>").html(city[i].name).attr("city",
									city[i].name).appendTo($("#citys"));
						}
					}
				});
		$("#provincs").trigger("change");
		$(".input1").click(function() {
			window.location.reload();
		});
		$(".input2").order();
	});
</script>
<link href="../../CSS/xmw/order.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="div1">
		<br />
		<table border="1">
			<thead>
				<tr>
					<th colspan="4">商品登记</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="td1" width="10%">公司名：</td>
					<td width="30%" id="CompName" contentEditable="true"
					class="td1s CompName"></td>
					<td class="td1" width="10%">公司类别：</td>
					<td width="30%" contentEditable="true" class="CompCateg"></td>
				</tr>
				<tr>
					<td class="td1">Login ID：</td>
					<td contentEditable="true" class="loginID"></td>
					<td class="td1">商品类别：</td>
					<td ><select style="width: 98%" class="Category">
							<option value="女装" >女装</option>
							<option value="男装">男装</option>
							<option value="童装">童装</option>
							<option value="内衣">内衣</option>
							<option value="鞋">鞋</option>
							<option value="箱包皮具">箱包皮具</option>
							<option value="母婴用品">母婴用品</option>
							<option value="服饰配件、饰品">服饰配件、饰品</option>
							<option value="工艺品、礼品">工艺品、礼品</option>
							<option value="运动户外+">运动户外+</option>
							<option value="日用百货">日用百货</option>
							<option value="美妆日化">美妆日化</option>
							<option value="LED">LED</option>
							<option value="纸业">纸业</option>
							<option value="照明工业">照明工业</option>
							<option value="印刷">印刷</option>
							<option value="仪器仪表">仪器仪表</option>
							<option value="医药">医药</option>
							<option value="保养">保养</option>
							<option value="冶金矿产">冶金矿产</option>
							<option value="眼镜及配件">眼镜及配件</option>
							<option value="橡塑">橡塑</option>
							<option value="项目合作">项目合作</option>
							<option value="五金">五金</option>
							<option value="工具">工具</option>
							<option value="玩具">玩具</option>
							<option value="通信产品">通信产品</option>
							<option value="数码">数码</option>
							<option value="电脑">电脑</option>
							<option value="食品">食品</option>
							<option value="饮料">饮料</option>
							<option value="生鲜">生鲜</option>
							<option value="商务服">商务服务</option>
							<option value="汽摩及配件">汽摩及配件</option>
							<option value="汽车用品">汽车用品</option>
							<option value="农业">农业</option>
							<option value="能源">能源</option>
							<option value="库存积压">库存积压</option>
							<option value="精细化学品">精细化学品</option>
							<option value="家装">家装</option>
							<option value="建材">建材</option>
							<option value="家用电">家用电器</option>
							<option value="家纺家饰">家纺家饰</option>
							<option value="加工">加工</option>
							<option value="机械及行业">机械及行业</option>
							<option value="设备">设备</option>
							<option value="机床">机床</option>
							<option value="环保">环保</option>
							<option value="个人防护">个人防护</option>
							<option value="钢铁">钢铁</option>
							<option value="纺织">纺织</option>
							<option value="皮革">皮革</option>
							<option value="二手设备转让">二手设备转让</option>
							<option value="电子元器件">电子元器件</option>
							<option value="电工电气">电工电气</option>
							<option value="代理">代理</option>
							<option value="传媒">传媒</option>
							<option value="宠物及园艺">宠物及园艺</option>
							<option value="餐饮">餐饮</option>
							<option value="包装 办公">包装 办公</option>
							<option value="文教 安全">文教 安全</option>
							<option value="防护">防护</option>
							<option value="其它">其它</option>
					</select></td>
				</tr>
				<tr>
					<td class="td1">登记时间：</td>
					<td><input type="text" class="laydate-icon RegisTime"
						onClick="laydate({istime: true, format: 'YYYY-MM-DD'})"
						id="input1" style="width: 41.7%" /></td>
					<td class="td1">商品来源：</td>
					<td  contentEditable="true" class="CommoSourc"></td>
				</tr>
				<tr>

					<td class="td1">商品名称：</td>
					<td contentEditable="true" class="CommoName"></td>
					<td class="td1">预计出库日期：</td>
					<td><input type="text" class="laydate-icon OutTime"
						onClick="laydate({istime: true, format: 'YYYY-MM-DD'})"
						id="input1" style="width: 41.7%" /></td>
				</tr>
				<tr>

					<td class="td1">省份地区：</td>
					<td><select id="provincs" style="width: 45%"
						class="clientRegion1"></select><select id="citys"
						style="width: 45%" class="clientRegion2"></select>
					<td class="td1">公司地址：</td>
					<td contentEditable="true" class="CommoAdd"></td>
				</tr>

				<tr>
					<td class="td1">电话：</td>
					<td contentEditable="true" class="Phone"></td>
					<td class="td1">手机：</td>
					<td contentEditable="true" class="MobPhone"></td>
				</tr>
				<tr>
					<td class="td1">E-mail：</td>
					<td contentEditable="true" class="Email"></td>
					<td class="td1">传真：</td>
					<td contentEditable="true" class="Fax"
						class="clientFax"></td>
				</tr>
				<tr>
					<td class="td1">客户背景：</td>
					<td contentEditable="true" class="ClienBound"></td>
					<td class="td1">是否绑定支付宝：</td>
					<td><input type="radio" name="ZFB" value="是" checked="checked" />是
						<input type="radio" name="ZFB" value="否" />否</td>
				</tr>

				<tr>
					<td class="td1">中文经营行为：</td>
					<td><input type="radio" name="ChAtion" value="是"
						checked="checked" />是 <input type="radio" name="ChAtion" value="否" />否</td>
					<td class="td1">淘宝经营行为：</td>
					<td><input type="radio" name="taob" value="是"
						checked="checked" />是 <input type="radio" name="taob" value="否" />否</td>
				</tr>
				<tr>
					<td class="td1">货运单号：</td>
					<td contentEditable="true" class="AgencyFee"></td>
					<td class="td1">规格：</td>
					<td contentEditable="true" class="CredMarg"></td>
				</tr>

				<tr>
					<td class="td1">单价（元）：</td>
					<td contentEditable="true" class="Money"></td>
					<td class="td1">总额（元）：</td>
					<td contentEditable="true" class="Amount"></td>
				</tr>
				<tr>
					<td class="td1">商品状态：</td>
					<td class="clientOrder"><select style="width: 99%"
						id="select_1">
							<option value="等待入库">等待入库</option>
							<option value="暂不入库">暂不入库</option>
					</select></td>
					<td class="td1">客户姓名：</td>
					<td contentEditable="true" class="CustName"></td>
				</tr>
				<tr>
					<td class="td1">商品数量：</td>
					<td contentEditable="true" class="Quantity"></td>
					<td class="td1">单个商品重量：</td>
					<td contentEditable="true" class="Commodity"></td>
				</tr>
				<tr>
					<td style="text-align:right;"><img src="../../IMG/xmw/order1.png" width="25px" id="img1"
						x="2">&nbsp;&nbsp;</td>
					<td colspan="4" class="td1"><input type="button" value="登记"
						class="input input2"><input type="button" value="重置"
						class="input input1"></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>