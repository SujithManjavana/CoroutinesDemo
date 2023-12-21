package com.example.coroutinesdemo1

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserDataManager2 {
    private var count = 0
    private lateinit var deferred: Deferred<Int>
    suspend fun getUserCount(): Int {
        coroutineScope {
            launch(Dispatchers.IO) {
                delay(3000)
                count = 50
            }

            deferred = async(Dispatchers.IO) {
                delay(1000)
                return@async 100
            }
        }
        return count + deferred.await()
    }
}