package ekrem.ozan.movieapp.presentation.list

import ekrem.ozan.movieapp.R
import ekrem.ozan.movieapp.base.view.BaseFragment
import ekrem.ozan.movieapp.databinding.FragmentMovieListBinding
import ekrem.ozan.movieapp.presentation.movies.MoviesViewModel

class MovieListFragment : BaseFragment<FragmentMovieListBinding, MoviesViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_movie_list
    override val classTypeOfViewModel: Class<MoviesViewModel> = MoviesViewModel::class.java


    override fun init() {
    }

    override fun setupClickListeners() {
        super.setupClickListeners()
    }

}