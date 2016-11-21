<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="crm" uri="http://www.trkj.com/tr15/tags"%>
<%@ taglib prefix="u" uri="/WEB-INF/mvc.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
<link href="../../CSS/wlf/deptlist.css" rel="stylesheet" type="text/css" />
<script src="../../jqery/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$('.button1').click(
				function() {
					var take = $(this).parents('tr').children('td');
					var id = take.eq(0).text();
					var name = $.trim(take.eq(1).text());
					if (name != "" && name.length > 0) {
						window.location.href = "DepupdtServlet?id=" + id
								+ "&name=" + name;
					} else {
						alert("输入不能为空");
					}
				});
		$('.button2').click(function() {
			if (confirm('确定要删除该部门吗？')) {
				var take = $(this).parents('tr').children('td');
				var id = take.eq(0).text();
				var name = $.trim(take.eq(1).text());
				alert(name);
				window.location.href = "DeptDelServlet?id=" + id
								+ "&name=" + name+"(旧"+id+")";
			}
		});
	});
</script>
</head>
<body>
	<div id="emps">
		<table >
			<thead>
				<tr>
					<th><a style="color: #FFFFFF;"
						href="DeptInqServlet?curpage=1&pagesize=4">部门查询</a></th>
					<th colspan="2">部门管理</th>
				</tr>
				<tr>
					<th width="20%">部门ID</th>
					<th width="50%">部门名称</th>
					<th width="30%">删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${info.data}" var="t">
					<tr>
						<td>${t.deptID}</td>
						<td ondblclick="this.contentEditable=true;">${t.deptName}</td>
						<td><input class="button button1" id="aa" type="button"
							value="修改"><input type="button" value="删除"
							class="button button2"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="page">
		<u:page pages="${info.pages}" url="DeptInqServlet"
			total="${info.total }" curpage="${info.curpage }"
			pagesize="${info.pagesize }" />
	</div>
</body>
</html>