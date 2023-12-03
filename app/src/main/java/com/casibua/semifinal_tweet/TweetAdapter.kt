package com.casibua.semifinal_tweet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TweetAdapter(private var tweets: List<Tweet>) : RecyclerView.Adapter<TweetAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tweet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tweet = tweets[position]
        holder.bind(tweet)
    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    fun setTweets(tweets: List<Tweet>) {
        this.tweets = tweets
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

        fun bind(tweet: Tweet) {
            nameTextView.text = tweet.name
            descriptionTextView.text = tweet.description
        }
    }
}
