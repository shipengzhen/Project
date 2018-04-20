$(function() {
	//住院办理
	//新增住院办理
	$("#addHos").submit(function() {

		$(".dd").html('');
		if($("#rid").val()==''){
			$("#rid").next().html('不能为空');
			return false;
		}
		if($("input[name=nurseid]").val()==''){
			$("input[name=nurseid]").next().html('不能为空');
			return false;
		}
		if($("input[name=bedid]").val()==''){
			$("input[name=bedid]").next().html('不能为空');
			return false;
		}
		if($("input[name=cashPledge]").val()==''){
			$("input[name=cashPledge]").next().html('不能为空');
			return false;
		}
		
		return true;
	})
	
	
	//通过挂号id获取信息
	$("#rid").blur(function() {
		$.ajax({
			type:"post",
			url:"/HMS/doReByidAjax",
			data:{"id":$("#rid").val()},		
			dataType:"json",
			success:function(data){
				if(data.code==200){
					var Re=data.data;
					$("#name").html(Re.name);
					$("#idcard").html(Re.idcard);
					$("#seid").html(Re.seid);
					$("#phone").html(Re.phone);
					$("#isfy").html(Re.isfy);
					$("#sex").html(Re.sex);
					$("#age").html(Re.age);
					$("#cfz").html(Re.cfz);
					$("#opdname").html(Re.opdname);
					$("#doctorName").html(Re.doctorName);
					$("#remarks").html(Re.remarks);
					
				}else if(data.code==500){
					$("#rid").val('');
					alert(data.data);
				}
			}
		});
	})
	
	
	
	
	
})