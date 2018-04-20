<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>录入住院信息--中软高科-2015</title>
    <meta charset="UTF-8">
      <%@include file="../comm/import.jsp" %>
    <script type="text/javascript" src="../Js/ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/Js/lz/hospital.js"></script>
 

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
		.dd{ color: red;}

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
<form action="/HMS/doAddHos" id="addHos" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft"><font color="red">*</font>病历号</td>
        <td><input type="text" id="rid" name="id" value=""/><span class="dd"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td id="name"></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件类型</td>
        <td>身份证</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件号</td>
        <td id="idcard"></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">社保号</td>
        <td id="seid"></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">联系电话</td>
        <td id="phone"></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">是否自费</td>
        <td id="isfy"></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td id="sex"></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
        <td id="age"></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">初复诊</td>
        <td id="cfz"></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">所挂科室</td>
        <td id="opdname"></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">指定医生</td>
        <td id="doctorName"></td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td id="remarks"></td>
	</tr>
    <tr>
        <td width="10%" class="tableleft">护理</td>
        <td><input type="text" name="nurseid" value=""/>
        	<span class="dd"></span>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">床位号</td>
        <td><input type="text" name="bedid" value=""/><span class="dd"></span></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">缴费押金</td>
        	
        <td><input type="text" name="cashPledge" value=""/><span class="dd"></span>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">病情</td>
        <td><textarea name="circumstances"></textarea><span class="dd"></span></td>
    </tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-success" onclick="window.history.go(-1)">返回列表</button>
				${msg}
			</center>
		</td>
    </tr>
</table>
</form>
</body>
</html>