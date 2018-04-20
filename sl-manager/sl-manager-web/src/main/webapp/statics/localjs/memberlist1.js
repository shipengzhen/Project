	function timeStamp2String (time){

	    var datetime = new Date();
	     datetime.setTime(time);
	     var year = datetime.getFullYear();
	     var month = datetime.getMonth() + 1;
	     var date = datetime.getDate();
	     var hour = datetime.getHours();
	     if(hour<=9){
	         hour="0"+hour;
	     }
	     var minute = datetime.getMinutes();
	      if(minute<=9){
	         minute="0"+minute;
	     }
	     var second = datetime.getSeconds();
	      if(second<=9){
	         second="0"+second;
	     }
	    // var mseconds = datetime.getMilliseconds();
	     return year + "-" + month + "-" + date;
	};



function checkEmail(str){
	var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(str == null || str == "" || reg.test(str))
		return true;
	else
		return false;
}

//修改
$('.modifymember').click(function(e){

	var m_id = $(this).attr('id');
	$.ajax({
		url: 'admin/UserById',
		type: 'POST',
		data:{id:m_id},
		dataType: 'html',
		timeout: 1000,
		error: function(){
			
			alert("error");
		},
		success: function(result){
			if("failed" == result){
				alert("操作超时！");
			}else if("nodata" == result){
				alert("没有数据！");
			}else{
				m = eval('(' + result + ')');
				$("#m_id").val(m.userid);
				$("#m_logincode").val(m.loginname);
				$("#m_username").val(m.uname);
			
				$("#m_cardtype").val(m.cardtypeid);
				$("#m_cardtypename").val(m.cardnumberName);
				var cardType = m.cardtypeid;
				var cardTypeName = m.cardnumberName;
				$("#m_cardtype").html('');
				
				if(cardType == null || cardType == "")
					$("#m_cardtype").append("<option value=\"\" selected=\"selected\">--请选择--</option>");
				for(var i=0;i<cartTypeListJson.length-1;i++){
					if(cartTypeListJson[i].valueId == cardType){
						$("#m_cardtype").append("<option value=\""+cardType+"\" selected=\"selected\">"+cardTypeName+"</option>");
					}else{
						$("#m_cardtype").append("<option value=\""+cartTypeListJson[i].valueId+"\">"+cartTypeListJson[i].valueName+"</option>");
					}
				}
				$("#m_rolename").val(m.roleName);
				$("#m_selectusertype").html('');
				$("#m_selectusertypename").val(m.hyType);
				
		
				
				var userType = m.associatorid;
				var userTypeName = m.hyType;
				
				
				if(userType == null || userType == "")
					$("#m_selectusertype").append("<option value=\"\" selected=\"selected\">--请选择--</option>");
				
				
				for(var i=0;i<userTypeListJson.length-1;i++){
					if(userTypeListJson[i].id == userType){
						$("#m_selectusertype").append("<option value=\""+userType+"\" selected=\"selected\">"+userTypeName+"</option>");
					}else{
						$("#m_selectusertype").append("<option value=\""+userTypeListJson[i].id+"\">"+userTypeListJson[i].roleName+"</option>");
					}
				}
				$("#m_sex").empty();	
				var sex = m.sex;
				if(sex == '男'){
					$("#m_sex").append("<option value=\"男\" selected=\"selected\">男</option><option value=\"女\">女</option>");
				}else if(sex == "女"){
					$("#m_sex").append("<option value=\"男\">男</option><option value=\"女\" selected=\"selected\">女</option>");
				}else{
					$("#m_sex").append("<option value=\"\" selected=\"selected\">--请选择--</option><option value=\"男\">男</option><option value=\"女\">女</option>");
				}
				$("#m_idcard").val(m.cardnumber);
				$("#m_mobile").val(m.phone);
				$("#m_email").val(m.email);
				$("#m_postcode").val(m.postalcode);
				$("#m_bankaccount").val(m.banknumber);
				$("#m_accountholder").val(m.bankuname);
				//$("#m_bankname").val(m.bankname);
				
				
				for(var i=0;i<backname.length-1;i++){
					if(backname[i].valuename == m.bankname){
						$("#m_bankname").append("<option  selected=\"selected\">"+backname[i].valuename+"</option>");
					}else{
						$("#m_bankname").append("<option>"+backname[i].valuename+"</option>");
					}
				}
				
				
				
				
				$("#m_createtime").val(timeStamp2String(m.created));
				var isstart = m.status;
				if(isstart == '0'){
					$("#m_isstart").append("<option value=\"1\" selected=\"selected\">启用</option><option value=\"2\">不启用</option>");
				}else{
					$("#m_isstart").append("<option value=\"1\">启用</option><option value=\"2\" selected=\"selected\">不启用</option>");
				}
				$("#m_useraddress").val(m.address);
				$("#m_refercode").val(m.refereeName);
				
				$("#m_fileInputIDPath").val(m.cardimg);
				var m_idcardpicpath = m.cardimg;
				if(m_idcardpicpath == null || m_idcardpicpath == "" ){
					$("#m_uploadbtnID").show();
				}else{
					$("#m_idPic").append("<p><span onclick=\"delpic('"+m.userid+"','m_idPic','m_uploadbtnID',this,'"+m_idcardpicpath+"','m_fileInputIDPath','m_fileInputID');\">x</span><img src=\""+m_idcardpicpath+"?m="+Math.random()+"\" /></p>");
					$("#m_uploadbtnID").hide();
				}
				
				$("#m_fileInputBankPath").val(m.yhimg);
				var m_bankpicpath = m.yhimg;
				
		
				
				if(m_bankpicpath == null || m_bankpicpath == "" ){
					$("#m_uploadbtnBank").show();
					
				}else{
					$("#m_bankPic").append("<p><span onclick=\"delpic('"+m.userid+"','m_bankPic','m_uploadbtnBank',this,'"+m_bankpicpath+"','m_fileInputBankPath','m_fileInputBank');\">x</span><img src=\""+m_bankpicpath+"?m="+Math.random()+"\" /></p>");
					$("#m_uploadbtnBank").hide();
				}
				e.preventDefault();
				
				
				$('#modifyMemberDiv').modal('show');
			}
		}
		});
});

$('.viewmembercancel').click(function(e){
	$("#v_idPic").html('');
	$("#v_bankPic").html('');
	$("#v_isstart").html('');
});

$('.modifymembercancel').click(function(e){
	$("#m_idPic").html('');
	$("#m_bankPic").html('');
	$("#modify_formtip").html('');
	$("#m_isstart").html('');
});

$('.viewmember').click(function(e){
	var m_id = $(this).attr('id');
	$.ajax({
		url: 'admin/UserById',
		type: 'POST',
		data:{id:m_id},
		dataType: 'html',
		timeout: 1000,
		error: function(){
			alert("error");
		},
		success: function(result){
			if("failed" == result){
				alert("操作超时！");
			}else if("nodata" == result){
				alert("没有数据！");
			}else{
				m = eval('(' + result + ')');
				$("#v_id").val(m.userid);
				$("#v_logincode").val(m.loginname);
				$("#v_username").val(m.uname);
		
				$("#v_cardtypename").val(m.cardnumberName);
				$("#v_rolename").val(m.roleName);
				$("#v_usertypename").val(m.hyType);
				$("#v_sex").val(m.sex);
				$("#v_idcard").val(m.cardnumber);
				$("#v_mobile").val(m.phone);
				$("#v_email").val(m.email);
				$("#v_postcode").val(m.postalcode);
				$("#v_bankaccount").val(m.banknumber);
				$("#v_accountholder").val(m.bankuname);
				$("#v_bankname").val(m.bankname);
				$("#v_createtime").val(timeStamp2String(m.created));
				var isstart = m.status;
				if(isstart == '0'){
					$("#v_isstart").append("<option value=\"1\" selected=\"selected\">启用</option><option value=\"2\">不启用</option>");
				}else{
					$("#v_isstart").append("<option value=\"1\">启用</option><option value=\"2\" selected=\"selected\">不启用</option>");
				}
				
				$("#v_useraddress").val(m.address);
				$("#v_refercode").val(m.refereeName);
				
				$("#v_fileInputIDPath").val(m.cardimg);
				var v_idcardpicpath = m.cardimg;
				
				if(v_idcardpicpath == null || v_idcardpicpath == "" ){
					$("#v_idPic").html("暂无");
				}else{
					$("#v_idPic").html("<p><img src=\""+v_idcardpicpath+"?m="+Math.random()+"\" /></p>");
				}
				
				$("#v_fileInputBankPath").val(m.yhimg);
				var v_bankpicpath = m.yhimg;
				if(v_bankpicpath == null || v_bankpicpath == "" ){
					$("#v_bankPic").html("暂无");
				}else{
					$("#v_bankPic").html("<p><img src=\""+v_bankpicpath+"?m="+Math.random()+"\" /></p>");
				}
				
				/*$("#v_fileInputIDPath").val(m.cardimg);
				var v_idcardpicpath = m.cardimg;
				if(v_idcardpicpath == null || v_idcardpicpath == "" ){
					$("#v_idPic").append("暂无");
				}else{
					$("#v_idPic").append("<p><img src=\""+v_idcardpicpath+"?m="+Math.random()+"\" /></p>");
				}
				
				$("#v_fileInputBankPath").val(m.yhimg);
				var v_bankpicpath = m.yhimg;
				if(v_bankpicpath == null || v_bankpicpath == "" ){
					$("#v_bankPic").append("暂无");
				}else{
					$("#v_bankPic").append("<p><img src=\""+v_bankpicpath+"?m="+Math.random()+"\" /></p>");
				}*/
				e.preventDefault();
				$('#viewMemberDiv').modal('show');
			}
		}
		});
});

$("#m_logincode").blur(function(){
	var mlc = $.trim($("#m_logincode").val());
	if(mlc != ""){
		$.post("/backend/logincodeisexit.html",{'loginCode':mlc,'id':$("#m_id").val()},function(result){
			if(result == "repeat"){
				$("#modify_formtip").css("color","red");
				$("#modify_formtip").html("<li>对不起，该用户名已存在。</li>");
				$("#modify_formtip").attr("key","1");
				result = false;
			}else if(result == "failed"){
				alert("操作超时!");
			}else if(result == "only"){
				$("#modify_formtip").css("color","green");
				$("#modify_formtip").html("<li>该用户名可以正常使用。</li>");
				$("#modify_formtip").attr("key","0");
			}
		},'html');
	}
});

$("#m_email").blur(function(){
	var flag = checkEmail($("#m_email").val());
	if(flag == false){
		$("#modify_formtip").css("color","red");
		$("#modify_formtip").html("<li>email格式不正确</li>");
		$("#modify_formtip").attr("email","1");
	}else{
		$("#modify_formtip").html("");
		$("#modify_formtip").attr("email","0");
	}
		
});
function modifyMemberFunction(){
	$("#modify_formtip").html("");
	var result = true;
	
	if($.trim($("#m_logincode").val()) == "" || $("#m_logincode").val() == null){
		$("#modify_formtip").css("color","red");
		$("#modify_formtip").append("<li>对不起，用户名不能为空。</li>");
		result = false;
	}else{
		if($("#modify_formtip").attr("key") == "1"){
			$("#modify_formtip").append("<li>对不起，该用户名已存在。</li>");
			result = false;
		}
	}
	if($.trim($("#m_username").val()) == "" || $("#m_username").val() == null){
		$("#modify_formtip").css("color","red");
		$("#modify_formtip").append("<li>对不起，真实姓名不能为空。</li>");
		result = false;
	}
	if($("#m_cardtype").val() == ""){
		$("#modify_formtip").css("color","red");
		$("#modify_formtip").append("<li>对不起，证件类型不能为空。</li>");
		result = false;
	}
	if($.trim($("#m_idcard").val()) == "" || $("#m_idcard").val() == null){
		$("#modify_formtip").css("color","red");
		$("#modify_formtip").append("<li>对不起，证件号码不能为空。</li>");
		result = false;
	}
	if($.trim($("#m_mobile").val()) == "" || $("#m_mobile").val() == null){
		$("#modify_formtip").css("color","red");
		$("#modify_formtip").append("<li>对不起，联系电话不能为空。</li>");
		result = false;
	}
	if($.trim($("#m_bankname").val()) == "" || $("#m_bankname").val() == null){
		$("#modify_formtip").css("color","red");
		$("#modify_formtip").append("<li>对不起，开户行不能为空。</li>");
		result = false;
	}
	if($.trim($("#m_bankaccount").val()) == "" || $("#m_bankaccount").val() == null){
		$("#modify_formtip").css("color","red");
		$("#modify_formtip").append("<li>对不起，开户卡号不能为空。</li>");
		result = false;
	}
	if($.trim($("#m_accountholder").val()) == "" || $("#m_accountholder").val() == null){
		$("#modify_formtip").css("color","red");
		$("#modify_formtip").append("<li>对不起，开户人不能为空。</li>");
		result = false;
	}
	if($.trim($("#m_email").val()) != "" && $("#m_email").val() != null && $("#modify_formtip").attr("email") == "1"){
		$("#modify_formtip").css("color","red");
		$("#modify_formtip").append("<li>email格式不正确</li>");
		result = false;
	}
	if(result == true) alert("修改成功 ^_^");
	return result;
}


$('.delmember').click(function(e){
	//delete
	var d = $(this);
	var d_logincode = d.attr('logincode');
	var d_id = d.attr('id');
	var d_idcardpicpath = d.attr('idcardpicpath');
	var d_bankpicpath = d.attr('bankpicpath');
	if(confirm("您确定要删除【"+d_logincode+"】这个用户吗？")){
		//delete
		$.post("admin/delteUser",{'delId':d_id,'delIdCardPicPath':d_idcardpicpath,'delBankPicPath':d_bankpicpath,'delUserType':'1'},function(result){
			if("success" == result){
				alert("删除成功！");
				window.location.href="admin/goUserHYList";
			}else{
				alert("删除失败！");
			}
		},'html');
	}
});

$("#m_uploadbtnID").click(function(){
	TajaxFileUpload($("#m_id").val(),'m_fileInputID','m_uploadbtnID','m_idPic','m_fileInputIDPath');
});

$("#m_uploadbtnBank").click(function(){
	TajaxFileUpload($("#m_id").val(),'m_fileInputBank','m_uploadbtnBank','m_bankPic','m_fileInputBankPath');
});

function TajaxFileUpload(flag,t1,t2,t3,t4)
{   
	if($("#"+t1+"").val() == '' || $("#"+t1+"").val() == null){
		alert("请选择上传文件！");
	}else{
		$.ajaxFileUpload
	    ({ 
	           url:'admin/fileUpdate', //处理上传文件的服务端
	           secureuri:false,
	           fileElementId:t1,
	           dataType: 'jsonp',
	           type:'post',
	           success: function(data) { 
	        	   data = data.replace(/(^\s*)|(\s*$)/g, "");
	        	   if(data == "1"){
	        		   alert("上传图片大小不得超过50K！");
	        		   $("#uniform-"+t1+" span:first").html('无文件');
	        		   $("input[name='"+t1+"']").change(function(){
	        			   var fn = $("input[name='"+t1+"']").val(); 
	        			   if($.browser.msie){
	        				   fn = fn.substring(fn.lastIndexOf("\\")+1);
	        			   }
	        			   $("#uniform-"+t1+" span:first").html(fn);
	        		   });
	        	   }else if(data == "2"){
	        		   alert("上传图片格式不正确！");
	        		   $("#uniform-"+t1+" span:first").html('无文件');
	        		   $("input[name='"+t1+"']").change(function(){
	        			   var fn = $("input[name='"+t1+"']").val(); 
	        			   if($.browser.msie){
	        				   fn = fn.substring(fn.lastIndexOf("\\")+1);
	        			   }
	        			   $("#uniform-"+t1+" span:first").html(fn);
	        		   });
	        	   } else{
	        		   $("#"+t3+"").append("<p><span onclick=\"delpic('"+flag+"','"+t3+"','"+t2+"',this,'"+data+"','"+t4+"','"+t1+"');\">x</span><img src=\""+data+"?m="+Math.random()+"\" /></p>");
	        		   $("#"+t2+"").hide();
	        		   $("#"+t4+"").val(data);
	        		   $("input[name='"+t1+"']").change(function(){
	        			   var fn = $("input[name='"+t1+"']").val(); 
	        			   if($.browser.msie){
	        				   fn = fn.substring(fn.lastIndexOf("\\")+1);
	        			   }
	        			   $("#uniform-"+t1+" span:first").html(fn);
	        		   });
	        	   }
	           },  
	           error: function() {  
	              alert("上传失败！");
	           } 
	        });
	}
}

function delpic(id,closeSpan,uploadBtn,obj,picpath,picText,fileinputid){
	
	alert("del");
	
	//delete
	$.post("admin/deletePic",{'id':id,'picpath':picpath},function(result){
		if("success" == result){
			alert("删除成功！");
			$('#'+picText).val('');
			$("#uniform-"+fileinputid+" span:first").html('无文件');
			document.getElementById(closeSpan).removeChild(obj.parentElement);$('#'+uploadBtn).show();
		}else
			alert("删除失败！");
	},'html');
	
}