package ekrem.ozan.movieapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ekrem.ozan.movieapp.presentation.home.HomeActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun bindHomeActivity(): HomeActivity
}