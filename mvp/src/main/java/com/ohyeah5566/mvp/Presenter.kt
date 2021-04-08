package com.ohyeah5566.mvp

import android.os.Handler
import android.os.Looper

class Presenter(
    private var view: Contract.View?
) : Contract.Presenter {

    override fun processA() {
        Thread {
            Thread.sleep(5000)
            view?.Afinish()
        }.start()
    }

    override fun processB() {
        Handler(Looper.getMainLooper()).postDelayed({
                view?.Bfinish()
            },
            10000
        )
    }

    override fun cleanUp() {
        println("presenter cleanUp")
        view = null
    }


}