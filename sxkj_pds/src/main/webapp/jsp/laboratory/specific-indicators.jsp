<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/tags/loushang-web" prefix="l" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge，chrome=1">
    <meta name="renderer" content="webkit">
    <title>陕西科技PDS管理服务系统</title>
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/bootstrap.min.css"/> " />
    <link rel="stylesheet" href="<l:asset path="../assets/css/font-awesome/font-awesome.min.css"/> "/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/lab_common.css"/> " />
    <link rel="stylesheet" href="<l:asset path="../assets/css/head.css"/> " />
    <link rel="stylesheet" href="<l:asset path="../assets/css/labAnalysis.css" />"/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/specificIndicators.css" />"/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/lab_auditing.css" />"/>
</head>

<body>
    <!--  头部-->
    <header class="clearfix">
        <div class="header-logo">
            <img src="../skins/assets/images/header-logo.png">
        </div>
        <div class="header-info">
            <span>
                <a href="../director/configureLinrarry" target="black">
                    <i class="fa fa-cogs"></i>指标配置库</a>
            </span>
            <span>
                <a href="#">
                    <i class="fa fa-search-plus"></i>信息审核查看</a>
            </span>
            <span>
                <a href="#">
                    <i class="fa fa-user"></i>用户中心</a>
            </span>
            <span>
                <a href="../login">
                    <i class="fa fa-sign-out"></i>注销</a>
            </span>
        </div>
    </header>
    <!-- 二级页面头部下方信息 -->
    <div class="page-info clearfix">
        <div class="page-location">
            <i class="fa fa-location"></i>
            <span>当前位置：</span>
            <i class="fa fa-angle-right"></i>
            <span>总体分析</span>
        </div>
    </div>
    <div class="indictormain-content">
        <!-- 每一行 -->
        <div class="single-row marginBottom20">
            <span class="right-abspic right-short">重
                <br>要
                <br>指
                <br>标</span>
            <ul class="imporindic-list clearfix">
                <li>
                    <!-- 每个模块 -->
                    <div class="module border">
                        <div class="module-title imporindic-moduletitle">
                            人员流动
                        </div>
                        <div class="module-con imporindic-modulecon" id="module1">

                        </div>
                    </div>
                </li>
                <li>
                    <!-- 每个模块 -->
                    <div class="module border">
                        <div class="module-title imporindic-moduletitle">
                            仪器共享率分析
                        </div>
                        <div class="module-con imporindic-modulecon" id="module2">

                        </div>
                    </div>
                </li>
                <li>
                    <!-- 每个模块 -->
                    <div class="module border">
                        <div class="module-title imporindic-moduletitle">
                            人才培养监测分析
                        </div>
                        <div class="module-con imporindic-modulecon" id="rcpy3">

                        </div>
                    </div>
                </li>
                <li>
                    <!-- 每个模块 -->
                    <div class="module border">
                        <div class="module-title imporindic-moduletitle">
                            区域成果展示
                        </div>
                        <div class="module-con imporindic-modulecon" id="result1">

                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <!-- 每一行 -->
        <div class="single-row marginBottom20">
            <span class="right-abspic right-long">数
                <br>据
                <br>指
                <br>标
                <br>分
                <br>析</span>
            <div class="dataanalysis-wrap clearfix">
                <div class="dataanalysis-left pull-left">
                    <div class="nav1 pull-left">
                        <div class="nav-top1">
                            导航
                        </div>
                        <div class="ue-vmenu">
                            <ul class="ce">
                                <li class="menu-1">
                                    <a href="#">“7+1”平台</a>
                                    <ul class="er" style="display:block;">
                                        <li class="e_li">
                                            <a href="#">高新区</a>
                                        </li>
                                        <li class="e_li">
                                            <a href="#">技术创新平台</a>
                                            <ul class="thr" style="display:block;">
                                                <li>
                                                    <a href="#">
                                                        <i class="fa fa-angle-right"></i>
                                                        重点实验室
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="e_li">
                                            <a href="#">技术转移平台</a>
                                            <ul class="thr">
                                                <li>
                                                    <a href="#">
                                                        <i class="fa fa-angle-right"></i>
                                                        技术合同认定登记机构
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="e_li">
                                            <a href="#">技术创新平台</a>
                                            <ul class="thr">
                                                <li>
                                                    <a href="#">
                                                        <i class="fa fa-angle-right"></i>
                                                        创新创业平台</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="e_li">
                                            <a href="#">创新服务平台</a>
                                            <ul class="thr">
                                                <li>
                                                    <a href="#">
                                                        <i class="fa fa-angle-right"></i>
                                                        省级软科学研究基地</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="e_li">
                                            <a href="#">科技金融平台</a>
                                            <ul class="thr">
                                                <li>
                                                    <a href="#" title="科技成果转化引导基金管理服务平台">
                                                        <i class="fa fa-angle-right"></i>
                                                        科技成果转化引导基金</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="e_li">
                                            <a href="#">资源共享平台</a>
                                            <ul class="thr">
                                                <li>
                                                    <a href="#">
                                                        <i class="fa fa-angle-right"></i>
                                                        科技资源开放共享平台</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="e_li">
                                            <a href="#">国际科技合作基地</a>
                                            <ul class="thr">
                                                <li>
                                                    <a href="#">
                                                        <i class="fa fa-angle-right"></i>
                                                        国际科技合作基地</a>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li class="menu-1">
                                    <a href="#">省级重大专项</a>
                                    <ul class="er">
                                        <li class="e_li">
                                            <a href="#">
                                                <i class="fa fa-angle-right"></i>
                                                暂无</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="dataanalysis-right pull-left">
                    <ul class="dataanalysis-list clearfix">
                        <li>
                            <!-- 每个模块 -->
                            <div class="module border">
                                <div class="module-title imporindic-moduletitle">
                                    实验室学科分布
                                </div>
                                <div class="module-con dataanalysis-modulecon" id="sysXkfb">

                                </div>
                            </div>
                        </li>
                        <li>
                            <!-- 每个模块 -->
                            <div class="module border">
                                <div class="module-title imporindic-moduletitle">
                                    设备总值分析
                                </div>
                                <div class="module-con dataanalysis-modulecon" id="sbzzfx">

                                </div>
                            </div>
                        </li>
                        <li>
                            <!-- 每个模块 -->
                            <div class="module border">
                                <div class="module-title imporindic-moduletitle">
                                    实验室人才投入分析
                                </div>
                                <div class="module-con dataanalysis-modulecon" id="sysRctr">

                                </div>
                            </div>
                        </li>
                        <li>
                            <!-- 每个模块 -->
                            <div class="module border">
                                <div class="module-title imporindic-moduletitle">
                                    实验室区域分布
                                </div>
                                <div class="module-con dataanalysis-modulecon" id="sysqyfb">

                                </div>
                            </div>
                        </li>
                        <li>
                            <!-- 每个模块 -->
                            <div class="module border">
                                <div class="module-title imporindic-moduletitle">
                                    实验室优化预警
                                </div>
                                <div class="module-con dataanalysis-modulecon" id="sysyh3">

                                </div>
                            </div>
                        </li>
                        <li>
                            <!-- 每个模块 -->
                            <div class="module border">
                                <div class="module-title imporindic-moduletitle">
                                    实验室学科领域分析
                                </div>
                                <div class="module-con dataanalysis-modulecon" id="prjArea">

                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 每一行 -->
        <div class="single-row marginBottom20">
            <span class="right-abspic right-short">异
                <br>常
                <br>列
                <br>表</span>
            <div class="error-wrap">
                <div class="lab_list">
                    <div class="lablist-top clearfix">
                        <div class="lab_select pull-left">
                            <span>平台类型：</span>
                            <select id="lab1">
                                <option>请选择</option>
                                <option value="labb">技术创新平台</option>
                                <option value="labc">园区基地平台</option>
                                <option value="labd">资源供销平台</option>
                                <option value="labe">创新服务凭他</option>
                                <option value="labf">创新创业平台</option>
                                <option value="labg">科技金融平台</option>
                                <option value="labh">技术转移平台</option>
                                <option value="labi">科技合作平台</option>
                            </select>
                            <select id="val" class="sel">
                                <option></option>
                            </select>
                        </div>
                        <div class="lab-search pull-right">
                            <input type="" name="" placeholder="名称/单位名称/负责人">
                            <a href="">搜索</a>
                        </div>
                    </div>
                    <div class="lab-table">
                        <table>
                            <tr>
                                <th>序号</th>
                                <th>实验室名称</th>
                                <th>批准时间</th>
                                <th>实验室主任</th>
                                <th>联系人</th>
                                <th>主管部门</th>
                                <th>异常比率</th>
                                <th>依托单位</th>
                                <th>操作</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>陕西省电工材料与熔（浸）渗技术重点实验室</td>
                                <td>2003</td>
                                <td>张三</td>
                                <td>王五</td>
                                <td>西安市科技局</td>
                                <td>90%</td>
                                <td>西安理工大学</td>
                                <td>
                                    <a href="">查看</a>
                                </td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>陕西省电工材料与熔（浸）渗技术重点实验室</td>
                                <td>2003</td>
                                <td>张三</td>
                                <td>王五</td>
                                <td>西安市科技局</td>
                                <td>90%</td>
                                <td>西安理工大学</td>
                                <td>
                                    <a href="">查看</a>
                                </td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>陕西省电工材料与熔（浸）渗技术重点实验室</td>
                                <td>2003</td>
                                <td>张三</td>
                                <td>王五</td>
                                <td>西安市科技局</td>
                                <td>90%</td>
                                <td>西安理工大学</td>
                                <td>
                                    <a href="">查看</a>
                                </td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>陕西省电工材料与熔（浸）渗技术重点实验室</td>
                                <td>2003</td>
                                <td>张三</td>
                                <td>王五</td>
                                <td>西安市科技局</td>
                                <td>90%</td>
                                <td>西安理工大学</td>
                                <td>
                                    <a href="">查看</a>
                                </td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>陕西省电工材料与熔（浸）渗技术重点实验室</td>
                                <td>2003</td>
                                <td>张三</td>
                                <td>王五</td>
                                <td>西安市科技局</td>
                                <td>90%</td>
                                <td>西安理工大学</td>
                                <td>
                                    <a href="">查看</a>
                                </td>
                            </tr>
                            <tr>
                                <td>6</td>
                                <td>陕西省电工材料与熔（浸）渗技术重点实验室</td>
                                <td>2003</td>
                                <td>张三</td>
                                <td>王五</td>
                                <td>西安市科技局</td>
                                <td>90%</td>
                                <td>西安理工大学</td>
                                <td>
                                    <a href="">查看</a>
                                </td>
                            </tr>
                            <tr>
                                <td>7</td>
                                <td>陕西省电工材料与熔（浸）渗技术重点实验室</td>
                                <td>2003</td>
                                <td>张三</td>
                                <td>王五</td>
                                <td>西安市科技局</td>
                                <td>90%</td>
                                <td>西安理工大学</td>
                                <td>
                                    <a href="">查看</a>
                                </td>
                            </tr>
                            <tr>
                                <td>8</td>
                                <td>陕西省电工材料与熔（浸）渗技术重点实验室</td>
                                <td>2003</td>
                                <td>张三</td>
                                <td>王五</td>
                                <td>西安市科技局</td>
                                <td>90%</td>
                                <td>西安理工大学</td>
                                <td>
                                    <a href="">查看</a>
                                </td>
                            </tr>
                            <tr>
                                <td>9</td>
                                <td>陕西省电工材料与熔（浸）渗技术重点实验室</td>
                                <td>2003</td>
                                <td>张三</td>
                                <td>王五</td>
                                <td>西安市科技局</td>
                                <td>90%</td>
                                <td>西安理工大学</td>
                                <td>
                                    <a href="">查看</a>
                                </td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td>陕西省电工材料与熔（浸）渗技术重点实验室</td>
                                <td>2003</td>
                                <td>张三</td>
                                <td>王五</td>
                                <td>西安市科技局</td>
                                <td>90%</td>
                                <td>西安理工大学</td>
                                <td>
                                    <a href="">查看</a>
                                </td>
                            </tr>
                        </table>
                        <div>
                            <ul class="pagination">
                                <li>
                                    <a href="#">首页</a>
                                </li>
                                <li>
                                    <a href="#">上一页</a>
                                </li>
                                <li>
                                    <a href="#">1</a>
                                </li>
                                <li>
                                    <a href="#">2</a>
                                </li>
                                <li>
                                    <a href="#">3</a>
                                </li>
                                <li>
                                    <a href="#">4</a>
                                </li>
                                <li>
                                    <a href="#">下一页</a>
                                </li>
                                <li>
                                    <a href="#">尾页</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/echarts.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/bootstrap.min.js"/> "></script>
<script type="text/javascript" src="<l:asset path="../assets/js/audit-nav.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/specific-indicators.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/index.js"/>"></script>
<script>
    $(function () {
        var result1 = document.getElementById("result1");
        var rcpy3 = document.getElementById("rcpy3");
        var sysXkfb = document.getElementById("sysXkfb");
        var sbzzfx = document.getElementById("sbzzfx");
        var sysRctr = document.getElementById("sysRctr");
        var sysqyfb = document.getElementById("sysqyfb");
        var sysyh3 = document.getElementById("sysyh3");
        var prjArea = document.getElementById("prjArea");

        //区域成果展示
        labResults(result1);
        //人才培养检测
        cultivation(rcpy3);
        //实验室学科分布
        geographical(sysXkfb);
        // 设备总值分析
        equipment(sbzzfx);
        //实验室投入
        labPut(sysRctr);
        // 实验室区域分布
        labDist(sysqyfb);
        //实验室优化预警
        labAlarming(sysyh3);
        // 实验室学科领域分析
          expertise(prjArea);
    });


        var select = document.getElementById("lab1");
        select.onchange=function(){
            var selvalue = select.value;
            var val = document.getElementById("val");
            switch(selvalue){
                case "labb" : val.innerHTML="<option>重点实验室</option><option>临床医学研究中心</option><option>创新药物研究中心</option><option>工程技术研究中心</option><option>药用植物示范基地</option><option>";break;
                case "labc" : val.innerHTML="<option>高新区</option><option>可持续发展实验室</option><option>农业科技园</option><option>县城科技创新实验示范站</option>";break;
                case "labd" : val.innerHTML="<option>科技资源开放共享平台</option>";
                    break;
                case "labe" : val.innerHTML="<option>省软科学研究基地</option>";break;
                
                case "labf" : val.innerHTML="<option>科技企业孵化器、众创空间</option><option>星创天地</option>";break;
                case "labg" : val.innerHTML="<option>科技成果转化引导基金管理服务平台</option>";break;
                case "labh" : val.innerHTML="<option>校企共建新型研发平台</option><option>技术转移示范机构</option><option>技术合同认定登记机构</option>";break;
               
                case "labi" : val.innerHTML="<option>国际科技合作基地</option>";
                    break;
            }
        };
</script>

</html>
