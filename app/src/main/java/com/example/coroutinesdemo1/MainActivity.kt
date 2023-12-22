package com.example.coroutinesdemo1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var btnDownloadUserData: Button
    private lateinit var btnCount: Button
    private lateinit var tvCount: TextView
    private lateinit var tvUserMessage: TextView
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        btnDownloadUserData = findViewById(R.id.btnDownloadUserData)
        btnCount = findViewById(R.id.btnCount)
        tvCount = findViewById(R.id.tvCount)
        tvUserMessage = findViewById(R.id.tvUserMessage)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
       // viewModel.getUserData()
        viewModel.users.observe(this) { users ->
            users?.forEach {
                tvCount.text = "${tvCount.text} ${it.name}\n"
            }
        }

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val name = async { getUserName() }
                withContext(Dispatchers.Main) {
                    tvUserMessage.text = UserDataManager2().getUserCount().toString()
                }
            }

        }


    }

    private suspend fun getUserName(): String {
        delay(3000)
        return "foo"
    }

    private suspend fun downloadUserData() {
        for (i in 1..200000) {
            withContext(Dispatchers.Main) {
                tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
                delay(1000)
            }

        }
    }
}