<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>入院办理--中软高科-2015</title>
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
				window.location.href="/HMS/goAddHospital";
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
    </script>
</head>
<body>

<form action="/HMS/doHosList" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">病例号：</td>
        <td><input type="text" name="id" value="${Res.id}"/><input type="hidden" name="pageNo" /></td>
		
        <td width="10%" class="tableleft">主治医生：</td>
        <td><input type="text" name="doctorname" value="${Res.doctorname}"/></td>
		
        <td width="10%" class="tableleft">科室：</td>
        <td><input type="text" name="opdName" value="${Res.opdName}"/></td>
    </tr>
    <tr>
		
        <td width="10%" class="tableleft">住院时间：</td>
		
		  <td colspan="5">
			<input type="date" name="begin" value="<fmt:formatDate value="${Res.begin}" pattern="yyyy-MM-dd"/>"/>&nbsp;至&nbsp;
			<input type="date" name="end" value="<fmt:formatDate value="${Res.end}" pattern="yyyy-MM-dd"/>"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-primary" type="button">查询</button> 
            <button type="submit" class="btn btn-primary" type="button">清空</button> 
			
        </td>
    </tr>
</table>
</form>
   
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>病历号</th>
        <th>姓名</th>
        <th>床位号</th>
        <th>联系电话</th>
        <th>押金</th>
        <th>主治医生</th>
        <th>入院时间</th>
        <th>科室</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    	<c:forEach var="hos" items="${list.list}">
	     <tr >
         	<td style="vertical-align:middle;">
         	<input type="checkbox" name="check" value="1"></td>
            <td style="vertical-align:middle;">${hos.id }</td>
            <td style="vertical-align:middle;">${hos.name}</td>
            <td style="vertical-align:middle;">${hos.bedid }</td>
            <td style="vertical-align:middle;">${hos.phone }</td>
            <td style="vertical-align:middle;">${hos.ymoeny}元</td>
            <td style="vertical-align:middle;">${hos.doctorName }</td>
            <td style="vertical-align:middle;"><fmt:formatDate value="${hos.ryDate }" pattern="yyyy-MM-dd HH:mm"/></td>
            <td style="vertical-align:middle;">${hos.opdname }</td>
            <td style="vertical-align:middle;">
            	<c:if test="${hos.status==3}">已住院</c:if>
            	<c:if test="${hos.status==4}">已出院</c:if>
            </td>
            <td style="vertical-align:middle;">
				<a href="/HMS/goLookHos?id=${hos.id}">详情>></a>&nbsp;&nbsp;&nbsp;
				<c:if test="${hos.status==3}">
					<a href="/HMS/goEditHos?id=${hos.id}">更改</a>&nbsp;&nbsp;&nbsp;
					<a href="/HMS/goUpdateMoney?id=${hos.id}">缴纳押金</a>&nbsp;&nbsp;&nbsp;
				</c:if>				
			</td>
        </tr>
	 	</c:forEach>
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5"> 		<div class="inline pull-right page">
					${list.total}条记录 ${list.pageNum}/${list.pages} 页
					<a href="javascript:page(document.forms[0],1)">首页</a>
					<c:forEach var="i"  items="${list.navigatepageNums}" >												
						<a href='javascript:page(document.forms[0],${i})' <c:if test='${list.pageNum==i}'> class='current' </c:if> >${i}</a>
					</c:forEach>
					<a href="javascript:page(document.forms[0],${list.pages})">最后一页</a>	
				</div>
		 <div><button type="button" class="btn btn-success" id="newNav">添加住院信息</button>&nbsp;&nbsp;&nbsp;
		 <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">出院</button>&nbsp;&nbsp;&nbsp;
		 <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">退院</button>&nbsp;&nbsp;&nbsp;
		 <button type="button" class="btn btn-success" id="delPro">导出Excel</button>
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
