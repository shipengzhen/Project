<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>门诊医生--中软高科-2015</title>
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
				window.location.href="/HMS/goAddDoctor";
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

<form action="/HMS/doSelectDoctor" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">医生编号：</td>
        <td><input type="text" name="doctorid" value="${doctor.doctorid }"/></td>
		<input type="hidden" name="pageNo" > 
        <td width="10%" class="tableleft">医生姓名：</td>
        <td><input type="text" name="doctorname" value="${doctor.doctorname }"/></td>
		
        <td width="10%" class="tableleft">科室：</td>
        <td><input type="text" name="name" value="${name }"/></td>
    </tr>
    <tr>
		  <td colspan="6"><center>
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
    	<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>医生编号</th>
        <th>医生姓名</th>
        <th>入院时间</th>
        <th>所属科室</th>
        <th>操作</th>
    </tr>
    </thead>
    	<c:forEach var="doctor" items="${list.list}">
	     <tr >
         	<td style="vertical-align:middle;"><input type="checkbox" name="check" value="1"></td>
            <td style="vertical-align:middle;">${doctor.doctorid }</td>
            <td style="vertical-align:middle;">${doctor.doctorname }</td>
            <td style="vertical-align:middle;"><fmt:formatDate value="${doctor.created}" pattern="yyyy-MM-dd"/> </td>
            <td style="vertical-align:middle;">${doctor.opdName }</td>
            <td style="vertical-align:middle;"><a href="/HMS/goLook?id=${doctor.doctorid }">详情>>></a>&nbsp;&nbsp;&nbsp;
            		<a href="/HMS/goEdit?id=${doctor.doctorid }">更改</a></td>
        </tr>
        </c:forEach>
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr>
  	<th colspan="5"> 
  			<div class="inline pull-right page">
					${list.total}条记录 ${list.pageNum}/${list.pages} 页
					<a href="javascript:page(document.forms[0],1)">首页</a>
					<c:forEach var="i"  items="${list.navigatepageNums}" >												
						<a href='javascript:page(document.forms[0],${i})' <c:if test='${list.pageNum==i}'> class='current' </c:if> >${i}</a>
					</c:forEach>
					<a href="javascript:page(document.forms[0],${list.pages})">最后一页</a>	
				</div>
		  
		 <div><button type="button" class="btn btn-success" id="newNav">添加新医生</button>
		 <button type="button" class="btn btn-success" id="delPro">批量删除</button>
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
