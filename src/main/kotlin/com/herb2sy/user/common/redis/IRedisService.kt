package com.herb2sy.user.common.redis


interface IRedisService {
    /**
     * 写入缓存
     * @param key
     * @param value
     * @return 写入成功或失败
     */
    fun save(key: String?, value: String?): Boolean

    /**
     * 根据key 获取value
     * @param key
     * @return
     */
    fun getByKey(key: String?): String?

    /**
     * 写入缓存设置有效时间
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    fun save(key: String?, value: Any?, expireTime: Long): Boolean

    /**
     * 批量删除对应的value
     * @param key
     */
    fun remove(vararg key: String?)



    /**
     * 删除对应的value
     * @param key
     */
    fun remove(key: String?)

    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    fun exists(key: String?): Boolean

    /**
     * 读取缓存
     * @param key
     * @return
     */
    operator fun get(key: String?): Any?

    fun expire(token: String?, time: Int): Boolean

    /**
     * 哈希添加
     * @param key
     * @param hashKey
     * @param value
     */
    fun hmSet(key: String?, hashKey: Any?, value: Any?)

    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    fun hmGet(key: String?, hashKey: Any?): Any?

    fun hmGet(key: String?): Map<Any?, Any?>?

//    /**
//     * 列表添加
//     * @param key
//     * @param v
//     */
//    fun lPush(key: String?, v: Any?)
//
//    /**
//     * 列表获取
//     * @param key
//     * @param l
//     * @param l1
//     * @return
//     */
//    fun lRange(key: String?, l: Long, l1: Long): List<Any>

//    /**
//     * 集合添加
//     * @param key
//     * @param value
//     */
//    fun add(key: String?, value: Any?)
//
//    /**
//     * 集合获取
//     * @param key
//     * @return
//     */
//    fun setMembers(key: String?): Set<Any>?

    fun mGet(key: String?): Set<Any?>?
//
//    /**
//     * 有序集合添加
//     * @param key
//     * @param value
//     * @param scoure
//     */
//    fun zAdd(key: String?, value: Any?, scoure: Double)
//
//    /**
//     * 有序集合获取
//     * @param key
//     * @param scoure
//     * @param scoure1
//     * @return
//     */
//    fun rangeByScore(key: String?, scoure: Double, scoure1: Double): Set<Any>


}