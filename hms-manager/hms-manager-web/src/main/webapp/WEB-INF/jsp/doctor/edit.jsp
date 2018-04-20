<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>修改医生--中软高科-2015</title>
    <meta charset="UTF-8">
   <%@include file="../comm/import.jsp" %>
    <script type="text/javascript" src="../Js/ckeditor/ckeditor.js"></script>
 

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
<form action="/HMS/doEdit" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>姓名</td>
       
        <td><input type="text" name="doctorname" value="${tbDoctor.doctorname }"/>
        	<input type="hidden" name="doctorid" value="${tbDoctor.doctorid }">
        </td>
    </tr>
    
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>身份证号</td>
        <td><input type="text" name="idcard" value="${tbDoctor.idcard }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>手机</td>
        <td><input type="text" name="phone" value="${tbDoctor.phone }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">座机</td>
        <td><input type="text" name="telephone" value="${tbDoctor.telephone }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>性别</td>
        <td>
        	
        	
        	<input type="radio" name="sex" value="男" <c:if test="${tbDoctor.sex=='男'}">checked</c:if> />男&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="sex" value="女" <c:if test="${tbDoctor.sex=='女'}">checked</c:if> />女
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>出生年月</td>
        <td><input type="text" name="birthday" value="<fmt:formatDate value="${tbDoctor.birthday}" pattern="yyyy-MM-dd"/> "/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">电子邮箱</td>
        <td><input type="text" name="email" value="${tbDoctor.email }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>所属科室</td>
        <td>
        	<select name="opdid">
        		<c:forEach var="vopt" items="${opdlist}">
        			<option value="${vopt.id }"<c:if test="${opd.id==vopt.id  }"></c:if>>${vopt.name }</option>
        		
        		</c:forEach>
        	</select>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">学历</td>
        <td>
        	<select name="education">
        		<option <c:if test="${tbDoctor.education=='专科'}"> selected="selected"</c:if>  >专科</option>
        		<option <c:if test="${tbDoctor.education=='本科'}"> selected="selected"</c:if> >本科</option>
        		<option <c:if test="${tbDoctor.education=='博士'}"> selected="selected"</c:if> >博士</option>
        		<option <c:if test="${tbDoctor.education=='博士后'}"> selected="selected"</c:if> >博士后</option>
        	</select>
        </td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td><textarea name="remarks">${tbDoctor.remarks }</textarea></td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>