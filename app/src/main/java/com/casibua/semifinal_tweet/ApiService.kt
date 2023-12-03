package com.casibua.semifinal_tweet

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("tweet/casibua")
    fun getAllTweets(): Call<List<Tweet>>

    @GET("tweet/casibua/{tweetId}")
    fun getTweetById(@Path("tweetId") tweetId: String): Call<Tweet>

    @POST("tweet/casibua")
    fun createTweet(@Body tweet: Tweet): Call<Map<String, String>>

    @PUT("tweet/casibua/{tweetId}")
    fun updateTweet(@Path("tweetId") tweetId: String, @Body tweet: Tweet): Call<Map<String, String>>

    @DELETE("tweet/casibua/{tweetId}")
    fun deleteTweet(@Path("tweetId") tweetId: String): Call<Map<String, String>>
}
