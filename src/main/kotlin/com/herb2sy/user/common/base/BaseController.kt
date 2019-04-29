package com.herb2sy.user.common.base

import com.herb2sy.user.common.redis.IRedisService
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
open class BaseController {

    @Autowired
    internal var iRedisService: IRedisService? = null


    /**
     * 获取请求文件的request
     *
     * @return
     */
    val request:() -> HttpServletRequest = {  (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request}

    val response: () -> HttpServletResponse? = { (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).response }

    val token: () -> String? = { request().getHeader("token")}



}