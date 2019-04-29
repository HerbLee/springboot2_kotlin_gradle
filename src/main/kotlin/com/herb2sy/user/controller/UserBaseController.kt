/**
 * Author Herb
 * Copyright (C) 2017-2019 All Rights Reserved
 */
package com.herb2sy.user.controller

import com.herb2sy.user.common.base.BaseController
import com.herb2sy.user.common.response.HserviceResult
import com.herb2sy.user.service.IUserBaseService
import com.herb2sy.user.utils.sms.SmsCode
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



/**
 * @author: HerbLee
 * @Date: Created on 2019/4/28 1:37 AM
 * @des:
 */

@Api("基础api")
@RestController
@RequestMapping("/user")
class UserBaseController:BaseController() {

    @Autowired
    val mIUserBaseService: IUserBaseService? = null

    @ApiOperation(value = "发送短信")
    @GetMapping("sendSms")
    fun get(phone:String,code:String): HserviceResult<String?>? {
        SmsCode.sendSms(phone,code)
        return mIUserBaseService?.getUserByNet(code,phone)
    }





}

