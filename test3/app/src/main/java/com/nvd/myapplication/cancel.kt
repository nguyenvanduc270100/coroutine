package com.nvd.myapplication

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = launch {
            repeat(1000) {
                println("Sleeping $it")
                delay(500L)
            }
        }

        delay(1300L)
        println("main: abc")
        job.cancel()
        println("done")
    }
}