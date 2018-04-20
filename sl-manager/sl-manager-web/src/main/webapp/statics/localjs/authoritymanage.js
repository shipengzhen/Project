$('.roleNameAuthority').click(function() {
	var authority = $(this);
	var roleId = authority.attr("roleid");
	$("#selectrole").html("当前配置角色为：" + authority.attr("rolename"));
	$("#roleidhide").val(roleId);
	//functions
	$.ajax({
		url : 'admin/authoritylist',
		type : 'POST',
		dataType :'json',
		timeout : 1000,
		error : function() {
			alert("对不起，功能列表获取失败，请重试。");
		},
		success : function(result) {
			if (result == "nodata") {
				alert("对不起，功能列表获取失败，请重试。");
			} else {
				//var json = eval('(' + result + ')');//强转json
				var json=result;
				listr = "";
				for (var i = 0; i < json.length; i++) {
					//alert(json[i].sysAuthority.authorityid);
					//alert(json[i].sysAuthority.authorityname);
					listr += "<li>";
//					一级
					listr += "<ul id=\"subfuncul" + json[i].sysAuthority.authorityid + "\" class=\"subfuncul\">";
					listr += "<li  class=\"functiontitle\" ><input id='functiontitle" + json[i].sysAuthority.authorityid + "' onchange='level1(this," + json[i].sysAuthority.authorityid + ");' funcid=\"" + json[i].sysAuthority.authorityid + "\" type='checkbox' />" + json[i].sysAuthority.authorityname;
//					二级
					listr += "<ul id=\"subfuncu2" + json[i].sysAuthority.authorityid + "\" class=\"subfuncu2\">";
					for (j = 0; j < json[i].menus.length; j++) {
						//alert(json[i].menus[j].sysAuthority.authorityid);
						//alert(json[i].menus[j].sysAuthority.authorityname);
						listr += "<li><input id='functiontitle" + json[i].menus[j].sysAuthority.authorityid +"' onchange='level2(this," + json[i].sysAuthority.authorityid +","+json[i].menus[j].sysAuthority.authorityid+");' funcid=\"" + json[i].menus[j].sysAuthority.authorityid + "\" type='checkbox' /> " + json[i].menus[j].sysAuthority.authorityname + "</li>";
//						三级
						listr += "<ul id=\"subfuncu3" + json[i].menus[j].sysAuthority.authorityid + "\" class=\"subfuncu3\">";
						for (k = 0; k < json[i].menus[j].menus.length; k++) {
							//alert(json[i].menus[j].menus[k].sysAuthority.authorityid);
							//alert(json[i].menus[j].menus[k].sysAuthority.authorityname);
							listr += "<li><input onchange='level3(this," +json[i].sysAuthority.authorityid+","+json[i].menus[j].sysAuthority.authorityid+ ");' funcid=\"" + json[i].menus[j].menus[k].sysAuthority.authorityid + "\" type='checkbox' /> " + json[i].menus[j].menus[k].sysAuthority.authorityname;
						}
						listr +="</ul></li>";
					}
					listr += "</ul></li></ul></li>";
				}
				$("#functionList").html(listr);
				//get default value
				$("#functionList :checkbox").each(function() {
					var checkbox = $(this);
					
					var authoriyId=$(this).attr("funcid");
					$.ajax({
						url : 'admin/getAuthorityDefault',
						type : 'POST',
						data : {
							roleId :roleId,
							authoriyId:authoriyId
						},
						dataType : 'html',
						timeout : 1000,
						error : function() {},
						success : function(result) {
							if (result == "success") {
								//alert("ok");
								checkbox.attr("checked", true);
							} else {
								//alert("no");
								checkbox.attr("checked", false);
							}
						}
					});
				});
			}
		}
	});
});

function level1(obj, id) {
	if (obj.checked) {
		$("#subfuncul" + id + " :checkbox").attr("checked", true);
	} else {
		$("#subfuncul" + id + " :checkbox").attr("checked", false);
	}
//alert($(this) +　id);
}

function level2(obj, id,id2) {
	if (obj.checked) {
		$("#functiontitle" + id).attr("checked", true);
	}
	if (obj.checked) {
		$("#subfuncu3" + id2 + " :checkbox").attr("checked", true);
	} else {
		$("#subfuncu3" + id2 + " :checkbox").attr("checked", false);
	}
}

function level3(obj,level1Id,level2Id) {
	if (obj.checked) {
		$("#functiontitle" + level1Id).attr("checked", true);
		$("#functiontitle" + level2Id).attr("checked", true);
	}
}



$("#selectAll").click(function() { //全选  
	$("#functionList :checkbox").attr("checked", true);
});

$("#unSelect").click(function() { //全不选  
	$("#functionList :checkbox").attr("checked", false);
});

$("#reverse").click(function() { //反选  
	$("#functionList :checkbox").each(function() {
		$(this).attr("checked", !$(this).attr("checked"));
	});
});



//修改权限
$("#confirmsave").click(function() {
	if (confirm("您确定要修改当前角色的权限吗？")) {
		var roleId = $("#roleidhide").val();
		var authorityIds="";
		$("#functionList :checkbox").each(function() {
			if ($(this).attr("checked") == 'checked') {
				authorityIds += $(this).attr("funcid")+"-";
			}
		});
		$.ajax({
			url : 'admin/modifyAuthority',
			type : 'POST',
			data : {
				roleId : roleId,
				authorityIds:authorityIds
			},
			dataType : 'html',
			timeout : 1000,
			error : function() {},
			success : function(result) {
				if (result == "nodata") {
					alert("对不起，功能列表获取失败，请重试。");
				}else if(result=="failed"){
					alert("权限修改失败。");
				} else {
					alert("恭喜您，权限修改成功。");
					window.location.href="admin/authoritymanage";  //跳页面
				}
			}
		});
	}
});