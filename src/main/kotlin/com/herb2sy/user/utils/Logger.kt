package com.herb2sy.user.utils

import mu.KotlinLogging

class Logger {



    companion object {
        private val logger = KotlinLogging.logger {}

        val d = { msg:String? -> logger.debug { msg }}
        val t = {msg:String? -> logger.trace { msg }}
        val w = {msg:String? -> logger.warn { msg }}
        val e = {msg:Any? -> logger.error { msg }}
    }



}