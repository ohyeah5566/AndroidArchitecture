package com.ohyeah5566

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.ohyeah5566.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var amiiboAdapter = AmiiboAdapter(listOf()) { url ->
        val dialog = ImageViewerDialog(url)
        dialog.show(supportFragmentManager, null)
    }

    val amiiboViewModel: AmiiboViewModel by viewModels()  //變成只要一個by viewModels()...太神啦

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewmodel = amiiboViewModel
        binding.amiiboAdapter = amiiboAdapter
        binding.lifecycleOwner = this  //如果有綁定跟viewModel liveData有關的需要設定lifecycleOwner

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

        binding.amiiboRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.searchEditText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                amiiboViewModel.searchAmiibo(binding.searchEditText.text.toString())
            }
            true
        }

        amiiboViewModel.errorMessage.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let { errorMsg ->
                Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
            }
        })

        amiiboViewModel.networkErrorEvent.observe(this, Observer { event ->
            event?.getContentIfNotHandled()?.let { errorMessage ->
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}