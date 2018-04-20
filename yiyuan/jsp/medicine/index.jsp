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
			
			
			
			
		</script>
	</head>

	<body>

		<form id="ff" action="index.html" method="get" class="definewidth m20">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="10%" class="tableleft">药品名称：</td>
					<td><input type="text" name="y_name" value="${y_name}" /></td>

					<td width="10%" class="tableleft">药品类型：</td>
					<td>
						<select name="y_type">
							<option value="1" ${y_type==1?"selected":""}>处方药</option>
							<option value="2" ${y_type==2?"selected":""}>中药</option>
							<option value="3" ${y_type==3?"selected":""}>西药</option>
						</select>
					</td>
				</tr>
				<tr>

					<td colspan="4">
						<center>
							<button type="submit" class="btn btn-primary" type="button">查询</button>
							<button type="reset" class="btn btn-primary" type="button">清空</button>
						</center>
					</td>
				</tr>
			</table>
		</form>

		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
					<th>药品编号</th>
					<th>药品名称</th>
					<th>药品类型</th>
					<th>简单描述</th>
					<th>状态</th>
					<th>剩余量</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${yaos}" var="y" >
				<tr>
					<td style="vertical-align:middle;"><input type="checkbox" name="check" value="1"></td>
					<td style="vertical-align:middle;">${y.yno}</td>
					<td style="vertical-align:middle;">${y.y_name}</td>
					<td style="vertical-align:middle;">${y.y_type==1?"处方药":y.y_type==2?"中药":"西药"}</td>
					<td style="vertical-align:middle;">${y.y_ms}</td>
					<td style="vertical-align:middle;">${y.y_state}</td>
					<td style="vertical-align:middle;">${y.y_kucun}</td>
					<td style="vertical-align:middle;">
						<a href="add_medicine.html?yno=${y.yno}">添加库存</a>&nbsp;&nbsp;&nbsp;
						<a href="look.html?yno=${y.yno}">详情>>></a>
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
						<button type="button" class="btn btn-success" id="newNav">添加新药</button>
						<button type="button" class="btn btn-success" id="delPro">导出Excel</button>
					</div>

				</th>
			</tr>
		</table>

	</body>

</html>