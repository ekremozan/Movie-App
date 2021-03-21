package ekrem.ozan.movieapp.presentation.splash

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import ekrem.ozan.movieapp.BuildConfig
import ekrem.ozan.movieapp.R
import ekrem.ozan.movieapp.presentation.home.HomeActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setupAnimationOfViews()

        if (BuildConfig.DEBUG) {
            handler.postDelayed({
                HomeActivity.start(this)
                supportFinishAfterTransition()
            }, 0)
        } else {
            handler.postDelayed({
                HomeActivity.start(this)
                supportFinishAfterTransition()
            }, 4000)
        }
    }


    private fun setupAnimationOfViews() {
        text.post {
            ObjectAnimator.ofFloat(text, "alpha", 0f, 1f).apply {
                duration = 1250
                startDelay = 1750L
                interpolator = DecelerateInterpolator(1.2f)
                start()
            }
        }
    }

}