<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

	<head>
		<title>枣阳市第二人民医院信息管理系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
		<!-- assets框架的css -->
		<link href="assets/css/bui.css" rel="stylesheet" type="text/css" />
		<!-- assets框架的css -->
		<link href="assets/css/main.css" rel="stylesheet" type="text/css" />
		<!-- assets框架的css -->

		<script src="js/jquery-1.8.2.min.js"></script>
		<script src="js/layer/layer.js"></script>

		<script type="text/javascript">
			function back() {

				layer.confirm("确认退出？", function() {
					window.location.href = "login.html";
				})

			}
		</script>
	</head>

	<body>

		<!--<div class="header">

	<div class="dl-title">
		<img src="/chinapost/Public/assets/img/top.png">
	</div>

	<div class="dl-log">欢迎您，<span class="dl-log-user">张三</span>
		<a href="/chinapost/index.php?m=Public&a=logout" title="退出系统" class="dl-log-quit">[退出]</a>
	</div>
</div>-->
		<div class="content">
			<div class="dl-main-nav">
				<div class="dl-inform">
					<div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div>
				</div>
				<ul id="J_Nav" class="nav-list ks-clear" style="float:left">
					<!--<li class="nav-item dl-selected"><div class="nav-item-inner nav-home">信息采编系统</div></li>-->
					<li style=" color: #000;font-size: 25px;margin-top: 17px;margin-left: 20px;">山东省第二人民医院管理平台</li>
				</ul>
				<div style="float: right;color: #F15D0C;margin-top: 22px;margin-right: 21px;font-size: 18px;font-weight: 800;">欢迎您，<span class="dl-log-user">${usee.uname}</span>
					<a href="javascript:void(0)" onclick="back()" id="out" title="退出系统" class="dl-log-quit">[退出]</a>
				</div>
			</div>

			<ul id="J_NavContent" class="dl-tab-conten">
			</ul>
		</div>
		<script type="text/javascript" src="assets/js/jquery-1.6.js"></script>
		<script type="text/javascript" src="assets/js/bui.js"></script>
		<script type="text/javascript" src="assets/js/common/main-min.js"></script>
		<script type="text/javascript" src="assets/js/config-min.js"></script>

		<script>
			BUI.use('common/main', function() {
				var config = [{
						id: '1',
						menu: [

							{
								text: '快速通道',
								items: ${menus}
							}

						]
					}

				];
				new PageUtil.MainPage({
					modulesConfig: config
				});

				/*for (var i=0;i<20;i++) {
					//alert(a)
					var a=config[0].menu[0].items[i];
					document.write("("+a.id+",'"+a.text+"','"+a.href+"',1),<br/>");
				}*/

			});
		</script>

	</body>

</html>