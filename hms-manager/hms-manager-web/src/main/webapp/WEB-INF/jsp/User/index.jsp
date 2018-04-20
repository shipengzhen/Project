<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
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
				window.location.href="/HMS/goAddUser";
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
<form class="form-inline definewidth m20" action="/HMS/findUserList" method="post">    
    用户名称：
    <input type="text" name="loginname" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
     <input type="hidden" name="pageNo" > 
    <button type="submit" class="btn btn-primary">查询</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
    	<th width="5%"><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>用户账户</th>
        <th>真实姓名</th>
        <th>角色</th>
        <th>状态</th>
        <th  width="10%">操作</th>
    </tr>
    </thead>
	    <c:forEach var="user" items="${userList.list}">
		     <tr>
	         	<td style="vertical-align:middle;"><input type="checkbox" name="check" value="1"></td>
	            <td>${user.loginname }</td>
	            <td>${user.username}</td>
	             <td>	
	            	<c:forEach var="r" items="${allRole}" >
	            		<c:if test="${r.id==user.roleid}">
	            			${r.rolename}
	            		</c:if>
	            	</c:forEach>
	             </td>
	            <td>
            		<c:if test="${user.status==1}">启用</c:if>
					<c:if test="${user.status==0}">禁用</c:if>
				</td>
	            <td>
	                <a href="/HMS/goUserEdit?id=${user.id}">编辑</a>&nbsp;&nbsp;&nbsp;
	                <a href="/HMS/delUser?id=${user.id}">删除</a>             
	            </td>
	        </tr>	
	    </c:forEach>
</table>
<table class="table table-bordered table-hover definewidth m10" >

  	<tr>
  		<th colspan="5">
				<div class="inline pull-right page">
					${userList.total}条记录 ${userList.pageNum}/${userList.pages} 页
					<a href="javascript:page(document.forms[0],1)">首页</a>
					<c:forEach var="i"  items="${userList.navigatepageNums}" >												
						<a href='javascript:page(document.forms[0],${i})' <c:if test='${userList.pageNum==i}'> class='current' </c:if> >${i}</a>
					</c:forEach>
					<a href="javascript:page(document.forms[0],${userList.pages})">最后一页</a>	
				</div>
				<div>
					<button type="button" class="btn btn-success" id="newNav">添加资源</button>
					&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-success" id="delPro"
						onClick="delAll();">删除选中</button>
				</div>
			</th>
  </table>
</body>
<script type="text/javascript">
		function page(frm,num){
			frm.pageNo.value = num;
			frm.submit();
		}	
	</script>
</html>