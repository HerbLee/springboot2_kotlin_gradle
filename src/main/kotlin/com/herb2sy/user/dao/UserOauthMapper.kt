package com.herb2sy.user.dao

import com.herb2sy.user.pojo.UserOauth
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserOauthMapper {
    fun deleteByPrimaryKey(uid: String): Int?

    fun insert(record: UserOauth): Int?

    fun insertSelective(record: UserOauth): Int?

    fun selectByPrimaryKey(uid: String): UserOauth?

    fun updateByPrimaryKeySelective(record: UserOauth): Int?

    fun updateByPrimaryKey(record: UserOauth): Int?
}