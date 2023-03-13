package com.timplifier.dokka.presentation.ui.fragments

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.timplifier.dokka.R
import com.timplifier.dokka.databinding.FragmentFooBinding
import com.timplifier.dokka.presentation.base.BaseFragment

/**
 * [FooFragment] description
 * @author Timur
 * @since 1.0v
 */
class FooFragment : BaseFragment<FragmentFooBinding, FooViewModel>(R.layout.fragment_foo) {
    override val binding by viewBinding(FragmentFooBinding::bind)
    override val viewModel by viewModels<FooViewModel>()

    override fun constructListeners() {
        searchForFoo()
    }

    /**
     * [searchForFoo] is invoked when user clicks on button
     * then searchFoo is invoked.
     */
    private fun searchForFoo() {
        binding.btnSearch.setOnClickListener {
            viewModel.searchFoo("someFoo")
        }
    }

    /**
     * [launchObservers] spectates fooState,
     * unwrapping it from [com.timplifier.dokka.presentation.ui.state.UIState]
     */
    override fun launchObservers() {
        viewModel.fooState.spectateUiState(success = {
            println(it)
        })
    }
}