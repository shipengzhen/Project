<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="/tags/loushang-web" prefix="l" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge，chrome=1">
    <meta name="renderer" content="webkit">
    <title>陕西科技PDS管理服务系统</title>
    <link rel="stylesheet" href="<l:asset path="../assets/css/common/bootstrap.min.css"/> " />
    <link rel="stylesheet" href="<l:asset path="../assets/css/font-awesome/font-awesome.min.css"/> "/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/head.css"/> " />
    <link rel="stylesheet" href="<l:asset path="../assets/css/monitor.css"/>"/>
    <link rel="stylesheet" href="<l:asset path="../assets/css/lab_auditing.css"/>"/>
</head>

<body>
    <!--  头部-->
    <header class="clearfix">
        <div class="header-logo">
            <img src="../skins/assets/images/header-logo.png">
        </div>
        <div class="header-info">
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
            <span>首页</span>
            <i class="fa fa-angle-right"></i>
            <span>信息填报</span>
            <i class="fa fa-angle-right"></i>
            <span>历史信息查看</span>
        </div>
    </div>
    <div class="labinfo-content">
        <!-- 实验室基本信息 -->
        <div class="info-group marginBottom10">
            <div class="info-head">
                <img src="../skins/assets/images/monitorAlert/icon-1.png" alt="">
                <i>实验室基本信息</i>
                <div class="infohead-act pull-right">
                    <a href="../laboratory/lab_tianbao">返回</a>
                </div>
            </div>

            <div class="info-content clearfix">
                <div class="labdetail-wrap clearfix">
                    <div class="lab-pic pull-left">
                        <img src="../skins/assets/images/monitorAlert/lab-pic.png" alt="">
                    </div>
                    <div class="lab-info lab-nes pull-left">
                        <ul class="clearfix">
                            <li class="half-len bgcgrey">
                                <label for="">实验室名称：</label>
                                <span>陕西省石油精细化学品重点实验室</span>
                            </li>
                            <li class="half-len bgcgrey">
                                <label for="">实验室地址：</label>
                                <span>陕西省西安市西延路61号</span>
                            </li>
                            <li class="half-len bgcblue">
                                <label for="">实验室所在区域：</label>
                                <span>陕西省西安市</span>
                            </li>
                            <li class="half-len bgcblue">
                                <label for="">批准时间：</label>
                                <span>2014年1月1号</span>
                            </li>
                            <li class="half-len bgcgrey">
                                <label for="">验收时间：</label>
                                <span>2014年3月1号</span>
                            </li>
                            <li class="half-len bgcgrey">
                                <label for="">实验室主任姓名：</label>
                                <span>胡广发</span>
                            </li>
                            <li class="half-len bgcblue">
                                <label for="">联系人名称：</label>
                                <span>王前进</span>
                            </li>
                            <li class="half-len bgcblue">
                                <label for="">主管部门：</label>
                                <span>陕西省科技厅</span>
                            </li>
                            <li class="half-len bgcgrey">
                                <label for="">依托单位名称：</label>
                                <span>陕西延安石油（集团）有责任公司</span>
                            </li>
                            <li class="half-len bgcgrey">
                                <label for="">学科领域：</label>
                                <span>化学</span>
                            </li>

                        </ul>
                        <ul>
                            <li class="whole-len bgcblue">
                                <label for="">研究方向：</label>
                                <span>（1）油田化学及新型绿色反应技术研究（2）油田采输防护技术（3）石油化工新材料研究（1）油田化学及新型绿色反应技术研究（2）油田采输防护技术（3）石油化工新材料研究</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="history-wrap clearfix">
            <!-- 左侧导航 -->
            <div class="nav1 pull-left">
                <div class="nav-top1">
                    导航
                </div>
                <div class="ue-vmenu">
                    <ul class="ce">
                        <li class="menu-1">
                            <a href="#">“7+1”平台</a>
                            <ul class="er">
                                <li class="e_li">
                                    <a href="#">高新区</a>
                                </li>
                                <li class="e_li">
                                    <a href="#">技术创新平台</a>
                                    <ul class="thr">
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
            <!-- 右侧内容 -->
            <div class="lab-right pull-right">
                <div class="mytab clearfix">
                    <a href='' class='mytab1'>2018年</a>
                    <a href='' class='mytab2'>2017年</a>
                    <a href='' class='mytab2'>2016年</a>
                    <a href='' class='mytab2'>2015年</a>
                    <a href='' class='mytab2'>2014年</a>
                    <a href='' class='mytab2'>2013年</a>
                    <a href='' class='mytab2'>2012年</a>
                    <a href='' class='mytab2'>2010年</a>
                </div>
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
    <!-- 页脚 -->
    <div class="footer">
        <p>版权所有：陕西科学技术厅 运行维护:陕西省科技资源统筹中心</p>
        <p>陕ICP备05002100号-6</p>
    </div>
</body>
<script type="text/javascript" src="<l:asset path="../assets/js/common/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/common/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<l:asset path="../assets/js/audit-nav.js"/>"></script>
<script type="text/javascript">
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
