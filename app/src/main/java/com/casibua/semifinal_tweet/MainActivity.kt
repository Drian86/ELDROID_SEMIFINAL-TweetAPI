package com.casibua.semifinal_tweet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tweetAdapter: TweetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the adapter with an empty list
        tweetAdapter = TweetAdapter(emptyList())
        recyclerView.adapter = tweetAdapter

        fetchTweets()
    }

    private fun fetchTweets() {
        val call = RetrofitClient.apiService.getAllTweets()
        call.enqueue(object : Callback<List<Tweet>> {
            override fun onResponse(call: Call<List<Tweet>>, response: Response<List<Tweet>>) {
                if (response.isSuccessful) {
                    val tweets = response.body()
                    tweets?.let {
                        tweetAdapter.setTweets(it)
                    }
                } else {
                    // Handle the error
                }
            }

            override fun onFailure(call: Call<List<Tweet>>, t: Throwable) {
                // Handle network failure
            }
        })
    }
}
