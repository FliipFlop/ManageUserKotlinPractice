package com.example.manageuserkotlinpractice.application

import android.content.Context

object Contextor {
    private var instance: Contextor? = null

    fun getInstance(): Contextor? {
        if (instance == null) instance = instance
        return instance
    }

    private var mContext: Context? = null

    fun init(context: Context) {
        mContext = context
    }

    fun getContext(): Context? {
        return mContext
    }
}