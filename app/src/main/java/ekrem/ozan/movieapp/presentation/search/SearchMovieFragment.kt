package ekrem.ozan.movieapp.presentation.search

import android.graphics.Color
import android.transition.TransitionInflater
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import ekrem.ozan.movieapp.R
import ekrem.ozan.movieapp.base.extension.clickSubmitButton
import ekrem.ozan.movieapp.base.view.BaseFragment
import ekrem.ozan.movieapp.databinding.FragmentSearchMovieBinding
import ekrem.ozan.movieapp.presentation.movies.MoviesViewModel

class SearchMovieFragment : BaseFragment<FragmentSearchMovieBinding, MoviesViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_search_movie
    override val classTypeOfViewModel: Class<MoviesViewModel> = MoviesViewModel::class.java


    override fun init() {
        context?.let { sharedElementEnterTransition = TransitionInflater.from(it).inflateTransition(android.R.transition.move) }
        setupSearchView()
    }


    override fun setupClickListeners() {
        binding.imageButtonBack.setOnClickListener { findNavController().popBackStack() }

    }

    private fun setupSearchView() {
        (binding.searchView.findViewById(androidx.appcompat.R.id.search_src_text) as TextView).setTextColor(Color.WHITE)
        binding.searchView.clickSubmitButton { query ->

        }
    }

}