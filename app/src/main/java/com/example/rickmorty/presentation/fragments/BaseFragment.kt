package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.rickmorty.RickMortyApp
import com.example.rickmorty.presentation.viewmodels.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    protected val binding: VB
        get() = checkNotNull(_binding) { "Fragment == null" }

    abstract fun getViewBinding(): VB

    @Inject
    lateinit var factory: ViewModelFactory

    protected val component by lazy {
        (requireActivity().application as RickMortyApp).component
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()
        return binding.root
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}