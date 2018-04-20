<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery.sorted.js"></script>
	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<script type="text/javascript" src="../js/ckform.js"></script>
	<script type="text/javascript" src="../js/common.js"></script>
	
	<script src="../js/layer/layer.js"></script>
	<script src="../kj/jqjq.js"></script>
	
	<script type="text/javascript">
		$(function(){
			//确认修改
			$(".ok").click(function(){
						
				if(chickform('#ff')==false){
					return layer.msg('请填写完整');
				}
				
				if($("[name=newpassword]").val()!=$("[name=newpassword2]").val()){
					return layer.msg('两次密码不一致');
				}
				
				$.post2('doPassword.ajax',$('#ff').serialize(),function(data){
					if(data.res==1){
						return layer.alert("修改成功",{},function(){
							location.href="index.html";
						});
					}else if(data.res==-1){
						return layer.alert("旧密码输入错误");
					}else{
						return layer.alert("修改失败");
					}
				},function(e,ee,eee){
					layer.alert("修改异常:"+eee);
				})
				
			})
			
			
		})
	</script>
	

</head>
<body>
<form id="ff" class="form-inline definewidth m20" action="" method="get">    
   <table>
		<tr>
			<td align="right"><font color="red">*</font>原密码:</td><td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td align="right"><font color="red">*</font>新密码:</td><td><input type="password" name="newpassword"/></td>
		</tr>
		<tr>
			<td align="right"><font color="red">*</font>确认密码:</td><td><input type="password" name="newpassword2"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><br/>
				<input type="button" value="保存" class="ok btn btn-primary"/>
			</td>
		</tr>
   </table>
</form>
</body>
</html>