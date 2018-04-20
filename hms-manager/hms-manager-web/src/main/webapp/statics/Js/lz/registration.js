$(function() {
	
	$(".th").click(function() {
		
		$.ajax({
			type:"post",
			url:"/HMS/doUpdateStatus",
			data:{"id":$(this).attr("f")},		
			dataType:"json",
			success:function(data){
				if(data.code==200){
					alert("修改成功！");
				}else if(data.code==500){
					alert(data.data);
				}
			}
		});
		
		
	})
	
	
	
	$("#idcard").blur(function(){
		//获取输入身份证号码 
		var UUserCard = $("#idcard").val(); 
		if(UUserCard != null && UUserCard != ''){
		//获取性别 
		if (parseInt(UUserCard.substr(16, 1)) % 2 == 1) { 
			$("#sex2").html('男');
			$("#sex1").val('男');			
		} else { 
			$("#sex2").html('女');
			$("#sex1").val('女');		
		} 
		
		//获取年龄 
		var myDate = new Date(); 
		var month = myDate.getMonth() + 1; 
		var day = myDate.getDate();

		var age = myDate.getFullYear() - UUserCard.substring(6, 10) - 1; 
			if (UUserCard.substring(10, 12) < month || UUserCard.substring(10, 12) == month && UUserCard.substring(12, 14) <= day) { 
				age++; 
			}
		$("#age").val(age);
		}
		
	});
	
	//提交
	$("#addRe").submit(function() {
		$(".dd").html('');
		if($("input[name=name]").val()==""){
			$("input[name=name]").next().html('不能为空！');
			return false;
		}
		//身份证
		var reg=/^\d{18}$/;
		if(reg.test($("input[name=idcard]").val())==false){
			 $("input[name=idcard]").next().html('输入有误');
			 return false;
		}
		
		return true;
	});
	
	//联动
	$("#opd").change(function(){
		$("#doctors").empty();	//清楚所有项
		
		$.ajax({
			type:"GET",
			url:"/HMS/doSelectOpdList",
			data:{"id":$("#opd").val()},		
			dataType:"json",
			success:function(data){
				if(data.code==200){
					for (var i = 0; i < data.data.length; i++) {
						$("#doctors").append("<option value="+data.data[i].doctorid+">"+data.data[i].doctorname+"</option>"); //为Select追加一个Option(下拉项)
					}
				}else if(data.code==500){
					alert(data.data);
				}
			}
		});
		
		
	
		
		
	})
	
	
	
})