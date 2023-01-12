package com.nvd.myapplication

import kotlinx.coroutines.*

// khắc phục chạy bất chấp
// nếu muốn cancel khi nó chạy trên 2 thread khác nhau thì kiểm tra điều
// kiện bằng biến isActice
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    // bỏ dispatcher đi sẽ tạo ra vòng lặp vô tận
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) {   // Điều kiện i < 5 đã được thay bằng isActive để ngăn chặn coroutine khi nó đã bị hủy
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    //delay(1300L)
    println("main: Now I can quit.")
}