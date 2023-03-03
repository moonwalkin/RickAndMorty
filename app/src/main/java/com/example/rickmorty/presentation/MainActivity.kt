package com.example.rickmorty.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
import com.example.rickmorty.HasCustomTitle
import com.example.rickmorty.Navigator
import com.example.rickmorty.R
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.models.ItemUi
import com.example.rickmorty.domain.models.LocationInfoUi
import com.example.rickmorty.presentation.fragments.*

class MainActivity : AppCompatActivity(), Navigator {

    private var currentFragment: Fragment? = null

    private val lifecycleCallback = object : FragmentLifecycleCallbacks() {
        override fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?
        ) {
            currentFragment = f
            showNavigateUpButton()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.registerFragmentLifecycleCallbacks(lifecycleCallback, false)
    }

    override fun showLocations() {
        launchFragment(LocationsFragment())
    }

    override fun showDetails(item: ItemUi) {
        when (currentFragment) {
            is CharactersFragment -> {
                launchFragment(DetailsCharacterFragment.newInstance(item as CharacterUi))
            }
            is LocationsFragment -> {
                launchFragment(DetailsLocationFragment.newInstance(item as LocationInfoUi))
            }
            else -> {
                launchFragment(DetailsEpisodeFragment.newInstance(item as EpisodeUi))
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    override fun showEpisodes() {
        launchFragment(EpisodesFragment())
    }

    override fun showCharacters() {
        launchFragment(CharactersFragment())
    }

    override fun onDestroy() {
        super.onDestroy()
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(lifecycleCallback)
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null).commit()
    }

    private fun showNavigateUpButton() {
        val fragment = currentFragment
        if (fragment is HasCustomTitle) {
            title = getString(fragment.getTitleRes())
        }

        if (supportFragmentManager.backStackEntryCount > 0) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        } else {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
    }
}