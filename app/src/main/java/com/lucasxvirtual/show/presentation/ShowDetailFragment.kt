package com.lucasxvirtual.show.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lucasxvirtual.show.databinding.FragmentShowDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShowDetailBinding.inflate(inflater, container, false)

        binding.apply {
            lifecycleOwner = this@ShowDetailFragment
        }

        return binding.root
    }

}