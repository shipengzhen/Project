package com.spz.pet.business.message.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**  
 * Copyright © 2018Company. All rightsreserved.
 * @文件名 MessageController.java
 * @项目名 pet_data
 * @包名 com.spz.pet.controller
 * @类名 MessageController
 * @功能描述 TODO
 * @创建人 施鹏振 
 * @创建时间 2018年11月27日上午9:19:09
 * @版本 TODO
 */
@Api(tags = "信息管理相关接口")
@RestController
@RequestMapping("api/message")
public class MassageController {

    /**
     * @方法名 postMessage
     * @return Object
     * @功能描述 发布信息
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午9:20:16
     */
    @ApiOperation("发布信息")
    @PostMapping("publish")
    public Object publishMessage(){
        return null;
    }
}
