package com.tc.jpastudy

object ThreadLocalContext {
    val userLocal = ThreadLocal.withInitial { "initdata" }

    var data = "data1"
}
