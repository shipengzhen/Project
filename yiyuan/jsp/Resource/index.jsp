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
		<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript" src="../js/jquery.sorted.js"></script>
		<script type="text/javascript" src="../js/bootstrap.js"></script>
		<script type="text/javascript" src="../js/ckform.js"></script>
		<script type="text/javascript" src="../js/common.js"></script>
		
		<script src="../js/layer/layer.js"></script>
		<script src="../kj/fenye99.js"></script>

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
			$(function() {
				$('#newNav').click(function() {
					window.location.href = "add.html";
				});
				
				//分页
				$("#box").paging({
		            currentPage:'${page.pn}',	//当前页
		            total: '${page.zy}',		//总页数
					showPage:'10',	//显示几个
		            beforeAjaxSubmit:function(){
		            	var pn=PageAPI.GetCurrentPage();
		            	location.href="index.html?pn="+pn+"&"+$("#ff").serialize();
		            }
		        });
				
			});

			function checkall() {
				var alls = document.getElementsByName("check");
				var ch = document.getElementById("checkall");
				if(ch.checked) {
					for(var i = 0; i < alls.length; i++) {
						alls[i].checked = true;
					}
				} else {
					for(var i = 0; i < alls.length; i++) {
						alls[i].checked = false;
					}
				}
			}

			function delAll() {
				var alls = document.getElementsByName("check");
				var ids = new Array();
				for(var i = 0; i < alls.length; i++) {
					if(alls[i].checked) {
						ids.push(alls[i].value);
					}
				}
				if(ids.length > 0) {
					layer.confirm("是否删除？",function(){
						doDel(ids);
					})
				} else {
					layer.msg("请选中要删除的项");
				}
			}
			
			
			//-------------
			/** 扩展$.post，使其追加一个异常函数功能 */
			$.post2=function(url,data,success,error){
				$.ajax({type:"post",url:url,data:data,dataType:'JSON',
					success:function(data){success(data);},
					error:function(e,ee,eee){error(e,ee,eee);}
				});
			}
			
			//点击单个的删除
			var doDelOne=function(mid){
				layer.confirm("是否删除？",function(){
					doDel(mid);
				})
			}
			
			//删除,给一个或数组
			var doDel=function(ids){
				var data='ids='+ids;
				$.post2("doDel.ajax",data,function(data){
					if(data.res>0){
						layer.msg("删除成功");
						setInterval(function(){
							location.reload();
						},500)
					}else{
						layer.msg("删除失败");
					}
				},function(e,ee,eee){
					layer.alert("删除异常："+eee);
				})
			}
			
			
			
			
			
			
			
			
			
		</script>
	</head>

	<body>
		<form id="ff" class="form-inline definewidth m20" action="index.html" method="get">
			资源(菜单)名称：
			<input type="text" name="text" id="username" class="abc input-default" value="${text}">&nbsp;&nbsp;
			<button type="submit" class="btn btn-primary">查询</button>
		</form>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th width="5%"><input type="checkbox" id="checkall" onChange="checkall();"></th>
					<th>资源名称</th>
					<th>路径Url</th>
					<th>是否有效</th>
					<th width="10%">操作</th>
				</tr>
			</thead>
			
			<c:forEach items="${menus}" var="m" >
				<tr>
					<td style="vertical-align:middle;"><input type="checkbox" name="check" value="${m.mid}"></td>
					<td>${m.text}</td>
					<td>${m.href}</td>
					<td>${m.myx == 1 ? "有效" : "无效"}</td>
					<td>
						<a href="edit.html?mid=${m.mid}">编辑</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:doDelOne(${m.mid})">删除</a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<th colspan="5">
					<div class="inline pull-right page">
						${page.count} 条记录 ${page.pn}/${page.zy} 页
						<div class="box" id="box" style="float: right;margin: -5px 10px;"></div>
					</div>
					<div>
						<button type="button" class="btn btn-success" id="newNav">添加资源</button>&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-success" id="delPro" onClick="delAll();">删除选中</button>
					</div>
				</th>
			</tr>
		</table>
		
		
		
	</body>

</html>