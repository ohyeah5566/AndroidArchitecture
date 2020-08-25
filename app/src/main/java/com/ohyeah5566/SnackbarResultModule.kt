package com.ohyeah5566

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject
import javax.inject.Qualifier

@InstallIn(ActivityComponent::class)
@Module
abstract class SnackbarResultModule {
    @Qualifier
    annotation class SnackbarResult

    /**
     *  @Binds 告知Hilt用哪種方法實現ResultInterface
     *  @param implToast 傳入要實作ResultInterface的class,這邊用Toast實做 所以傳入ToastResultImpl
     */
    @Binds
    @SnackbarResult
    abstract fun bindPrintInterface(implToast: SnackbarResultImpl): ResultInterface

    /**
     * 實作ResultInterface
     * 在這邊加@Inject是為了告知Hilt該如何提供ToastResultImpl的實體
     *
     * constructor 用hilt提供的context , showResult時 只需要傳入text即可
     * //private val context: ActivityContext 不知道為什麼這個不行QQ
     */
    class SnackbarResultImpl @Inject constructor(@ActivityContext private val context: Context) :
        ResultInterface {
        override fun showResult(text: String) {
            val view = (context as Activity).window.decorView.findViewById<View>(android.R.id.content)
            Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show()
        }
    }
}
