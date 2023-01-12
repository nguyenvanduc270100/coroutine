package com.nvd.myapplication

import kotlinx.coroutines.*
// chạy bất chấp
fun main() = runBlocking {
    // nếu bỏ dispatcher đi sẽ chạy tuần tự in đủ 5 lần rồi mới chạy tiếp ra ngoài
    val startTime = System.currentTimeMillis()
    val job = launch {
        println("thread1: ${Thread.currentThread().name}")
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("thread2: ${Thread.currentThread().name}")
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    println("main: Now I can quit.")
}