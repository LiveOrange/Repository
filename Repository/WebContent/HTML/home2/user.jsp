<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="crm" uri="http://www.trkj.com/tr15/tags"%>
<%@ taglib prefix="u" uri="/WEB-INF/mvc.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../CSS/wlf/deptlist.css" rel="stylesheet" type="text/css" />
<script src="../../jqery/jquery-3.1.0.js"></script>
<script src="../../JS/user1.js"></script>
<script type="text/javascript">
	$(function() {
		$(".job").each(function() {
			var job = $(this).text();
			var dem;
			if (job == '1') {
				dem = '总经理';
			} else if (job == '2') {
				dem = '技术总监';
			} else if (job == '3') {
				dem = '部门经理';
			} else if (job == '4') {
				dem = '业务员';
			}
			$(this).text(dem);
		});
		$(".empState").each(function() {
			var job = $(this).text();
			var dem;
			if (job == '0') {
				dem = '离职';
			} else if (job == '1') {
				dem = '在职';
			}
			$(this).text(dem);
		});
		$('.button1').users();
		$('.button2').click(
				function() {
					if (confirm('删除该员工可能导致数据异常是否删除？')) {
						var take = $(this).parents('tr').children('td');
						var id = take.eq(0);
						var name = $.trim(take.eq(1).children().val());
					}
				});
	});
</script>
</head>
<body>
	<div id="emps">
		<table>
			<thead>
				<tr>
					<th><a style="color: #FFFFFF;"
						href="UserInqsServlet?curpage=1&pagesize=4">查询</a></th>
					<th colspan="5">员工管理</th>
				</tr>
				<tr>
					<th width="10%">员工ID</th>
					<th width="10%">员工名称</th>
					<th width="20%">员工部门</th>
					<th width="10%">员工职位</th>
					<th width="10%">入职状态</th>
					<th width="10%">编辑</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${info.data}" var="t">
					<tr>
						<td>${t.id}</td>
						<td ondblclick="this.contentEditable=true;">${t.userName}</td>
						<td ondblclick="this.contentEditable=true;">${t.deptName}</td>
						<td class="job" ondblclick="this.contentEditable=true;">${t.job}</td>
						<td class="empState" ondblclick="this.contentEditable=true;">${t.empState}</td>
						<td><input class="button button1" id="aa" type="button"
							value="修改"><input type="button" value="删除"
							class="button button2"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="page">
		<div class="page">
			<u:page pages="${info.pages}" url="UserInqsServlet"
				total="${info.total }" curpage="${info.curpage }"
				pagesize="${info.pagesize }" />
		</div>
	</div>
</body>
</html>