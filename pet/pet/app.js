//app.js
var api = require('/config/api.js');
App({

  globalData: {

  },

  onLaunch() {
    try {
      const res = wx.getSystemInfoSync();
      console.log(res.model);
      console.log(res.pixelRatio);
      console.log(res.windowWidth);
      console.log(res.windowHeight);
      console.log(res.language);
      console.log(res.version);
      console.log(res.platform);

      this.globalData.windowWidth = res.windowWidth;
      this.globalData.windowHeight = res.windowHeight;
      console.log(this.globalData.windowWidth);
      console.log(this.globalData.windowHeight);

    } catch (e) {
      console.log(e)
    }

    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs);

    // 登录
    wx.login({
      success: res => {
        const code = res.code;
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        wx.request({
          url: api.Login,
          data: {
            appid: "wx0a974225796472c9",
            code: code
          },
          method: 'GET',
          header: {
            'content-type': 'application/json'
          },
          success: function(res) {
            wx.setStorageSync('sessionKey', res.data.sessionKey);
          }
        });
      }
    })
    const sessionKey = wx.getStorageSync('sessionKey');
    // 获取用户信息
    if (sessionKey != null && sessionKey != "") {
      wx.getSetting({
        success: res => {
          if (res.authSetting['scope.userInfo']) {
            // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
            wx.getUserInfo({
              success: res => {
                // 可以将 res 发送给后台解码出 unionId
                this.globalData.userInfo = res.userInfo;
                wx.setStorageSync('userInfo', res.userInfo);
                // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
                // 所以此处加入 callback 以防止这种情况
                if (this.userInfoReadyCallback) {
                  this.userInfoReadyCallback(res)
                }
              }
            })
          }
        }
      })
    }
  },
  globalData: {
    userInfo: null
  }
})