package com.austen.cloudmusic.di

import com.austen.cloudmusic.BuildConfig
import com.austen.cloudmusic.common.net.AppNetEnv
import com.austen.cloudmusic.http.api.LoginApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/12/30-01:30
 * ================================================
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class NormalOkHttpClient

    @Provides
    @Singleton
    fun provideLoginService(@NetworkModule.NormalOkHttpClient client: OkHttpClient): LoginApiService {
        return Retrofit.Builder()
            .baseUrl(AppNetEnv.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoginApiService::class.java)
    }

    @NormalOkHttpClient
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logger =
            HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BASIC
                } else {
                    HttpLoggingInterceptor.Level.BODY
                }
            }

        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }
}