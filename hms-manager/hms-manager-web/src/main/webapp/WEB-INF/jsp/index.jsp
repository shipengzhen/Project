<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>枣阳市第二人民医院信息管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../statics/assets/css/dpl-min.css" rel="stylesheet"
	type="text/css" />
<link href="../statics/assets/css/bui.css" rel="stylesheet"
	type="text/css" />
<link href="../statics/assets/css/main.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	function back() {
		if (confirm("确认退出")) {
			window.location.href = "/HMS/doTu";
		}
	}
</script>
</head>
<body>


	<!--<div class="header">

    <div class="dl-title">
        <img src="/chinapost/Public/assets/img/top.png">
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">张三</span><a href="/chinapost/index.php?m=Public&a=logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>-->
	<div class="content">
		<div class="dl-main-nav">
			<div class="dl-inform">
				<div class="dl-inform-title">
					<s class="dl-inform-icon dl-up"></s>
				</div>
			</div>
			<ul id="J_Nav" class="nav-list ks-clear" style="float:left">
				<!--<li class="nav-item dl-selected"><div class="nav-item-inner nav-home">信息采编系统</div></li>-->
				<li
					style=" color: #000;font-size: 25px;margin-top: 17px;margin-left: 20px;">山东省第二人民医院管理平台</li>
			</ul>
			<div
				style="float: right;color: #F15D0C;margin-top: 22px;margin-right: 21px;font-size: 18px;font-weight: 800;">
				欢迎您，<span class="dl-log-user">${User.username}</span><a
					href="javascript:void(0)" onclick="back()" id="out" title="退出系统"
					class="dl-log-quit">[退出]</a>
			</div>
		</div>

		<ul id="J_NavContent" class="dl-tab-conten">
		</ul>
	</div>
	<script type="text/javascript" src="../statics/assets/js/jquery-1.6.js"></script>
	<script type="text/javascript" src="../statics/assets/js/bui.js"></script>
	<script type="text/javascript"
		src="../statics/assets/js/common/main-min.js"></script>
	<script type="text/javascript" src="../statics/assets/js/config-min.js"></script>
	<script>
    BUI.use('common/main',function(){
    	//参数1
        var config = [
		{id:'1',menu:[
		
		{text:'快速通道',items:${list} [
		
	
		{'id':'2','text':'挂号信息管理','href':'goReIdex'},		
		
		{id:'5',text:'住院办理',href:'gohospitalIndex'},
		{id:'8',text:'住院结算',href:'goAccount'},
		
		{id:'7',text:'在院发药',href:'goDispensingIndex'},
		{id:'4',text:'药品管理',href:'goMeIndex'},
		
		{id:'16',text:'检查收费项目登记',href:'gocharge2'},
		{id:'6',text:'收费项目管理',href:'gocharge'},				
		{id:'3',text:'门诊医生管理',href:'goDoctIndex'},
		{id:'11',text:'用户管理',href:'goUserIndx'},
		{id:'12',text:'角色管理',href:'goRoleIndex'},
		{id:'13',text:'资源管理',href:'goResourceIndex'}
		
		]}
		
		]}
		];
		
		//参数2
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>


</body>
</html>