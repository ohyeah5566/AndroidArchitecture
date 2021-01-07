package com.ohyeah5566

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.ohyeah5566.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var amiiboAdapter = AmiiboAdapter(listOf()) { url ->
        val dialog = ImageViewerDialog(url)
        dialog.show(supportFragmentManager, null)
    }
    val viewModel by lazy {
        AmiiboViewModel(AmiiboRepository(getAmiiboService())) //TODO viewModuleFactory, hilt inject
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // init spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.search_type,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.searchTypeSpinner.adapter = adapter
        }

        binding.searchTypeSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {}

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val type = parent?.getItemAtPosition(position) as String
                }
            }

        binding.amiiboRecyclerView.adapter = amiiboAdapter
        binding.amiiboRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.searchEditText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.searchAmiibo(binding.searchEditText.text.toString())
            }
            true
        }

        viewModel.amiiboLists.observe(this, Observer { list ->
            amiiboAdapter.updateList(list)
        })
    }
}