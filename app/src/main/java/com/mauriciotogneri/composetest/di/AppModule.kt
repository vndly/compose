package com.mauriciotogneri.composetest.di

import android.content.Context
import com.mauriciotogneri.composetest.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun extraSingleton() = "This is the extra"

    @Singleton
    @Provides
    fun providesSingleton(
        extra: String,
        @ApplicationContext context: Context
    ) = "${context.getString(R.string.app_name)} - $extra"
}