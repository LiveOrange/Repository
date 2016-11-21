;
(function($) {
	$.fn.extend({
		searchs : function() {
			$(".gation_input2").click(
					function() {
						var x = $("#daohan").attr("x");
						console.log("x:" + x);
						var datas = $.trim($(".gation_input1").val());
						if (datas != null && datas.length > 0) {
							console.log("x:" + datas);
							if (x == "0") {
							} else if (x == "1") {
								$.ajax({
									type : "get",
									url : "CustomerInqServlet",
									data : {
										clientName : datas,
										id : x,
									},
									success : function(data, textStatus) {
										var objs = eval(data); // 解析json对象
										var obj = objs[0];
										console.log(obj);
										var iframe = $("#iframe3").contents();
										iframe.find("#clientName1").text(
												obj.clientName);
										iframe.find(".clientIndusttry1").text(
												obj.clientIndusttry);
										iframe.find(".loginID1").text(
												obj.loginID);
										iframe.find(".clientProd1").text(
												obj.clientProd);
										iframe.find(".datas1").text(
												obj.datas);
										iframe.find(".clientSource1").text(
												obj.clientSource);
										iframe.find(".clientAddress1").text(
												obj.clientAddress);
										iframe.find(".clientCorporat1").text(
												obj.clientCorporat);
										iframe.find(".clientCapital1").text(
												obj.clientCapital);
										iframe.find(".clientNumber1").text(
												obj.clientNumber);
										iframe.find(".clientWebType1").text(
												obj.clientWebType);
										iframe.find(".ensure1").text(
												obj.ensure);
										iframe.find(".taobao1").text(
												obj.taobao);
										iframe.find(".zfb1").text(
												obj.zfb);
										iframe.find(".clientfirm1").text(
												obj.clientfirm);
										iframe.find(".clientPhone1").text(
												obj.clientPhone);
										iframe.find(".clientPost1").text(
												obj.clientPost);
										iframe.find(".clientCall1").text(
												obj.clientCall);
										iframe.find(".clientDept1").text(
												obj.clientDept);
										iframe.find(".clientFax").text(
												obj.clientFax);
										iframe.find(".email1").text(
												obj.email);
										iframe.find(".clientOffer1").text(
												obj.clientOffer);
										iframe.find(".clientReputat1").text(
												obj.clientReputat);
										iframe.find(".clientPayment1").text(
												obj.clientPayment);
										iframe.find(".clientBackground1").text(
												obj.clientBackground);
										iframe.find(".clientRegion1").text(
												obj.clientRegion);
									}
								});
							} else if (x == "2") {
							}

						} else {
							alert("输入不能为空!");
						}
					});
		}
	});
})(jQuery);