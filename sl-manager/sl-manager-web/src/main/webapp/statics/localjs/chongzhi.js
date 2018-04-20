//充值
$("input[name=sub]").click(function(){

	
	//金额
	var money=$("input[name=money]").val();
	if(money==""||money==0){
		$("input[name=money]").next().html("金额不能为空*");
		return false;
	}
	//二级密码
	var mima2=$("#mima").val();	//二级密码
	var loginpwd2=$("input[name=loginpwd2]").val();
	if(loginpwd2==""){
		$("input[name=loginpwd2]").next().html("二级密码不能为空*");
		return false;
	}
	if(mima2!=loginpwd2){
		$("input[name=loginpwd2]").next().html("二级密码不对*");
		return false;
	}
	
	
	if(confirm("确定充值")){
		
		$.ajax({
			url: 'admin/doCz',
			type: 'POST',
			data:{"money":money,"remark":$("#digest").val(),"mtype":0},
			dataType: 'html',
			timeout: 1000,
			error: function(){
				alert("充值失败");
			},
			success: function(result){
				if(result=="success"){
					$('#CZsucc').modal();
					$("input[name=money]").val("");
					$("input[name=loginpwd2]").val("");
					$("#digest").val("");
					
				}else if(result=="error"){
					alert("充值失败！")
				}else if(result=="nodate"){
					alert("没有数据")
				}
			}
		});
		
		
	}
	
	return false;
	
});