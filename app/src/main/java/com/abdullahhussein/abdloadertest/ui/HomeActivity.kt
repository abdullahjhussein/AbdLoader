package com.abdullahhussein.abdloadertest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.abdullahhussein.abdloadertest.R
import com.abdullahhussein.abdloadertest.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewDataBinding: ActivityHomeBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_home)

        val mHomeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewDataBinding.viewModel = mHomeViewModel
        viewDataBinding.lifecycleOwner = this

        mHomeViewModel.getImagesData()
    }
}