package com.herb2sy.user.service

import com.herb2sy.user.common.response.HserviceResult

interface IUserBaseService {

    fun getUserByNet(token:String?,name:String?):HserviceResult<String?>


}