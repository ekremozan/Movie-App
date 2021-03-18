package ekrem.ozan.movieapp.presentation.splash

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import ekrem.ozan.movieapp.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupAnimationOfViews()
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