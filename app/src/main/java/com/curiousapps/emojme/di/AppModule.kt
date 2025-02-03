package com.curiousapps.emojme.di

import com.curiousapps.emojme.data.MoJiRepositoryImpl
import com.curiousapps.emojme.domain.MoJiRepository
import com.curiousapps.emojme.network.MoJApi
import com.curiousapps.emojme.util.MOJI_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoJiRepo(
        api: MoJApi
    ): MoJiRepository = MoJiRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideMoJiApi(): MoJApi{
        return Retrofit.Builder()
            .baseUrl(MOJI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoJApi::class.java)
    }
}