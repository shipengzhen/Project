// 地图
function sxMap(ele) {
    // 陕西省科技资源地图
    var sxmap = echarts.init(ele);
    
    option = {
        visualMap: {
            show: true,
            min: 0,
            max: 2500,
            left: 10,
            top: 1,
            realtime: false,
            calculable: true,
            inRange: {
                color: ['#e2fffc', '#96f0ff', '#4adeff', '#00c5ff', '#0099ff']
            }
        },
        tooltip: {
          padding: 0,
          confine:true,

          // enterable: true,
          // transitionDuration: 1,
          textStyle: {
              color: '#000',
              // decoration: 'none',
          },
          formatter: function(params) {
            // console.log(params)
            var tipHtml = '';
                 tipHtml = '<div class="map-tooltip">'
                        + '<div class="map-tooltip-hd">'+ params.name+ '</div>'
                        + '<div class="map-tooltip-bd">'
                        + '<ul>'
                        + '<li>高新技术产业开发区（国家级' + params.data.tipData[0] + '家、省级' + params.data.tipData[1] + '家）</li>'
                        + '<li>重点研发机构（院所' + params.data.tipData[2] + '家、高校' + params.data.tipData[3] + '家、高企' + params.data.tipData[4] + '家）</li>'
                        + '<li>重点实验室（国家级' + params.data.tipData[5] + '家、省级' + params.data.tipData[6] + '家）</li>'
                        + '<li>工程技术研究中心（国家级' + params.data.tipData[7] + '家、省级' + params.data.tipData[8] + '家）</li>'
                        + '<li>科技企业孵化器（国家级' + params.data.tipData[9] + '家、省级' + params.data.tipData[10] + '家）</li>'
                        + '<li>众创空间（国家级' + params.data.tipData[11] + '家、省级' + params.data.tipData[12] + '家）</li>'
                        + '<li>陕西省星创天地' + params.data.tipData[13] + '家</li>'
                        + '<li>科技资源统筹中心' + params.data.tipData[14] + '家</li>'
                        + '<li>农业科技园区（国家级' + params.data.tipData[15] + '家、省级' + params.data.tipData[16] + '家）</li>'
                        + '<li>陕西省临床医学研究中心' + params.data.tipData[17] + '家（国家级' + params.data.tipData[18] + '家、省级' + params.data.tipData[19] + '家）</li>'
                        + '<li>陕西省创新药物研究中心' + params.data.tipData[20] + '家</li>'
                        + '<li>创新型试点县（市、区）' + params.data.tipData[21] + '家</li>'
                        + '<li>技术市场交易额' + params.data.tipData[22] + '亿元</li>'
                        + '<li>专利授权' + params.data.tipData[23] + '件</li>'
                        + '<li>R&D人员' + params.data.tipData[24] + '人年（2016年），院士' + params.data.tipData[25] + '人</li>'
                        + '<li>R&R&D经费支出' + params.data.tipData[26] + '亿元、R&D/GDP' + params.data.tipData[27] + '%(2016年)</li>'
                        + '<li>R&本级财政科技支出' + params.data.tipData[28] + '亿元、占财政增支出' + params.data.tipData[29] + '%（2016年）</li>'
                        + '<li>R&规上工业企业R&D经费支出占号主营业务收入' + params.data.tipData[30] + '%（2016年）</li>'
                        + '</ul>'
                        + '</div>'
                        + '</div>';
                return tipHtml;
            },
            position:[220,20],
        },
        series: [{
            name: '',
            type: 'map',
            map: '陕西',
            zoom: "0.8",
            left: "0%",
            top: '0%',
            itemStyle: {
                normal: {
                    label: {
                        show: true
                    }
                },
                emphasis: {
                    label: {
                        show: true
                    }
                }
            },
            data:[{
            name: "榆林市",
            value: 322,
            tipData:[1,1,51,31,899,11,55,12,12,0,0,22,34,7,2,1,2,
           22,0,0,0,11,'5551.74',15022,59123,51,'225','2.21',14.00,'3.01','1.00',]
        }, {
            name: "延安市",
            value: 2111,
            tipData:[1,1,71,81,1840,22,127,23,20,0,0,58,49,8,3,1,4,
            35,0,0,5,13,'851.74',25042,69159,63,'525.56','5.20',24.76,'5.26','2.07',]
        }, {
            name: "铜川市",
            value: 1111,
            tipData:[0,0,12,32,777,11,12,13,20,0,0,58,44,1,1,0,0,
            3,0,0,1,10,'654.12',23222,12324,23,'213','4',22,'2','2',]
        },
        {
            name: "咸阳市",
            value: 2013,
            tipData:[0,1,71,0,675,11,127,23,20,0,0,58,49,8,3,1,4,
            35,0,0,5,13,'654.12',23222,12324,23,'213','4',22,'2','2',]
        }, {
            name: "渭南市",
            value: 200,
            tipData:[0,1,31,12,233,21,67,22,15,0,0,58,49,8,3,1,4,
            35,0,0,5,13,'5551.74',15022,59123,51,'225','2.21',14.00,'3.01','1.00',]
        }, {
            name: "宝鸡市",
            value: 1411,
            tipData:[0,0,56,44,245,20,34,14,20,0,0,55,22,1,2,0,2,
            23,0,0,3,12,'234',12314,53633,23,'321','2',12,'4','1',]
        },
        {
            name: "西安市",
            value: 113,
            selected: true,
            tipData:[1,1,71,81,1840,22,127,23,20,0,0,58,49,8,3,1,4,
            35,0,0,5,13,'851.74',25042,69159,63,'525.56','5.20',24.76,'5.26','2.07',]
        }, {
            name: "商洛市",
            value: 1111,
            tipData:[0,0,34,54,1111,22,432,11,20,0,0,58,49,8,3,1,4,
            35,0,0,3,12,'234',12314,53633,23,'321','2',12,'4','1',]
        }, {
            name: "汉中市",
            value: 1300,
            tipData:[1,0,70,33,123,2,12,3,2,0,0,8,32,8,3,1,4,
            35,0,0,5,13,'851.74',23222,12324,23,'213','4',22,'5.26','2.07',]
        },
        {
            name: "安康市",
            value: 100,
            tipData:[0,1,7,32,155,11,76,11,12,0,0,33,33,8,3,1,4,
            35,0,0,5,13,'332',12334,43255,63,'324','2',24.76,'2','1',]
        }
    ]
        }]
    }
    // 使用刚指定的配置项和数据显示图表。
    sxmap.setOption(option);
    sxmap.on('click', function (params) {
        window.open("../map/map")
        // window.location.href="../map/map.html"
    });

}
// 实验室分布
function labDist(ele) {
    var myChart = echarts.init(ele);
    var xName = ['2014年', '2015年', '2016年', '2017年', '2018年'];
    var yName = ['西安市', '铜川市', '宝鸡市', '咸阳市', '渭南市', '延安市', '汉中市', '榆林市', '安康市', '商洛市', '杨凌示范区'];
    var data = [
        [25, 25, 25, 25, 25],
        [12, 12, 12, 12, 12],
        [21, 21, 21, 21, 21],
        [12, 12, 12, 12, 12],
        [5, 5, 5, 5, 5],
        [12, 12, 12, 12, 12],
        [18, 18, 18, 18, 18],
        [9, 9, 9, 9, 9],
        [14, 14, 14, 14, 14],
        [10, 10, 10, 10, 10],
        [17, 17, 17, 17, 17]
    ];
    option = {

        color: ['#f4d769', '#aeb6c2', '#f19fa0', '#fec9a2', '#66c9eb', '#cdbbde', '#55d8d2'],
        tooltip: {
            trigger: 'axis',
            confine:true
            //formatter: "{b} <br> 合格率: {c}%"
        },

        legend: {
            data: yName,
            x: 'center',
            y: 'bottom',
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '24%',
            top: '8%',
            containLabel: true
        },

        xAxis: {

            type: 'category',
            axisTick: {
                show: false
            },
            boundaryGap: true,
            data: xName,
            axisLine: {
                show: true,
                lineStyle: {
                    color: '#75bbd5',
                    width: 2, //这里是坐标轴的宽度
                }
            },
        },
        yAxis: {

            type: 'value',
            max: '40',
            axisLine: {
                show: true,
                lineStyle: {
                    color: '#75bbd5',
                    width: 2, //这里是坐标轴的宽度
                }
            },
        },
        series: [{
                name: yName[0],
                // symbol:'circle',
                smooth: true,
                type: 'line',
                areaStyle: {
                    normal: {
                        opacity: "0.6",
                    }
                },
                data: data[0],
            },
            {
                name: yName[1],
                smooth: true,
                type: 'line',
                areaStyle: {
                    normal: {
                        opacity: "0.6",
                    }
                },
                data: data[1],
            },
            {
                name: yName[2],
                smooth: true,
                type: 'line',
                areaStyle: {
                    normal: {
                        opacity: "0.6",
                    }
                },
                data: data[2],
            },
            {
                name: yName[3],
                type: 'line',
                smooth: true,
                areaStyle: {
                    normal: {
                        opacity: "0.6",
                    }
                },
                data: data[3],
            }, {
                name: yName[4],
                smooth: true,
                type: 'line',
                areaStyle: {
                    normal: {
                        opacity: "0.6",
                    }
                },
                data: data[4],
            }, , {
                name: yName[5],
                smooth: true,
                type: 'line',
                areaStyle: {
                    normal: {
                        opacity: "0.6",
                    }
                },
                data: data[5],
            }, , {
                name: yName[6],
                smooth: true,
                type: 'line',
                areaStyle: {
                    normal: {
                        opacity: "0.6",
                    }
                },
                data: data[6],
            },
            , {
                name: yName[7],
                smooth: true,
                type: 'line',
                areaStyle: {
                    normal: {
                        opacity: "0.6",
                    }
                },
                data: data[7],
            },
            , {
                name: yName[8],
                smooth: true,
                type: 'line',
                areaStyle: {
                    normal: {
                        opacity: "0.6",
                    }
                },
                data: data[8],
            },
            , {
                name: yName[9],
                smooth: true,
                type: 'line',
                areaStyle: {
                    normal: {
                        opacity: "0.6",
                    }
                },
                data: data[9],
            },
            , {
                name: yName[10],
                smooth: true,
                type: 'line',
                areaStyle: {
                    normal: {
                        opacity: "0.6",
                    }
                },
                data: data[10],
            },
            {
                name: yName[11],
                smooth: true,
                type: 'line',
                areaStyle: {
                    normal: {
                        opacity: "0.6",
                    }
                },
                data: data[11],
            },
        ]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    };


};
// 人才培养检测
function cultivation(ele) {
    var myChart = echarts.init(ele);
    var dataAxis = ['在读博士生数', '在读硕士生数', '毕业博士生数', '毕业硕士生数'];
    var xData = ['西安', '铜川','宝鸡', '咸阳', '渭南', '延安','汉中', '榆林', '安康', '商洛', '杨凌'];
    var data = [
        [121, 41, 12, 21, 24, 21, 41, 24, 21, 24, 31],
        [211, 121, 42, 64, 32, 32, 36, 13, 74, 64, 81],
        [541, 132, 12, 52, 23, 45, 13, 52, 13, 51, 72],
        [2141, 421, 121, 114, 421, 124, 241, 121, 241, 124, 83]

    ];
    option = {
        backgroundColor: "#ffffff",
        color: ["#ffc900", "#4faad3", "#a57eff", "#00c0ff", "#ffa226", "#ff6f6c", "#c7e207"],
        legend: {
            data: dataAxis,
            x: 'center',
            y: 'bottom',
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        grid: {
            left: '1%',
            right: '4%',
            bottom: '18%',
            top: '8%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            data: xData,
            axisLabel: {
                // interval:0,
                // rotate:20
            },
            axisTick: {
                alignWithLabel: true
            }
        }],
        yAxis: [{
            max: '5000',
            type: 'value'
        }],
        series: [{
                name: dataAxis[0],
                type: 'bar',
                stack: '总量',
                barWidth: '70%',
                data: data[0],
            },
            {
                name: dataAxis[1],
                type: 'bar',
                stack: '总量',
                barWidth: '70%',
                data: data[1],
            },
            {
                name: dataAxis[2],
                type: 'bar',
                stack: '总量',
                barWidth: '70%',
                data: data[2],
            },
            {
                name: dataAxis[3],
                type: 'bar',
                stack: '总量',
                barWidth: '70%',
                data: data[3],
            },
            {
                name: dataAxis[4],
                type: 'bar',
                stack: '总量',
                barWidth: '70%',
                data: data[4],
            },
            {
                name: dataAxis[5],
                type: 'bar',
                stack: '总量',
                barWidth: '70%',
                data: data[5],
            },
            {
                name: dataAxis[6],
                type: 'bar',
                stack: '总量',
                barWidth: '70%',
                data: data[6],
            },
        ]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    };
};
//实验室学科领域分布
function ambit(ele) {
    var myChart = echarts.init(ele);
    var leiData = ['2014', '2015', '2016', '2017', '2018'];
    var xName = ['数理科学部', '化学科学部', '生命科学部', '铜地球科学部川', '工程与材料科学部', '信息科学部', '管理科学部', '医学科学部'];
    var data = [
        [20, 21, 7, 10, 21, 12, 18, 21],
        [20, 21, 7, 10, 21, 12, 18, 21],
        [20, 21, 7, 10, 40, 12, 18, 21],
        [22, 21, 7, 10, 41, 12, 18, 21],
        [23, 21, 7, 10, 43, 12, 18, 21]
    ];
    option = {

        baseOption: {
            timeline: {
                data: leiData, //第一个数据空白很重要
                axisType: 'category',
                show: true,
                autoPlay: true,
                playInterval: 1500,
                symbolSize: 10,
                lineStyle: {
                    width: 1,
                    color: '#999'
                },
                label: {
                    fontSize: 12,
                    color: '#666',

                },
                controlStyle: {
                    showPlayBtn: true,
                    showPrevBtn: true,
                    showNextBtn: true,
                    itemSize: 20,
                    itemGap: 8,
                    normal: {
                        color: '#999',
                        borderColor: '#999',
                    }
                },
                checkpointStyle: {
                    symbolSize: 13,
                    color: '#f13e5a',
                    borderColor: 'rgba(241,62,90,0.6)'
                }
            },
            color: ['#249cf9'],

            tooltip: {
                'trigger': 'axis'
            },

            calculable: true,
            grid: {
                left: '3%',
                right: '3%',
                bottom: '13%',
                top: '8%',
                containLabel: true
            },
            label: {
                normal: {
                    textStyle: {
                        color: '#fff'
                    }
                }
            },
            "xAxis": [{
                "type": "category",
                "axisLine": {
                    lineStyle: {
                        color: 'rgba(101,124,168,0.3)',
                    }
                },
                "splitLine": {
                    "show": false,
                    lineStyle: {
                        color: 'rgba(101,124,168,0.1)',
                    }
                },
                "axisTick": {
                    "show": false
                },
                "splitArea": {
                    "show": false
                },
                "axisLabel": {
                    show:false,
                    "interval": 0,
                    textStyle: {
                        fontSize: 12,
                        color: '#657ca8',
                    }
                },
                "data": xName,
            }],
            yAxis: [{
                type: 'value',
                name: '',
                min: 0,
                max: 50,
                position: 'left',
                "axisTick": {
                    "show": false
                },
                axisLine: {
                    lineStyle: {
                        color: 'rgba(101,124,168,0.1)'
                    }
                },
                "splitLine": {
                    "show": true,
                    lineStyle: {
                        color: 'rgba(101,124,168,0.1)',
                    }
                },
                axisLabel: {
                    formatter: '{value} ',
                    textStyle: {
                        color: '#657ca8',
                    }
                }
            }],
            series: [{

                'type': 'bar',
                barGap: "10%",
                barWidth: '30%',
            }]
        },
        options: [{
            title: {
                'text': ''
            },
            series: [{
                'data': data[0]
            }]
        }, {
            title: {
                'text': ''
            },
            series: [{
                'data': data[1]
            }]
        }, {
            title: {
                'text': ''
            },
            series: [{
                'data': data[2]
            }]
        }, {
            title: {
                'text': ''
            },
            series: [{
                'data': data[3]
            }]
        }, {
            title: {
                'text': ''
            },
            series: [{
                'data': data[4]
            }]
        }, ]
    };


    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    };
    myChart.on('click', function (params) {
        window.open("../laboratory/platform.html")
    });
};
// 设备总值分析
function equipment(ele) {

    var myChart = echarts.init(ele);
    var yName = ['2014年', '2015年', '2016年', '2017年', '2018年'];
    var xName = ['西安', '铜川', '宝鸡', '咸阳', '渭南', '延安', '汉中', '榆林', '安康', '商洛', '杨凌'];
    var data = [
        [571, 739, 891, 1177, 1245, 1367, 2051, 2200,2300, 2553, 2600],
        [899, 990, 1990, 2011, 2100, 2141, 2300, 2381, 2500, 2521, 2799],
        [988, 811, 1000, 1588, 1778, 2112, 2199, 2281, 2324, 2612, 2501],
        [300, 823, 1009, 1639, 1781, 1891, 2399, 2891, 2921, 2977,3000 ],
        [317, 830, 1100, 1800, 1890, 2400, 2581, 2900, 3358, 3467.5, 3521]
    ];
    option = {
        color: ['#ff872d', '#e70219', '#004c7e', '#37d616', '#d006f7'],
        tooltip: {
            trigger: 'axis',
            confine:true
        },

        legend: {
            data: yName,

        },
        grid: {
            left: '2%',
            right: '6%',
            bottom: '4%',
            top: '20%',
            containLabel: true
        },

        xAxis: {
            type: 'category',
            axisTick: {
                show: false
            },
            boundaryGap: false,
            data: xName,
            axisLine: {
                show: true,
                lineStyle: {
                    color: '#75bbd5',
                    width: 2, //这里是坐标轴的宽度
                }
            },
        },
        yAxis: {
            type: 'value',
            max: '4000',
            axisLabel: {
                formatter: '{value}万',
            },
            axisLine: {
                show: true,

                lineStyle: {
                    color: '#75bbd5',
                    width: 2, //这里是坐标轴的宽度
                }
            },
        },
        series: [{
                name: yName[0],
                symbol: 'rect',
                type: 'line',

                data: data[0],
            },
            {
                name: yName[1],
                symbol: 'roundRect',
                type: 'line',

                data: data[1],
            },
            {
                name: yName[2],
                symbol: 'triangle',
                type: 'line',
                data: data[2],
            },
            {
                name: yName[3],
                type: 'line',
                symbol: 'diamond',
                data: data[3],
            }, {
                name: yName[4],
                symbol: 'arrow',
                type: 'line',
                data: data[4],
            }

        ]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    };
};
//实验室区域分布
function geographical(ele) {
    var myChart = echarts.init(ele);
    var valueData = [{
            value: 12,
            name: '数理科学部'
        },
        {
            value: 9,
            name: '化学科学部'
        },
        {
            value: 3,
            name: '生命科学部'
        },
        {
            value: 5,
            name: '地球科学部'
        },
        {
            value: 18,
            name: '工程与材料科学部'
        },
        {
            value: 5,
            name: '信息科学部'
        },
        {
            value: 2,
            name: '管理科学部'
        },
        {
            value: 1,
            name: '医学科学部'
        }
    ];
    option = {

        color: ['#45dbf7', '#44aff0', '#f69846', '#f6d54a'],
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)",
            confine:true
        },

        calculable: true,
        series: [{

            type: 'pie',
            radius: ['40%', '55%'],
            center: ['50%', '50%'],
            roseType: 'area',
            labelLine: {
                normal: {
                    length: 3,
                    length2: 12
                }
            },
            data: valueData,
        }]
    };

    // hideLoading() echarts加载完数据后,隐藏加载动画
    myChart.hideLoading();
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    };
}
//实验室成果分布
function labResults(ele) {
    var myChart = echarts.init(ele);


    option = {
        "normal": {
            "top": 200,
            "left": 300,
            "width": 500,
            "height": 400,
            "zIndex": 6,
            "backgroundColor": ""
        },
        "color": ["rgba(245, 166, 35, 1)", "rgba(19, 173, 255, 1)"],
        "tooltip":  { 
            confine:true,
            show:true,
            trigger: 'item',
     },

        "radar": {
            "center": ["50%", "50%"],
            "radius": "60%",
            "startAngle": 90,
            "splitNumber": 4,
            "shape": "circle",
            "splitArea": {
                "areaStyle": {
                    "color": ["transparent"]
                }
            },
            "axisLabel": {
                "show": false,
                "fontSize": 18,
                "color": "#fff",
                "fontStyle": "normal",
                "fontWeight": "normal"
            },
            "axisLine": {
                "show": true,
                "lineStyle": {
                    "color": "grey" //
                }
            },
            "splitLine": {
                "show": true,
                "lineStyle": {
                    "color": "grey" //
                }
            },
            "indicator": [{
                "name": "西安",
                "max": 88
            }, {
                "name": "咸阳",
                "max": 88
            }, {
                "name": "宝鸡",
                "max": 88
            }, {
                "name": "渭南",
                "max": 88
            }, {
                "name": "延安",
                "max": 88
            }, {
                "name": "榆林",
                "max": 88
            }, {
                "name": "汉中",
                "max": 88
            }, {
                "name": "安康",
                "max": 88
            }, {
                "name": "商洛",
                "max": 88
            }, {
                "name": "铜川",
                "max": 88
            }, {
                "name": "杨凌",
                "max": 88
            }]
        },
        "series": [{
            "name": "",
            "type": "radar",
            "symbol": "circle",
            "symbolSize": 10,
            "itemStyle": {
                "normal": {
                    color: 'rgba(19, 173, 255, 1)',
                    "borderColor": "rgba(19, 173, 255, 0.4)",
                    "borderWidth": 10
                }
            },
            "areaStyle": {
                "normal": {
                    "color": "rgba(19, 173, 255, 0.5)"
                }
            },
            "lineStyle": {
                "normal": {
                    "color": "rgba(19, 173, 255, 1)",
                    "width": 2,
                    "type": "dashed"
                }
            },
            "data": [
                [60, 60, 65, 60, 70, 40,39,59, 80, 63, 68, 60, 77, 60, 80, 62, 80]
            ]
        }]
    };

    // hideLoading() echarts加载完数据后,隐藏加载动画
    myChart.hideLoading();
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    };
}
//实验室成功转化率
function labAlarming(ele) {
    var labAgeWarn = echarts.init(ele);
    var hideStyle = {
        normal: {
            color: '#fff', //未完成的圆环的颜色
            label: {
                show: false
            },
            labelLine: {
                show: false
            }
        },
        emphasis: {
            show: false
        }
    };
    var option = {
        tooltip: {
            formatter:'{a}<br>{c}%'
        },
        legend: {
        // orient: 'vertical',
        left:'center',
        bottom:0,
        data:['数理科学部','化学科学部','生命科学部','地球科学部',
        '工程与材料科学部','信息科学部','管理科学部','医学科学部']
         },
        color: ['#ea747a', '#ffb57b', '#0bb3f1', '#b9a0dd', '#00cacc'],
        series: [{
                name: '数理科学部',
                type: 'pie',
                clockWise: false, //顺时针
                radius: [100, 110],
                label: {
                    normal: {
                        show: false,
                        position: 'inside'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                hoverAnimation: false,
                data: [{
                    value: 13,
                    name: '数理科学部'
                }, {
                    value: 87,
                    show: false,
                    itemStyle: hideStyle
                }]
            }, {
                name: '化学科学部',
                type: 'pie',
                clockWise: false, //顺时针
                radius: [90, 100],
                label: {
                    normal: {
                        show: false,
                        position: 'inside'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                hoverAnimation: false,
                data: [{
                    value: 15,
                    name: '化学科学部'
                }, {
                    value: 85,
                    show: false,
                    itemStyle: hideStyle
                }]
            }, {
                name: '生命科学部',
                type: 'pie',
                clockWise: false, //顺时针
                radius: [80, 90],
                label: {
                    normal: {
                        show: false,
                        position: 'inside'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                hoverAnimation: false,
                data: [{
                    value: 6,
                    name: '生命科学部'
                }, {
                    value: 94,
                    show: false,
                    itemStyle: hideStyle
                }]
            }, {
                name: '地球科学部',
                type: 'pie',
                clockWise: false, //顺时针
                radius: [70, 80],
                label: {
                    normal: {
                        show: false,
                        position: 'inside'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                hoverAnimation: false,
                data: [{
                    value: 21,
                    name: '地球科学部'
                }, {
                    value: 79,
                    show: false,
                    itemStyle: hideStyle
                }]
            },
            {
                name: '工程与材料科学部',
                type: 'pie',
                clockWise: false, //顺时针
                radius: [60, 70],
                label: {
                    normal: {
                        show: false,
                        position: 'inside'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                hoverAnimation: false,
                data: [{
                    value: 43,
                    name: '工程与材料科学部'
                }, {
                    value: 57,
                    show: false,
                    itemStyle: hideStyle
                }]
            },
            {
                name: '信息科学部',
                type: 'pie',
                clockWise: false, //顺时针
                radius: [50, 60],
                label: {
                    normal: {
                        show: false,
                        position: 'inside'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                hoverAnimation: false,
                data: [{
                    value: 20,
                    name: '信息科学部'
                }, {
                    value: 80,
                    show: false,
                    itemStyle: hideStyle
                }]
            },
            {
                name: '管理科学部',
                type: 'pie',
                clockWise: false, //顺时针
                radius: [40, 50],
                label: {
                    normal: {
                        show: false,
                        position: 'inside'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                hoverAnimation: false,
                data: [{
                    value: 17,
                    name: '管理科学部'
                }, {
                    value: 83,
                    show: false,
                    itemStyle: hideStyle
                }]
            },
            {
                name: '医学科学部',
                type: 'pie',
                clockWise: false, //顺时针
                radius: [30, 40],
                label: {
                    normal: {
                        show: false,
                        position: 'inside'
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                hoverAnimation: false,
                data: [{
                    value: 56,
                    name: '医学科学部'
                }, {
                    value: 44,
                    show: false,
                    itemStyle: hideStyle
                }]
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    labAgeWarn.setOption(option);
}

//项目领域
function expertise(ele) {
    var projectField = echarts.init(ele);
    var projectFielddata = [{
            name: "数理科学部",
            value: 78
        },
        {
            name: "化学科学部",
            value: 53
        },
        {
            name: "生命科学部",
            value: 62
        },
        {
            name: "地球科学部",
            value: 83
        },
        {
            name: "工程与材料科学部",
            value: 81
        },
        {
            name: "信息科学部",
            value: 59
        },
        {
            name: "管理科学部",
            value: 60
        },
        {
            name: "医学科学部",
            value: 56
        }
    ];
    option = {
        tooltip: {
            confine:true
        },
        //  color: ['#bba3de', '#7aaee3', '#ffb47f', '#e38080', '#8794ae', '#e0c34f', '#9ac95a', '#9d8685', '#e573a7'],
        series: [{
            type: 'pie',
            radius: '50%',
            data: projectFielddata,
            center: ["50%", "50%"],
            roseType: 'area',
            labelLine: {
                normal: {
                    show: false
                }
            },
            label: {
                normal: {
                    show: false
                }
            },
            itemStyle: {
                 color: "#58d2d4",
                borderColor: "#fafbfb"
            }
        }, {
            type: 'pie',
            data: projectFielddata,
            radius: ['60%', '85%'],
            center: ["50%", "50%"],
            zlevel: -2,
            label: {
                normal: {
                    position: 'inside',
                    color: "#333"
                }
            },
            itemStyle: {
                 color: "#fff",
                borderColor: "#a7c4c8"
            }
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    projectField.setOption(option);

}
//实验室人才
function labPut(ele) {
    var labFluid = echarts.init(ele);
    // 指定图表的配置项和数据
    var a = {
        "caName": ["西安", "铜川", "宝鸡", "咸阳", "渭南", "延安", "汉中", "榆林", "安康", "商洛", "杨凌"],
        "lgName": ["工程", "化学", "信息", "地学", "生命", "材料", "医学", "数理", "其他"],
        "data": [{
                "name": "工程",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "label": {
                            "show": false,
                            "position": "insideRight"
                        },
                    }
                },
                "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 69]
            },
            {
                "name": "化学",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "label": {
                            "show": false,
                            "position": "insideRight"
                        },
                    }
                },
                "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 59]
            },
            {
                "name": "信息",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "label": {
                            "show": false,
                            "position": "insideRight"
                        },
                    }
                },
                "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 49]
            },
            {
                "name": "地学",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "label": {
                            "show": false,
                            "position": "insideRight"
                        }
                    }
                },
                "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 39]
            },
            {
                "name": "生命",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "label": {
                            "show": false,
                            "position": "insideRight"
                        },
                    }
                },
                "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 40]
            },
            {
                "name": "材料",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "label": {
                            "show": false,
                            "position": "insideRight"
                        },
                    }
                },
                "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 30]
            },
            {
                "name": "医学",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "label": {
                            "show": false,
                            "position": "insideRight"
                        },
                    }
                },
                "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 30]
            },
            {
                "name": "数理",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "label": {
                            "show": false,
                            "position": "insideRight"
                        },
                    }
                },
                "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 40]
            },
            {
                "name": "其他",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "label": {
                            "show": false,
                            "position": "insideRight"
                        },
                    }
                },
                "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 56]
            }

        ],
        "max": 74263
    };
    // c = JSON.parse(a);
    option = {
        tooltip: {
            trigger: "axis",
            confine:true,
            axisPointer: {
                type: "shadow"
            }
        },
        color: ["#edce1d", "#8897b2", "#ea747a", "#ffb57b", "#b9a0dd", "#00cacc", "#0bb3f1"],
        backgroundColor: "#fff",
        grid: {
            top: "4%",
            right: "10%",
            left: "18%",
            bottom: "10%",
            borderWidth: 0
        },
        calculable: !1,
        xAxis: [{
            type: "value",
            axisLine: {
                lineStyle: {
                    color: "#9dc8cb",
                    width: 1
                }
            },
            splitLine: {
                lineStyle: {
                    color: "#9dc8cb",
                    width: 1
                }
            },
            axisTick: {
                show: !0
            },
            nameTextStyle: {
                color: "#e4e4e4"
            },
            axisLabel: {
                textStyle: {
                    color: "#333",
                    fontFamily: "Microsoft yahei"
                }
            },
            // max: a.max,
            splitArea: {
                show: !1
            },
            splitLine: {
                show: !1
            }
        }],
        yAxis: [{
            type: "category",
            axisLine: {
                lineStyle: {
                    color: "#9dc8cb",
                    width: 1
                }
            },
            axisLabel: {
                formatter: function (a) {
                    for (i in a)
                        return a.length > 5 ? a.substring(0, 4) + ".." : a
                },
                textStyle: {
                    color: "#333",
                    fontFamily: "Microsoft yahei"
                }
            },
            axisTick: {
                show: !1
            },
            splitArea: {
                show: !1
            },
            splitLine: {
                show: !1
            },
            data: a.caName
        }],
        series: a.data,
        noDataLoadingOption: {
            text: "暂无数据",
            effect: "whirling"
        }
    }


    // 使用刚指定的配置项和数据显示图表。
    labFluid.setOption(option);

}
// 各区域项目经费投入情况趋势
function labSpend(ele) {
    var projecFund = echarts.init(ele);
    //myChart.showLoading();
    var colorList = {
        type: 'linear',
        x: 0,
        y: 0,
        x2: 0,
        y2: 1,
        colorStops: [{
            offset: 0,
            color: '#06DBF5' // 0% 处的颜色
        }, {
            offset: 1,
            color: '#00d386' // 100% 处的颜色
        }],
        globalCoord: false // 缺省为 false
    }
    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
                type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            top: "7%",
            left: '2%',
            right: '4%',
            bottom: '2%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: ['西安市', '咸阳市', '宝鸡市', '铜川市', '渭南市',
                '延安市', '榆林市', '汉中市', '安康市', '商洛市', '杨凌示范区'
            ],
            // axisTick: {
            //     alignWithLabel: true
            // }
            axisLine: {
                lineStyle: {
                    color: '#7ba9ae'

                }
            },
            axisLabel: {
                // show:'false',
                // interval: 0,
                // rotate: 40,
                 interval: 0,  
                   formatter:function(value)  
                   {  
                       return value.split("").join("\n");  
                   },
                textStyle: {
                    fontFamily: 'Microsoft YaHei',
                    color: "#333"
                }
            },
        },

        yAxis: {
            type: 'value',
            axisLine: {
                // show: false,
                lineStyle: {
                    color: '#7ba9ae'
                }

            },
            splitLine: {
                show: true,
                lineStyle: {
                    color: 'rgba(255,255,255,0.3)'
                }
            },
            axisLabel: {
                textStyle: {
                    fontFamily: 'Microsoft YaHei',
                    color: "#333"
                }
            }
        },

        series: [{
            name: '',
            type: 'bar',
            barWidth: '40%',
            itemStyle: {
                color: function (params) {
                    return colorList;
                },
            },
            data: [1200, 1000, 800, 800, 600, 600, 600, 577, 2000, 1760,577, ]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    projecFund.setOption(option);
}

// 人员整体流动率
function turnover(ele) {
    var labFluid = echarts.init(ele);
    option = {
        title: {
            text: '80%',
            subtext: "流动率",
            x: 'center',
            y: 'center',
            textStyle: {
                fontWeight: 'normal',
                color: '#000000',
                fontSize: '30'
            },
            subtextStyle: {
                color: '#000000',
                fontSize: '20'
            }
        },
        color: ['#a9a9a9'],
        tooltip: {
            show: false,
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        series: [{
            name: 'Line 1',
            type: 'pie',
            clockWise: true,
            radius: ['60%', '80%'],
            itemStyle: {
                normal: {
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                }
            },
            hoverAnimation: false,

            data: [{
                value: 80,
                name: '01',
                itemStyle: {
                    normal: {
                        color: "#00b9d5",
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        }
                    },
                    emphasis: {
                        color: '#00cefc' // 鼠标悬浮上去完成的圆环的颜色
                    }
                }
            }, {
                value: 20,
                name: 'invisible'
            }]
        }]
    }
    // 使用刚指定的配置项和数据显示图表。
    labFluid.setOption(option);
}
//项目经费投入分析
function proSpend(ele) {
    var labelData = ["西安", "铜川", "宝鸡", "咸阳", "渭南", "延安", "汉中", "榆林", "安康", "商洛", "杨凌"];
    var manData = [5131, 1212, 1123, 531, 761, 512, 312, 412, 532, 1121, 495];
    var womanData = [-584, -292, -123, -231, -313, -531, -331, -121, -123, -241, -322];
    var myChart = echarts.init(ele);
    option = {
        backgroundColor: '#fff',
        legend: {
            orient: 'horizontal', // 'vertical'
            x: 'center', // 'center' | 'left' | {number},
            y: 'top', // 'center' | 'bottom' | {number}
            data: [{
                    name: '项目数量',
                    textStyle: {
                        fontWeight: 'bolder',
                        padding: [10, 100, 15, 0]
                        // color:'#cccccc'
                    },

                },
                {
                    name: '横向经费(万)',
                    textStyle: {
                        fontSize: 12,
                        fontWeight: 'bolder'
                    },

                }
            ]

        },
        // tooltip（提示框组件）
        tooltip: {
            //trigger(触发类型)，可选'item','axis','none'
            trigger: 'axis',
            axisPointer: {
                //指示器类型,可选'line','shadow','cross'
                type: 'shadow'
            },
            // 自定义提示内容
            formatter: function (a) {
                var v = a[0];
                return v.name + '<br/>' + v.marker + v.seriesName + '：' + Math.abs(v.value);
            }
        },
        xAxis: [{
            type: 'value',
            min: -800,
            max: 0,
            gridIndex: 0,
            axisTick: {
                show: false,
                inside: false
            },
            axisLabel: {
                show: false
            },
            axisLine: { // Y轴轴线样式
                show: false,
                lineStyle: {
                    color: '#000',
                }
            },
            splitLine: {
                show: false
            }
        }, {
            type: 'value',
            gridIndex: 1,
            min: 0,
            max: 8000,
            axisTick: {
                show: false
            }, //是否显示刻度
            axisLine: { // Y轴轴线样式
                show: false, // 是否显示X轴
                lineStyle: {
                    color: '#000',
                }
            },
            axisLabel: {
                show: false //是否显示X轴内容
            },
            splitLine: {
                show: false
            }
        }],
        yAxis: [{
            type: 'category',
            gridIndex: 0,
            inverse: true,
            data: labelData,
            axisTick: {
                show: false
            },
            axisLabel: {
                show: false
            },
            axisLine: { // Y轴轴线样式
                show: false,
                lineStyle: {
                    color: '#000',
                }
            }
        }, {
            type: 'category',
            gridIndex: 1,
            inverse: true,
            data: labelData,
            axisTick: {
                show: false
            },
            axisLabel: {},
            axisLine: {
                show: false //是否显示轴线
            }
        }],
        grid: [{
            top: 45,
            bottom: 20,
            width: '32%',
            left: 30,
            gridIndex: 0,
        }, {
            top: 45,
            bottom: 20,
            left: '53%',
            gridIndex: 1,
        }],
        color: ['#2FACFA', '#F5A623'],
        series: [{
                name: '项目数量',
                type: 'bar',
                barWidth: '12',
                gridIndex: 0,
                itemStyle: {
                    normal: {
                        show: true,
                        color: '#5de3e1',
                        barBorderRadius: 50,
                        borderWidth: 0,
                        borderColor: '#333',
                        label: {
                            show: true,
                            position: 'left',
                            formatter: function (v) {
                                return (v.value * -1);
                            }
                        }
                    }
                },
                data: womanData
            },
            {
                name: '横向经费(万)',
                type: 'bar',
                barWidth: '12',
                xAxisIndex: 1,
                yAxisIndex: 1,
                itemStyle: {
                    normal: {
                        show: true,
                        color: '#8A3EEB',
                        barBorderRadius: 50,
                        borderWidth: 0,
                        borderColor: '#333',
                        label: {
                            show: true,
                            position: 'right',
                            formatter: function (v) {
                                return v.value;
                            }
                        }
                    }
                },
                data: manData
            }

        ]
    };
    myChart.setOption(option);
}
//点击注销返回登录页面
$(function(){

})
