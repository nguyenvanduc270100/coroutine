package com.nvd.myapplication

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { printOne1() }
        val two = async(start = CoroutineStart.LAZY) { printTwo2() }

        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun printOne1(): Int {
    delay(1000L)
    return 10
}

suspend fun printTwo2(): Int {
    delay(1000L)
    return 20
}