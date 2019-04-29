/**
 * Author Herb
 * Copyright (C) 2017-2019 All Rights Reserved
 */
package com.herb2sy.user.utils.sms

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.herb2sy.user.common.Const

/**
 * @author: HerbLee
 * @Date: Created on 2019/4/29 11:24 PM
 * @des: 短信发送类
 */
class SmsCode {



    companion object{

        fun sendSms(phone:String,code:String){
            val profile = DefaultProfile.getProfile("default", Const.ALI.SMS_ACCESSKEYID, Const.ALI.SMS_ACCESSSECRET)
            val client = DefaultAcsClient(profile)
            val request = CommonRequest()
            request.method = MethodType.POST
            request.domain = "dysmsapi.aliyuncs.com"
            request.version = "2017-05-25"
            request.action = "SendSms"
            request.putQueryParameter("PhoneNumbers", phone)
            request.putQueryParameter("SignName", Const.ALI.SMS_SIGNNAME)
            request.putQueryParameter("TemplateCode", Const.ALI.SMS_TEMPLATE)
            request.putQueryParameter("TemplateParam", "{code:$code}")
            try {
                val response = client.getCommonResponse(request)
                println(response.data)
            } catch (e: ServerException) {
                e.printStackTrace()
            } catch (e: ClientException) {
                e.printStackTrace()
            }


        }
    }





}
