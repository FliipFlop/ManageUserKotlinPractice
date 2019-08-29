package com.example.manageuserkotlinpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.manageuserkotlinpractice.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.contentContainer , MainFragment.newInstance())
                .commit()
        }
    }
}
