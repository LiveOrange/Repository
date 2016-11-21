;
(function($) {
	$.fn.extend({
		order : function() {
			// 样式
			return $(this).click(
					function() {
						var Phone = $(".Phone").text();
						var MobPhone= $(".MobPhone").text();
						var Email = $(".Email").text();
						var Fax = $(".Fax").text();
						var Money = $(".Money").text();
						var Amount = $(".Amount").text();
						var Quantity = $(".Quantity").text();
						Phone = $.trim(Phone);
						Email = $.trim(Email);
						Fax = $.trim(Fax);
						Money = $.trim(Money);
						Amount = $.trim(Amount);
						Quantity = $.trim(Quantity);
						MobPhone= $.trim(MobPhone);
						var a,b;
						var isMobile = /^(?:13\d|15\d)\d{5}(\d{3}|\*{3})$/;
						var isPhone = /^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
						if (Phone.length > 0) {
							if (!isMobile.test(Phone) && !isPhone.test(Phone)) {
								alert("电话号码格式不正确！");
								$("#img1").attr("src",
										"../../IMG/xmw/order2.png");
								a = 0;
							} else {
								a = 1;
							}
						} else {
							a = 1;
						}
						if (MobPhone.length > 0&&a=="1") {
							if (!isMobile.test(MobPhone) && !isPhone.test(MobPhone)) {
								alert("手机号码格式不正确！");
								$("#img1").attr("src",
										"../../IMG/xmw/order2.png");
								b = 0;
							} else {
								b = 1;
							}
						} else {
							b = 1;
						}
						if (a=="1"&&b=="1") {
							if (!isNaN(Fax)) {

								if (!isNaN(Money)) {
									if ((/^(\+|-)?\d+$/.test(Quantity))&&Quantity>0) {
										console.log("执行！");//$(".Category").find("option:selected").text()
										console.log($(".Category").find("option:selected").text());
										$.ajax({
											type : "get",
											url : "ClientInsertServlet",
											data : {
													CompName:    $(".CompName").text(),
													CompCateg:   $(".CompCateg").text(),
													LoginID:     $(".loginID").text(),
													Category:    $(".Category").find("option:selected").text(),
													RegisTime:   $(".RegisTime").val(),
												
													CommoSourc:  $(".CommoSourc").text(),
													CommoName:   $(".CommoName").text(),
													OutTime:     $(".OutTime").val(),
													ProArea:     $(".clientRegion1").find("option:selected").text()+$(".clientRegion2").find("option:selected").text(),
													CommoAdd:    $(".CommoAdd").text(),
													
													Phone:       Phone,
													MobPhone:    MobPhone,
													Email:       Email,
													Fax:         Fax,
													ClienBound:  $(".ClienBound").text(),
													
													ZFB:   		 $('input:radio[name="ZFB"]:checked').val(),
													ChAtion:     $('input:radio[name="ChAtion"]:checked').val(),
													taob: 		 $('input:radio[name="taob"]:checked').val(),
													AgencyFee:   $(".AgencyFee").text(),
													CredMarg:    $(".CredMarg").text(),
													
													Money:		 Money,
													Amount:		 Amount,
													CustName:	 $(".CustName").text(),
													Quantity: 	 Quantity,
													Commodity:	 $(".Commodity").text(),
											},
												success : function(data, textStatus) {
												if(data=="1"){
													alert("账单录入成功！");
													window.location.reload();
												}else{
													alert("账单录入失败！");
													}
											}
										});
									} else {
										alert("数量请输入大于零的正整数！");
										$("#img1").attr("src",
												"../../IMG/xmw/order2.png");
									}
								} else {
									alert("单价非法字符！");
									$("#img1").attr("src",
											"../../IMG/xmw/order2.png");
								}

							} else {
								a = 0;
								alert("传真非法字符！");
								$("#img1").attr("src",
										"../../IMG/xmw/order2.png");
							}
						}
						console.log(a + "a");
					});

		}
	});
}

)(jQuery);