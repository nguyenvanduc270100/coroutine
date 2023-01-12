package com.nvd.myapplication

import kotlinx.coroutines.*
import java.io.IOException

fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception with suppressed ${exception.suppressed.contentToString()}")
    }
    val job = GlobalScope.launch(handler) {
        launch {
            try {
                delay(Long.MAX_VALUE) // delay vô hạn
            } finally {
                throw ArithmeticException()
            }
        }
        launch {
            try {
                delay(Long.MAX_VALUE) // delay vô hạn
            } finally {
                throw IndexOutOfBoundsException()
            }
        }
        launch {
            delay(100)
            throw IOException()
        }
        delay(Long.MAX_VALUE)
    }
    job.join()
}