<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>发药详情--中软高科-2015</title>
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
				window.location.href="add.html";
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
   
<table class="table table-bordered table-hover definewidth m10" >
<form action="/HMS/goDiLook" method="post">
	<input type="hidden" name="id" value="${id}"/>
	<input type="hidden" name="pageNo" />
</form>
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
    	<c:forEach var="item" items="${list.list}">
	     <tr >
            <td style="vertical-align:middle;">${item.id}</td>
            <td style="vertical-align:middle;">${item.name}</td>
            <td style="vertical-align:middle;">${item.medicineNmae}</td>
            <td style="vertical-align:middle;">${item.medicineNumber}</td>
            <td style="vertical-align:middle;">${item.medicineYF}<c:if test="${item.medicineYF==null}">0</c:if></td>
            <td style="vertical-align:middle;">
            	<c:if test="${item.medicineYF==null || item.medicineYF==0}">${item.medicineNumber}</c:if>
            	<c:if test="${item.medicineYF!=null || item.medicineYF>0}">${item.medicineNumber-item.medicineYF}</c:if>
            	
            </td>
            <td style="vertical-align:middle;">
            	<c:if test="${item.medicineNumber!=item.medicineYF }">
	            	<a href="/HMS/doUpdateDi?id=${item.id}&number=${item.medicineNumber}&rid=${id}">发全</a>&nbsp;&nbsp;&nbsp;
	            	<c:if test="${item.medicineYF==null}">
	            		<a href="/HMS/doUpdateDi?id=${item.id}&number=2&rid=${id}">发2</a>&nbsp;&nbsp;&nbsp;
	            	</c:if>
	            	<c:if test="${item.medicineYF!=null}">
	            		<a href="/HMS/doUpdateDi?id=${item.id}&number=${item.medicineYF+2 }&rid=${id}">发2</a>&nbsp;&nbsp;&nbsp;
	            	</c:if>
	            		<c:if test="${item.medicineYF==null}">
	            		<a href="/HMS/doUpdateDi?id=${item.id}&number=5&rid=${id}">发5</a>&nbsp;&nbsp;&nbsp;
	            	</c:if>
	            	<c:if test="${item.medicineYF!=null}">
	            		<a href="/HMS/doUpdateDi?id=${item.id}&number=${item.medicineYF+5 }&rid=${id}">发5</a>&nbsp;&nbsp;&nbsp;
	            	</c:if>
            	</c:if>
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
		 
		 
		 
				<button type="button" class="btn btn-success" onclick="window.history.go(-1)">返回列表</button>
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
