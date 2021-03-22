package ekrem.ozan.movieapp.presentation.movies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import ekrem.ozan.movieapp.BR
import ekrem.ozan.movieapp.R
import ekrem.ozan.movieapp.data.model.uimodel.MovieViewItem
import ekrem.ozan.movieapp.databinding.ItemMovieBinding

class MoviePagerAdapter(context: Context, private val itemType: ITEM_TYPE) : PagerAdapter() {
    private var movieItem = emptyList<MovieViewItem>()

    fun setItem(movieItem: List<MovieViewItem>) {
        this.movieItem = movieItem
    }

    var inflater: LayoutInflater = LayoutInflater.from(context)

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return (movieItem.size)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = DataBindingUtil.inflate<ItemMovieBinding>(inflater, R.layout.item_movie, container, false)
        binding.setVariable(BR.movie, movieItem[position])
        container.addView(binding.root)


        binding.root.setOnClickListener { onMovieItemClick?.invoke(movieItem[position]) }

        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getPageWidth(position: Int): Float {
        return if (itemType == ITEM_TYPE.SMALL) 0.29f else 1.0f
    }

    enum class ITEM_TYPE {
        SMALL,
        LARGE
    }

    /** Item Click Functions **/
    var onMovieItemClick: ((MovieViewItem) -> Unit)? = null

}