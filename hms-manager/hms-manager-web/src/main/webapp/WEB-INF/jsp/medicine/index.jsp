<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>药品查询--中软高科-2015</title>
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
				window.location.href="/HMS/goAddMe";
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

<form action="/HMS/MeList" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">药品名称：</td>
        <td><input type="text" name="medicinenmae" value="${me.medicinenmae }"/><input type="hidden" name="pageNo" /></td>
		
        <td width="10%" class="tableleft">药品类型：</td>
        <td><select name="medicinetype">
        		<option <c:if test="${me.medicinetype=='中药'}">selected="selected"</c:if> >中药</option>
        		<option <c:if test="${me.medicinetype=='西药'}">selected="selected"</c:if>>西药</option>
        		<option <c:if test="${me.medicinetype=='处方药'}">selected="selected"</c:if>>处方药</option>
        		<option <c:if test="${me.medicinetype=='非处方'}">selected="selected"</c:if>>非处方</option>
        	</select>
        </td>
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
    	<c:forEach var="me" items="${list.list}">
	     <tr >
         	<td style="vertical-align:middle;">
         		<input type="checkbox" name="check" value="1"></td>
            <td style="vertical-align:middle;">${me.id }</td>
            <td style="vertical-align:middle;">${me.medicinenmae }</td>
            <td style="vertical-align:middle;">${me.medicinetype }</td>
            <td style="vertical-align:middle;">${me.describe}</td>
            <td style="vertical-align:middle;"><c:if test="${me.status==1 }">在售中</c:if> 
            									<c:if test="${me.status==2 }">未售</c:if> 
            </td>
            <td style="vertical-align:middle;"><c:if test="${me.stock==null}">0</c:if> ${me.stock}袋</td>
            <td style="vertical-align:middle;">
					<a href="/HMS/goMeEdit?id=${me.id}">更改</a>&nbsp;&nbsp;&nbsp;
					<a href="/HMS/goAddmedicine?id=${me.id }">添加库存</a>&nbsp;&nbsp;&nbsp;
					<a href="/HMS/goLookMe?id=${me.id }">详情>>></a>
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
  		
		 <div>
			<button type="button" class="btn btn-success" id="newNav">添加新药</button>
			<button type="button" class="btn btn-success" id="delPro">导出Excel</button>	 ${msg }		
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
