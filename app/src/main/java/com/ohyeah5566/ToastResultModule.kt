package com.ohyeah5566

import android.content.Context
import android.widget.Toast
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

@InstallIn(ActivityComponent::class)
@Module
abstract class ToastResultModule {

    /**
     *  @Binds 告知Hilt用哪種方法實現ResultInterface
     *  @param implToast 傳入要實作ResultInterface的class,這邊用Toast實做 所以傳入ToastResultImpl
     */
    @Binds
    abstract fun bindPrintInterface(implToast: ToastResultImpl): ResultInterface

    /**
     * 實作ResultInterface
     * 在這邊加@Inject是為了告知Hilt該如何提供ToastResultImpl的實體
     *
     * constructor 用hilt提供的context , showResult時 只需要傳入text即可
     * //private val context: ActivityContext 不知道為什麼這個不行QQ
     */
    class ToastResultImpl @Inject constructor(@ActivityContext private val context: Context) :
        ResultInterface {
        override fun showResult(text: String) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }
    }
}
