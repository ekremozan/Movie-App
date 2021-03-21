package ekrem.ozan.movieapp.presentation.detail

import ekrem.ozan.movieapp.R
import ekrem.ozan.movieapp.base.view.BaseFragment
import ekrem.ozan.movieapp.databinding.FragmentMovieDetailBinding
import ekrem.ozan.movieapp.presentation.movies.MoviesViewModel

class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding, MoviesViewModel>() {
    override val layoutResourceId: Int = R.layout.fragment_movie_detail
    override val classTypeOfViewModel: Class<MoviesViewModel> = MoviesViewModel::class.java


    override fun init() {
    }

    override fun setupClickListeners() {
        super.setupClickListeners()
    }

}