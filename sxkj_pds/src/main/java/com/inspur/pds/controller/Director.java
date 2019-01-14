package com.inspur.pds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: HP
 * @Date: 2018/12/26 21:58
 * @Description:主任业务逻辑层
 */
@Controller
@RequestMapping(value = "/director")
public class Director {
    /**
     * 跳转到Director界面
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/director/index");
        return modelAndView;
    }

    /**
     * 跳转到configureLinrarry界面
     * @return
     */
    @RequestMapping(value = "/configureLinrarry")
    public ModelAndView configurelinrarry() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/director/configurelinrarry");
        return modelAndView;
    }

    /**
     * 跳转到厅长具体分析(director_analysis)界面
     * @return
     */
    @RequestMapping(value = "/director_analysis")
    public ModelAndView director_analysis() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/director/director-analysis");
        return modelAndView;
    }
}
