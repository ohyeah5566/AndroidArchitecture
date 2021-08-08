object Versions {
    const val android_gradle = "4.0.2"
    const val kotlin_gradle_plugin = "1.5.21"
    const val recycler_view = "1.2.1"
    const val retrofit = "2.9.0"
    const val lifecycle_version = "2.3.1"
}

//發現這邊要用const,不然在gradle使用 會需要Libs.INSTANCE.xxx
//不過看其他範例都沒這個問題 奇怪
object Libs {
    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_gradle_plugin}"

    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_gradle_plugin}"

    const val recycler_view = "androidx.recyclerview:recyclerview:${Versions.recycler_view}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_converter_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    const val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
}

//如果要分類也可以多幾個object
object AndroidX{

}
object Jetpack{

}
object Test{

}