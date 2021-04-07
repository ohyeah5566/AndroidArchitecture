package com.ohyeah5566.mvp

interface Contract {
    interface View{
        fun Afinish()
        fun Bfinish()
    }

    interface Presenter{
        fun processA()
        fun processB()
    }
}