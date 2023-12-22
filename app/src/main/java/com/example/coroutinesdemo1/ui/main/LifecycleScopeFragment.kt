package com.example.coroutinesdemo1.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesdemo1.R

class LifecycleScopeFragment : Fragment() {

    companion object {
        fun newInstance() = LifecycleScopeFragment()
    }

    private lateinit var viewModel: LifecycleScopeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LifecycleScopeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_lifecycle_scope, container, false)
    }

}