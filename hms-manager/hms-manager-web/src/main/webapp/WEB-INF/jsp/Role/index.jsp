<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
     <%@include file="../comm/import.jsp" %>
     <script type="text/javascript" src="${pageContext.request.contextPath}/statics/Js/lz/Role.js"></script>

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
				window.location.href="/HMS/goRoleAdd";
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
				if(confirm("确认删除?")){
					alert("删除成功!");
				}
			}else{
				alert("请选中要删除的项");
			}
		}
    </script>   
    
</head>
<body>
<form class="form-inline definewidth m20" action="/HMS/doFindLikeRoleName" method="post">  
    角色名称：
    <input type="text" name="rolename" id="rolename"class="abc input-default" placeholder="" value="${rolename}">&nbsp;&nbsp;  
     <input type="hidden" name="pageNo" > 
    <button type="submit" class="btn btn-primary">查询</button>
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
    	<th width="5%"><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>角色名称</th>
        <th>状态</th>
        <th width="10%">操作</th>
    </tr>
    </thead>
    	<c:forEach var="item" items="${info.list}">

	     <tr>
         	<td style="vertical-align:middle;"><input type="checkbox" name="check" value="1"></td>
            <td>${item.rolename}</td>
            <td>
            	<c:if test="${item.status==1}">启用</c:if>
				<c:if test="${item.status==0}">禁用</c:if>
			</td>
            <td><a href="/HMS/goeditRole?id=${item.id}">编辑</a>&nbsp;&nbsp;&nbsp;
            	<a href="" class="delRole">删除</a>
            	<input type="hidden" value="${item.id}">
             </td>
        </tr>
        </c:forEach>
       </table>
        
   <table class="table table-bordered table-hover definewidth m10" >
  	<tr>
  		<th colspan="5">
				<div class="inline pull-right page">
					${info.total}条记录 ${info.pageNum}/${info.pages} 页
					<a href="javascript:page(document.forms[0],1)">首页</a>
					<c:forEach var="i"  items="${info.navigatepageNums}" >												
						<a href='javascript:page(document.forms[0],${i})' <c:if test='${info.pageNum==i}'> class='current' </c:if> >${i}</a>
					</c:forEach>
					<a href="javascript:page(document.forms[0],${info.pages})">最后一页</a>	
				</div>
				<div>
					<button type="button" class="btn btn-success" id="newNav">添加资源</button>
					&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-success" id="delPro"
						onClick="delAll();">删除选中</button>
				</div>
			</th>
  	
  	</tr>
  </table>     
 </body>
 	<script type="text/javascript">
		function page(frm,num){
			frm.pageNo.value = num;
			frm.submit();
		}	
	</script>
</html>