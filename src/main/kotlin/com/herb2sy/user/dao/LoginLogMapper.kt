package com.herb2sy.user.dao

import com.herb2sy.user.pojo.LoginLog
import org.apache.ibatis.annotations.Mapper

@Mapper
interface LoginLogMapper {
    fun deleteByPrimaryKey(id: Int?): Int

    fun insert(record: LoginLog): Int

    fun insertSelective(record: LoginLog): Int

    fun selectByPrimaryKey(id: Int?): LoginLog

    fun updateByPrimaryKeySelective(record: LoginLog): Int

    fun updateByPrimaryKey(record: LoginLog): Int
}