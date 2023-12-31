package com.example.coroutinesdemo1

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserDataManager {

    suspend fun getUserCount(): Int {
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            count = 14
        }

        val v = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 110
        }
        return count + v.await()
    }
}