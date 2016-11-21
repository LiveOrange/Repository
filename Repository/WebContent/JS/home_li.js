;(function($){
     $.fn.extend({
          jump:function(){
			 return $(this).hover(
				function() {
				$(this).children().children().css({
						"color" : "#DAA520",
						"font-size" : "18px"
					});
					var ts = $(this).children().eq(0);
					var a = ts.attr("id");
					if (a === "td1") {
						ts.eq(0).css("background-color", "#FB6B5B");
						ts.eq(0).children("img").attr("src",
								"../../IMG/xmw/dt1_1.png");
					} else if (a === "td2") {
						ts.eq(0).css("background-color", "#ea8010");
						ts.eq(0).children("img").attr("src",
								"../../IMG/xmw/dt2_1.png");
					} else if (a === "td3") {
						ts.eq(0).css("background-color", "#32CD32");
						ts.eq(0).children("img").attr("src",
								"../../IMG/xmw/dt3_1.png");
					} else if (a === "td4") {
						ts.eq(0).css("background-color", "#FF82AB");
						ts.eq(0).children("img").attr("src",
								"../../IMG/xmw/dt4_1.png");
					} else if (a === "td5") {
						ts.eq(0).css("background-color", "#00CED1");
						ts.eq(0).children("img").attr("src",
								"../../IMG/xmw/dt5_1.png");
					} else if (a === "td6") {
						ts.eq(0).css("background-color", "#8B658B");
						ts.eq(0).children("img").attr("src",
								"../../IMG/xmw/dt6_1.png");
					}
					ts.eq(0).children("img").css({
						"width" : "30px",
						"height" : "30"
					});
				},function() {
					var ts = $(this).children().eq(0);
					var a = ts.attr("id");
					if (a === "td1") {
						ts.eq(0).children("img").attr("src",
								"../../IMG/xmw/dt1.png");
					} else if (a === "td2") {
						ts.eq(0).children("img").attr("src",
								"../../IMG/xmw/dt2.png");
					} else if (a === "td3") {
						ts.eq(0).children("img").attr("src",
								"../../IMG/xmw/dt3.png");
					} else if (a === "td4") {
						ts.eq(0).children("img").attr("src",
								"../../IMG/xmw/dt4.png");
					} else if (a === "td5") {
						ts.eq(0).children("img").attr("src",
								"../../IMG/xmw/dt5.png");
					} else if (a === "td6") {
						ts.eq(0).children("img").attr("src",
								"../../IMG/xmw/dt6.png");
					}
					$(this).children().children().css({
						"color" : "#949494",
						"font-size" : "15px"
					});
					ts.children("img").css({
						"width" : "25px",
						"height" : "25"
					});
					$(this).children().css("background-color", "#EEEEEE");
				});
          }
     });
})(jQuery);


