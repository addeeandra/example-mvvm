package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private val mViewModel by lazy {
//        ViewModelProvider
//            .AndroidViewModelFactory
//            .getInstance(application)
//            .create(MainViewModel::class.java)
//    }

    private val mBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        mBinding.viewmodel.toastMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            Log.d("ASDASD", it)
        })

        mBinding.viewmodel.action.observe(this, Observer {
            if (it == MainViewModel.OPEN_HOME_PAGE) {
                // INTENT HOME PAGE
            } else if (it == MainViewModel.OPEN_REGISTER_PAGE) {
                // INTENT REGISTER PAGE
            }
        })
    }
}
