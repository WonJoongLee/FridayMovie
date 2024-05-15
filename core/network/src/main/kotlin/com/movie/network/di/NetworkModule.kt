package com.movie.network.di

import androidx.tracing.trace
import com.movie.fridaymovie.core.network.BuildConfig
import com.movie.network.FridayMovieNetworkDataSource
import com.movie.network.retrofit.FridayMovieRetrofitNetwork
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkModule {

    @Binds
    @Singleton
    abstract fun provideFridayMovieNetworkDataSource(
        fridayMovieRetrofitNetwork: FridayMovieRetrofitNetwork,
    ): FridayMovieNetworkDataSource

    companion object {
        @Provides
        @Singleton
        fun providesNetworkJson(): Json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }

        @Provides
        @Singleton
        fun okHttpCallFactory(): Call.Factory = trace("FridayMovieOkHttpClient") {
            OkHttpClient.Builder()
                .apply {
                    addInterceptor {
                        it.proceed(
                            it.request().newBuilder()
                                .apply {
                                    addHeader(
                                        "Authorization",
                                        "Bearer ${BuildConfig.TMDB_API_KEY}"
                                    )
                                }
                                .build()
                        )
                    }
                }
                .build()
        }
    }
}
