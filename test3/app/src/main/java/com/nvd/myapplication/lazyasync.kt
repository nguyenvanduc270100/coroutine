package com.nvd.myapplication

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { printOne() }
        val two = async(start = CoroutineStart.LAZY) { printTwo() }
        one.start() // start the first one
        two.start() // start the second one
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun printOne(): Int {
    delay(1000L)
    return 10
}

suspend fun printTwo(): Int {
    delay(1000L)
    return 20
}