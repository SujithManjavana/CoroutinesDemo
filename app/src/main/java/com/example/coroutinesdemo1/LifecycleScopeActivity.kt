package com.example.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
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
            delay(2500)
            findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
            delay(6000)
            findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
        }
    }
}