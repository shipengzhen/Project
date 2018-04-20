$(function(){
	
	

	//通过身份证获取``
	$("#idcard").blur(function(){
		//获取输入身份证号码 
		var UUserCard = $("#idcard").val(); 
		
		if(UUserCard != null && UUserCard != ''){
		//获取出生日期 
		var birthday = UUserCard.substring(6, 10) + "-" + UUserCard.substring(10, 12) + "-" + UUserCard.substring(12, 14); 
		
		$("#birthday").val(birthday);			//出生年月
		$("#birthdays").html(birthday);;		//出生年月
		
		//获取性别 
		if (parseInt(UUserCard.substr(16, 1)) % 2 == 1) { 
			$("#sexspan").html('男');
			$("#sex").val('男');			
		} else { 
			$("#sexspan").html('女');
			$("#sex").val('女');		
		} 
		
		/*获取年龄 
		var myDate = new Date(); 
		var month = myDate.getMonth() + 1; 
		var day = myDate.getDate();

		var age = myDate.getFullYear() - UUserCard.substring(6, 10) - 1; 
		if (UUserCard.substring(10, 12) < month || UUserCard.substring(10, 12) == month && UUserCard.substring(12, 14) <= day) { 
		age++; 
		}
		$("#age").val(age);
		年龄 age */
		}
		
	});
	
	//新增医生
	$("#addDoctor").submit(function(){
		
		$(".msgs").html('');
		

		//姓名
		if( $("input[name=doctorname]").val()==""){
			 $("input[name=doctorname]").next().html('不能为空！');
			 return false;
		}
		//身份证
		var reg=/^\d{18}$/;
		if(reg.test($("input[name=idcard]").val())==false){
			 $("input[name=idcard]").next().html('输入有误');
			 return false;
		}
		//手机号
		var reg2=/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
		if(reg2.test($("input[name=phone]").val())==false){
			 $("input[name=phone]").next().html('输入有误');
			 return false;
		}
		//电子邮箱
		var reg3=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if(reg3.test($("input[name=email]").val())==false){
			 $("input[name=email]").next().html('输入有误');
			 return false;
		}
		
	})
	
	
	
});