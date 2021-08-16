package com.ohyeah5566.di

import com.ohyeah5566.api.PostService
import com.ohyeah5566.api.getPostService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
class NetworkModule {

    @Provides
    fun providePostService() : PostService {
        return getPostService()
    }
}