;(function($){
     $.fn.extend({
	  home_dao: function(){
			//样式
			return $(this).each(function (){
				$(".div_2-1").hide();
				//默认选中	
				var datas=$(this);
				datas.find('ul li:first')
					.attr('id','daohan');
				//导航修改
				datas.find('ul li')
					.each(function (index){
						$(this).attr("x",index);
						}).click(function (){
							$(this).siblings()
								 .attr('id','');
							$(this).attr('id','daohan');
				});
				
			});		
		}
     });
})(jQuery);