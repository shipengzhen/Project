<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>药品查询--中软高科-2015</title>
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
					if(confirm("确认操作?")) {
						alert("成功!");
					}
				} else {
					alert("请选中要操作的项");
				}
			}
			
			//退院或出院，1=退院，2=出院
			var tuichu=function(gid,way){
				var status="已出院";
				$.post2('doUpdateStatus.ajax',{gid:gid,status:status}, function(data) {
					if(data.res > 0) {
						return layer.alert("成功");
					} else {
						return layer.alert("失败");
					}
				}, function(e, ee, eee) {
					layer.alert("异常:" + eee);
				})
			}
			
			
			
			
		</script>
	</head>

	<body>

		<form id="ff" action="index.html" method="get" class="definewidth m20">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="10%" class="tableleft">病历号：</td>
					<td><input type="text" name="gid" value="${gid}" /></td>

					<td width="10%" class="tableleft">主治医生：</td>
					<td><input type="text" name="d_zsname" value="${d_zsname}" /></td>

					<td width="10%" class="tableleft">科室：</td>
					<td><input type="text" name="kname" value="${kname}" /></td>
				</tr>
				<tr>

					<td width="10%" class="tableleft">住院时间：</td>

					<td colspan="5">
						<input type="text" class="kai" name="kai" value="${kai}" />&nbsp;至&nbsp;
						<input type="text" class="end" name="end" value="${end}" />
						 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="submit" class="btn btn-primary" type="button">查询</button>
						<button type="submit" class="btn btn-primary" type="button">清空</button>

					</td>
				</tr>
			</table>
		</form>

		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
					<th>病历号</th>
					<th>姓名</th>
					<th>床位号</th>
					<th>联系电话</th>
					<th>押金</th>
					<th>主治医生</th>
					<th>护理</th>
					<th>入院时间</th>
					<th>科室</th>
					<th>押金剩余</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			
			<c:forEach items="${zhuyuans}" var="z" >
				<tr>
					<td style="vertical-align:middle;"><input type="checkbox" name="check" value="1"></td>
					<td style="vertical-align:middle;">${z.guahao.gid}</td>
					<td style="vertical-align:middle;">${z.guahao.gname}</td>
					<td style="vertical-align:middle;">${z.z_cw}</td>
					<td style="vertical-align:middle;">${z.guahao.g_phone}</td>
					<td style="vertical-align:middle;">${z.z_yajin}</td>
					<td style="vertical-align:middle;">${z.guahao.d_zsname}</td>
					<td style="vertical-align:middle;">${z.z_huli}</td>
					<td style="vertical-align:middle;">${z.z_zydate}</td>
					<td style="vertical-align:middle;">${z.guahao.kname}</td>
					<td style="vertical-align:middle;">${z.z_yajin}</td>
					<td style="vertical-align:middle;">${z.guahao.g_status}</td>
					<td style="vertical-align:middle;">
						<a href="look.html?zid=${z.zid}">详情>></a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:tuichu(${z.guahao.gid},2);"
							 style='${z.guahao.g_status!="已结算"?"display: none;":""}'>退院>></a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:tuichu(${z.guahao.gid},1);" 
							style='${z.guahao.g_status!="已结算"?"display: none;":""}'>出院>></a>&nbsp;&nbsp;&nbsp;
						<a href="edit.html?zid=${z.zid}" style='${z.guahao.g_status!="已住院"?"display: none;":""}'>
							更改</a>&nbsp;&nbsp;&nbsp; 
						<a href="add_many.html?zid=${z.zid}" style='${z.guahao.g_status!="已住院"?"display: none;":""}'>
							缴纳押金</a>&nbsp;&nbsp;&nbsp;
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
					<div><button type="button" class="btn btn-success" id="newNav">添加住院信息</button>&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-success" id="delPro">导出Excel</button>
					</div>
				</th>
			</tr>
		</table>

	</body>

</html>