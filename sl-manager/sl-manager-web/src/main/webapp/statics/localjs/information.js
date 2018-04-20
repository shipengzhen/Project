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

//判断重名
$("#informationTitle").blur(function(){
	
	
	$.ajax({
		url: 'admin/findInfoByTitle',
		type: 'POST',
		data:{"title":$("#informationTitle").val()},
		dataType: 'html',
		success: function(result){
			if(result=="no"){
				$("#add_formtip").css("color","red");
				$("#add_formtip").html("名称重复");
				$("#informationTitle").val("")
			}else{
				$("#add_formtip").html("");
			}
		}
	});
	
	
});

	
	

$('#informationContent').cleditor();

$(".addinfocancel").click(function(){
	$("#add_formtip").html("");
});
$(".modifyinfocancel").click(function(){
	$("#modify_formtip").html("");
});

//新增 资讯
$("#informationuploadbtn").click(function(){
	informationFileUpload();
});



//修改 资讯
$("#informationuploadMbtn").click(function(){
	informationFileUploadM();
});
$(".addInformation").click(function(e){
	e.preventDefault();
	/*
	$("#afficheCode").val("");
	$("#afficheTitle").val("");
	$("#startTime").val("");
	$("#endTime").val("");
	$("#afficheContent").val("");
	$("#add_formtip").html("");
	*/
	$('#addInformationDiv').modal('show');
	$("#uniform-uploadInformationFile span:first").html('无文件');
});

$("#docType").change(function(){
	$("#typeNamehide").val($("#docType").find("option:selected").text());
	//alert($("#typeNamehide").val());
});
$("#docTypeModity").change(function(){
	$("#typeNamehideM").val($("#docTypeModity").find("option:selected").text());
	//alert($("#typeNamehide").val());
});
// 删除文件
function delFile(){
	$.ajax({
		url: 'admin/delFile',
		type: 'POST',
		data:{filePath:$("#zfile").val()},
		dataType: 'html',
		timeout: 1000,
		error: function(){
			alert("删除文件失败！请重试。");
		},
		success: function(result){
			if(result != "" && result == "success"){
				$("#zfile").val('');
				$("#uploadInformationFile").val("");
				$("#informationuploadbtn").show();
				$("#filearea").html("");
       		    $("#uploadfilenamehide").val('');
    		    $("#uploadfilepathhide").val('');
    		    $("#fileSizehide").val('');
    		    $("#uniform-uploadInformationFile span:first").html('无文件');
			}else if("failed" == result){
				alert("删除文件失败！请重试。");
			}else if("nodata" == result){
				alert("对不起，没有任何数据需要处理！请重试。");
			}
		}
		});
}

//新增
function informationFileUpload()
{  
	if($("#uploadInformationFile").val() == "" || $("#uploadInformationFile").val()  == null){
		alert("请选择上传文件！");
	}else{
		$.ajaxFileUpload
	    ({ 
	           url:'admin/addFile', //处理上传文件的服务端
	           secureuri:false,
	           fileElementId:'uploadInformationFile',
	           dataType: 'jsonp',
	           type:'post',
	           success: function(data) { 
	        	   data = data.replace(/(^\s*)|(\s*$)/g, "");
	        	   if(data == "1"){
	        		   alert("上传图片大小不得超过500M！");
	        		   $("#uniform-uploadInformationFile span:first").html('无文件');
	        		   $("#uploadInformationFile").change(function(){
	        			   var fn = $("#uploadInformationFile").val(); 
	        			   if($.browser.msie){
	        				   fn = fn.substring(fn.lastIndexOf("\\")+1);
	        			   }
	        			   $("#uniform-uploadInformationFile span:first").html(fn);
	        		   });
	        	   }else{

	        		   m = eval('(' + data + ')');   
	        		   	        		   
	        		   var oldFile = m.oldFile;
	        		   var newFile = m.newFile;
	        		   var fileSize =m.fileSize;
	        		   
	        		   $("#zfile").val(m.url);
	        		   $("#uploadfilenamehide").val(oldFile);
	        		   
	        		   $("#uploadfilepathhide").val(newFile);
	        		   $("#fileSizehide").val(fileSize);
	        		   $("#filearea").css("color","green");
	        		   $("#filearea").html("上传文件：" + oldFile + " 大小："+(fileSize/1000)+"KB <a style=\"color:red;\" href=\"javascript:delFile();\">X</a>");
	        		   $("#informationuploadbtn").hide();
	        		   
	        		   $("#uploadInformationFile").change(function(){
	        			   var fn = $("#uploadInformationFile").val(); 
	        			   if($.browser.msie){
	        				   fn = fn.substring(fn.lastIndexOf("\\")+1);
	        			   }
	        			   $("#uniform-uploadInformationFile span:first").html(fn);
	        		   });
	        	   }
	           },  
	           error: function() {  
	              alert("上传失败！");
	           } 
	        });
	}
}



//修改 上传文件
function informationFileUploadM()
{   
	if($("#uploadInformationFileM").val() == "" || $("#uploadInformationFileM").val()  == null){
		alert("请选择上传文件！");
	}else{
		$.ajaxFileUpload
		({ 
			url:'admin/addFile', //处理上传文件的服务端
			secureuri:false,
			fileElementId:'uploadInformationFileM',
			dataType: 'jsonp',
	        type:'post',
			success: function(data) { 
				data = data.replace(/(^\s*)|(\s*$)/g, "");
				if(data == "1"){
					alert("上传图片大小不得超过500M！");
				}else{
					
					 m = eval('(' + data + ')');  
					
					var oldFile = m.oldFile;	//旧文件名称
	        		var newFile = m.newFile;	//新文件名称
	        		var fileSize =m.fileSize;
					
					
					
					$("#uploadfilenamehideM").val(oldFile);	   //文件名称
					$("#uploadfilepathhideM").val(m.url);		//上传地址
					$("#fileSizehideM").val(fileSize);			//大小
					
					$("#fileareaM").css("color","green");
					$("#fileareaM").html("上传文件：" + oldFile + " 大小："+(fileSize/1000)+"KB <a style=\"color:red;\" href=\"javascript:delFileM();\">X</a>");
					$("#informationuploadMbtn").hide();
					 $("#uploadInformationFileM").change(function(){
	        			   var fn = $("#uploadInformationFileM").val(); 
	        			   if($.browser.msie){
	        				   fn = fn.substring(fn.lastIndexOf("\\")+1);
	        			   }
	        			   $("#uniform-uploadInformationFileM span:first").html(fn);
	        		 });
				}
			},  
			error: function() {  
				alert("上传失败！");
			} 
		});
	}
}


//查看
$(".viewinformation").click(function(e){
	id = $(this).attr("id");
	title = $(this).attr("title");
	$.ajax({
		url: 'admin/findInfo',
		type: 'POST',
		data:{id:id},
		dataType: 'html',
		timeout: 1000,
		error: function(){
			alert("获取"+title+"失败！请重试。");
		},
		success: function(result){
			
			 if("failed" == result){
					alert("获取"+title+"失败！请重试。");
				
			 }else if("nodata" == result){
					alert("对不起，没有任何数据需要处理！请重试。");
			 }else{
				
				jsonStrInfo = eval("("+result+")");
					state = "未发布";
				if(jsonStrInfo.status == 0){
					state = "发布";
				}
				$("#viewContent").html("");
				
				$("#viewContent").append("<li>标题：<input type=\"text\" style=\"border:0px;\" disabled=\"disabled\" value=\""+jsonStrInfo.ztitle+"\"/></li>");
				$("#viewContent").append("<li>发布状态："+state+"</li>");
				$("#viewContent").append("<li>发布人："+jsonStrInfo.createUname+"</li>");
				$("#viewContent").append("<li>发布时间："+timeStamp2String(jsonStrInfo.created) +"</li>");
				if(jsonStrInfo.filename != null && jsonStrInfo.filename != "" && jsonStrInfo.zfile != null && jsonStrInfo.zfile != ""){
					$("#viewContent").append("<li>附件类型："+jsonStrInfo.typeName+"</li>");
					$("#viewContent").append("<li>附件名称："+jsonStrInfo.filename+"</li>");
															// href='"+jsonStrInfo.zfile+"'  onclick='downLoad("+jsonStrInfo.zid+")'
					$("#viewContent").append("<li>附件存放路径：<a href='"+jsonStrInfo.zfile+"' >下载(默认下载到桌面..)</a></li>");
					$("#viewContent").append("<li>附件大小："+(jsonStrInfo.zfilesize/1000)+"KB</li>");
				}else{
					$("#viewContent").append("<li>附件：暂无</li>");
				}
				$("#viewContent").append("<li>上传时间："+timeStamp2String(jsonStrInfo.created)+"</li>");
				$("#viewContent").append("<li>资讯内容：<div>"+jsonStrInfo.zdoc+"</div></li>");
				e.preventDefault();
				$('#viewInfoDiv').modal('show');
				
			}
		}
		});
});

//下载
function downLoad(id){
	//alert(id);
	
	$.ajax({
		url: 'admin/dowload',
		type: 'POST',	 
		data:{id:id},
		dataType: 'html',
		timeout: 10000,
		error: function(){
			alert("下载失败！");
		},
		success: function(result){
			if(result=="success"){
				alert("下载成功！");
			}else{
				alert("下载失败!");
			}
		}
	});
	
	
}

//删除文件  修改
function delFileM(){
	if(confirm("您确定要删除文件吗？如果删除将永久删除。")){
	$.ajax({
		url: 'admin/delFile',
		type: 'POST',	 
		data:{filePath:$("#uploadfilepathhideM").val(),id:$("#infoIdModify").val()},
		dataType: 'html',
		timeout: 1000,
		error: function(){
			alert("删除文件失败！请重试。");
		},
		success: function(result){
			 if("failed" == result){
				alert("删除文件失败！请重试。");
			}else if("nodata" == result){
				alert("对不起，没有任何数据需要处理！请重试。");
			}else if(result == "success"){
				$("#uploadfilepathhideM").val('');
				$("#uploadfilenamehideM").val('');
				$("#fileSizehideM").val('');
				$("#informationuploadMbtn").show();
				$("#fileareaM").html("");
				$("#uniform-uploadInformationFileM span:first").html('无文件');
			}
		}
		});
	}
}


//修改
$(".modifyinformation").click(function(e){
	id = $(this).attr("id");
	$.ajax({
		url: 'admin/findInfo',
		type: 'POST',
		data:{id:id},
		dataType: 'html',
		timeout: 1000,
		error: function(){
			alert("获取"+title+"失败！请重试。");
		},
		success: function(result){
			
			if("failed" == result){
				alert("获取"+title+"失败！请重试。");
			}else if("nodata" == result){
				alert("对不起，没有任何数据需要处理！请重试。");
			}else{
				
				jsonStrInfo = eval("("+result+")");
				//id
				$("#infoIdModify").val(jsonStrInfo.zid);
				$("#informationTitleModify").val(jsonStrInfo.ztitle);
				//typeID typeName
				$("#typeNamehideM").val(jsonStrInfo.typeName);
				$("#docTypeModity").val(jsonStrInfo.ztypeid);
				//fileName
				$("#uploadfilenamehideM").val(jsonStrInfo.filename);
				//filePath
				$("#uploadfilepathhideM").val(jsonStrInfo.zfile);
				//fileSize
				$("#fileSizehideM").val(jsonStrInfo.zfilesize);
				//set select
				$("#docTypeModity").html("");
				for(var i=0;i<dicJson.length-1;i++){
					if(dicJson[i].dictionaryid == jsonStrInfo.ztypeid){
						$("#docTypeModity").append("<option value=\""+dicJson[i].valueId+"\" selected=\"selected\">"+dicJson[i].valueName+"</option>");
					}else{
						$("#docTypeModity").append("<option value=\""+dicJson[i].valueId+"\">"+dicJson[i].valueName+"</option>");
					}
				}
				if(jsonStrInfo.filename != null && jsonStrInfo.filename != ""){
					$("#fileareaM").css("color","green");
	     		    $("#fileareaM").html("上传文件：" + jsonStrInfo.filename + " 大小："+(jsonStrInfo.zfilesize/1000)+"KB <a style=\"color:red;\" href=\"javascript:delFileM();\">X</a>");
				}else{
					$("#fileareaM").css("color","red");
	     		    $("#fileareaM").html("上传文件：暂无");
	     		    $("#informationuploadMbtn").show();
				}
				$("#modifyinformationli").html("");
     		    $("#modifyinformationli").append("<span>资讯内容：</span> <br/><textarea id=\"infoContentModifyContent\" name=\"zdoc\" rows=\"3\">"+jsonStrInfo.zdoc+"</textarea>");
     		    $('#infoContentModifyContent').cleditor();
				
				e.preventDefault();
				$('#modifyInfoDiv').modal('show');
				
			}
		}
		});
});

function CoverFormXmlTag(value){
	value = value.replace("&","&amp;");
	value = value.replace("<","&lt;");
	value = value.replace(">","&gt;");
	value = value.replace("'\'","&quot;");
	value = value.replace("\r\n","<br>");
	value = value.replace("","");
	return value;
}

function addInfoFunction(){
	infoTitle = $("#informationTitle");
	docType = $("#docType");
	filePath = $("#uploadfilepathhide");
	content = $("#informationContent");
	add_formtip = $("#add_formtip");
	
	//infoTitle.val(CoverFormXmlTag(infoTitle.val()));
	
	if( $.trim(infoTitle.val()) == "" || infoTitle.val() == null){
		add_formtip.css("color","red");
		add_formtip.html("对不起，资讯标题不能为空。");
		infoTitle.focus();
		return false;
	}else if( docType.val() == ""){
		add_formtip.css("color","red");
		add_formtip.html("对不起，资讯类型不能为空。");
		docType.focus();
		return false;
	}
//	else if( filePath.val() == ""){
//		add_formtip.css("color","red");
//		add_formtip.html("对不起，您还没有上传文件。");
//		return false;}
	else if( content.val() == "" ||  content.val() == "<br>"){
		add_formtip.css("color","red");
		add_formtip.html("对不起，资讯内容不能为空。");
		return false;
	}else{
		return true;
	}
}
function modifyInfoFunction(){
	infoTitle = $("#informationTitleModify");
	docType = $("#docTypeModity");
	filePath = $("#uploadfilepathhideM");
	content = $("#infoContentModifyContent");
	modify_formtip = $("#modify_formtip");
	infoid = $("#infoIdModify");
	//alert(infoid.val());
	//return false;
	//infoTitle.val(CoverFormXmlTag(infoTitle.val()));
	if( $.trim(infoTitle.val()) == "" || infoTitle.val() == null){
		modify_formtip.css("color","red");
		modify_formtip.html("对不起，资讯标题不能为空。");
		infoTitle.focus();
		return false;
	}else if( docType.val() == ""){
		modify_formtip.css("color","red");
		modify_formtip.html("对不起，资讯类型不能为空。");
		docType.focus();
		return false;
	}
//	else if( filePath.val() == ""){
//		modify_formtip.css("color","red");
//		modify_formtip.html("对不起，您还没有上传文件。");
//		return false;}
	else if( content.val() == "" ||  content.val() == "<br>"){
		modify_formtip.css("color","red");
		modify_formtip.html("对不起，资讯内容不能为空。");
		return false;
	}else{
		return true;
	}
}
//删除自资讯
$(".delinformation").click(function(){
	id = $(this).attr("id");
	title = $(this).attr("title");
	if(confirm("您确定要删除" + title + "吗？" )){
		$.ajax({
			url: 'admin/delInfo',
			type: 'POST',
			data:{id:id},
			dataType: 'html',
			timeout: 1000,
			error: function(){
				alert("删除"+title+"失败！请重试。");
			},
			success: function(result){
				if("failed" == result){
					alert("删除"+title+"失败！请重试。");
				}else if("nodata" == result){
					alert("对不起，没有任何数据需要处理！请重试。");
				}else if("success" == result){
					window.location.href="admin/infoList";
				}
			}
			});
	}
});



//修改 状态  0 发布 1 不发布
$(".modifyInformationState").click(function(){
	modify = $(this);
	
	id= modify.attr("inforid");			//id
	stus= modify.attr("inforstate");	//status
	var status;
	if(stus == "1"){
		status = 0;
		modify.attr("inforstate",0);
	}
	else{
		status = 1;
		modify.attr("inforstate",1);
	}
	
	$.ajax({
		url: 'admin/updateInfoStatus',
		type: 'POST',
		data:{id:id,status:status},
		dataType: 'html',
		timeout: 1000,
		error: function(){
			alert("开启或关闭发布状态操作时失败！请重试。");
		},
		success: function(result){
			if("success" == result){
				if(isstart == "1")
					modify.attr("isstart",0);
				else
					modify.attr("isstart",1);
			}else if("failed" == result){
				alert("开启或关闭发布状态操作时失败！请重试。");
			}else if("nodata" == result){
				alert("对不起，没有任何数据需要处理！请重试。");
			}
		}
	});
});