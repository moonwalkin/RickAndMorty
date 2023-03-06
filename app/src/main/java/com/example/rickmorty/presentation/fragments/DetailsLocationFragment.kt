package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import com.example.rickmorty.presentation.HasCustomTitle
import com.example.rickmorty.R
import com.example.rickmorty.databinding.FragmentDetailsLocationBinding
import com.example.rickmorty.domain.models.LocationInfoUi

class DetailsLocationFragment : BaseFragment<FragmentDetailsLocationBinding>(), HasCustomTitle {
    override fun getViewBinding() = FragmentDetailsLocationBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val location = requireArguments().getSerializable(LOCATION) as LocationInfoUi
            binding.apply {
                tvDimension.text = getString(R.string.location_dimension,location.dimension)
                tvLocationName.text = getString(R.string.location_name, location.name)
                tvType.text = getString(R.string.location_type, location.type)
            }
    }

    override fun getTitleRes() = R.string.title_location_details

    companion object {
        private const val LOCATION = "location"

        fun newInstance(location: LocationInfoUi) = DetailsLocationFragment().apply {
            arguments = Bundle().apply {
                putSerializable(LOCATION, location)
            }
        }
    }

}