package com.herb2sy.user.common.response

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import javax.servlet.http.HttpServletResponse

class HserviceResult<T> : Serializable {
    var message: String? = null

    var code: Int = 0

    var data: T? = null


    val isSuccesss: Boolean
        @JsonIgnore
        get() = this.code == HresultCode.SUCCESS.code

    private constructor(code: Int) {
        this.code = code
    }

    private constructor(code: Int, data: T?) {
        this.code = code
        this.data = data
    }

    private constructor(code: Int, message: String?) {
        this.code = code
        this.message = message
    }

    private constructor(code: Int, message: String?, data: T?) {
        this.code = code
        this.message = message
        this.data = data
    }


    companion object {




        fun <T> createBySuccess(): HserviceResult<T> {
            return HserviceResult(HresultCode.SUCCESS.code)
        }

        fun <T> createBySuccess(message: String?): HserviceResult<T> {
            return HserviceResult(HresultCode.SUCCESS.code, message)
        }

        fun <T> createBySuccess(data: T): HserviceResult<T> {
            return HserviceResult(HresultCode.SUCCESS.code, HresultCode.LOGINSUCCESS.desc, data)
        }

        fun <T> loginSuccess(response: HttpServletResponse, data: T): HserviceResult<T> {

            response.status = HttpServletResponse.SC_CREATED
            return HserviceResult(HresultCode.LOGINSUCCESS.code, HresultCode.LOGINSUCCESS.desc, data)
        }

        fun <T> createBySuccess(msg: String?, data: T): HserviceResult<T> {
            val hserviceResult = HserviceResult(HresultCode.SUCCESS.code, msg, data)
            return hserviceResult
        }



        fun <T> createByError(response: HttpServletResponse, msg: String?): HserviceResult<T> {
            response.status = HttpServletResponse.SC_BAD_REQUEST
            return HserviceResult(HresultCode.ERROR.code, msg)
        }

        fun <T> createByError(response: HttpServletResponse, code: Int, msg: String?): HserviceResult<T> {
            response.status = HttpServletResponse.SC_BAD_REQUEST
            return HserviceResult(code, msg)
        }

        fun <T> createByException(response: HttpServletResponse, msg: String?): HserviceResult<T> {
            response.status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR
            return HserviceResult(HresultCode.EXCEPTION.code, msg)
        }

        fun <T> createByToken(response: HttpServletResponse): HserviceResult<T> {
            response.status = HttpServletResponse.SC_UNAUTHORIZED
            return HserviceResult(HresultCode.TOKEN_TIMEOUT.code, HresultCode.TOKEN_TIMEOUT.desc)
        }
    }

}