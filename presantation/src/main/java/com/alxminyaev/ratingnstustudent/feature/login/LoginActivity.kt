package com.alxminyaev.ratingnstustudent.feature.login

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alxminyaev.ratingnstustudent.R
import com.alxminyaev.ratingnstustudent.databinding.ActivityLoginBinding
import com.alxminyaev.ratingnstustudent.feature.BaseActivity
import com.alxminyaev.ratingnstustudent.feature.LoaderScreen

class LoginActivity : BaseActivity(), LoaderScreen {
    companion object {
        private const val STATE_USERNAME = "STATE_USERNAME"
        private const val STATE_PASSWORD = "STATE_PASSWORD"
        private const val STATE_MESSAGE = "STATE_MESSAGE"
    }

    private lateinit var mBinding: ActivityLoginBinding
    private lateinit var mViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
            .create(LoginViewModel::class.java)
        if (savedInstanceState != null) {
            mViewModel.username = savedInstanceState.getString(STATE_USERNAME) ?: ""
            mViewModel.password = savedInstanceState.getString(STATE_PASSWORD) ?: ""
        }
    }

    private fun setupView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        mBinding.lifecycleOwner = this
        mBinding.btnLogin.setOnClickListener {
            showLoad()
            mViewModel.singIn()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        if (outState != null) {
            outState.putString(STATE_USERNAME, mViewModel.username)
            outState.putString(STATE_PASSWORD, mViewModel.password)
            outState.putString(STATE_MESSAGE, mViewModel.message.value)
        }
    }

    override fun showLoad() {
        mBinding.progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoad() {
        mBinding.progressBar.visibility = ProgressBar.INVISIBLE
    }
}