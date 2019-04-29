package com.herb2sy.user.pojo

class OauthType {
    var id: Int? = null

    var name: String? = null
        set(name) {
            field = name?.trim { it <= ' ' }
        }

    var descriptioin: String? = null
        set(descriptioin) {
            field = descriptioin?.trim { it <= ' ' }
        }
}