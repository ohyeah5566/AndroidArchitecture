object Versions{
    const val android_gradle = "4.1.3"
    const val kotlin_version = "1.5.21"
    const val core_ktx = "1.6.0"
    const val fragment_ktx = "1.3.6"
    const val activity_ktx = "1.3.0"

    const val appcompat = "1.3.1"
    const val constrantlayout = "2.1.0"
    const val recycler_view = "1.0.0"
    const val viewpager = "1.0.0"
    const val material = "1.4.0"

    const val retrofit = "2.9.0"
    const val logging_interceptor = "4.9.0"
    const val moshi_kotlin = "1.12.0"

    const val coroutine = "1.5.1"

    const val lifecycle = "2.3.1"

    const val room = "2.3.0"

    const val coil = "1.3.1"

    //Test
    const val junit = "4.13.2"
    const val androidx_junit = "1.1.3"
    const val espresso_core = "3.4.0"
    const val mockk = "1.12.0"
    const val core_testing = "2.1.0"

}

object Deps {
    const val android_gradle = "com.android.tools.build:gradle:${Versions.android_gradle}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
    const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin_version}"

    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.fragment_ktx}"
    const val activity_ktx = "androidx.activity:activity-ktx:${Versions.activity_ktx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constrantlayout}"

    const val recycler_view = "androidx.recyclerview:recyclerview:${Versions.recycler_view}"
    const val viewpager = "androidx.viewpager2:viewpager2:${Versions.viewpager}"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"

    const val coroutine_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutine_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    const val coroutine_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"

    const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    const val moshi_kotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi_kotlin}"

    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val room_testing = "androidx.room:room-testing:${Versions.room}"

    const val coil = "io.coil-kt:coil:${Versions.coil}"

    //test
    const val junit = "junit:junit:${Versions.junit}"
    const val androidx_junit ="androidx.test.ext:junit:${Versions.androidx_junit}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val core_testing = "androidx.arch.core:core-testing:${Versions.core_testing}"
}


