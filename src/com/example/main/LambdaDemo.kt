package com.example.main


/**
 * Created by ls on 18/4/16.
 */
class LambdaDemo {
    private var faildListener: ResponseFaildCallback? = null
    fun setListener(listener: () -> Unit) {
    }

    fun setFaildListener(listener: (Exception) -> Unit) {
        listener.invoke(Exception(""))
    }
}