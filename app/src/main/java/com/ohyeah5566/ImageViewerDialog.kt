package com.ohyeah5566

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.ohyeah5566.databinding.ImageViewerBinding

class ImageViewerDialog(private val imageUrl: String) : DialogFragment() {
    private lateinit var binding: ImageViewerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.setCanceledOnTouchOutside(true)

        binding = ImageViewerBinding.inflate(layoutInflater, container, false)
        Glide.with(requireContext())
            .load(imageUrl)
            .into(binding.imageView)
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.ImageViewerDialog)
    }


}