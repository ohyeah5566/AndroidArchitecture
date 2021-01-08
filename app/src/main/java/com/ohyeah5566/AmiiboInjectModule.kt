package com.ohyeah5566

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 *  提供amiiboServer 給 amiiboRepository
 */
@Module
@InstallIn(ActivityComponent::class)
class AmiiboInjectModule {

    @Provides
    fun provideAmiiboServer() : AmiiboService{
        return getAmiiboService()
    }
}