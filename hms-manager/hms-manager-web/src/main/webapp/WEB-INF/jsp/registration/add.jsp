<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>更改挂号--中软高科-2015</title>
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
		.dd{ color: red; }

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
<form action="/HMS/doAddRe" method="post" id="addRe" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>姓名</td>
        <td><input type="text" name="name" value=""/><span class="dd"></span></td>
    </tr>

    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>身份证号</td>
        <td><input type="text" name="idcard" id="idcard" value=""/><span class="dd"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
        <td><input type="text" name="seid" value=""/><span class="dd"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>挂号费</td>
        <td><input type="text" name="cost" value=""/>元</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>联系电话</td>
        <td><input type="text" name="phone" value=""/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>是否自费</td>
        <td><input type="radio" name="isfy" value="否" checked/>否&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="isfy" value="是"/>是
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>性别</td>
        <td>
        	<input type="hidden" name="sex" id="sex1"><span id="sex2"></span>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td><input type="text" name="age" id="age"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">职业</td>
        <td><input type="text" name="occupation" value=""/><span class="dd"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">初复诊</td>
        <td><input type="radio" name="cfz" value="初诊" checked/>初诊&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="cfz" value="复诊"/>复诊</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>所挂科室</td>
        <td><select name="opdid" id="opd" >
       		 <option> --请选择 --</option>
        		<c:forEach var="opd" items="${opdlist }">
        			<option value="${opd.id}">${opd.name}</option>
        		</c:forEach>
        	</select>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>指定医生</td>
        <td><select name="doctorid" id="doctors">
        		
        	</select>
        </td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td><textarea name="remarks"></textarea></td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-success" onclick="window.history.go(-1)">返回列表</button>${msg}
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>