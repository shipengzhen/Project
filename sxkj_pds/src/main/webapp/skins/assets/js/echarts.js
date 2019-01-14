
//下钻图表
function renderlabPersonCharts(){
    var personnel = echarts.init(document.getElementById('personnel'));
    option = {
        tooltip:{
            show:true
        },
        grid: {
            left: '10%',
            right: '10%',
            bottom: '20%',
            top:'12%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: ['研究人员', '管理人员', '技术人员']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [104, 50, 70],
            type: 'bar',
            name:'人员投入情况',
            //配置样式
            itemStyle: {   
                //通常情况下：
                normal:{  
    　　　　　　　　　　　　//每个柱子的颜色即为colorList数组里的每一项，如果柱子数目多于colorList的长度，则柱子颜色循环使用该数组
                    color: function (params){
                        var colorList = ['#1befff','#2097c4','#ecac3d'];
                        return colorList[params.dataIndex];
                    }
                },
            },
            barWidth : 120,
        }]
    };

    personnel.setOption(option); 
}

//下钻图表
function renderlabChangeCharts(){
    var change = echarts.init(document.getElementById('change'));
    option = {
        color:'#32b9f8',
        tooltip:{
            show:true
        },
        xAxis: {
            type: 'category',
            data: ['2011年', '2012年', '2013年', '2014年', '2015年', 
            '2016年', '2017年']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name:'实验室数量',
            symbolSize: 10,
            symbol: 'circle',
            itemStyle : {
                normal : {
                    color:'#eb6100',
                    lineStyle:{
                        color:'#32b9f8'
                    }
                }
            },
            data: [25, 38, 50,62,58,90,110],
            type: 'line'
        }]
    };

    change.setOption(option); 
}

function platformDist(ele) {
    var xData = ['重点实验室', '工程技术研究中心', '临床医学研究中心', '药用植物科技示范基地', '创新药物研究中心', '校企共建新型研发平台', '技术合同认定登记机构', '技术转移示范机构', '科技资源开放共享平台', '科技企业孵化器、众创空间', '星创天地', '省软科学研究基地', '科技成果转化引导基金管理服务平台', '国际科技合作基地', '高新区', '农业科技园区', '可持续发展实验区', '县城科技创新试验示范站'];
    var valueData = [70, 24, 44, 59, 60, 73, 11, 20, 70, 68, 82, 32, 12, 44, 67, 88, 90, 11];
    var myChart = echarts.init(document.getElementById(ele));
    option = {
        tooltip:{
            show:true
        },
        grid: {
            top: "8%",
            right: "8%",
            left: "11%",
            bottom: "40%",
        },
        xAxis: {
            type: 'category',
            data: xData,
            axisLabel: {
                interval: 0,
                formatter: function (val) {
                    return val.split("").join("\n");
                }
            }
        },

        yAxis: {
            type: 'value',
            max: 120,
        },
        series: [{
            data: valueData,
            type: 'bar',
            barWidth: '30%',
            //配置样式
            itemStyle: {
                //通常情况下：
                normal: {
                    barBorderRadius: 50,
                    //每个柱子的颜色即为colorList数组里的每一项，如果柱子数目多于colorList的长度，则柱子颜色循环使用该数组
                    color: function (params) {
                        // var colorList = ['rgb(164,205,238)','rgb(42,170,227)','rgb(25,46,94)','rgb(195,229,235)'];
                        var colorList = ['#1aefff', '#12d7bd', '#dff170', '#83adfb', '#4adfeb', '#db9ff5', '#fd99db', '#9be5e9', '#fbd370', '#e7e170', '#ade37c', '#f0a4c0', '#9bd3d7', '#f6c7e1', '#78b9bd', '#ababf3', '#2edbe9', '#a5cfee'];
                        return colorList[params.dataIndex];
                    }
                },
                //鼠标悬停时：
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            },
            //设置柱子的宽度
            // barWidth : 120,
        }]
    };

    myChart.setOption(option);
    myChart.on("click",function(params){
        window.location.href="../laboratory/lab_change"
    })
}