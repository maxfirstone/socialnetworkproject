package com.example.thesocialnetwork.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thesocialnetwork.Creator
import com.example.thesocialnetwork.Post
import com.example.thesocialnetwork.PostType
import com.example.thesocialnetwork.R
import com.example.thesocialnetwork.User
class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FeedAdapter(
            posts = listOf(
                Post(
                    id = "1",
                    text = "Post text 1",
                    type = PostType.Text,
                    creator = Creator(
                        user = User(
                            fullName = "Joel Maximiliano Fleita",
                            profilePicture = "https://www.contextotucuman.com/uploads/2016/07/22/92735_rohitkhandelwal1.jpg"
                        )
                    )
                ),

                Post(
                    id = "2",
                    text = "Post text 3",
                    type = PostType.Text,
                    creator = Creator(
                        user = User(
                            fullName = "Emiliano Fleita",
                            profilePicture = "https://www.jordanharbinger.com/wp-content/uploads/2018/09/be-the-most-interesting.jpg"
                        )
                    )
                ),
                Post(
                    id = "3",
                    text = "Post text 3",
                    type = PostType.Text,
                    creator = Creator(
                        user = User(
                            fullName = "Hernan Scheck",
                            profilePicture = "https://descubrepolonia.net/wp-content/uploads/2020/01/tipico-polaco.jpg"
                        )
                    )

                )
            )
        )

    }

}