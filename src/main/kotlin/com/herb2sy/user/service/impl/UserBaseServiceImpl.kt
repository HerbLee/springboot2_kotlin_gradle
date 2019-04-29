package com.herb2sy.user.service.impl

import com.herb2sy.user.common.response.HserviceResult
import com.herb2sy.user.service.IUserBaseService
import org.springframework.stereotype.Service

@Service
class UserBaseServiceImpl:IUserBaseService {
    override fun getUserByNet(token: String?, name: String?): HserviceResult<String?> {
        return  HserviceResult.createBySuccess(token,name)

    }


}