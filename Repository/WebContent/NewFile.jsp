<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../../jqery/jquery-3.1.0.js"></script>
<script type="text/javascript">
$(function() {
	$(".aa").click(function() {
		$.ajax({
			type : "get",
			url : "/HTML/home3/OrderSum",
			data : {
				data:data,
			},
			success : function(data, textStatus) {
				//var data={"Sum2":"1","Sum1":"4","Sum":"6","Sum6":"0","Sum5":"0","Sum4":"0","Sum3":"1"};
				console.log(data);
				var datas=data;
				console.log(datas);
				var eValue=data.Sum2;  
				 alert(eValue);  
			}});
	});
	
});
</script>
</head>
<body>

<input type="button" class="aa">








</body>
</html>