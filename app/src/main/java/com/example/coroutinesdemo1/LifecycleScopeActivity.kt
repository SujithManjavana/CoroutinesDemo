package com.example.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesdemo1.ui.main.LifecycleScopeFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LifecycleScopeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_scope)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LifecycleScopeFragment.newInstance())
                .commitNow()
        }
        lifecycleScope.launch {
            delay(1000)
            val tv = findViewById<TextView>(R.id.tv)
            tv.visibility = View.VISIBLE
            for (i in 0..10) {
                tv.text = i.toString()
                delay(1000)
            }
            Toast.makeText(this@LifecycleScopeActivity, "Finished", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
    }
}