$("#loginBtn").click(function(){
	var user = new Object();
	user.loginCode = $("#logincode").val();
	user.password = $("#password").val();
	
	
	if(user.loginCode == "" || user.loginCode == null){
		 $("#logincode").focus();
		 $("#formtip").css("color","red");
		 $("#formtip").html("对不起，登录账号不能为空。");
	}else if(user.password == "" || user.password == null){
		$("#password").focus();
		$("#formtip").css("color","red");
		$("#formtip").html("对不起，登录密码不能为空。");
	}else{
		$("#formtip").html("");
		
		$.ajax({
			url: 'doLogin',
			type: 'POST',
			data:{loginName:user.loginCode,loginPwd:user.password},
			dataType: 'html',
			timeout: 1000,
			error: function(){
				$("#formtip").css("color","red");
				$("#formtip").html("登录失败！请重试。");
			},
			success: function(result){
				if("success" == result){
					window.location.href='admin/main';
				}else if("failed" == result){
					$("#formtip").css("color","red");
					$("#formtip").html("登陆失败！请重试。");
					$("#logincode").val('');
					$("#password").val('');
					
				}else if("pwderror" == result){
					$("#formtip").css("color","red");
					$("#formtip").html("登录密码错误，请重试。");
				}else if(result=="jy"){
					alert("你已被禁用");
				}else if(result=="jh"){
					alert("请激活用户");
				}
			}
			});
	}
});

