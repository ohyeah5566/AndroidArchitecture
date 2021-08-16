package com.ohyeah5566.di

import android.content.Context
import com.ohyeah5566.db.PostDao
import com.ohyeah5566.db.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ViewModelComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun providePostDatabase(@ApplicationContext context: Context): PostDatabase {
        return PostDatabase.getInstance(context)
    }

    @Provides
    fun providePostDao(postDatabase: PostDatabase): PostDao {
        return postDatabase.transactionDao()
    }

}