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
<link href="../../CSS/wlf/dept.css" rel="stylesheet" type="text/css" />
<script src="../../jqery/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(function() {
		$('.button1').click(function() {
			if (confirm('确定要挑入该客户吗？')){
				var take = $(this).parents('tr').children('td');
				var td1=take.eq(0).text();
				var td2=take.eq(2).text();
				var x=$(".x1").attr("x");
				var x1=$(".x2").attr("x1");
				console.log(td1+":"+td2+":"+x);
				$.ajax({
					type : "get",
					url : "ConsumerServlet",
					data : {
						td1 : td1,
						td2 : td2,
						x : x,
						x1:x1,
					},
					success : function(data, textStatus) {
						var objs = eval(data);
						
					}
				});
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
					<th colspan="8">公海客户</th>
				</tr>
				<tr>
					<th width="8%">客户ID</th>
					<th width="10%">客户名称</th>
					<th width="8%">公海ID</th>
					<th width="10%">客户产品</th>
					<th width="10%">客户电话</th>
					<th width="15%">流入公海时间</th>
					<th width="15%" class="x2" x1="${info.username}">流入公海原因</th>
					<th width="10%" class="x1" x="${info.x}">编辑</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${info.data}" var="t">
					<tr>
						<td>${t.clientID}</td>
						<td>${t.clientfirm}</td>
						<td>${t.comseaID}</td>
						<td>${t.clientProd}</td>
						<td>${t.clientPhone}</td>
						<td>${t.data}</td>
						<td>${t.reason}</td>
						<td><input class="button button1" id="aa" type="button"
							value="客户挑入"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="page">
		<div class="page">
			<u:page pages="${info.pages}"
				url="IiberumServlet?a=${info.a}&logid=${info.logid}&id=${info.id}&name=${info.name}&prod=${info.prod}&x=${info.x}&username=${info.username}"
				total="${info.total }" curpage="${info.curpage }"
				pagesize="${info.pagesize }" />
		</div>
	</div>
</body>
</html>