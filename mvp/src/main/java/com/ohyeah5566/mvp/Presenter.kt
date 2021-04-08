package com.ohyeah5566.mvp

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Presenter(
    private var view: Contract.View?,
    private val lifecycle: Lifecycle
) : Contract.Presenter, LifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    override fun processA() {
        Thread {
            Thread.sleep(5000)
            view?.Afinish()
        }.start()
    }

    override fun processB() {
        Handler(Looper.getMainLooper()).postDelayed(
            { view?.Bfinish() },
            10000
        )
    }

//   透過announce 讓傳進來的view的生命週期在onDestroy時會會觸發這個function
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun cleanUp() {
        println("presenter cleanUp")
        view = null
    }


}