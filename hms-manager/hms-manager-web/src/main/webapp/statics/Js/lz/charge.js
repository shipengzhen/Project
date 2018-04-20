$(function() {
	//删除
	$(".del").click(function() {
		$.ajax({
			type:"post",
			url:"/HMS/delCostItem",
			data:{"id":$(this).attr("aa")},		
			dataType:"json",
			success:function(data){
				if(data.code==200){
				
					$(this).parent().parent().remove();
				}else if(data.code==500){
					alert(data.data);
				}
			}
		});
		
	});
	
	
	//新增
	$("#addCostItem").submit(function() {
		
		$(".dd").html('');
		//姓名
		if( $("input[name=costitemname]").val()==""){
			 $("input[name=costitemname]").next().html('不能为空！');
			 return false;
		}
		//qian
		if( $("input[name=cost]").val()==""){
			 $("input[name=cost]").next().html('不能为空！');
			 return false;
		}
		
		return true;
	});
	

	
	
})