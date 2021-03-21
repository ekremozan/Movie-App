package ekrem.ozan.movieapp.presentation.movies

import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import ekrem.ozan.movieapp.R
import ekrem.ozan.movieapp.base.view.BaseFragment
import ekrem.ozan.movieapp.databinding.FragmentMoviesBinding

class MoviesFragment : BaseFragment<FragmentMoviesBinding, MoviesViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_movies
    override val classTypeOfViewModel: Class<MoviesViewModel> = MoviesViewModel::class.java


    override fun init() {
    }

    override fun setupClickListeners() {
        binding.imageButtonSearch.setOnClickListener { navigateSearch() }
    }

    private fun navigateSearch() {
        val extras = FragmentNavigatorExtras(binding.cardViewToolbarContent to binding.cardViewToolbarContent.transitionName)
        findNavController().navigate(MoviesFragmentDirections.actionMoviesFragmentToSearchMovieFragment(), extras)
    }
}
