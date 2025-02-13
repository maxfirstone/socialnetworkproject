package com.example.aprendiendoxml2.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendiendoxml2.Creator
import com.example.aprendiendoxml2.Post
import com.example.aprendiendoxml2.R
import com.example.aprendiendoxml2.User

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
                    creator = Creator(
                        user = User (
                            fullName = "Joel Maximiliano Fleita",
                            profilePicture = "https://www.contextotucuman.com/uploads/2016/07/22/92735_rohitkhandelwal1.jpg"
                        )
                    )
                ),

                Post(
                    id = "2",
                    text = "Post text 3",
                    creator = Creator(
                        user = User (
                            fullName = "Emiliano Fleita",
                            profilePicture = "https://www.jordanharbinger.com/wp-content/uploads/2018/09/be-the-most-interesting.jpg"
                        )
                    )
                ),
            Post(
                id = "3",
                text = "Post text 3",
                creator = Creator(
                    user = User (
                        fullName = "Hernan Scheck",
                        profilePicture = "https://descubrepolonia.net/wp-content/uploads/2020/01/tipico-polaco.jpg"
                )
            )

            )
            )
        )

    }

}