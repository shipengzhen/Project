$(function(){
	$("#loginname").blur(function(){
		$.ajax({
			type:"GET",
			url:"/HMS/doUserByusername",
			data:{"loginName":$("#loginname").val()},		
			dataType:"json",
			success:function(data){
				if(data.code==500){
					$("#loginname").val("");
					$("#loginnameSpan").html(data.data);
				}
			}
		});
	});
	
	$("#addUserForm").submit(function(){
		
		$(".msg").html('');
		if($("#loginname").val()==""){
			$("#loginname").next().html("不能为空");
			return false;
		}
		
		if($("#loginpwd").val().length<6){
			$("#loginpwd").next().html("不能少于6位");
			return false;
		}
		if($("#username").val()==""){
			$("#username").next().html("不能为空!");
			return false;
		}
			
		var reg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(reg.test($("input[name=email]").val())==false){
			$("input[name=email]").next().html("邮箱有误!");
			return false;
		}
		
		if($("#roleid").val()=="-1"){
			$("#roleid").next().html("请选择!");
			return false;
		}
		
		return true;
		
	})
	
	
	
	
});