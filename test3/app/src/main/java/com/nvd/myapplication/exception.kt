package com.nvd.myapplication

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    GlobalScope.launch {
        try {
            println("Throwing exception from launch")
            throw IndexOutOfBoundsException()
            println("Unreached")
        } catch (e: IndexOutOfBoundsException) {
            println("Caught IndexOutOfBoundsException")
        }
    }

    val deferred = GlobalScope.async {
        println("Throwing exception from async")
        throw ArithmeticException()
        println("Unreached")
    }
    try {
        deferred.await()
        println("Unreached")
    } catch (e: ArithmeticException) {
        println("Caught ArithmeticException")
    }
}