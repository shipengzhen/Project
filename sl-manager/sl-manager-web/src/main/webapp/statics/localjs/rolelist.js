$('.addrole').click(function(e){
		e.preventDefault();
		$('#addRoleDiv').modal('show');
  });

$("#addRoleCancel").click(loadingRoleList);
$("#addRoleClose").click(loadingRoleList);

//关闭
function loadingRoleList(){
	window.location.href = "admin/roleList";
}
//新增角色
$("#addRoleBtn").click(function(){
	var status =$.trim($('input:radio:checked').val());
	var roleName = $.trim($("#roleName").val());
	if(status == "" ||status == null){
		 $("#roleCode").focus();
		 $("#formtip").css("color","red");
		 $("#formtip").html("对不起，角色状态不能为空。");
	}else if(roleName == "" ||roleName == null){
		$("#roleName").focus();
		$("#formtip").css("color","red");
		$("#formtip").html("对不起，角色名称不能为空。");
	}else{
		$("#formtip").html("");
		$.ajax({
			url: 'admin/addRole',
			type: 'POST',
			data:{roleName:roleName,status:status},
			dataType: 'html',
			timeout: 1000,
			error: function(){
				$("#formtip").css("color","red");
				$("#formtip").html("角色添加失败！请重试。");
			},
			success: function(result){
				if(result != "" && "success" == result){
					$("#formtip").css("color","green");
					$("#formtip").html("角色添加成功 ^_^ 继续添加请填写。");
					$("#roleCode").val('');
					$("#roleName").val('');
				}else if("failed" == result){
					$("#formtip").css("color","red");
					$("#formtip").html("角色添加失败！请重试。");
				}
				else if("rename" == result){
					$("#formtip").css("color","red");
					$("#formtip").html("角色添加失败！角色代码和角色名称不能重复，请重试。");
				}else if("nodata" == result){
					alert("对不起，没有任何数据需要处理！请重试。");
				}
			}
		});
	}
});

//修改角色
$(".modifyrole").click(function(){
	var modify = $(this);
	var roleid= modify.attr("roleid");
	var oldName= modify.attr("rolename");
	var roleName = $.trim($("#roleName"+roleid).val());
	if(roleName == "" || roleName == null){
		alert("对不起，角色名称不能为空。");
	}else{
		var tip = "您确定要将原来的角色名称:"+oldName + "\n,修改角色名称:" + roleName + "\n吗？";
		if(confirm(tip)){
			$.ajax({
				url: 'admin/modifyRole',
				type: 'POST',
				data:{roleid:roleid,rolename:roleName},
				dataType: 'html',
				timeout: 1000,
				error: function(){
					alert("角色修改失败！请重试。");
					loadingRoleList();
				},
				success: function(result){
					if(result != "" && "success" == result){
						alert("角色修改成功 ^_^");
					}else if("failed" == result){
						alert("角色修改失败！请重试。");
						loadingRoleList();
					}else if("nodata" == result){
						alert("对不起，没有任何数据需要处理！请重试。");
						loadingRoleList();
					}else if("rename" == result){
						alert("角色添加失败！角色代码和角色名称不能重复，请重试。");
						loadingRoleList();
					}
				}
			});
		}
	}
});

//修改角色 状态 
$(".modifyIsStart").click(function(){
	var modify = $(this);
	var roleid= modify.attr("roleid");
	var status= modify.attr("isstart");
	if(status == "0"){
		status = 1;
	}
	else{
		status = 0;
	}
	$.ajax({
		url: 'admin/modifyRole',
		type: 'POST',
		data:{roleid:roleid,status:status,code:"1"},
		dataType: 'html',
		timeout: 1000,
		error: function(){
			alert("开启或关闭角色操作时失败！请重试。");
			loadingRoleList();
		},
		success: function(result){
			if("success" == result){
				if(status ==1)
					modify.attr("isstart",0);
				else
					modify.attr("isstart",1);
			}else if("failed" == result){
				alert("开启或关闭角色操作时失败！请重试。");
				loadingRoleList();
			}else if("nodata" == result){
				alert("对不起，没有任何数据需要处理！请重试。");
				loadingRoleList();
			}else if("nofalse"==result){
				alert("该角色被占用！不能修改");
				modify.attr("isstart",0);
				loadingRoleList();
			}
		}
	});
});

//删除角色
$(".delrole").click(function(){
	var modify = $(this);
	var roleid= modify.attr("roleid");
	var roleName= modify.attr("rolename");
	var tip = "您确定要删除角色："+roleName+"吗？";
	if(confirm(tip)){
		$.ajax({
			url: 'admin/delRole',
			type: 'POST',
			data:{roleid:roleid},
			dataType: 'html',
			timeout: 1000,
			error: function(){
				alert("删除角色失败！请重试。");
			},
			success: function(result){
				if(result != "" && "success" == result){
					alert("删除角色成功 ^_^");
					loadingRoleList();
				}else if("failed" == result){
					alert("删除角色失败！请重试。");
				}else if("nodata" == result){
					alert("对不起，没有任何数据需要处理！请重试。");
				}else if(result=="nodel"){
					alert("系统中有用户被授权该角色，不能被删除!");
				}
			}
		});
	}
});