package com.example.coroutinesdemo1.model

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User> {
        delay(8000)
        val users: List<User> = listOf(
            User(1, "Joe"),
            User(2, "Chandler"),
            User(3, "Rose"),
            User(4, "Pheebie"),
            User(5, "Rachel"),
            User(6, "Monica")
        )
        return users
    }
}