package com.alxminyaev.ratingnstustudent.feature.login

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alxminyaev.ratingnstustudent.R
import com.alxminyaev.ratingnstustudent.databinding.ActivityLoginBinding
import com.alxminyaev.ratingnstustudent.feature.BaseActivity

class LoginActivity : BaseActivity() {
    companion object {
        private const val STATE_USERNAME = "STATE_USERNAME"
        private const val STATE_PASSWORD = "STATE_PASSWORD"
        private const val STATE_MESSAGE = "STATE_MESSAGE"
    }

    private lateinit var mBinding: ActivityLoginBinding
    private lateinit var mViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel(savedInstanceState)
        setupView(mViewModel)
    }

    private fun setupViewModel(savedInstanceState: Bundle?) {
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
            .create(LoginViewModel::class.java)
        if (savedInstanceState != null) {
            mViewModel.username = savedInstanceState.getString(STATE_USERNAME) ?: ""
            mViewModel.password = savedInstanceState.getString(STATE_PASSWORD) ?: ""
            mViewModel.message.set(savedInstanceState.getString(STATE_MESSAGE) ?: "")
        }
    }

    private fun setupView(loginViewModel: LoginViewModel) {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = loginViewModel
    }

    override fun onStart() {
        super.onStart()
        mViewModel.student.observe(this, Observer {
            Log.d("LOGIN", "Student auth is success")
        })
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        if (outState != null) {
            outState.putString(STATE_USERNAME, mViewModel.username)
            outState.putString(STATE_PASSWORD, mViewModel.password)
        }
    }
}