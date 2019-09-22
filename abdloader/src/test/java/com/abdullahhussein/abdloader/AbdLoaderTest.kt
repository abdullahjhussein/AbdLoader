package com.abdullahhussein.abdloader


import android.content.Context
import android.os.Build
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class AbdLoaderTest {

    @Mock
    lateinit var context: Context

    private val url = "https://jsonplaceholder.typicode.com/todos/1"
    private val result = "{\n" +
            "  \"userId\": 1,\n" +
            "  \"id\": 1,\n" +
            "  \"title\": \"delectus aut autem\",\n" +
            "  \"completed\": false\n" +
            "}"

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        AbdLoader.initialize(context)
    }

    @Test
    fun testLoadUrl() {
        val data = runBlocking { AbdLoader.load(url) }
        Assert.assertEquals(result, data)
    }
}