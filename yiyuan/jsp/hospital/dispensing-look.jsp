<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>发药详情--中软高科-2015</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
		<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript" src="../js/jquery.sorted.js"></script>
		<script type="text/javascript" src="../js/bootstrap.js"></script>
		<script type="text/javascript" src="../js/ckform.js"></script>
		<script type="text/javascript" src="../js/common.js"></script>
		
		<script src="../kj/laydate/laydate.js"></script>
		<script src="../js/layer/layer.js"></script>
		<script src="../kj/fenye99.js"></script>
		<script src="../kj/jqjq.js"></script>
		

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
		            	location.href="dispensing.html?pn="+pn+"&"+$("#ff").serialize();
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

			//发药指定数量
			var fayao=function(fid,num){
				
				$.post2("doFayao.ajax",{fid:fid,num:num},function(data){
					if(data.res>0){
						layer.msg("发药成功");
						setInterval(function(){
							location.reload();
						},500)
					}else{
						layer.msg("发药失败");
					}
				},function(e,ee,eee){
					layer.msg("发药异常"+eee);
				})
				
			}
			
			
			
			$(function() {
				$('#backid').click(function() {
					window.location.href = "dispensing.html";
				});
			});
		</script>
	</head>

	<body>

		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th>病历号</th>
					<th>姓名</th>
					<th>药品名称</th>
					<th>药品数量</th>
					<th>已发数量</th>
					<th>未发数量</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${fayaos}" var="f" >
				<tr>
					<td style="vertical-align:middle;">${guahao.gid}</td>
					<td style="vertical-align:middle;">${guahao.gname}</td>
					<td style="vertical-align:middle;">${f.y_name}</td>
					<td style="vertical-align:middle;">${f.f_num}</td>
					<td style="vertical-align:middle;">${f.f_ynum}</td>
					<td style="vertical-align:middle;">${f.f_wnum}</td>
					<td style="vertical-align:middle;">
						<a href="javascript:fayao(${f.fid},${f.f_wnum});">发全</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:fayao(${f.fid},1);">发1</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:fayao(${f.fid},5);">发5</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:fayao(${f.fid},30);">发30</a>
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
						<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
					</div>

				</th>
			</tr>
		</table>

	</body>

</html>