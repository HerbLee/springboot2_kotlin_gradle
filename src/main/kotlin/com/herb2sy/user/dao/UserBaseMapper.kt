package com.herb2sy.user.dao

import com.herb2sy.user.pojo.UserBase
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserBaseMapper {
    fun deleteByPrimaryKey(uid: String): Int

    fun insert(record: UserBase): Int

    fun insertSelective(record: UserBase): Int

    fun selectByPrimaryKey(uid: String): UserBase

    fun updateByPrimaryKeySelective(record: UserBase): Int

    fun updateByPrimaryKey(record: UserBase): Int
}