package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.rickmorty.RickMortyApp
import com.example.rickmorty.di.ApplicationComponent
import com.example.rickmorty.domain.Result
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.ItemUi
import com.example.rickmorty.navigate
import com.example.rickmorty.presentation.adapter.RickMortyAdapter
import com.example.rickmorty.presentation.viewmodels.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    protected val binding: VB
        get() = checkNotNull(_binding) { "Fragment == null" }

    protected val adapter = RickMortyAdapter { item ->
        navigate().showDetails(item)
    }
    abstract fun getViewBinding(): VB

    @Inject
    lateinit var factory: ViewModelFactory

    protected val component: ApplicationComponent by lazy {
        (requireActivity().application as RickMortyApp).component
    }

    protected fun <T : ItemUi> show(
        textView: TextView,
        progressBar: ProgressBar,
        result: Result<List<T>>
    ) {
        when (result) {
            is Result.Loading -> {
                progressBar.isVisible = true
            }
            is Result.Success -> {
                progressBar.isVisible = false
                adapter.submitList(result.data)
            }
            is Result.Error -> {
                textView.isVisible = true
                textView.text = result.exception.message
                progressBar.isVisible = false
            }
        }
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