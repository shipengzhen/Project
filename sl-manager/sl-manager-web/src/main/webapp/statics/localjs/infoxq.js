//下载
function downLoad(id){
	alert(id);
	
	return false;
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