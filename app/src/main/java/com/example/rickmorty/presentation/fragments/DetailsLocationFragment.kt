package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.rickmorty.HasCustomTitle
import com.example.rickmorty.R
import com.example.rickmorty.databinding.FragmentDetailsLocationBinding
import com.example.rickmorty.presentation.viewmodels.LocationViewModel

class DetailsLocationFragment : BaseFragment<FragmentDetailsLocationBinding>(), HasCustomTitle {
    override fun getViewBinding() = FragmentDetailsLocationBinding.inflate(layoutInflater)
    private val viewModel: LocationViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchSingleLocation(requireArguments().getInt(LOCATION_ID))
        viewModel.observeSingleLocation(viewLifecycleOwner) { location ->
            binding.apply {
                tvDimension.text = getString(R.string.location_dimension,location.dimension)
                tvLocationName.text = getString(R.string.location_name, location.name)
                tvType.text = getString(R.string.location_type, location.type)
            }
        }
    }

    override fun getTitleRes() = R.string.title_location_details

    companion object {
        private const val LOCATION_ID = "location_id"

        fun newInstance(id: Int) = DetailsLocationFragment().apply {
            arguments = Bundle().apply {
                putInt(LOCATION_ID, id)
            }
        }
    }

}