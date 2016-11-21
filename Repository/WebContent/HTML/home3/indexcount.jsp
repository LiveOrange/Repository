<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计插件</title>
<script type="text/javascript" src="../../JS/xmw/js/jquery.js"></script>
<script type="text/javascript" src="../../JS/xmw/js/jsapi.js"></script>
<script type="text/javascript" src="../../JS/xmw/js/corechart.js"></script>		
<script type="text/javascript" src="../../JS/xmw/js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="../../JS/xmw/js/jquery.ba-resize.min.js"></script>
<script type="text/javascript">
gvChartInit();
$(document).ready(function(){
	$('#myTable5').gvChart({
		chartType: 'PieChart',
		gvSettings: {
			vAxis: {title: 'No of players'},
			hAxis: {title: 'Month'},
			width: 80%+"",
			height: 80%+""
		}
	});
});
</script>
<script type="text/javascript">
gvChartInit();
$(document).ready(function(){
		$('#myTable1').gvChart({
			chartType: 'PieChart',
			gvSettings: {
			vAxis: {title: 'No of players'},
			hAxis: {title: 'Month'},
			width: 80%+"",
			height: 80%+""
		}
	});
});
</script>
</head>
<body>
<div style="width:100%;margin:0 auto;">
	   <table id='myTable5'>
			<caption>客户订单详情统计</caption>
			<thead>
				<tr>
					<th></th>
					<th>服务中</th>
					<th>已签单</th>
					<th>流入公海</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>${info.sum}</th>
					<td>${info.wks}</td>
					<td>${info.qdz}</td>
					<td>${info.ywjs}</td>
				</tr>
			</tbody>
		</table> 
		<table id='myTable1'>
			<caption>员工部门分部</caption>
			<thead>
				<tr>
					<th></th>
					<c:forEach items="${info.data }" var="e">
						<th>${e.data}</th>				
				   </c:forEach>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>${info.cout}</th>
					<c:forEach items="${info.data }" var="e">
						<td>${e.count}</td>				
				   </c:forEach>
					</tr>
			</tbody>
		</table> 
	</div>	
</body>
</html>