<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title></title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
		<script type="text/javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" src="../js/jquery.sorted.js"></script>
		<script type="text/javascript" src="../js/bootstrap.js"></script>
		<script type="text/javascript" src="../js/ckform.js"></script>
		<script type="text/javascript" src="../js/common.js"></script>
		
		<script src="../js/layer/layer.js"></script>

		<style type="text/css">
			body {
				padding-bottom: 40px;
			}
			
			.sidebar-nav {
				padding: 9px 0;
			}
			
			@media (max-width: 980px) {
				/* Enable use of floated navbar text */
				.navbar-text.pull-right {
					float: none;
					padding-left: 5px;
					padding-right: 5px;
				}
			}
		</style>
		<script type="text/javascript">
			
			$(function(){
				/** 验证表单是否已经全部填写 */
				var chickform=function(selected){
					var b=true;
					$("input",selected).each(function(){
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
				
				
				
				$(".ok").click(function(){
					
					if(chickform('#ff')==false){
						return layer.msg('请填写完整');
					}
					
					
					$.post2('doAdd.ajax',$('#ff').serialize(),function(data){
						if(data.res==1){
							return layer.alert("添加成功",{},function(){
								$('#backid').click();
							});
						}else{
							return layer.alert("添加失败");
						}
					},function(e,ee,eee){
						layer.alert("添加异常:"+eee);
					})
					
				})
				
				
				
			})
			
			
			
		</script>
	</head>

	<body>
		<form id="ff" action="index.html" method="post" class="definewidth m20">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="10%" class="tableleft">
						<font color="red">*</font>角色名称</td>
					<td><input type="text" name="rname" /></td>
				</tr>
				<tr>
					<td class="tableleft">
						<font color="red">*</font>状态</td>
					<td>
						<input type="radio" name="rstate" value="1" checked/> 启用 
						<input type="radio" name="rstate" value="0" /> 禁用
					</td>
				</tr>
				<tr>
					<td class="tableleft">
						<font color="red">*</font>权限</td>
					<td>
						<c:forEach items="${menus}" var="m">
							<ul><label class='checkbox inline'><input type='checkbox' name='mids' value='${m.mid}' />${m.text}</label></ul>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td class="tableleft"></td>
					<td>
						<button type="button" class="ok btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
						<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
					</td>
				</tr>
			</table>
		</form>
	</body>

</html>
<script>
	$(function() {
		$(':checkbox[name="group[]"]').click(function() {
			$(':checkbox', $(this).closest('li')).prop('checked', this.checked);
		});

		$('#backid').click(function() {
			window.location.href = "index.html";
		});
	});
</script>