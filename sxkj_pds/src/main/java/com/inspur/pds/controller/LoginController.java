package com.inspur.pds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: HP
 * @Date: 2019/1/2 20:17
 * @Description:PDS登录管理系统界面
 */
@Controller
public class LoginController {
    /**
     * 跳转到PDS登录管理系统
     * @return
     */
    @RequestMapping(value = "/login")
    public String goLogin(){
        return "public/login";
    }
}
