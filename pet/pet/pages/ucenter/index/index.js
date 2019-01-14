var api = require('../../../config/api.js');
var app = getApp();

Page({
  data: {
    userInfo: {},
    hasMobile: ''
  },
  onLoad: function(options) {
    // 页面初始化 options为页面跳转所带来的参数
    console.log(app.globalData)
  },
  onReady: function() {

  },
  onShow: function () {
    this.setData({
      userInfo: wx.getStorageSync('userInfo')
    });

  },
  onHide: function() {
    // 页面隐藏

  },
  onUnload: function() {
    // 页面关闭
  },
  bindGetUserInfo(e) {
    let userInfo = e.detail.userInfo;
    if (userInfo) {
      wx.setStorageSync('userInfo', userInfo);
      //用户按了允许授权按钮
      this.setData({
        userInfo: userInfo
      });
    }else{

    }
  },
  exitLogin () {
    wx.showModal({
      title: '',
      confirmColor: '#b4282d',
      content: '退出登录？',
      success: function(res) {
        if (res.confirm) {
          wx.removeStorageSync('userInfo');
          wx.switchTab({
            url: '/pages/index/index'
          });
        }
      }
    })
  }
})