package com.example.main

/**
 * Created by ls on 18/5/3.
 */
enum class ProtocolState {
    WATING {
        override fun signal(): ProtocolState {
            return Taking
        }
    },
    Taking {
        override fun signal(): ProtocolState {
            return WATING
        }
    };

    abstract fun signal(): ProtocolState

}