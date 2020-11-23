package com.ohyeah5566

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking(Dispatchers.IO) {
            val listD = mutableListOf<Deferred<Int>>()
            val listR = mutableListOf<Int>()
            for (i in 0..10) {
                listD.add(getNumbers(i))
            }
            listD.forEach {
                listR.add(it.await())
            }
            listR.forEach {
                Log.d(TAG, "it:$it")
            }


        }
    }

    suspend fun getNumbers(input: Int) = async {
        Log.d(TAG, "input:$input")
        delay(input * 500L)
        input
    }


    override val coroutineContext: CoroutineContext
        get() = job
    private val job = Job()
}