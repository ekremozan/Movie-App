package ekrem.ozan.movieapp.base.view

import android.app.Dialog
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import ekrem.ozan.movieapp.base.domain.BaseViewViewState
import ekrem.ozan.movieapp.base.extension.getErrorMessage
import ekrem.ozan.movieapp.base.extension.orFalse
import ekrem.ozan.movieapp.base.viewmodel.BaseViewModel
import ekrem.ozan.movieapp.view.BaseView
import javax.inject.Inject

abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @get:LayoutRes
    protected abstract val layoutResourceId: Int
    lateinit var binding: DB
    private lateinit var viewModel: VM
    protected abstract val classTypeOfViewModel: Class<VM>
    private var hasRequestSend = false
    private var progressDialog: Dialog? = null
    protected var baseView: BaseView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(classTypeOfViewModel)
        binding = DataBindingUtil.setContentView(this, layoutResourceId)
        binding.lifecycleOwner = this

        intent?.extras?.let {
            viewModel.handleIntent(it)
            it.clear()
        }

        setUpViewModelStateObservers()

        init()

        if (!hasRequestSend) {
            initStartRequest()
            hasRequestSend = true
        }
    }

    open fun initStartRequest() {}
    open fun init() {}

    private fun setUpViewModelStateObservers() {
        viewModel.baseViewViewStateLiveData.observe(this, ::onStateChanged)
    }

    private fun onStateChanged(stateView: BaseViewViewState?) {
        when {
            stateView?.showLoading.orFalse() -> baseView?.showLoading()
            stateView?.showContent.orFalse() -> baseView?.showContent()
            stateView?.showEmpty.orFalse() -> baseView?.showEmpty()
            stateView?.showError.orFalse() -> {
                val errorMsg = stateView?.throwable?.getErrorMessage(applicationContext)
                baseView?.showError()
                baseView?.setErrorText(errorMsg)
            }
        }
    }

}