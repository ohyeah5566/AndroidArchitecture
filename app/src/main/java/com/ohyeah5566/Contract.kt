package com.ohyeah5566

interface Contract {
    interface View{
        fun Afinish()
        fun Bfinish()
    }

    interface Presenter{
        fun processA()
        fun processB()
        fun cleanUp()
    }
}