package com.inspur.pds.controller;

import com.inspur.pds.data.Customer;
import com.inspur.pds.util.ExcelUtil;
import com.inspur.pds.util.ReadExcel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: HP
 * @Date: 2018/12/26 23:57
 * @Description:跳转到门诊化验室控制层
 */
@Controller
@RequestMapping(value = "/laboratory")
public class LaboratoryController {

    /**
     * 跳转到Laboratory界面
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/laboratory/index");
        return modelAndView;
    }

    /**
     * 跳转到lab_analysis界面
     *
     * @return
     */
    @RequestMapping(value = "/lab_analysis")
    public ModelAndView lab_analysis() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/laboratory/lab-analysis");
        return modelAndView;
    }

    /**
     * 跳转到lab_auditing界面
     *
     * @return
     */
    @RequestMapping(value = "/lab_auditing")
    public ModelAndView lab_auditing() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/laboratory/lab-auditing");
        return modelAndView;
    }

    /**
     * 跳转到lab_change界面
     *
     * @return
     */
    @RequestMapping(value = "/lab_change")
    public ModelAndView lab_change() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/laboratory/lab-change");
        return modelAndView;
    }

    /**
     * 跳转到lab_history界面
     *
     * @return
     */
    @RequestMapping(value = "/lab_history")
    public ModelAndView lab_history() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/laboratory/lab-history");
        return modelAndView;
    }

    /**
     * 跳转到lab_tianbao界面
     *
     * @return
     */
    @RequestMapping(value = "/lab_tianbao")
    public ModelAndView tianBao() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/laboratory/lab-tianbao");
        return modelAndView;
    }

    /**
     * 跳转到labMonitor界面
     *
     * @return
     */
    @RequestMapping(value = "/labMonitor")
    public ModelAndView labMonitor() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/laboratory/labMonitor");
        return modelAndView;
    }

    /**
     * 跳转到personnel界面
     *
     * @return
     */
    @RequestMapping(value = "/personnel")
    public ModelAndView personnel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/laboratory/personnel");
        return modelAndView;
    }

    /**
     * 跳转到platform界面
     *
     * @return
     */
    @RequestMapping(value = "/platform")
    public ModelAndView platform() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/laboratory/platform");
        return modelAndView;
    }

    /**
     * 跳转到specific_indicators界面
     *
     * @return
     */
    @RequestMapping(value = "/specific_indicators")
    public ModelAndView specific_indicators() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/laboratory/specific-indicators");
        return modelAndView;
    }
    @RequestMapping(value = "/fileupload")
    @ResponseBody
    public ModelAndView fileUpload(@RequestParam(value="attach", required = false) MultipartFile multipartFile, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String Msg =null;
        boolean b = false;

        //判断文件是否为空
        if(multipartFile==null){
            Msg ="文件是为空！";
            request.getSession().setAttribute("msg",Msg);
            modelAndView.setViewName("");
        }

        //获取文件名
        String name=multipartFile.getOriginalFilename();

        long size=multipartFile.getSize();
        if(name==null || ("").equals(name) && size==0 && !ExcelUtil.isExcel(name)){
            Msg ="文件格式不正确！请使用.xls或.xlsx后缀文档。";
            request.getSession().setAttribute("msg",Msg);
        }

        //创建处理EXCEL
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取客户信息集合。
        List<Customer> customerList = readExcel.getExcel(name,multipartFile,request);
        if(customerList != null && !customerList.toString().equals("[]") && customerList.size()>=1){
            b = true;
        }
        if(b){
            for(Customer customer:customerList){
                System.out.println("第一个值："+customer.getCustomerName()+"\t第二个值："+customer.getSimpleName()+"\t第三个值："+customer.getAddress()+"\t第四个值:"+customer.getTrade());
            }
            Msg ="批量导入EXCEL成功！";
            request.getSession().setAttribute("msg",Msg);
        }else{
            Msg ="批量导入EXCEL失败！";
            request.getSession().setAttribute("msg",Msg);
        }
        return modelAndView;
    }
}
