<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>收费项目管理</title>
    <meta charset="UTF-8">
  <%@include file="../comm/import.jsp" %>

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
	 $(function () {
		$('#newNav').click(function(){
				window.location.href="charge-new.html";
		 });
    });
	
    	function checkall(){
			var alls=document.getElementsByName("check");
			var ch=document.getElementById("checkall");
			if(ch.checked){
				for(var i=0;i<alls.length;i++){
					alls[i].checked=true;	
				}	
			}else{
				for(var i=0;i<alls.length;i++){
					alls[i].checked=false;	
				}	
			}
		}
		function delAll(){
			var alls=document.getElementsByName("check");
			var ids=new Array();
			for(var i=0;i<alls.length;i++){
				if(alls[i].checked){
					ids.push(alls[i].value);
				}		
			}
			if(ids.length>0){
				if(confirm("确认操作?")){
					alert("成功!");
				}
			}else{
				alert("请选中要操作的项");
			}
		}
    $(function () {       
		$('#backid').click(function(){
				window.location.href="dispensing.html";
		 });
    });
    </script>
</head>
<body>
   
<form action="/HMS/docostsList" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">病历号：</td>
        <td><input type="text" name="id" value="${id }"/><input type="hidden" name="pageNo" > </td>
		
        <td width="10%" class="tableleft">姓名：</td>
        <td><input type="text" name="name" value="${name }"/></td>
    </tr>
    <tr>
		
		
		  <td colspan="4">
			<center>
				<button type="submit" class="btn btn-primary" type="button">查询</button> 
				<button type="submit" class="btn btn-primary" type="button">清空</button> 
			</center>
        </td>
    </tr>
</table>
</form>
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
        <th>病历号</th>
        <th>姓名</th>
        <th>住院日期</th>        
        <th>操作</th>
    </tr>
    </thead>
    	<c:forEach var="df" items="${list.list }">
	     <tr >
            <td style="vertical-align:middle;">${df.id}</td>
            <td style="vertical-align:middle;">${df.name }</td>
            <td style="vertical-align:middle;">	<fmt:formatDate value="${df.ryDate }" pattern="yyyy-MM-dd"/></td>
            <td style="vertical-align:middle;">
				<a href="/HMS/goCharge2">详情</a>
				<a href="/HMS/goaddCostccostItem?id=${df.id }">添加收费项</a>
			</td>
        </tr>
        </c:forEach>
		
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5"> 
  	<div class="inline pull-right page">
					${list.total}条记录 ${list.pageNum}/${list.pages} 页
					<a href="javascript:page(document.forms[0],1)">首页</a>
					<c:forEach var="i"  items="${list.navigatepageNums}" >												
						<a href='javascript:page(document.forms[0],${i})' <c:if test='${list.pageNum==i}'> class='current' </c:if> >${i}</a>
					</c:forEach>
					<a href="javascript:page(document.forms[0],${list.pages})">最后一页</a>	
				</div>
		
		 
		 </th></tr>
  </table>
  
</body>
<script type="text/javascript">
		function page(frm,num){
			frm.pageNo.value = num;
			frm.submit();
		}	
	</script>
</html>
