/** 验证表单是否已经全部填写 */
var chickform=function(selected){
	var b=true;
	$(":text,:password",selected).each(function(){
		if($(this).val()==""){
			return b=false;
		}
	})
	return b;
}

/** 扩展$.post，使其追加一个异常函数功能 */
$.post2=function(url,data,success,error){
	$.ajax({type:"post",url:url,data:data,dataType:'JSON',
		success:function(data){success(data);},
		error:function(e,ee,eee){error(e,ee,eee);}
	});
}

