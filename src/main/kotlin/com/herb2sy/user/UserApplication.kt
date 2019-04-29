package com.herb2sy.user

import SpringContextUtil
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class UserApplication

fun main(args: Array<String>) {
    val run = SpringApplication.run(UserApplication::class.java, *args)
    //初始化上下文
    SpringContextUtil.instance.init(run)
}


