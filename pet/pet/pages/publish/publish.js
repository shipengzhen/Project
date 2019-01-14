// pages/publish/publish.js
Page({

  /**
   * 页面的初始数据
   */
  staticData: {
    type: "buy"
  },
  data: {
    success:false,
    address: "点击选择,要勾选哦~",
    items: [{
        name: 'buy',
        value: '求购',
        checked: true
      },
      {
        name: 'sell',
        value: '转让',
        checked: false
      }
    ]
  },
  handTypeChange(e) {
    console.log('radio发生change事件，携带value值为：', e.detail.value);
    this.staticData.type = e.detail.value;
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage(res) {
    return {
      title: '发布信息',
      path: '/pages/publish/publish'
    }
  },

  //选择地址
  handleAddressClick() {
    wx.chooseLocation({
      success: this.handleChooseLocationSucc.bind(this)
    });
  },
  handleChooseLocationSucc(res) {
    this.setData({
      address: res.address
    });
    console.log(res);
    Object.assign(this.staticData, {
      latitude: res.latitude,
      longitude: res.longitude
    })
  },

  //获取说明
  handleMessageChange(e) {
    this.staticData.message = e.detail.value;
    console.log(this.staticData.message);
  },

  //获取联系方式
  handleContactChange(e) {
    this.staticData.contact = e.detail.value;
    console.log(this.staticData.contact);
  },

  //发布信息
  handleSubmit() {
    //地址校验
    console.log(this.data.address);
    if (this.data.address === "" || this.data.address === "点击选择,要勾选哦~") {
      wx.showToast({
        title: '请填写地址',
        icon: 'loading',
        duration: 2000
      });
      return;
    }
    //具体需求校验
    console.log(this.staticData.message);
    if (this.staticData.message === "" || this.staticData.message === "请填写您的具体需求") {
      wx.showToast({
        title: '请填写您的具体需求',
        icon: 'loading',
        duration: 2000
      });
      return;
    }
    //联系方式校验
    console.log(this.staticData.contact);
    if (this.staticData.contact === "" || this.staticData.contact === "请填您的联系方式") {
      wx.showToast({
        title: '请填您的联系方式',
        icon: 'loading',
        duration: 2000
      });
      return;
    }
    this.setData({
      success: true
    });
  },
  handleBackTap(){
    wx.navigateBack();
  }

})