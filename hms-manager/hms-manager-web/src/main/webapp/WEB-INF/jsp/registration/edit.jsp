<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>挂号--中软高科-2015</title>
    <meta charset="UTF-8">
   
	<%@include file="../comm/import.jsp" %>
    <script type="text/javascript" src="../Js/ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/Js/lz/registration.js"></script>
 

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
		$('#backid').click(function(){
				window.location.href="index.html";
		 });
    });
    </script>
</head>
<body>
<form action="/HMS/doUpdateRe" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>姓名</td>
        <td><input type="text" name="name" value="${register.name }"/>
        	<input type="hidden" name="id" value="${register.id }">
        </td>
        
    </tr>

    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>身份证号</td>
        <td><input type="text" name="idcard" value="${register.idcard }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>挂号费</td>
        <td><input type="text" name="cost" value="${register.cost }"/>元</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
        <td><input type="text" name="seid" value="${register.seid }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>联系电话</td>
        <td><input type="text" name="phone" value="${register.phone }"/></td>
    </tr>
    <tr>
   
        <td width="10%" class="tableleft"><font color="red">*</font>是否自费</td>
        <td><input type="radio" name="isfy" value="是"  <c:if test="${register.isfy=='是' }">checked</c:if>   />是&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="isfy" value="否" <c:if test="${register.isfy=='否' }">checked</c:if>  />否</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>性别</td>
        <td><input type="radio" name="sex" value="男"  <c:if test="${register.sex=='男' }">checked</c:if>  checked/>男&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="sex" value="女" <c:if test="${register.sex=='女' }">checked</c:if> />女</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>年龄</td>
        <td><input type="text" name="age" value="${register.age }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">职业</td>
        <td><input type="text" name="occupation" value="${register.occupation }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">初复诊</td>
        <td><input type="radio" name="cfz" value="初诊"  <c:if test="${register.cfz=='初诊' }">checked</c:if> />初诊&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="cfz" value="复诊" <c:if test="${register.cfz=='复诊' }">checked</c:if> />复诊</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>所挂科室</td>
        <td>
        	<select name="opdid" id="opd">
        		<c:forEach var="opt" items="${opdlist}">
        			<option value="${opt.id}" <c:if test="${opt.id==register.opdid}">selected='selected' </c:if> >${opt.name }</option>
        		</c:forEach>
        	</select>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>指定医生</td>
        <td><select name="doctorid" id="doctors" >
       			<c:forEach var="doct" items="${doctors}">
       				<option value="${doct.doctorid} " <c:if test="${doct.doctorid==register.opdid }"></c:if> >${doct.doctorname }</option>
       			</c:forEach>
        		
        	</select>
        </td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td><textarea name="remarks">${register.remarks }</textarea></td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-success" onclick="window.history.go(-1)" >返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>