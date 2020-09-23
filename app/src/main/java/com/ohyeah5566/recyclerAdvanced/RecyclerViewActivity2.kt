package com.ohyeah5566.recyclerAdvanced

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ohyeah5566.databinding.ActivityRecyclerBinding

class RecyclerViewActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            recyclerView.adapter = AdvancedRecyclerAdapter(
                mutableListOf(
                    Msg("", ""),
                    Msg("1", "q"),
                    Msg("2", "w"),
                    Msg("3", "e"),
                    Msg("4", "r"),
                    Msg("5", "t"),
                    Msg("6", "y"),
                    Msg("6", "y"),
                    Msg("6", "y"),
                    Msg("6", "y"),
                    Msg("6", "y"),
                    Msg("6", "y"),
                    Msg("6", "y")

                )
            )
            recyclerView.layoutManager =
                androidx.recyclerview.widget.LinearLayoutManager(this@RecyclerViewActivity2)

        }
    }
}