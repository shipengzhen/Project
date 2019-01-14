var markerArea = "陕西省";
var markerType = "";
var ListInfoWin = [];
var searchType = 0;
$(function(){
    // $('.m-tab .tab-header>ul>li').click(function () {
    //     var count = $(this).index();
    //     $(this).addClass('active').siblings('li').removeClass('active');
    //     $(this).parents('.m-tab').find('.tab-body').children().children().hide().eq(count).show();
    // });

    var count=0;
    var map = new BMap.Map("map");//在百度地图容器中创建一个地图
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
    }
    //创建地图函数：
    function createMap(){
        //var point = new BMap.Point(117.024967,36.682785);//定义一个中心点坐标
        //map.centerAndZoom(point,15);//设定地图的中心点和坐标并将地图显示在地图容器中
        map.centerAndZoom("陕西省",7.5);
        //getBoundary();
        window.map = map;//将map变量存储在全局
        //可视范围 自动弹回
        /*var b = new BMap.Bounds(new BMap.Point(114.11668,34.271395),new BMap.Point(126.442869,41.879616)); // 范围 左下角，右上角的点位置
        try {    // js中尽然还有try catch方法，可以避免bug引起的错误
            BMapLib.AreaRestriction.setBounds(map, b); // 已map为中心，已b为范围的地图
        } catch (e) {
            // 捕获错误异常
            alert(e);
        }*/
    }

    //设置行政区划
    function getBoundary(){
        var bdary = new BMap.Boundary();
        bdary.get(markerArea, function(rs){       //获取行政区域
            //map.clearOverlays();        //清除地图覆盖物
            var count = rs.boundaries.length; //行政区域的点有多少个
            if (count === 0) {
                alert('未能获取当前输入行政区域');
                return ;
            }
            var pointArray = [];
            for (var i = 0; i < count; i++) {
                var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2, strokeColor: "#ffbe33", fillColor: "#ffbe33",fillOpacity : 0.2}); //建立多边形覆盖物
                map.addOverlay(ply);  //添加覆盖物
                pointArray = pointArray.concat(ply.getPath());
            }
            //map.setViewport(pointArray);   //调整视野
        });
    }


    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }

    //地图控件添加函数：
    function addMapControl(){
        //向地图中添加缩放控件
        var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
        map.addControl(ctrl_nav);
        //向地图中添加比例尺控件
        var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
        map.addControl(ctrl_sca);
    }
    //地址解析
    var index = 0;
    var myGeo = new BMap.Geocoder();
    function bdGEO(data){
        ListInfoWin = [];
        $.each(data,function(n,value) {
            count = n+1;
            if((!value.pos)||(value.pos == '')){
                var add = value.add;
                geocodeSearch(add,value);
            }
            else{
                var address = new BMap.Point(value.pos[0], value.pos[1]);
                addMarker(address,new BMap.Label(index+":"+add,{offset:new BMap.Size(20,-10)}),value);
            }
        });
        $('.tab-body>ul>li:eq('+searchType+') .result-num em').text(data.length);
    }
    function geocodeSearch(add,addObj){
        myGeo.getPoint(add, function(point){
            if (point) {
                var address = new BMap.Point(point.lng, point.lat);
                addMarker(address,new BMap.Label(index+":"+add,{offset:new BMap.Size(20,-10)}),addObj);
            }
        }, '陕西省');
    }
    //添加标注
    function addMarker(point,label,addObj){
        var typeIcon;
        if(addObj.type == '平台'){
            typeIcon = new BMap.Icon("../skins/assets/images/red.png", new BMap.Size(17,23));
        }
        else if(addObj.type == '服务'){
            typeIcon = new BMap.Icon("../skins/assets/images/cyan.png", new BMap.Size(17,23));
        }else if(addObj.type == '机构'){
            typeIcon = new BMap.Icon("../skins/assets/images/blue.png", new BMap.Size(17,23));
        }else if(addObj.type == '人才'){
            typeIcon = new BMap.Icon("../skins/assets/images/cheng.png", new BMap.Size(17,23));
        }else if(addObj.type == '项目'){
            typeIcon = new BMap.Icon("../skins/assets/images/green.png", new BMap.Size(17,23));
        }

        var marker = new BMap.Marker(point,{icon: typeIcon});
        map.addOverlay(marker);
        var posData = addObj.pos;
        if(posData==""){
            posData = [point.lng,point.lat];
        }
        var listHtml= '<li data-target="'+posData+'" class="clearfix">'
                    +'<span>'+count+'</span>'
                    +'<div class="result-list-info">'
                    +'<div class="result-name">'
                    +'<div>'+addObj.name+'</div></div>'
                    //+'<div class="result-type">'
                    //+'<span>'+addObj.sectype+'</span>'
                    //+'<span>'+addObj.thdtype+'</span>'
                    //+'</div>'
                    +'<div class="result-add">'+addObj.add+'</div>'
                    +'</div>'
                    +'</li>';
        $('.tab-body>ul>li:eq('+searchType+') .result-list>ul').append(listHtml);
        /*old */
        /*var contentHtml = '<div class="map-panel">'
                            +'<div class="map-name"><a href="#">'+addObj.name+'</a></div>'
                            +'<div class="map-type"><span>'+addObj.type+'</span><span>'+addObj.sectype+'</span><span>'+addObj.thdtype+'</span></div>'
                            +'<div class="map-add">'+addObj.add+'</div>'
                            +'</div>';*/
        /*new*/
        if (addObj.sectype == '实验室') {
            var contentHtml = '<div class="map-panel">'
                            +'<div class="map-name">'+addObj.name+'</div>'
                            +'<div class="map-add"><i class="fa fa-map-marker"></i>'+addObj.add+'</div>'
                            +'<div class="map-type"><span>'+addObj.labcategory+'</span></div>'
                            +'<div class="map_tab">'
                            +'<div class="tab-head">'
                            +'<ul><li onclick="tabSwitch(this)" class="active">基本信息</li><li onclick="tabSwitch(this)">联系方式</li></ul>'
                            +'</div>'
                            +'<div class="tab-body tab-body_change" id="tab-body">'
                            +'<ul><li>'
                            +'<p class="hehehe">实验室类型：'+addObj.labtype+'</p>'
                            +'<p class="hehehe">实验室类别：'+addObj.labcategory+'</p>'
                            +'<p>研究领域：'+addObj.filed+'</p>'
                            +'<p>主管部门：'+addObj.department+'</p>'
                            +'</li><li>'//联系方式
                            +'<p>姓名：'+addObj.linkman+'</p>'
                            +'<p>电话：'+addObj.phone+'</p>'
                            +'<p>邮箱：'+addObj.postbox+'</p>'
                            +'<p>邮政编码：'+addObj.postcode+'</p>'
                            +'<p>地址：'+addObj.add+'</p>'
                            +'</li></ul>'
                            +'</div>'
                            +'</div>'
                            //+'<div class="map_detail"><span><a href="http://221.214.94.50:81/portal/platform.htm" target="_blank">查看详情>></a></span></div>'
                            +'</div>'

        }else if (addObj.sectype=='科技成果转化') {
            var contentHtml = '<div class="map-panel">'
                            +'<div class="map-name"><a href="#">'+addObj.name+'</a></div>'
                            +'<div class="map-add"><i class="fa fa-map-marker"></i>'+addObj.add+'</div>'
                            +'<div class="map-type"><span>'+addObj.industry+'</span></div>'
                            +'<div class="map_tab">'
                            +'<div class="tab-head">'
                            +'<ul><li onclick="tabSwitch(this)" class="active">基本信息</li><li onclick="tabSwitch(this)">成果简介</li></ul>'
                            +'</div>'
                            +'<div class="tab-body tab-body_change" id="tab-body">'
                            +'<ul><li>'
                            +'<p>所属行业：'+addObj.industry+'</p>'
                            +'<p>成果第一完成单位：'+addObj.firstemployer+'</p>'
                            +'<p>成果参与完成单位：'+addObj.counterparts+'</p>'
                            +'</li><li style="height:150px;overflow:hidden">'
                            +'<div class="map-abstract" niceScroll><p>成果介绍：'+addObj.abstract+'</p></div>'
                            +'</li></ul>'
                            +'</div>'
                            +'</div>'
        }else if (addObj.sectype=='中小微') {
            var contentHtml = '<div class="map-panel">'
                            +'<div class="map-name"><a href="#">'+addObj.name+'</a></div>'
                            +'<div class="map-add"><i class="fa fa-map-marker"></i>'+addObj.add+'</div>'
                            +'<div class="map-type"><span>'+addObj.type+'</span><span>'+addObj.sectype+'</span></div>'
                            +'<div class="map_tab">'
                            +'<div class="tab-head">'
                            +'<ul><li onclick="tabSwitch(this)" class="active">基本信息</li><li onclick="tabSwitch(this)">基础设施</li></ul>'
                            +'</div>'
                            +'<div class="tab-body tab-body_change">'
                            +'<ul><li>'
                            +'<p>企业性质：'+addObj.Nature+'</p>'
                            +'</li><li>'
                            +'<p>是否省级以上孵化器：'+addObj.isfh+'</p>'
                            +'<p>是否省级以上众创空间：'+addObj.iszc+'</p>'
                            +'</li></ul>'
                            +'</div>'
                            +'</div>'
        }else if (addObj.sectype=='孵化器') {
            var contentHtml = '<div class="map-panel">'
                            +'<div class="map-name"><a href="#">'+addObj.name+'</a></div>'
                            +'<div class="map-add"><i class="fa fa-map-marker"></i>'+addObj.add+'</div>'
                            +'<div class="map-type"><span>'+addObj.fundtype+'</span></div>'
                            +'<div class="map_tab">'
                            +'<div class="tab-head">'
                            +'<ul><li onclick="tabSwitch(this)" class="active">基本信息</li><li onclick="tabSwitch(this)">基础设施</li></ul>'
                            +'</div>'
                            +'<div class="tab-body tab-body_change" id="tab-body">'
                            +'<ul><li>'
                            +'<p>基金名称：'+addObj.fundname+'</p>'
                            +'<p>基金额度：'+addObj.fundamount+'</p>'
                            +'<p>单位性质：'+addObj.nature+'</p>'
                            +'<p>是否在省级以上高新区：'+addObj.isprovince+'</p>'
                            +'</li><li>'
                            +'<p>入驻企业使用场地面积：'+addObj.enterprisearea+'</p>'
                            +'<p>公共服务场地面积：'+addObj.servicearea+'</p>'
                            +'</li></ul>'
                            +'</div>'
                            +'</div>'
        }else if (addObj.type=='机构') {
            var contentHtml = '<div class="map-panel">'
                            +'<div class="map-name"><a href="#">'+addObj.name+'</a></div>'
                            +'<div class="map-add"><i class="fa fa-map-marker"></i>'+addObj.add+'</div>'
                            +'<div class="map-type"><span>'+addObj.Nature+'</span></div>'
                            +'<div class="map_tab">'
                            +'<div class="tab-head">'
                            +'<ul><li onclick="tabSwitch(this)" class="active">基本信息</li></ul>'
                            +'</div>'
                            +'<div class="tab-body tab-body_change">'
                            +'<ul><li>'
                            +'<p>联系人姓名：'+addObj.linkman+'</p>'
                            //+'<div class="map-tel">联系电话：'+addObj.phone+'</div>'
                            +'<p>联系邮箱：'+addObj.post+'</p>'
                            +'<p>邮编：'+addObj.Postcodes+'</p>'
                            +'</li></ul>'
                            +'</div>'
                            +'</div>'
        }else if (addObj.type=='人才') {
            var contentHtml = '<div class="map-panel">'
                            +'<div class="map-name"><a href="#">'+addObj.name+'</a></div>'
                            +'<div class="map-add"><i class="fa fa-map-marker"></i>'+addObj.add+'</div>'
                            +'<div class="map-type"><span>'+addObj.type+'</span><span>'+addObj.sectype+'</span></div>'
                            +'<div class="map_tab">'
                            +'<div class="tab-head">'
                            +'<ul><li onclick="tabSwitch(this)" class="active" style="width:90px;">企业基本信息</li><li onclick="tabSwitch(this)" style="width:90px;">院士基本信息</li></ul>'
                            +'</div>'
                            +'<div class="tab-body tab-body_change" id="tab-body">'
                            +'<ul><li>'
                            +'<p class="map-acname">注册时间：'+addObj.creattime+'</p>'
                            +'<p class="map-acname">员工人数：'+addObj.count+'</p>'
                            +'<p class="map-acname">研发人员数量：'+addObj.researchcount+'</p>'
                            +'</li><li>'
                            +'<p class="map-acname">院士名称：'+addObj.acname+'</p>'
                            +'<p class="map-acname">学科领域：'+addObj.filed+'</p>'
                            +'<p class="map-workunit">工作单位：'+addObj.workunite+'</p>'
                            +'</li></ul>'
                            +'</div>'
                            +'</div>'
        }else if (addObj.type=='项目') {
            var contentHtml = '<div class="map-panel">'
                            +'<div class="map-name"><a href="#">'+addObj.name+'</a></div>'
                            +'<div class="map-add"><i class="fa fa-map-marker"></i>'+addObj.add+'</div>'
                            +'<div class="map-type"><span>'+addObj.projecttype+'</div>'
                            +'<div class="map_tab">'
                            +'<div class="tab-head">'
                            +'<ul><li onclick="tabSwitch(this)" class="active">基本信息</li><li onclick="tabSwitch(this)">项目简介</li></ul>'
                            +'</div>'
                            +'<div class="tab-body tab-body_change" id="tab-body">'
                            +'<ul><li>'
                            +'<p>单位名称：'+addObj.unit+'</p>'
                            +'<p>项目类型：'+addObj.projecttype+'</p>'
                            +'</li><li>'
                            +'<p>项目申报单位：'+addObj.declaringunit+'</p>'
                            +'<p>联合申报单位：'+addObj.jointdeclarationunit+'</p>'
                            +'<p>单位类型：'+addObj.unittype+'</p>'
                            +'</li></ul>'
                            +'</div>'
                            +'</div>'
        }
        addClickHandler(contentHtml,marker);
        ListInfoWin.push(contentHtml);
    }

    //点击标注
    function addClickHandler(content,marker){
        marker.addEventListener("click",function(e){
                openInfo(content,e)}
        );
    }
    //开启信息窗口
    var opts = {
        width : 300,     // 信息窗口宽度
        height: 280,     // 信息窗口高度
        panel : "panel", //检索结果面板
        enableAutoPan : true //自动平移

    };
    function openInfo(content,e){
        var p = e.target;
        var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
        var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象
        map.openInfoWindow(infoWindow,point); //开启信息窗口
    }
     function listOpenInfo(content,pos){
        var point = new BMap.Point(pos[0], pos[1]);
        var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象
        map.openInfoWindow(infoWindow,point); //开启信息窗口
    }
    //map.setMapStyle({style:'midnight'});
    var styleJson = [
         {
           "featureType": "all",
           "elementType": "geometry",
           "stylers": {
                     "hue": "#96aedc",
                     "saturation": 89
           }
         },
         {
           "featureType": "water",//水的颜色
           "elementType": "all",
           "stylers": {
                     "color": "#ffffff"
           }
         },
         {
            "featureType": "road",//去掉路网
            "elementType": "all",
            "stylers": {
                      "color": "#ffffff",
                      "visibility": "off"
            }
         },
         {
            "featureType": "land", //陆地颜色
            "elementType": "all",
            "stylers": {
                      "color": "#fff"
            }
         }
     ]
    map.setMapStyle({styleJson:styleJson});
    getBoundary();
    initMap();//创建和初始化地图
    bdGEO(platObj);

    function searchMap(){
        var baseList;
        switch(searchType)
        {
            case 0:
                baseList = platObj;
                break;
            case 1:
                baseList = servObj;
                break;
            case 2:
                baseList = jigouObj;
                break;
            case 3:
                baseList = userObj;
                break;
            case 4:
                baseList = projObj;
                break;
        }
        count = 0;
        map.clearOverlays();
        markerArea = $('.tab-body>ul>li').eq(searchType).find('.areaSelect').val();
        markerType = $('.tab-body>ul>li').eq(searchType).find('.typeSelect').val();
        if(!markerArea){
            markerArea = '陕西省';
        }
        if(!markerType){
            markerType = '';
        }
        var searchList = [];
        if(markerType!=""){
            for(var i = 0 ; i < baseList.length; i++){
                if(baseList[i]['sectype'] == markerType){
                    searchList.push(baseList[i]);
                }
            }
        }
        else{
            searchList = baseList;
        }
        if(markerArea!="陕西省"){
            var areaList = searchList;
            searchList = [];
            for(var j = 0 ; j < areaList.length; j++){
                if(areaList[j]['city'] == markerArea){
                    searchList.push(areaList[j]);
                }
            }
        }
        getBoundary();
        $('.result-list>ul').empty();
        bdGEO(searchList);
    }
    function searchMapType(){
        var baseList;
        switch(searchType)
        {
            case 0:
                baseList = platObj;
                break;
            case 1:
                baseList = servObj;
                break;
            case 2:
                baseList = jigouObj;
                break;
            case 3:
                baseList = userObj;
                break;
            case 4:
                baseList = projObj;
                break;
        }
        count = 0;
        map.clearOverlays();
        markerArea = $('.tab-body>ul>li').eq(searchType).find('.areaSelect').val();
        //markerType = $('.tab-body>ul>li').eq(searchType).find('.map_tabcon_con li span').html();
        console.log(markerType);
        if(!markerArea){
            markerArea = '陕西省';
        }
        if(!markerType){
            markerType = '';
        }
        var searchList = [];
        if(markerType!=""){
            for(var i = 0 ; i < baseList.length; i++){
                if(baseList[i]['sectype'] == markerType){
                    searchList.push(baseList[i]);
                }
            }
        }
        else{
            searchList = baseList;
        }
        if(markerArea!="陕西省"){
            var areaList = searchList;
            searchList = [];
            for(var j = 0 ; j < areaList.length; j++){
                if(areaList[j]['city'] == markerArea){
                    searchList.push(areaList[j]);
                }
            }
        }
        getBoundary();
        $('.result-list>ul').empty();
        bdGEO(searchList);
    }
    $('.m-select').change(function(){
        var filterType = $(this).parents('.sx-mapsearch').parent('li');
        searchType = filterType.index();
        console.log(searchType);
        searchMap();
    });
    $('.map_tabcon_con span').click(function(){
        var filterType = $(this).parents('.map_tabcon').parent('li');
        searchType = filterType.index();
        markerType=$(this).html();
        searchMapType();
        //console.log(searchType);
    });
    $('.tab-header>ul>li').click(function(){
      debugger;
        searchType = $(this).index();
        if (searchType!=0) {
          alert("暂无数据！")
        }else{
          var filterLi = $('.tab-body>ul>li').eq($(this).index());
          filterLi.find('.typeSelect').val('');
          filterLi.find('.areaSelect').val('陕西省');
          searchMap();
        }
    });
    $('.result-list').on('click','li',function(){
       var posChecked = $(this).attr('data-target').split(","),
           countChecked = $(this).index();
        listOpenInfo(ListInfoWin[countChecked],posChecked);
    });
    $('[niceScroll]').niceScroll({
        cursoropacitymin: 0.5,
        cursorcolor:"#bfebf2",
        cursorborder: '#bfebf2'
    });

 });

function tabSwitch(obj){
    var aaa = $(obj);
    var count= aaa.index();
    $('.tab-body_change').children().children().hide().eq(count).show();
    $(".tab-head ul li").eq(count).addClass("active").siblings().removeClass("active");
}
