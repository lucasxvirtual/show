package com.lucasxvirtual.data.remote

import com.lucasxvirtual.data.BuildConfig
import com.lucasxvirtual.data.model.EpisodeResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface SeasonService {

    @GET("seasons/{id}/episodes")
    suspend fun getEpisodesOfSeason(
        @Path("id") id : Int
    ) : List<EpisodeResponse>

    companion object {
        private const val BASE_URL = BuildConfig.BASE_URL

        fun create(): SeasonService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SeasonService::class.java)
        }
    }

}