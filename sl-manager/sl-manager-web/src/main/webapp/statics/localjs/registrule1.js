
$(".agreerule").click(function(){
	if($(".agreerule").attr("checked") == 'checked')
		$(".nextbtn").removeAttr("disabled");
	else
		$(".nextbtn").attr("disabled","disabled");
});

$(".nextbtn").click(function(){
	window.location.href="admin/goAddUserByEmp";
}); 




$(".closebtn").click(function(){
	window.location.href="admin/main";
});