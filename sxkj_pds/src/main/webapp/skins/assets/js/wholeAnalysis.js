// 陕西省实验室领域数量分布
var labDistribute = echarts.init(document.getElementById('module1'));
var data = [{
    name: '数理科学部',
    count1: 23,
    count2: 22,
    count3: 20,
    count4: 20,
    count5: 20,
},
{
    name: '化学科学部',
    count1: 21,
    count2: 21,
    count3: 21,
    count4: 21,
    count5: 21,
},
{
    name: '生命科学部',
    count1: 7,
    count2: 7,
    count3: 7,
    count4: 7,
    count5: 7,
},
{
    name: '地球科学部',
    count1: 10,
    count2: 10,
    count3: 10,
    count4: 10,
    count5: 10,
},
{
    name: '工程与材料科学部 ',
    count1: 43,
    count2: 41,
    count3: 40,
    count4: 21,
    count5: 21,
},
{
    name: '信息科学部 ',
    count1: 12,
    count2: 12,
    count3: 12,
    count4: 12,
    count5: 12,
},
{
    name: '管理科学部',
    count1: 18,
    count2: 18,
    count3: 18,
    count4: 18,
    count5: 18,
},
{
    name: '医学科学部 ',
    count1: 21,
    count2: 21,
    count3: 21,
    count4: 21,
    count5: 21,
}
]
var names = data.map(v => {
    return v.name
});
var count1 = data.map(v => {
    return v.count1
});
var count2 = data.map(v => {
    return v.count2
});
var count3 = data.map(v => {
    return v.count3
});
var count4 = data.map(v => {
    return v.count4
});
var count5 = data.map(v => {
    return v.count5
});
var count6 = data.map(v => {
    return v.count6
});
var count7 = data.map(v => {
    return v.count7
});
option = {
    barWidth: 30,
    color: ['#ffcf19', '#4aa9d5', '#a57aff', '#00bfff', '#ffa300', '#ff6e68', '#c7e400'],
    // barWidth: 50,
    tooltip: {
        trigger: 'axis',
        axisPointer: { // 坐标轴指示器，坐标轴触发有效
            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
        },
        backgroundColor: '#fff',
        extraCssText: 'box-shadow: 0px 0px 8px 0px rgba(0,0,0,0.2);',
        textStyle: {
            color: "#333",
        }
    },
    grid: {
        left: '3%',
        right: '3%',
        bottom: '6%',
        top: '8%',
        containLabel: true
    },
    legend: {
        // align: 'left',
        // position: 'left',
        left: 'center',
        bottom: 10,
        itemWidth: 18,
        itemHeight: 8,
        borderRadius: 0
    },
    xAxis: {
        type: 'category',
        axisTick: {
            show: false,
            alignWithLabel: true
        },
        splitLine: {
            lineStyle: {
                color: "#d6d6d6",
                type: "dashed"
            }
        },
        axisLine: {
            lineStyle: {
                color: "#76bcd6"
            }
        },
        axisLabel: {
            color: "#666666"
        },
        data: names
    },
    yAxis: {
        type: 'value',
        axisTick: {
            show: false,
            alignWithLabel: true
        },
        splitLine: {
            lineStyle: {
                color: "#d6d6d6",
                type: "dashed"
            }
        },
        axisLine: {
            lineStyle: {
                color: "#76bcd6"
            }
        },
        axisLabel: {
            color: "#666666"
        },
    },
    series: [{
        type: 'bar',
        name: '2018',
        stack: '总量',
        data: count1
    },
    {
        type: 'bar',
        name: '2017',
        stack: '总量',
        data: count2
    },
    {
        type: 'bar',
        name: '2016',
        stack: '总量',
        data: count3
    },
    {
        type: 'bar',
        name: '2015',
        stack: '总量',
        data: count4
    },
    {
        type: 'bar',
        name: '2014',
        stack: '总量',
        data: count5
    },
    ]
};
// 使用刚指定的配置项和数据显示图表。
labDistribute.setOption(option);


// 陕西省实验室领域数量趋势分布
var labFieldnum = echarts.init(document.getElementById('module2'));
option = {
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            // type: 'cross',
            label: {
                backgroundColor: '#6a7985'
            }
        }
    },
    legend: {
        data: ['西安', '咸阳', '宝鸡', '铜川', '渭南', '延安', '榆林', '汉中', '安康', '商洛', '杨凌示范区'],
        left: 'center',
        bottom: 10,
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '29%',
        top: "8%",
        containLabel: true
    },
    xAxis: [
        {
            type: 'category',
            boundaryGap: true,
            data: ['2014', '2015', '2016', '2017', '2018'],
            axisTick: {
                show: false,
                alignWithLabel: true
            },
            splitLine: {
                lineStyle: {
                    color: "#8ababd",
                    // type: "dashed"
                }
            },
            axisLine: {
                lineStyle: {
                    color: "#8ababd"
                }
            },
            axisLabel: {
                color: "#666666"
            },
        }
    ],
    yAxis: [
        {
            type: 'value',
            axisTick: {
                show: false,
                alignWithLabel: true
            },
            splitLine: {
                lineStyle: {
                    color: "#8ababd",
                    // type: "dashed"
                }
            },
            axisLine: {
                lineStyle: {
                    color: "#8ababd"
                }
            },
            axisLabel: {
                color: "#666666"
            },
        }
    ],
    series: [
        {
            name: '西安',
            type: 'line',
            stack: '总量',
            // symbol :"circle",
            areaStyle: {
                normal: {
                    color: "#5ae4e1"
                }
            },
            data: [25, 25, 25, 25, 25]
        },
        {
            name: '咸阳',
            type: 'line',
            stack: '总量',
            // symbol: "circle",
            areaStyle: {
                normal: {
                    color: "#d0bde4"
                }
            },
            data: [12, 12, 12, 12, 12]
        },
        {
            name: '宝鸡',
            type: 'line',
            stack: '总量',
            // symbol: "circle",
            areaStyle: {
                normal: {
                    color: "#60c8ed"
                }
            },
            data: [21, 21, 21, 21, 21]
        },
        {
            name: '铜川',
            type: 'line',
            stack: '总量',
            // symbol: "circle",
            areaStyle: {
                normal: {
                    color: "#ffcaa0"
                }
            },
            data: [12, 12, 12, 12, 12]
        },
        {
            name: '渭南',
            type: 'line',
            // symbol: "circle",
            stack: '总量',
            areaStyle: {
                normal: {
                    color: "#f29e9e"
                }
            },
            data: [5, 5, 5, 5, 5]
        },
        {
            name: '延安',
            type: 'line',
            stack: '总量',
            // symbol: "circle",
            areaStyle: {
                normal: {
                    color: "#adb5c3"
                }
            },
            data: [12, 12, 12, 12, 12]
        },
        {
            name: '榆林',
            type: 'line',
            // symbol: "circle",
            stack: '总量',
            areaStyle: {
                normal: {
                    color: "#f4d860"
                }
            },
            data: [9, 9, 9, 9, 9]
        },
        {
            name: '汉中',
            type: 'line',
            // symbol: "circle",
            stack: '总量',
            areaStyle: {
                normal: {
                    color: "#f4d860"
                }
            },
            data: [18, 18, 18, 18, 18]
        },
        {
            name: '安康',
            type: 'line',
            // symbol: "circle",
            stack: '总量',
            areaStyle: {
                normal: {
                    color: "#f4d860"
                }
            },
            data: [14, 14, 14, 14, 14]
        },
        {
            name: '商洛',
            type: 'line',
            // symbol: "circle",
            stack: '总量',
            areaStyle: {
                normal: {
                    color: "#f4d860"
                }
            },
            data: [10, 10, 10, 10, 10]
        },
        {
            name: '杨凌示范区',
            type: 'line',
            // symbol: "circle",
            stack: '总量',
            areaStyle: {
                normal: {
                    color: "#f4d860"
                }
            },
            data: [17, 17, 17, 17, 17]
        }
    ]
};

// 使用刚指定的配置项和数据显示图表。
labFieldnum.setOption(option);

// 各区域项目经费投入情况趋势
var projecFund = echarts.init(document.getElementById('module3'));
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
        top: "8%",
        left: '2%',
        right: '4%',
        bottom: '2%',
        containLabel: true
    },
    xAxis: {
        type: 'category',
        data: ['西安市', '铜川市', '宝鸡市', '咸阳市', '渭南市',
            '延安市', '汉中市', '榆林市', '安康市', '商洛市', '杨凌示范区'
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
              interval: 0,  
               formatter:function(value)  
               {  
                   return value.split("").join("\n");  
               },
            // interval: 0,
            // rotate: 40,
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
        data: [3014, 715, 187, 251, 497, 225, 311, 227, 349, 263, 267]
    }]
};

// 使用刚指定的配置项和数据显示图表。
projecFund.setOption(option);


// 学科投入指标
var module4 = echarts.init(document.getElementById('module4'));
var projectFieldtext = ['数理科学部', '化学科学部', '生命科学部', '地球科学部',
    '工程与材料科学部 ', '信息科学部 ', '管理科学部', '医学科学部 '];

var projectFielddata = [{ name: "数理科学部", value: 456 },
{ name: "化学科学部", value: 345 },
{ name: "生命科学部", value: 456 },
{ name: "地球科学部", value: 223 },
{ name: "工程与材料科学部 ", value: 334 },
{ name: "信息科学部 ", value: 345 },
{ name: "管理科学部", value: 678 },
{ name: "医学科学部 ", value: 345 },
];
option = {
    tooltip: {},
    // color: ['#bba3de', '#7aaee3', '#ffb47f', '#e38080', '#8794ae', '#e0c34f', '#9ac95a', '#9d8685', '#e573a7'],
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
module4.setOption(option);


// 区域内投入指标
var labFluid = echarts.init(document.getElementById('module5'));
// 指定图表的配置项和数据
var a = {
    "caName": ["西安市", "铜川市", "宝鸡市", "咸阳市", "渭南市", "延安市", "汉中市", "榆林市", "安康市", "商洛市", "杨凌示范区"],
    "lgName": ["工程", "化学", "信息", "地学", "生命", "材料", "医学", "数理", "其他"],
    "data": [
        {
            "name": "工程", "type": "bar", "stack": "总量",
            "itemStyle": { "normal": { "label": { "show": false, "position": "insideRight" }, } },
            "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 69]
        },
        {
            "name": "化学", "type": "bar", "stack": "总量",
            "itemStyle": { "normal": { "label": { "show": false, "position": "insideRight" }, } },
            "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 59]
        },
        {
            "name": "信息", "type": "bar", "stack": "总量",
            "itemStyle": { "normal": { "label": { "show": false, "position": "insideRight" }, } },
            "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 49]
        },
        {
            "name": "地学", "type": "bar", "stack": "总量",
            "itemStyle": { "normal": { "label": { "show": false, "position": "insideRight" } } },
            "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 39]
        },
        {
            "name": "生命", "type": "bar", "stack": "总量",
            "itemStyle": { "normal": { "label": { "show": false, "position": "insideRight" }, } },
            "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 40]
        },
        {
            "name": "材料", "type": "bar", "stack": "总量",
            "itemStyle": { "normal": { "label": { "show": false, "position": "insideRight" }, } },
            "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 30]
        },
        {
            "name": "医学", "type": "bar", "stack": "总量",
            "itemStyle": { "normal": { "label": { "show": false, "position": "insideRight" }, } },
            "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 30]
        },
        {
            "name": "数理", "type": "bar", "stack": "总量",
            "itemStyle": { "normal": { "label": { "show": false, "position": "insideRight" }, } },
            "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 40]
        },
        {
            "name": "其他", "type": "bar", "stack": "总量",
            "itemStyle": { "normal": { "label": { "show": false, "position": "insideRight" }, } },
            "data": [191, 22, 261, 11, 44, 21, 33, 22, 13, 53, 56]
        }

    ],
    "max": 74263
};
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
        top: "8%",
        right: "10%",
        left: "23%",
        bottom: "12%",
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


var dom = document.getElementById("module6");
var module6 = echarts.init(dom);
var yName = ['投入指标的松弛变量', '产出指标的松弛变量', 'depa效率值'];
var xName = ['数理\n科学部', '化学\n科学部', '生命\n科学部', '地球\n科学部',
    '工程与材料\n科学部 ', '信息\n科学部 ', '管理\n科学部', '医学\n科学部 '];
var data = [
    [3120, 32, 1101, 2134, 190, 230, 2110, 2123, 1411, 124, 41],
    [5120, 132, 101, 134, 90, 2310, 210, 123, 241, 824, 441],
    [2120, 432, 2101, 1134, 1190, 1230, 110, 523, 641, 124, 241],
];
option = {
    color: ['#ff872d', '#e70219', '#004c7e', '#37d616', '#d006f7'],
    tooltip: {
        trigger: 'axis',
        confine:true
        //formatter: "{b} <br> 合格率: {c}%"
    },

    legend: {
        data: yName,
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        top: '18%',
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
        axisLabel: {
            // interval: 0
        }
    },
    yAxis: {
        type: 'value',
        max: '10000',
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
    },
    ]
};
if (option && typeof option === "object") {
    module6.setOption(option, true);
};

// 实验室数量
var module7 = echarts.init(document.getElementById('module7'));
var valueData = [{
    value: 12,
    name: '西安市'
},
{
    value: 9,
    name: '铜川市'
},
{
    value: 3,
    name: '宝鸡市'
},
{
    value: 5,
    name: '咸阳市'
},
{
    value: 18,
    name: '渭南市'
},
{
    value: 5,
    name: '延安市'
},
{
    value: 2,
    name: '汉中市'
},
{
    value: 1,
    name: '榆林市'
},
{
    value: 5,
    name: '安康市'
},
{
    value: 2,
    name: '商洛市'
},
{
    value: 1,
    name: '杨凌示范区'
}
];
option = {

    color: ['#45dbf7', '#44aff0', '#f69846', '#f6d54a'],
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },

    calculable: true,
    series: [{
        name: '',
        type: 'pie',
        radius: '60%',
        center: ['50%', '50%'],
        labelLine: {
            normal: {
                length: 3,
                length2: 12
            }
        },
        data: valueData,
    }]
};

if (option && typeof option === "object") {
    module7.setOption(option, true);
};

// 学科发展
var module8 = echarts.init(document.getElementById('module8'));
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
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },

    calculable: true,
    series: [{
        name: '',
        type: 'pie',
        radius: ['34%', '64%'],
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

if (option && typeof option === "object") {
    module8.setOption(option, true);
};


// 区域学科
var module9 = echarts.init(document.getElementById('module9'));


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
    "tooltip": {
        "show": true,
        "trigger": "item",
        confine:true
    },

    "radar": {
        "center": ["50%", "50%"],
        "radius": "65%",
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
                "color": "grey"//
            }
        },
        "splitLine": {
            "show": true,
            "lineStyle": {
                "color": "grey"//
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
            "name": "铜川",
            "max": 88
        }, {
            "name": "商洛",
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
            [60, 60, 45, 32, 65, 60, 70, 40, 80, 63, 68, 60, 77, 60, 80, 62, 80]
        ]
    }]
};

if (option && typeof option === "object") {
    module9.setOption(option, true);
};