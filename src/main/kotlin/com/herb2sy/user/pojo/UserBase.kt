package com.herb2sy.user.pojo

import com.herb2sy.user.common.base.Base

import java.util.Date

class UserBase {

    var uid: String? = null
        set(uid) {
            field = uid?.trim { it <= ' ' }
        }

    var nickname: String? = null
        set(nickname) {
            field = nickname?.trim { it <= ' ' }
        }

    var name: String? = null
        set(name) {
            field = name?.trim { it <= ' ' }
        }

    var password: String? = null
        set(password) {
            field = password?.trim { it <= ' ' }
        }

    private var tCreate: Date? = null

    private var tModify: Date? = null

    private var tDelete: Date? = null

    var gender: Int? = null

    var birthday: Date? = null

    private var tLast: Date? = null

    var lastIp: String? = null
        set(lastIp) {
            field = lastIp?.trim { it <= ' ' }
        }

    var addr: String? = null
        set(addr) {
            field = addr?.trim { it <= ' ' }
        }

    var idCard: String? = null
        set(idCard) {
            field = idCard?.trim { it <= ' ' }
        }

    var idType: Int? = null

    var isDelete: Int? = null

    var avatar: String? = null
        set(avatar) {
            field = avatar?.trim { it <= ' ' }
        }

    fun gettCreate(): Date? {
        return tCreate
    }

    fun settCreate(tCreate: Date) {
        this.tCreate = tCreate
    }

    fun gettModify(): Date? {
        return tModify
    }

    fun settModify(tModify: Date) {
        this.tModify = tModify
    }

    fun gettDelete(): Date? {
        return tDelete
    }

    fun settDelete(tDelete: Date) {
        this.tDelete = tDelete
    }

    fun gettLast(): Date? {
        return tLast
    }

    fun settLast(tLast: Date) {
        this.tLast = tLast
    }
}