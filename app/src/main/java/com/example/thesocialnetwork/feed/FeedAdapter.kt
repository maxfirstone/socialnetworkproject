package com.example.thesocialnetwork.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thesocialnetwork.Post
import com.example.thesocialnetwork.PostType
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.databinding.ItemPostBinding
import com.example.thesocialnetwork.databinding.ItemPostImageBinding

class FeedAdapter(
    private val posts: List<Post> = emptyList()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class TextPostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            post.text?.let { text ->
                binding.post.text = text
            }

            post.creator?.user?.profilePicture?.let {
                // Glide image
                Glide.with(itemView.context)
                    .load(post.creator.user.profilePicture)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.profilePicture)
            }
            post.creator?.user?.fullName?.let { fullName ->
                binding.creator.text = fullName
            }

        }
    }

    class ImagePostViewHolder(private val binding: ItemPostImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            post.text?.let { text ->
                binding.post.text = text
            }

            post.creator?.user?.profilePicture?.let {
                // Glide image
                Glide.with(itemView.context)
                    .load(post.creator.user.profilePicture)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.profilePicture)
            }
            post.creator?.user?.fullName?.let { fullName ->
                binding.creator.text = fullName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // En lugar de inflar una vista, lo que vamos a hacer es vincular una vista, con el mismo layou_inflater
        when (viewType) {
            (PostType.Text.ordinal) -> {
                val binding =
                    ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return TextPostViewHolder(binding)
            }

            (PostType.Image.ordinal) -> {
                val binding =
                    ItemPostImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ImagePostViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Tipo de vista no válido: $viewType")
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = posts[position]
        when (holder) {
            is TextPostViewHolder -> holder.bind(post)
            is ImagePostViewHolder -> holder.bind(post)
            else -> throw IllegalArgumentException("Tipo de ViewHolder no válido")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return posts[position].type.ordinal
    }
}