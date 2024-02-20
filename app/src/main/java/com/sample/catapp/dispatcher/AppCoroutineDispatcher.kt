package com.sample.catapp.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface AppCoroutineDispatcher {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}
