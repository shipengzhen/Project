function page(frm, num) {
	frm.pageNo.value = num;
	frm.submit();
};

// 删除商品
$('.delShopingCardcs').click(function(e) {
	var d = $(this);
	var price = d.attr('price');
	var csname = d.attr('csname');
	var oid = d.attr('oid');
	var csid = d.attr('csid');
	var cstype = d.attr('cstype');
	var ocsCnum=d.attr('num');
	// alert(price);
	// alert(csname);
	// alert(oid);
	// alert(csid);
	// alert(cstype);
	var str = "";
	if (cstype == 1) {
		str = "您确定要删除【" + csname + "】这个商品吗？"
	}
	if (cstype == 2) {
		str = "您确定要删除【" + csname + "】这个套餐吗？"
	}
	if (confirm(str)) {
		$.post("user/delShopingCardcs", {
			'ocsOid' : oid,
			'ocsCsid' : csid,
			'cstype' : cstype,
			'price' : price,
			'ocsCnum':ocsCnum
		}, function(result) {
			if ("success" == result) {
				alert("删除成功！");
				window.location.href = "user/shopingCard";
			} else if (result == "nodata") {
				alert("没有数据！");
			} else {
				alert("删除失败！");
			}
		}, 'html');
	}
});

//结算
$("#settleAccounts").click(function(e) {
	$("#dd123").html("");
	var uname1=$("#uname1").val();
	if(uname1==""){
		$("#dd123").html("收货人不能为空！");
		return false;
	}
	
	var phone1=$("#phone1").val();
	if(phone1==""){
		$("#dd123").html("电话不能为空！");
		return false;
	}
	
	var address1=$("#address1").val();
	if(address1==""){
		$("#dd123").html("地址不能为空！");
		return false;
	}
	
	//---
	var d = $(this);
	var price = d.attr('price');
	var oid = d.attr('oid');
//	alert(price);
//	alert(oid);
	$.post("user/settleAccounts", {
		'price' : price,
		'oid' : oid,
	}, function(result) {
		if ("success" == result) {
			alert("结算成功！");
			window.location.href = "user/shopingCard";
		} else if (result == "nodata") {
			alert("没有数据！");
		} else {
			alert("结算失败！");
		}
	}, 'html');
});