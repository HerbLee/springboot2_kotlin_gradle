package com.herb2sy.user.config

import com.herb2sy.user.common.response.HresultCode
import com.herb2sy.user.utils.Logger
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.view.json.MappingJackson2JsonView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse



@Component
class GlobalExceptionHandler:HandlerExceptionResolver {
    override fun resolveException(request: HttpServletRequest, response: HttpServletResponse, handler: Any?, ex: Exception): ModelAndView? {
        Logger.e(ex)
        val modelAndView = ModelAndView(MappingJackson2JsonView())
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
        modelAndView.addObject("code", HresultCode.EXCEPTION.code)
        modelAndView.addObject("message", HresultCode.EXCEPTION.desc)
        modelAndView.addObject("data", "服务异常，详情查看服务端日志")
        return modelAndView
    }


}