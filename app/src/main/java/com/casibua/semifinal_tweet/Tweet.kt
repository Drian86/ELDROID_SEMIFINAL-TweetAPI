package com.casibua.semifinal_tweet

data class Tweet(
    val id: String,
    val name: String,
    val description: String,
    val timestamp: Timestamp
)

data class Timestamp(
    val _seconds: Long,
    val _nanoseconds: Long
)
