package com.ohyeah5566.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ohyeah5566.databinding.ActivityRecyclerBinding

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            recyclerView.adapter = RecyclerAdapter(
                listOf(
                    Color("#E52B50", "Amaranth"),
                    Color("#FFBF00", "Amber"),
                    Color("#9966CC", "Amethyst"),
                    Color("#7FFFD4", "Aquamarine"),
                    Color("#F5F5DC", "Beige"),
                    Color("#000000", "Black"),
                    Color("#E0B0FF", "Mauve"),
                    Color("#CCCCFF", "Periwinkle"),
                    Color("#C0C0C0", "Silver"),
                    Color("#FFFFFF", "White")
                )
            )
            recyclerView.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)

        }


    }

}