;(function($){
     $.fn.extend({
	  users: function(){
			return $(this).click(function (){
			var take = $(this).parents('tr').children('td');
					var id = take.eq(0).text();
					var name = $.trim(take.eq(1).text());
					var dept = $.trim(take.eq(2).text());
					var job = $.trim(take.eq(3).text());
					var empState = $.trim(take.eq(4).text());
					console.log(name != "" && name.length > 0&&dept != "" && dept.length > 0);
					if (name != "" && name.length > 0&&dept != "" && dept.length > 0) {
						var d,c;
						 if(job=='总经理'){
							 	d=1;
							}else if(job=='技术总监'){	
								d=2;
							}else if(job=='部门经理') {
								d=3;
							}else if(job=='业务员'){
								d=4;
							}else{
								d=5;
							}
						if(d!=5&&empState=='离职'){
							c=0;	
						}else if(d!=5&&empState=="在职"){
							c=1
						}else if(d==5){
							alert("员工职务修改失败！");
						}else {
							alert("员工状态修改失败！");
						}
						if(c==0||c==1){
							window.location.href = "UserupdtServlet?id=" + id
						     +"&name=" + name+"&dept="+dept
							 +"&job="+d+"&empState="+c;
						}
					} else {
						alert("输入不能为空");
					}
			});		
		}
     });
})(jQuery);