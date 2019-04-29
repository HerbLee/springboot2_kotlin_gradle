package com.herb2sy.user.config.interceptor

import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 拦截器
 * 写自己要过滤的内容
 */
class BaseInterceptor:HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {





        return super.preHandle(request, response, handler)
    }



}