package com.lucasxvirtual.data.remote

import com.lucasxvirtual.data.BuildConfig
import com.lucasxvirtual.data.model.SearchResponse
import com.lucasxvirtual.data.model.SeasonResponse
import com.lucasxvirtual.data.model.ShowResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ShowService {

    @GET("shows")
    suspend fun getShows(
        @Query("page") page : Int
    ) : List<ShowResponse>

    @GET("shows/{id}/seasons")
    suspend fun getSeasonsOfShow(
        @Path("id") id : Int
    ) : List<SeasonResponse>

    @GET("search/shows")
    suspend fun searchShow(
        @Query("q") query : String
    ) : List<SearchResponse>

    companion object {
        private const val BASE_URL = BuildConfig.BASE_URL

        fun create(): ShowService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ShowService::class.java)
        }
    }

}