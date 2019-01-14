$(function(){
    // 人员流动情况
var personFlow = echarts.init(document.getElementById('module1'));

option = {
    backgroundColor: '#fff',
    tooltip: {
        trigger: 'axis',
        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    legend: {
        data: ['流出', '流入'],
        bottom: "3%",
        left: "center"
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '13%',
        top: "5%",
        containLabel: true
    },
    xAxis: [
        {
            type: 'value',
            position: "top"
        }
    ],
    yAxis: [
        {
            type: 'category',
            axisTick: { show: false },
            data: ['第一季度', '第二季度', '第三季度', '第四季度'],
            show: false
        }
    ],
    color: ["#b5adde", "#52c9cd"],
    series: [
        {
            name: '流入',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: "inside"
                }
            },
            data: [320, 302, 341, 374]
        },
        {
            name: '流出',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: "inside"
                }
            },
            data: [-120, -132, -101, -134]
        }
    ]
};


// 使用刚指定的配置项和数据显示图表。
personFlow.setOption(option);


// 人员流动情况
var module2 = echarts.init(document.getElementById('module2'));
var angle = [220, -40],
    curVal = 67.8;
var option = {
    backgroundColor: '#fff',
    tooltip: {
        show: false,
        formatter: "{a} <br/>{b} : {c}%"
    },
    series: [{
        name: '最外层环仪表盘',
        type: "gauge",
        min: 0,
        max: 100,
        startAngle: angle[0],
        center: ["50%", "60%"],
        endAngle: angle[1],
        splitNumber: 20,
        axisLine: {
            lineStyle: {
                color: [
                    [1, "#c1c3c5"]
                ],
                width: 4
            }
        },
        axisTick: {
            lineStyle: {
                color: "#fff",
                width: 2
            },
            length: 0,
            splitNumber: 1
        },
        axisLabel: {
            distance: -40,
            formatter: function (v) {
                if (v == 60) {
                    return '{a|' + v + '}';
                } else if (v == 85) {
                    return '{b|' + v + '}';
                } else {
                    return v;
                };
            },
            textStyle: {
                color: "#bbb"
            },
            rich: {
                a: {
                    color: '#fbe010'
                },
                b: {
                    color: '#3fa7dc'
                }
            }
        },
        splitLine: {
            show: true,
            length: 10,
            lineStyle: {
                color: '#fff',
                width: 2
            }
        },
        itemStyle: {
            normal: {
                color: "#818488",
                shadowColor: 'rgba(0, 0, 0, 0.5)',
                shadowBlur: 10
            }
        },
        detail: {
            formatter: "{value}%",
            offsetCenter: [0, "60%"],
            textStyle: {
                fontSize: 20,
                color: "#333"
            }
        },
        title: {
            show: false
        },
        pointer: {
            length: '85%'
        },
        data: [{
            value: curVal
        }]
    }, {
        name: "内环仪表盘四段颜色",
        type: "gauge",
        min: 0,
        max: 100,
        radius: '80%',
        center:["50%","60%"],
        startAngle: angle[0],
        endAngle: angle[1],
        splitNumber: 10,
        axisLine: {
            lineStyle: {
                color: [
                    [0.6, '#fb5310'],
                    [0.85, '#fbe010'],
                    [1, "#3fa7dc"]
                ],
                width: 15
            }
        },
        axisTick: {
            show: false
        },
        axisLabel: {
            show: false
        },
        splitLine: {
            show: true,
            length: 15,
            lineStyle: {
                color: '#fff',
                width: 2
            }
        },
        pointer: {
            length: 0
        },
        detail: {
            show: false
        },
    }]
}
// 使用刚指定的配置项和数据显示图表。
module2.setOption(option);
})

