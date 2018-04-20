function page(frm,num){
	frm.pageNo.value = num;
	frm.submit();
}


$('.addGoodsPack').click(function(e){
	window.location.href="admin/addSetMealManager";
});

$('.modifygoodspack').click(function(e){
	var id = $(this).attr('id');
	window.location.href="admin/modifysetMealManager?smId="+id;
});

$('.viewgoodspack').click(function(e){
	var id = $(this).attr('id');
	window.location.href="admin/setMealInfo?smId="+id;
});

$('.delgoodspack').click(function(e){
	var d_id = $(this).attr('id');
	var goodsPackName = $(this).attr('goodsPackName');
	if(confirm("您确定要删除【"+goodsPackName+"】这个商品套餐吗？")){
		//delete
		$.post("admin/delSetMeal",{'smId':d_id},function(result){
			if("success" == result){
				alert("删除成功！");
				window.location.href="admin/setMealManager";
			}else{
				alert("删除失败！");
			}
		},'html');
	}
	
	
});

$(".modifystate").click(function(){
	modify = $(this);
	state= modify.attr("state");
	id= modify.attr("goodspackid");
	goodsPackStart = new Object();
	goodsPackStart.id = id;
	if(state == "1"){
		goodsPackStart.state = 2;
		modify.attr("state","2");
	}
	else{
		goodsPackStart.state = 1;
		modify.attr("state","1");
	}
	$.ajax({
		url: 'admin/modifySetMealStatus',
		type: 'POST',
		data:{smid:id,smstatic:goodsPackStart.state},
		dataType: 'html',
		timeout: 1000,
		error: function(){
			alert("上架或下架商品套餐操作时失败！请重试。");
			window.location.href="admin/setMealManager";
		},
		success: function(result){
			if(result != "" && "success" == result){
				if(state == "1")
					modify.attr("state",2);
				else
					modify.attr("state",1);
			}else if("failed" == result){
				alert("上架或下架商品套餐操作时失败！请重试。");
				window.location.href="admin/setMealManager";
			}else if("nodata" == result){
				alert("对不起，没有任何数据需要处理！请重试。");
				window.location.href="admin/setMealManager";
			}
		}
	});
});

