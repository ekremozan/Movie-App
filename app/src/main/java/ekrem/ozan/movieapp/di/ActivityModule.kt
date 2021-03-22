package ekrem.ozan.movieapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ekrem.ozan.movieapp.presentation.home.HomeActivity
import ekrem.ozan.movieapp.presentation.splash.SplashActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity
}