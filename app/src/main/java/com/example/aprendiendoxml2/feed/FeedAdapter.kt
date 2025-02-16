package com.example.aprendiendoxml2.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aprendiendoxml2.Post
import com.example.aprendiendoxml2.R

class FeedAdapter (
    private val posts : List<Post>
) : RecyclerView.Adapter<FeedAdapter.PostViewHolder>() {

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val profilePictureImageView = view.findViewById<ImageView>(R.id.profilePicture)
        private val creatorTextView = view.findViewById<TextView>(R.id.creator)
        private val postTextView = view.findViewById<TextView>(R.id.post)

        fun bind(post: Post) {
            postTextView.text = post.text
            creatorTextView.text = post.creator.user.fullName

            // Glide image
            Glide.with(profilePictureImageView.context)
                .load(post.creator.user.profilePicture)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(profilePictureImageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
       return PostViewHolder(view)

    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

}