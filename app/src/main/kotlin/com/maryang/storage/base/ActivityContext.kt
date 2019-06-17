package com.maryang.storage.base

import android.content.Context

interface ActivityContext {
    fun showLoading()
    fun hideLoading()
    fun getContext(): Context
    fun toast(message: String)
}
