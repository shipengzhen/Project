<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>门诊查询--中软高科-2015</title>
    <meta charset="UTF-8">
	<%@include file="../comm/import.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/Js/lz/registration.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/Js/lz/jquery.table2excel.min.js"></script>

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
				window.location.href="/HMS/goAddRe";
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

<form action="/HMS/doReList" method="post" class="definewidth m20">
<table class="noExl table  table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">病历号：<input type="hidden" name="pageNo" /> </td>
        
        <td><input type="text" name="id" value="${Res.id}"/></td>
		
        <td width="10%" class="tableleft">主治医生：</td>
        <td><input type="text" name="doctorname" value="${Res.doctorname}"/></td>
		
        <td width="10%" class="tableleft">科室：</td>
        <td><input type="text" name="opdName" value="${Res.opdName}"/></td>
    </tr>
    <tr>
		
        <td width="10%" class="tableleft">挂号时间：</td>
		  <td colspan="5">
			<input type="date" name="begin" value="<fmt:formatDate value="${Res.begin}" pattern="yyyy-MM-dd"/>"/>&nbsp;至&nbsp;
			<input type="date" name="end" value="<fmt:formatDate value="${Res.end}" pattern="yyyy-MM-dd"/>"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-primary" type="button">查询</button> 
            <button type="reset" class="btn btn-primary" type="button">清空</button> 
			
        </td>
    </tr>
</table>
</form>
   
<table class="table exl table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>门诊编号</th>
        <th>主治医生</th>
        <th>挂号时间</th>
        <th>挂号科室</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    	<c:forEach var="re" items="${list.list}">
	     <tr >
         	<td style="vertical-align:middle;">
         		<input type="checkbox" name="check" value="1">
         	</td>
            <td style="vertical-align:middle;">${re.id}</td>
            <td style="vertical-align:middle;">${re.doctorName}</td>
            <td style="vertical-align:middle;">
            	<fmt:formatDate value="${re.created}" pattern="yyyy-MM-dd HH:mm"/>
            </td>
            <td style="vertical-align:middle;">${re.opdname}</td>
            <td style="vertical-align:middle;">
            	<span>
            		<c:if test="${re.status==1}">以挂号</c:if>
            		<c:if test="${re.status==2}">已退号</c:if>
            		<c:if test="${re.status==3}">已住院</c:if>
            	</span>
            </td>
            <td style="vertical-align:middle;" cc="dd">
            		<a href="/HMS/doReByid?id=${re.id}">详情>>></a>&nbsp;&nbsp;&nbsp;
            		<c:if test="${re.status==1 or re.status==3 }">
            			<a href="/HMS/goUpdateRe?id=${re.id}">更改</a>&nbsp;&nbsp;&nbsp;
            			<a href="#" class="th" f="${re.id}">退号</a>
            		</c:if>
            </td>
        </tr>
        </c:forEach>
	   </tbody>
  </table>
  
  <table class="table  noExl table-bordered table-hover definewidth m10" >
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
		 <button type="button" class="btn btn-success" id="newNav">门诊挂号</button>&nbsp;&nbsp;&nbsp;
		 <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">退号</button>&nbsp;&nbsp;&nbsp;
		 <button type="button" class="btn btn-success" id="Excel">导出Excel</button>
		
		 
		 </div>
		 
		 </th></tr>
  </table>
  <script type="text/javascript">
		function page(frm,num){
			frm.pageNo.value = num;
			frm.submit();
		}	

	    $(function(){
	        $("body").on("click","#Excel",function(){
	            exportExcel();
	        });
	        function exportExcel(){
	            $(".exl").table2excel({
	                exclude: ".noExl",	//不导出的表格数据选择器，不导出的数据加class加上 noExl就可以了
	                name: "Excel Document Name",
	                filename: "myFileName",
	                fileext: ".xls",
	                exclude_img: true,
	                exclude_links: true,
	                exclude_inputs: true
	            });
	        }
	    })		
	</script>
</body>
</html>
