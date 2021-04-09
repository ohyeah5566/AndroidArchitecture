package com.ohyeah5566

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import io.mockk.mockk
import org.junit.Test

class LifecycleTest {

    @Test
    fun presenterCleanUpTest() {
        val lifecycleOwner = mockk<LifecycleOwner>()
        val lifecycleRegister = LifecycleRegistry(lifecycleOwner)

        val view = mockk<Contract.View>()
        val presenter = Presenter(view, lifecycleRegister)
        //在切換到ON_DESTROY之前 一定要先切到別的狀態
        //主要是因為 上面建起來的presenter lifecycle狀態會是在INITIALIZED
        //lifecycle在INITIALIZED的state 遇到 DESTROYED 會throw IllegalArgumentException
        //所以要先給presenter一個INITIALIZED以外的狀態 才可以切換到ON_DESTROY
        lifecycleRegister.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        lifecycleRegister.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)

        assert(presenter.view == null)
    }
}