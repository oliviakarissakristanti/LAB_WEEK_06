package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender
import androidx.recyclerview.widget.ItemTouchHelper

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }


    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male, CatBreed.ExoticShorthair, "Tom", "Loves sleeping all day", "https://cdn2.thecatapi.com/images/bpc.jpg"),
                CatModel(Gender.Female, CatBreed.BalineseJavanese, "Luna", "Loves chasing laser pointers", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
                CatModel(Gender.Female, CatBreed.AmericanCurl, "Mochi", "Cuddly and playful", "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"),
                CatModel(Gender.Male, CatBreed.ExoticShorthair, "Leo", "Friendly neighborhood cat", "https://cdn2.thecatapi.com/images/4r0.jpg"),
                CatModel(Gender.Male, CatBreed.AmericanCurl, "Simba", "Likes to nap in the sun", "https://cdn2.thecatapi.com/images/9ep.jpg"),
                CatModel(Gender.Female, CatBreed.BalineseJavanese, "Nala", "Always hungry for treats", "https://cdn2.thecatapi.com/images/MTgwODA1OQ.jpg"),
                CatModel(Gender.Unknown, CatBreed.ExoticShorthair, "Shadow", "Mysterious and quiet", "https://cdn2.thecatapi.com/images/8q2.jpg")
            )
        )

    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
