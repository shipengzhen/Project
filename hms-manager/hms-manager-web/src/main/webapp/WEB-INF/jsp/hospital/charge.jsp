<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>收费项目登记</title>
    <meta charset="UTF-8">
	<%@include file="../comm/import.jsp" %>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/statics/Js/lz/charge.js"></script>
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
				window.location.href="/HMS/goAddCostItem";
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
   
<form action="/HMS/doSelectList" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">收费项目名称：</td>
        <td width="10%"><input type="text" name="costitemname" value="${costitemname}"/>
        		<input type="hidden" name="pageNo" > 
        </td>
		
        <td>
		<button type="submit" class="btn btn-primary" type="button">查询</button> 
			<button type="reset" class="btn btn-primary" type="button">清空</button> </td>
    </tr>
   
</table>


</form>
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
        <th>编号</th>
        <th>收费项目名称</th>        
        <th>收费金额</th>
        <th>创建日期</th>
        <th>操作</th>
    </tr>
    </thead>
    	<c:forEach var="costItem" items="${list.list}">
	     <tr >
            <td style="vertical-align:middle;">${costItem.id}</td>
            <td style="vertical-align:middle;">${costItem.costitemname}</td>
            <td style="vertical-align:middle;">${costItem.cost}</td>
            <td style="vertical-align:middle;">	<fmt:formatDate value="${costItem.created}" pattern="yyyy-MM-dd"/></td>
            <td style="vertical-align:middle;">
				<a href="/HMS/goUpdateCitem?id=${costItem.id }">修改</a>
				<a href="#" class="del" aa="${costItem.id}">删除</a>
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
		 <div><button type="button" class="btn btn-success" id="newNav">添加收费项目</button>
		 
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
