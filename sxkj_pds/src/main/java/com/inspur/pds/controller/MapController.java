package com.inspur.pds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: HP
 * @Date: 2019/1/2 22:35
 * @Description:跳转到地图控制层
 */
@Controller
@RequestMapping(value = "/map")
public class MapController {
    /**
     * 跳转到地图界面
     * @return
     */
    @RequestMapping(value = "/map")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/map/map");
        return modelAndView;
    }
}
