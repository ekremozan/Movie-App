package ekrem.ozan.movieapp.presentation.movies

import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import ekrem.ozan.movieapp.R
import ekrem.ozan.movieapp.base.extension.observeNonNull
import ekrem.ozan.movieapp.base.view.BaseFragment
import ekrem.ozan.movieapp.data.model.uimodel.MovieViewItem
import ekrem.ozan.movieapp.databinding.FragmentMoviesBinding
import ekrem.ozan.movieapp.presentation.movies.adapter.MoviePagerAdapter

class MoviesFragment : BaseFragment<FragmentMoviesBinding, MoviesViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_movies
    override val classTypeOfViewModel: Class<MoviesViewModel> = MoviesViewModel::class.java


    override fun init() {
        binding.vm = viewModel
        baseView = binding.baseView
    }

    override fun initStartRequest() {
        viewModel.getMovies()
    }

    override fun setUpViewModelStateObservers() {
        viewModel.livaDataViewState.observeNonNull(viewLifecycleOwner, { viewState ->
            setViewState(viewState)
        })
    }


    private fun setViewState(fragmentViewState: MoviesFragmentViewState) {
        fragmentViewState.getPopularMovies()?.let { setupSmallItemViewPagerAdapter(it.movies, binding.layoutPopularMovies.viewPager) }
        fragmentViewState.getUpComingMovies()?.let { setupSmallItemViewPagerAdapter(it.movies, binding.layoutUpComingMovies.viewPager) }
        fragmentViewState.getDailyTrendingMovies()?.let { setupSmallItemViewPagerAdapter(it.movies, binding.layoutDailyTrendingMovies.viewPager) }
        fragmentViewState.getWeeklyTrendingMovies()?.let { setupSmallItemViewPagerAdapter(it.movies, binding.layoutWeeklyTrendingMovies.viewPager) }
    }

    private fun setupSmallItemViewPagerAdapter(movies: List<MovieViewItem>, viewPager: ViewPager) {
        MoviePagerAdapter(requireContext(), MoviePagerAdapter.ITEM_TYPE.SMALL).apply {
            setItem(movies)
            onMovieItemClick = ::onMovieItemClick
            viewPager.adapter = this
        }
    }


    private fun onMovieItemClick(movieItem: MovieViewItem) {

    }


    override fun setupClickListeners() {
        binding.imageButtonSearch.setOnClickListener { navigateSearch() }
    }

    private fun navigateSearch() {
        val extras = FragmentNavigatorExtras(binding.cardViewToolbarContent to binding.cardViewToolbarContent.transitionName)
        findNavController().navigate(MoviesFragmentDirections.actionMoviesFragmentToSearchMovieFragment(), extras)
    }
}
