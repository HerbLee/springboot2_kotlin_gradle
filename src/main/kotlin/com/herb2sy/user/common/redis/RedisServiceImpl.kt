package com.herb2sy.user.common.redis

import com.herb2sy.utils.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit


@Service
class RedisServiceImpl: IRedisService {

    @Autowired
    private val redisTemplate = RedisTemplate<String, String>()


    override fun save(key: String?, value: String?): Boolean {

        if (StringUtils.isEmptys(key,value)){
            return false
        }

        var result = false
        try {
            inits()
            val operations = redisTemplate.opsForValue()

            operations.set(key!!, value!!)
            result = true
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }

    override fun getByKey(key: String?): String? {

        if (StringUtils.isEmptys(key)){
            return null
        }
        inits()
        return redisTemplate.opsForValue().get(key!!)
    }

    override fun save(key: String?, value: Any?, expireTime: Long): Boolean {
        if (StringUtils.isEmptys(key)){
            return false
        }
        var result = false
        try {
            inits()
            val operations = redisTemplate.opsForValue()
            operations.set(key!!, value.toString())
            redisTemplate.expire(key!!, expireTime, TimeUnit.SECONDS)
            result = true
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }

    override fun remove(vararg keys: String?) {
        if (keys.size == 0){
            return
        }
        for (key in keys) {
            remove(key)
        }
    }



    override fun remove(key: String?) {
        if (key == null){
            return
        }
        inits()
        if (exists(key)) {
            redisTemplate.delete(key!!)
        }
    }

    override fun exists(key: String?): Boolean {
        if (key == null){
            return false
        }
        inits()
        return redisTemplate.hasKey(key)
    }

    override fun get(key: String?): Any? {
        if (key == null){
            return false
        }
        inits()
        var result: Any? = null
        val operations = redisTemplate.opsForValue()
        result = operations.get(key)
        return result
    }

    override fun expire(token: String?, time: Int): Boolean {
        if (token == null){
            return false
        }
        inits()
        var result = false
        try {
            val operations = redisTemplate.opsForValue()
            redisTemplate.expire(token, time.toLong(), TimeUnit.SECONDS)
            result = true
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }

    override fun mGet(key: String?): Set<*>? {
        if (key == null){
            return null
        }
        inits()
        return redisTemplate.keys(key)
    }

    override fun hmSet(key: String?, hashKey: Any?, value: Any?) {
        if (key == null || hashKey == null || value == null){
            return
        }

        inits()
        val hash = redisTemplate.opsForHash<Any,Any>()
        hash.put(key, hashKey, value)
    }

    override fun hmGet(key: String?, hashKey: Any?): Any? {
        if (key == null || hashKey == null){
            return null
        }
        inits()
        val hash = redisTemplate.opsForHash<Any,Any>()
        return hash.get(key, hashKey)
    }

    override fun hmGet(key: String?): Map<Any?, Any?>? {
        if (key == null){
            return null
        }
        inits()
        val hash = redisTemplate.opsForHash<Any,Any>()

        return hash.entries(key)
    }






    fun inits() {
        redisTemplate.keySerializer = StringRedisSerializer()
        redisTemplate.valueSerializer = GenericJackson2JsonRedisSerializer()
    }
}