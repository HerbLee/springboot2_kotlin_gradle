package com.herb2sy.user.dao

import com.herb2sy.user.pojo.OauthType
import org.apache.ibatis.annotations.Mapper

@Mapper
interface OauthTypeMapper {
    fun deleteByPrimaryKey(id: Int?): Int

    fun insert(record: OauthType): Int

    fun insertSelective(record: OauthType): Int

    fun selectByPrimaryKey(id: Int?): OauthType

    fun updateByPrimaryKeySelective(record: OauthType): Int

    fun updateByPrimaryKey(record: OauthType): Int
}