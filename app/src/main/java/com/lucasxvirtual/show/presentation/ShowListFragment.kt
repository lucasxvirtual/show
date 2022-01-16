package com.lucasxvirtual.show.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.lucasxvirtual.data.remote.Status
import com.lucasxvirtual.show.databinding.FragmentShowListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ShowListFragment : Fragment() {

    private val viewModel : ShowViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShowListBinding.inflate(inflater, container, false)

        binding.apply {
            lifecycleOwner = this@ShowListFragment
        }

        lifecycleScope.launch {
            viewModel.showList.collect {
                when(it.status){
                    Status.SUCCESS -> {

                    }
                    Status.LOADING -> {

                    }
                }
            }
        }

        return binding.root
    }

}