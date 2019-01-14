
// 人员流动情况
var personFlow = echarts.init(document.getElementById('person-flow'));

option = {
    tooltip: {
        trigger: 'axis',
        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    legend: {
        data: ['迁入', '迁出'],
        bottom:"3%",
        left:"center"
    },
    grid: {
        left: '2%',
        right: '4%',
        bottom: '13%',
        top:"5%",
        containLabel: true
    },
    xAxis: [
        {
            type: 'value',
            position:"top",
        }
    ],
    yAxis: [
        {
            type: 'category',
            axisTick: { show: false },
            data: ['第一季度', '第二季度', '第三季度', '第四季度'],
            show:false
        }
    ],
    color: ["#b5adde","#52c9cd"],
    series: [
        {
            name: '迁入',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position:"inside"
                }
            },
            data: [320, 302, 341, 420]
        },
        {
            name: '迁出',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: "inside"
                }
            },
            data: [-120, -132, -101, -210]
        }
    ]
};


// 使用刚指定的配置项和数据显示图表。
personFlow.setOption(option);

// 本年度信息填报完成情况
var infoFill = echarts.init(document.getElementById('info-fill'));

option = {
    title: {
        bottom: '1%',
        left: 'center',
        subtext: '本年度信息填报完成度：50%',
        subtextStyle: {
            color: '#666',
            fontSize: 14
        }
    },
    grid:{
        top:"5%",
        bottom:"10%"
    },
    series: [{
        type: 'liquidFill',
        radius: '75%',
        center:['50%','45%'],
        data: [0.5],
        label: {
            normal: {
                textStyle: {
                    color: '#fff',
                    insideColor: '#fff',
                    fontSize: 18
                }
            }
        },
        outline: {
            itemStyle: {
                borderColor: '#365da2',
                borderWidth: 4
            },
            borderDistance: 6
        }
    },
    ]
}
// 使用刚指定的配置项和数据显示图表。
infoFill.setOption(option);

// 人员年龄占比
var persoAge = echarts.init(document.getElementById('person-age'));
option = {
    calculable: true,
    tooltip: {},
    series: [
        {
            name: '人员年龄占比',
            type: 'pie',
            radius: [20, 130],
            center: ['50%', '50%'],
            roseType: 'radius',
            label: {
                normal: {
                    show: false
                },
                emphasis: {
                    show: false,
                    color: "#333"
                }
            },
            lableLine: {
                normal: {
                    show: false
                },
                emphasis: {
                    show: false,
                    lineStyle: {
                        color: "#333"
                    }
                }
            },
            data: [
                { value: 1, name: '25-35', itemStyle: { color: "#8794ae" } },
                { value: 2, name: '35-45', itemStyle: { color: "#e0c34f" } },
                { value: 3, name: '45-55', itemStyle: { color: "#9acb59" } },
                { value: 4, name: '55-65', itemStyle: { color: "#9d8685" } },
                { value: 5, name: '65以上', itemStyle: { color: "#e573a7" } },
            ]
        }
       
    ]
};
// 使用刚指定的配置项和数据显示图表。
persoAge.setOption(option);

// 历年承担项目、项目经费、人才培养情况
var protaInfo = echarts.init(document.getElementById('protal-info'));
option = {
    tooltip: {
        trigger: 'axis',
        confine:true,
        axisPointer: {
            // type: 'cross',
            label: {
                backgroundColor: '#6a7985'
            }
        }
    },
    legend: {
        data: ['西安', '铜川', '宝鸡', '咸阳', '渭南', '延安', '榆林'],
        left: 'center',
        bottom: 10,
    },
    grid: {
        left: '2%',
        right: '4%',
        bottom: '13%',
        top: "8%",
        containLabel: true
    },
    xAxis: [
        {
            type: 'category',
            boundaryGap: true,
            data: ['2010', '2011', '2012', '2013', '2014', '2015'],
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
            data: [120, 132, 101, 134, 90, 230, 210]
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
            data: [220, 182, 191, 234, 290, 330, 310]
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
            data: [150, 232, 201, 154, 190, 330, 410]
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
            data: [320, 332, 301, 334, 390, 330, 320]
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
            data: [820, 932, 901, 934, 1290, 1330, 1320]
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
            data: [820, 932, 901, 934, 1290, 1330, 1320]
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
            data: [820, 932, 901, 934, 1290, 1330, 1320]
        }
    ]
};

// 使用刚指定的配置项和数据显示图表。
protaInfo.setOption(option);

// 历年获得研究成果情况
var fruitInfo = echarts.init(document.getElementById('fruit-info'));
var fundAnlysisXData = ['2013年', '2014年', '2015年', '2016年', '2017年', '2018年'];
var fundAnlysisYData = [50, 62, 83, 45, 110, 90];

color = (val) => {
    let color = ['#4fabd3', '#75bbd5', '#75bbd5', '#39c6c7', '#4eaad3', '#74bcd6']
    return color[val.dataIndex]
}

option = {
    title: {
        text: "历\n年\n研\n究\n成\n果",
        left: '2%',
        bottom: '9%',
        textStyle: {
            verticalAlign: "bottom",
            align: "left",
            fontWeight: "400",
            fontSize: 14
        }
    },
    grid: {
        left: '6%',
        right: '4%',
        bottom: '5%',
        top: '8%',
        containLabel: true
    },
    tooltip: {
        formatter: '{b} : {c}'
    },
    xAxis: [
        {
            type: 'category',
            data: fundAnlysisXData,
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
        }
    ],
    yAxis: [
        {
            type: 'value',
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
            axisTick: {
                show: false
            }
        }
    ],
    series: [
        {
            type: 'bar',
            barWidth: '60%',
            data: fundAnlysisYData,
            itemStyle: {
                color: (params) => {
                    return color(params)
                }
            }
        }, {
            type: 'line',
            barWidth: '60%',
            data: fundAnlysisYData,
            symbol: 'circle',
            itemStyle: {
                color: '#a3acb2'
            }
        }
    ]
};
// 使用刚指定的配置项和数据显示图表。
fruitInfo.setOption(option);