package com.herb2sy.user.common.base

import com.fasterxml.jackson.databind.annotation.JsonSerialize

import java.io.Serializable

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
class Base : Serializable {
    companion object {
        private val serivalVersionUID = 1L
    }
}