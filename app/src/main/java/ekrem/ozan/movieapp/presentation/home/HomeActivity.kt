package ekrem.ozan.movieapp.presentation.home

import android.app.Activity
import android.content.Intent
import ekrem.ozan.movieapp.R
import ekrem.ozan.movieapp.base.view.BaseActivity
import ekrem.ozan.movieapp.databinding.ActivityHomeBinding


class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {
    override val layoutResourceId: Int = R.layout.activity_home
    override val classTypeOfViewModel: Class<HomeViewModel> = HomeViewModel::class.java

    companion object {
        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, HomeActivity::class.java))
        }
    }
}