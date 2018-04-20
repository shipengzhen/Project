function page(frm, num) {
	frm.pageNo.value = num;
	frm.submit();
};


// 删除商品
$('.delorders').click(function(e) {
	var d = $(this);
	var d_id = d.attr('id');
	if (confirm("您确定要删除【" + d_id + "】这个商品吗？")) {
		$.post("user/delOrders", {
			'ordersId' : d_id
		}, function(result) {
			if ("success" == result) {
				alert("删除成功！");
				window.location.href = "user/ordersList";
			} else if (result == "nodata") {
				alert("没有数据！");
			} else {
				alert("删除失败！");
			}
		}, 'html');
	}
});