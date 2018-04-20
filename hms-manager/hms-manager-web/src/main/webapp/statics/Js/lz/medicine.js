$(function() {

	
	$("#addMe").submit(function() {
		
		$(".ddq").html('');
	
		
		if( $("input[name=id]").val()==""){
			 $("input[name=id]").next().html('不能为空！');
			 return false;
		}
		if( $("#img").val()==""){
			 $("#img").next().html('不能为空！');
			 return false;
		}
		if( $("input[name=jprice]").val()==""){
			 $("input[name=jprice]").next().html('不能为空！');
			 return false;
		}
		if( $("input[name=sprice]").val()==""){
			 $("input[name=sprice]").next().html('不能为空！');
			 return false;
		}
		if( $("input[name=medicinenmae]").val()==""){
			 $("input[name=medicinenmae]").next().html('不能为空！');
			 return false;
		}
		if( $("input[name=qgp]").val()==""){
			 $("input[name=qgp]").next().html('不能为空！');
			 return false;
		}
		
		
		return true;
	})
})