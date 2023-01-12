package com.nvd.myapplication

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val int: Deferred<Int> = async { printInt() }
    val str: Deferred<String> = async { return@async "Sun" }
    val unit: Deferred<Unit> = async { }

    println("Int = ${int.await()}")
    println("String = ${str.await()}")
}

fun printInt(): Int {
    return 10
}