package com.spz.pet.business.auth.api;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spz.pet.business.message.domain.TradeInfo;
import com.spz.pet.initial.WxMaConfiguration;
import com.spz.pet.utils.JsonUtils;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import io.swagger.annotations.Api;
import me.chanjar.weixin.common.error.WxErrorException;

/**  
 * Copyright © 2018Company. All rightsreserved.
 * @文件名 LoginController.java
 * @项目名 weixin-demo
 * @包名 com.example.demo.controller
 * @类名 LoginController
 * @功能描述 TODO
 * @创建人 施鹏振 
 * @创建时间 2018年10月19日下午3:55:25
 * @版本 TODO
 */
@Api(tags = "API登录授权接口")
@RestController//=@ResponseBody+@Controller
@RequestMapping("api/auth")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 登陆接口
     */
    @GetMapping("login")
    public String login(String appid, String code) {
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }

        final WxMaService wxService = WxMaConfiguration.getMaServices().get(appid);
        if (wxService == null) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%d]的配置，请核实！", appid));
        }

        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            this.logger.info(session.getSessionKey());
            this.logger.info(session.getOpenid());
            return JsonUtils.toJson(session);
        } catch (WxErrorException e) {
            this.logger.error(e.getMessage(), e);
            return e.toString();
        }
    }

    @RequestMapping(value = "test")
    //@RequestBody(required = true)required默认为true当前参数必须有
    public String test(String test) {
        TradeInfo info=new TradeInfo();
        info.setMessage("施鹏振");
        return JsonUtils.toJson(info) ;
    }
}
