<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../../jqery/jquery-3.1.0.js"></script>
<style type="text/css">
.div4_2 {
	border: 1px solid #D5D5D5;
	position: absolute;
	width: 360px;
	height: 380px;
	left: 50%;
	top: 50%;
	margin-left: -180px;
	margin-top: -200px;
	border-radius: 5px;
	background-color: #A9D96C;
}

.div4_3 {
	position: absolute;
	left: 12%;
	top: 8%;
}

.ipt2 {
	position: relative;
	top: 0px;
	left: -55px;
	border-radius: 2px;
	font-size: 12px;
	color: #4B4B4B;
}
</style>
<script type="text/javascript">
	$(function() {
		$(".img1").each(function() {
			$(this).attr("x", "0");
		});
		$(".inpt1").blur(
				function() {
					if ($(this).val().length > 0) {
						$(this).parents("tr").children("td").eq(2).children(
								"img").attr("src", "../../IMG/wlf/l2-5.png")
								.attr("x", "1");
					} else {
						$(this).parents("tr").children("td").eq(2).children(
								"img").attr("src", "../../IMG/wlf/l2-2.png")
								.attr("x", "0");
					}
				});
		$(".inpt2").blur(
				function() {
					if ($(this).val().length > 0) {
						$(this).parents("tr").children("td").eq(2).children(
								"img").attr("src", "../../IMG/wlf/l2-5.png")
								.attr("x", "1");
					} else {
						$(this).parents("tr").children("td").eq(2).children(
								"img").attr("src", "../../IMG/wlf/l2-2.png")
								.attr("x", "0");
					}
				});

		$(".inpt3").blur(
				function() {
					if ($(this).val().length > 0
							&& ($(".inpt2").val() == $(this).val())) {
						$(this).parents("tr").children("td").eq(2).children(
								"img").attr("src", "../../IMG/wlf/l2-5.png")
								.attr("x", "1");
					} else {
						$(this).parents("tr").children("td").eq(2).children(
								"img").attr("src", "../../IMG/wlf/l2-2.png")
								.attr("x", "0");
					}
				});
		$(".inpt4")
				.blur(
						function() {
							var reg = /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
							if (reg.test($(this).val())) {
								$(this).parents("tr").children("td").eq(2)
										.children("img").attr("src",
												"../../IMG/wlf/l2-5.png").attr(
												"x", "1");
							} else {
								$(this).parents("tr").children("td").eq(2)
										.children("img").attr("src",
												"../../IMG/wlf/l2-2.png").attr(
												"x", "0");
							}
						});
		$(".ipt2").click(function() {
		$("#myForm").submit(function(e) {
						e.preventDefault();
						window.location.reload();
			});	
		});
		$(".ipt1").click(function() {
			var pot = 1;
			$(".img1").each(function() {
				if ($(this).attr("x") == "0") {
					pot = 0;
				}
			});
			if (pot) {
				if (!confirm('信息输入正确，确定要录入吗？')) {
					$("#myForm").submit(function(e) {
						e.preventDefault();
						window.location.reload();
					});	
				}
			} else {
				alert("输入有错，请保证信息正确!");
				$("#myForm").submit(function(e) {
					e.preventDefault();
					window.location.reload();
				});
			}
		});
	});
</script>
</head>
<body>
	<div class="div4_2">
		<div class="div4_3">
			<form method="post" action="UserInsertServlet" id="myForm">
				<table border="0" cellspacing="5" cellpadding="5">
					<thead>
						<tr>
							<td><img src="../../IMG/wlf/l2-1.png" width="25" height="25"></td>
							<td><input type="text" width="15%" name="name"
								placeholder="请输入用户名" class="inpt1" /></td>
							<td><img src="../../IMG/wlf/l2-2.png" width="25" height="25"
								class="img1" news="1"></td>
						</tr>
						<tr>
							<td><img src="../../IMG/wlf/l2-3.png" width="25" height="25"></td>
							<td><input type="password" width="15%" name="password"
								placeholder="请输入密码" class="inpt2" /></td>
							<td><img src="../../IMG/wlf/l2-2.png" width="25" height="25"
								class="img1"></td>
						</tr>
						<tr>
							<td><img src="../../IMG/wlf/l2-3.png" width="25" height="25"></td>
							<td><input type="password" width=80px placeholder="请确认密码"
								class="inpt3" /></td>
							<td><img src="../../IMG/wlf/l2-2.png" width="25" height="25"
								class="img1"></td>
						</tr>
						<tr>
							<td><img src="../../IMG/wlf/l2-4.png" width="25" height="25"></td>
							<td><select style="width: 45%" name="job" id="provincs">
									<option value="1">总经理</option>
									<option value="2">技术总监</option>
									<option value="3">部门经理</option>
									<option value="4">业务员</option>
							</select> <select  name="depa" id="citys" style="width: 50%">
									<c:forEach items="${info}" var="t">
										<option value="${t.deptID}">${t.deptName}</option>
									</c:forEach>
							</select></td>
							<td><img src="../../IMG/wlf/l2-5.png" width="25" height="25"></td>
						</tr>
						<tr>
							<td><img src="../../IMG/wlf/l2-7.png" width="25" height="25"></td>
							<td><input name="idCard" type="text" width=80px
								placeholder="请输入身份证号" class="inpt4" /></td>
							<td><img src="../../IMG/wlf/l2-2.png" width="25" height="25"
								class="img1"></td>
						</tr>
						<tr>
							<td><img src="../../IMG/wlf/l2-6.png" width="25" height="25"></td>
							<td><input name="address" type="text" width=80px
								placeholder="请输入家庭住址" class="inpt1" /></td>
							<td><img src="../../IMG/wlf/l2-2.png" width="25" height="25"
								class="img1"></td>
						</tr>

						<tr>
							<td></td>
							<td><input type="image" src="../../IMG/wlf/submit.png"
								width="30" height="30" class="ipt1" /></td>
							<td><input type="image" src="../../IMG/wlf/rest.png"
								width="26" height="26" value="重置" class="ipt2" /></td>
						</tr>
					</thead>
				</table>
			</form>
		</div>
	</div>
</body>
</html>