package com.herb2sy.user.common.response

import lombok.Getter

@Getter
enum class HresultCode private constructor(//失败返回

        val code: Int, val desc: String) {

    SUCCESS(200, "SUCCESS"), //成功返回

    LOGINSUCCESS(201, "登陆成功"),

    EXCEPTION(500, "出现异常"), //出现异常

    TOKEN_TIMEOUT(401, "登陆过期，请重新登陆"), //token过期

    ERROR(400, "网络请求出错")
}