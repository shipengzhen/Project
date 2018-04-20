$(function(){
	
	var rname=function(){
		$.ajax({
			type:"GET",
			url:"/HMS/doRibyRname",
			data:{"rnam":$("#addrnam").val()},		
			dataType:"json",
			success:function(data){
				if(data.msg=="no"){
					$("#addrnammsg").html('已存在不能重复！');
					$("#addrnam").val("");
				}else if(data.msg=="ok"){
					$("#addrnammsg").html('');
				}
			}
		});
	}
	//更新 ajax 验证
	var rname=$("#updaternam").val();
	//ajax验证
	$("#updaternam").blur(function() {
		$("#updaternammsg").html('');
		if(rname!=$("#updaternam").val()){
			$.ajax({
				type:"GET",
				url:"/HMS/doRibyRname",
				data:{"rnam":$("#updaternam").val()},		
				dataType:"json",
				success:function(data){
					if(data.msg=="no"){
						$("#updaternammsg").html('已存在不能重复！');
						$("#updaternam").val("");
					}else if(data.msg=="ok"){
						$("#updaternammsg").html('');
					}
				}
			});
		}
		
	});
	
	
	//更新提交非空验证
	$("#updateFrom").submit(function(){
		$("#updaternammsg").html('');
		$("#updateurlmsg").html('');
		
		if($("#updaternam").val()==""){
			$("#updaternammsg").html('不能为空！');
			return false;
		}
		if($("#updateurl").val()==""){
			$("#updateurlmsg").html('不能为空！');
			return false;
		}
		return true;
	})
	
	//删除项
	$(".delRitem").click(function(){
		con=confirm("确认删除吗？");
		if(con==true){
			var but=$(this);
			$.ajax({
				type:"GET",
				url:"/HMS/delRItem",
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
	
	//新增 ajax验证
	$("#addrnam").blur(function() {
		rname();
	});
	
	//新增提交非空验证
	$("#addFrom").submit(function(){
		$("#addurlmsg").html('');
		$("#addrnammsg").html('');
		if($("#addrnam").val()==""){
			$("#addrnammsg").html('不能为空！');
			return false;
		}
		if($("#addurl").val()==""){
			$("#addurlmsg").html('不能为空！');
			return false;
		}
		return true;
	})
	
	
});
