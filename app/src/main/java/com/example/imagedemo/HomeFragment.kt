package com.example.imagedemo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imagedemo.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val homeViewModel:HomeViewModel by viewModels()


    override fun onStart() {
        super.onStart()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val root : View = binding.root

        val recyclerView : RecyclerView = binding.recyclerView

        getRV()

        homeViewModel.getRecentPhoto().observe(viewLifecycleOwner) {
            recyclerView.adapter = RVAdapter(it.photoList!!)
        }


        return root
    }

    private fun getRV() {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context,3)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}