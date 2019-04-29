package com.herb2sy.user.pojo

import java.util.Date

class LoginLog {
    var id: Int? = null

    private var tCreate: Date? = null

    var ip: String? = null
        set(ip) {
            field = ip?.trim { it <= ' ' }
        }

    var addr: String? = null
        set(addr) {
            field = addr?.trim { it <= ' ' }
        }

    var loginOauth: String? = null
        set(loginOauth) {
            field = loginOauth?.trim { it <= ' ' }
        }

    var description: String? = null
        set(description) {
            field = description?.trim { it <= ' ' }
        }

    fun gettCreate(): Date? {
        return tCreate
    }

    fun settCreate(tCreate: Date) {
        this.tCreate = tCreate
    }
}