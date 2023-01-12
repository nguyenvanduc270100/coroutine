package com.nvd.myapplication

import kotlinx.coroutines.*

fun main() {
    val job2 = GlobalScope.launch {
        delay(5000L)
        println("job2 world!")
    }
    runBlocking {
        val job = GlobalScope.launch {
            delay(5000L)
            println("job world!")
        }
        println("job Hello")
        job.join()
        job2.join()
        println("job done")
    }

    println("Hello")

    println("done")
}