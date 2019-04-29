package com.herb2sy.user.pojo

import java.util.Date

class UserOauth {
    var uid: String? = null
        set(uid) {
            field = uid?.trim { it <= ' ' }
        }

    private var tCreate: Date? = null

    private var tModify: Date? = null

    private var tDelete: Date? = null

    var isDelete: Int? = null

    var userUid: String? = null
        set(userUid) {
            field = userUid?.trim { it <= ' ' }
        }

    var unionid: String? = null
        set(unionid) {
            field = unionid?.trim { it <= ' ' }
        }

    var openid: String? = null
        set(openid) {
            field = openid?.trim { it <= ' ' }
        }

    var oauthType: Int? = null

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
}