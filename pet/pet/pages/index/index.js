//index.js
//获取应用实例
const app = getApp();
mapCtx:"";

Page({
  data:{
    longitude:"",
    latitude:""
  },

  //获取当前地理位置
  getLocation(){
    wx.getLocation({
      type : 'gcj02',
      success : this.handleGetLocationSucc.bind(this)
    })
  },
  handleGetLocationSucc(res) {
    this.setData({
      longitude: res.longitude,
      latitude: res.latitude,
      controls: [{
        iconPath: '/resources/img/中心.png',
        position: {
          left: app.globalData.windowWidth/2-15,
          top:  (app.globalData.windowHeight-40)/2-30,
          width: 30,
          height: 30
        }
      },
        {
          id: 1,
          iconPath: '/resources/img/罗盘.png',
          position: {
            left:20,
            top: app.globalData.windowHeight - 150,
            width: 100,
            height: 100
          },
          clickable: true
        }]
    })
  },

  //还原地图
  controltap(){
    this.mapCtx.moveToLocation();
  },

  onShow () {
    this.getLocation();
  },

  onReady () {
    // 使用 wx.createMapContext 获取 map 上下文
    this.mapCtx = wx.createMapContext('map');
  },


  onShareAppMessage (res) {
    return {
      title: '萌宠交易平台',
      path: '/page/index/index'
    }
  }

})
