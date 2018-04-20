<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>添加医生--中软高科-2015</title>
    <meta charset="UTF-8">
    <%@include file="../comm/import.jsp" %>
   <script type="text/javascript" src="${pageContext.request.contextPath}/statics/Js/lz/doctor.js"></script>

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
        .msgs{
        	color: red;
        }


    </style>
</head>
<body>
<form action="/HMS/doAddDoctor" id="addDoctor" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>姓名</td>
        <td><input type="text" name="doctorname" value=""/><span class="msgs"></span></td>
    </tr>
    
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>身份证号</td>
        <td><input type="text" id="idcard" name="idcard" value=""/><span class="msgs"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>手机</td>
        <td><input type="text" name="phone" value=""/><span class="msgs"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">座机</td>
        <td><input type="text" name="telephone" value=""/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>性别</td>
        <td>
        	<input type="hidden" id="sex" name="sex" value=""/><span id="sexspan"></span>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>出生年月</td>
        <td><input type="hidden" id="birthday" name="birthday" value=""/><span id="birthdays"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">电子邮箱</td>
        <td><input type="text" name="email" value=""/><span class="msgs"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>所属科室</td>
        <td>
        	<select name="opdid">
        		<c:forEach var="opd" items="${opdList}">
        			<option value="${opd.id}">${opd.name}</option>
        		</c:forEach>
        	</select>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">学历</td>
        <td>
        	<select name="education"><option>专科</option><option>本科</option><option>博士</option><option>博士后</option></select></td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td><textarea name="remarks"></textarea></td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-success"onclick="window.history.go(-1)" >返回列表</button>
				${msg}
			</center>
			
		</td>
    </tr>
</table>
</form>
</body>
</html>