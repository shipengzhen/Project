$(function() {
	//新增 ajax 验证 姓名
	$("#roleName").blur(function() {
		
		$.ajax({
			type:"GET",
			url:"/HMS/findByRoleName",
			data:{"roleName":$("#roleName").val()},		
			dataType:"json",
			success:function(data){
				if(data.msg=="no"){
					$("#roleNameMSG").html('已存在不能重复！');
					$("#roleName").val("");
				}else if(data.msg=="ok"){
					$("#roleNameMSG").html('');
				}
			}
		});
	})
	
	//新增 非空验证
	$("#addRoleForm").submit(function(){
		$("#roleNameMSG").html('');
		if($("#roleName").val()==""){
			$("#roleNameMSG").html('不能为空！');
			return false;
		}
		return true;
	});
	
	//删除项
	$(".delRole").click(function(){
		
		con=confirm("确认删除吗？");
		if(con==true){
			var but=$(this);
			$.ajax({
				type:"post",
				url:"/HMS/dodelRole",
				data:{"id":but.next().val()},		
				dataType:"json",
				success:function(data){
					if(data.code==200){
						alert("删除成功！");
						but.closest().closest().del();
					}else if(data.code==500){
						alert(data.data);
					}
				}
			});
		};
	});
	
	
	
})