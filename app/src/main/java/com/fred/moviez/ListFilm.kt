package com.fred.moviez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFilm : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var List: ArrayList<New>
    lateinit var itemImages : Array<Int>
    lateinit var itemTitles : Array<String>
    lateinit var itemRating : Array<String>
    lateinit var itemGenre : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        itemImages = arrayOf(
            R.drawable.black_widow,
            R.drawable.snake_eyes,
            R.drawable.hitmans,
            R.drawable.space_jam,
            R.drawable.the_boss_baby,
            R.drawable.escape_room,
        )

        itemTitles = arrayOf(
            "BLACK WIDOW",
            "SNAKE EYES",
            "HITMANS WIFES BODYGUARD",
            "SPACE JAM: A NEW LEGACY",
            "THE BOSS BABY: FAMILY BUSINESS",
            "ESCAPE ROOM: TOURNAMENT OF CHAMPIONS",
        )

        itemRating = arrayOf(
            "R 13+",
            "R 13+",
            "D 17+",
            "SU",
            "SU",
            "R 13+",
        )

        itemGenre = arrayOf(
            "Action, Adventure,Sci-fi",
            "Action",
            "Action, Comedy, Crime",
            "Animation",
            "Animation, Adventure, Comedy",
            "Thriller",
        )

        recyclerView = findViewById(R.id.recycler_View)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        List = arrayListOf<New>()
        getData()
    }

    private fun getData() {
        for(i in itemImages.indices)
            List.add(New(itemImages[i],itemTitles[i],itemRating[i],itemGenre[i]))

        recyclerView.adapter = MyAdapter(List)
    }
}