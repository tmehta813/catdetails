package com.sample.catapp.dispatcher

import kotlinx.coroutines.Dispatchers
import org.junit.Assert.assertEquals
import org.junit.Test

class AppCoroutineDispatcherImplTest {

    @Test
    fun `test main dispatcher`() {
        // Create an instance of AppCoroutineDispatcherImpl
        val dispatcher: AppCoroutineDispatcher = AppCoroutineDispatcherImpl()

        // Check if the main dispatcher is Dispatchers.Main
        assertEquals(Dispatchers.Main, dispatcher.main)
    }

    @Test
    fun `test io dispatcher`() {
        // Create an instance of AppCoroutineDispatcherImpl
        val dispatcher: AppCoroutineDispatcher = AppCoroutineDispatcherImpl()

        // Check if the io dispatcher is Dispatchers.IO
        assertEquals(Dispatchers.IO, dispatcher.io)
    }

    @Test
    fun `test default dispatcher`() {
        // Create an instance of AppCoroutineDispatcherImpl
        val dispatcher: AppCoroutineDispatcher = AppCoroutineDispatcherImpl()

        // Check if the default dispatcher is Dispatchers.Default
        assertEquals(Dispatchers.Default, dispatcher.default)
    }

    @Test
    fun `test unconfined dispatcher`() {
        // Create an instance of AppCoroutineDispatcherImpl
        val dispatcher: AppCoroutineDispatcher = AppCoroutineDispatcherImpl()

        // Check if the unconfined dispatcher is Dispatchers.Unconfined
        assertEquals(Dispatchers.Unconfined, dispatcher.unconfined)
    }
}
