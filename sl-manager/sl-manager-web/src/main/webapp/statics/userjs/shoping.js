function page(frm, num) {
	frm.pageNo.value = num;
	frm.submit();
};

// 用户名验证
function common() {
	$("#userError").html("");
	var loginName = $("#loginName").val();
	if (loginName == null || loginName == '') {
		$("#userError").html("请输入用户名！");
		$("#userError").css("color", "red");
		return;
	}
	$.ajax({
		url : 'user/userExists',
		type : 'POST',
		data : {
			loginName : loginName,
		},
		dataType : 'html',
		timeout : 1000,
		error : function() {
			$("#userError").html("error！");
			$("#userError").css("color", "red");
		},
		success : function(result) {
			if ("failed" == result) {
				$("#userError").html("请输入注册会员名！");
				$("#userError").css("color", "red");
			} else if ("nodata" == result) {
				$("#userError").html("没有数据！");
				$("#userError").css("color", "red");
			}
		}
	});
};

$("#loginName").blur(function() {
	common();
});

// 加入购物车
$(".addShopingCard").click(function(e) {
	var price = $(this).attr('price');
	var ordertype = $(this).attr('ordertype');
	var status = $(this).attr('status');
	var cstype = $(this).attr('cstype');
	var csId = $(this).attr('id');
	
	var csid2=csId+"q";
	
	var num = $("#num" + csid2).val();
	var smtypeid = $(this).attr('smtypeid');

	
	//alert(price+"-"+ordertype+"-"+status+"-"+cstype+"-"+csId+"-"+csid2+"-"+num+"-"+smtypeid);
	//801.0-2-2-1-14-14q-1-undefined
	
	$.ajax({
		url : 'user/addShopingCard',
		type : 'POST',
		data : {
			ocsCsid : csId,
			cstype : cstype,
			ocsCnum : num,
			price : price,
			ordertype : ordertype,
			status : status
		},
		dataType : 'html',
		timeout : 1000,
		error : function() {
			alert("error");
		},
		success : function(result) {
			if ("failed" == result) {
				alert("操作超时！");
			} else if ("nodata" == result) {
				alert("没有数据！");
			} else {
				alert("成功加入购物车！");
			}
		}
	});
});

var li=0;
//立即购买
$(".lijigm").click(function(){
	li=0;
	li=$(this).attr("li");
	$("#fukuan").modal();
});

//确定
$("#isok").click(function(){
	$(".spSMG").html('');
	
	var shren=$("#shren").val();		//用户
	if(shren==null||shren==''){
		$("#shren").next().html("用户名不能为空！");
		return false;
	}
	var shphone=$("#shPhone").val();
	if(shphone==''||shphone==null){
		$("#shPhone").next().html("电话不能为空！");
		return false;
	}
	var shaddress=$("#shaddress").val();
	if(shaddress==''||shaddress==null){
		$("#shaddress").next().html("地址不能为空！");
		return false;
	}
	var pwd2=$("#pwd2").val();
	var pwd2session=$("#pwd2session").val();
	
	if(pwd2==''||pwd2==null){
		$("#pwd2").next().html("密码不能为空！");
		return false;
	}else if(pwd2!=pwd2session){
		$("#pwd2").next().html("密码不正确！");
		return false;
	}
	
	
	aa(li);
});


function aa(e) {
	
					var price = $("#"+e+"q").attr('price');
					var ordertype = $("#"+e+"q").attr('ordertype');
					var status = $("#"+e+"q").attr('status');
					var cstype = $("#"+e+"q").attr('cstype');
					var csId = $("#"+e).attr('id');
					var csid2=csId+"q";
					//alert(csid2); //14q
					
					var num = $("#num" + csid2).val();
					var smtypeid = $("#"+e+"q").attr('smtypeid');
					
					//alert(price+"-"+ordertype+"-"+status+"-"+cstype+"-"+csId+"-"+num+"-"+smtypeid);
					// 801.0-1-1-1-14q-undefined-undefined
		
					if (smtypeid == 9) {
						var str = '<input type="hidden" id="csId" value="'
								+ csId + '">';
						str += '<input type="hidden" id="price" value="'
								+ price + '">';
						str += '<input type="hidden" id="cstype" value="'
								+ cstype + '">';
						str += '<input type="hidden" id="num" value="' + num
								+ '">';
						str += '<input type="hidden" id="ordertype" value="'
								+ ordertype + '">';
						str += '<input type="hidden" id="status" value="'
								+ status + '">';
						str += '<input type="hidden" id="smtypeid" value="'
								+ smtypeid + '">';
						$("#add_formtip").html(str);
						e.preventDefault();
					} else {
						$.ajax({
							url : 'user/addOrders',
							type : 'POST',
							data : {
								ocsCsid : csId,
								cstype : cstype,
								ocsCnum : num,
								price : price,
								ordertype : ordertype,
								status : status
							},
							dataType : 'html',
							timeout : 1000,
							error : function() {
								alert("error");
							},
							success : function(result) {
								if ("failed" == result) {
									alert("操作超时！");
								} else if ("nodata" == result) {
									alert("没有数据！");
								} else if ("no" == result) {
									alert("余额不足！");
								} else {
									
									alert("购买成功！");
								}
							}
						});
					}
				}

// 报单购买
$("#bdAdd").click(function() {
	$("#userError").html("");
	var loginName = $("#loginName").val();
	//alert(loginName);
	if (loginName == null || loginName == '') {
		$("#userError").html("请输入用户名！");
		$("#userError").css("color", "red");
		return;
	}
	$.ajax({
		url : 'user/userExists',
		type : 'POST',
		data : {
			loginName : loginName,
		},
		dataType : 'html',
		timeout : 1000,
		error : function() {
			$("#userError").html("error！");
			$("#userError").css("color", "red");
		},
		success : function(result) {
			if ("failed" == result) {
				$("#userError").html("请输入注册会员名！");
				$("#userError").css("color", "red");
			} else if ("nodata" == result) {
				$("#userError").html("没有数据！");
				$("#userError").css("color", "red");
			} else {
				var csId = $("#csId").val();
				var price = $("#price").val();
				var cstype = $("#cstype").val();
				var num = $("#num").val();
				var smtypeid = $("#smtypeid").val();
				var status = $("#status").val();
				var ordertype = $("#ordertype").val();
//				alert(price);
//				alert(ordertype);
//				alert(status);
//				alert(cstype);
//				alert(csId);
//				alert(num);
//				alert(smtypeid);
				$.ajax({
					url : 'user/addOrders',
					type : 'POST',
					data : {
						ocsCsid : csId,
						cstype : cstype,
						ocsCnum : num,
						price : price,
						ordertype : ordertype,
						status : status,
						loginName:loginName,
						smtypeid:smtypeid
					},
					dataType : 'html',
					timeout : 1000,
					error : function() {
						alert("error");
					},
					success : function(result) {
						if ("failed" == result) {
							alert("操作超时！");
						} else if ("nodata" == result) {
							alert("没有数据！");
						} else if ("no" == result) {
							alert("余额不足！");
						} else {
							alert("购买成功！");
							
						}
					}
				});
			}
		}
	});
});