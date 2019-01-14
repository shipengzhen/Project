package com.inspur.pds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: HP
 * @Date: 2018/12/26 21:51
 * @Description:业务控制层
 */
@Controller
@RequestMapping(value = "/business")
public class BusinessController {
    /**
     * 跳转到Business界面
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/business/index");
        return modelAndView;
    }

    /**
     * 跳转到wholeAnalysis(具体指标查看)界面
     * @return
     */
    @RequestMapping(value = "/wholeAnalysis")
    public ModelAndView wholeAnalysis() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/business/wholeAnalysis");
        return modelAndView;
    }
}
