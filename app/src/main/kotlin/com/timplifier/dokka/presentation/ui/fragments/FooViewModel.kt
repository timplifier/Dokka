package com.timplifier.dokka.presentation.ui.fragments

import com.timplifier.dokka.domain.useCases.FetchFooUseCase
import com.timplifier.dokka.domain.useCases.SearchFooUseCase
import com.timplifier.dokka.presentation.base.BaseViewModel
import com.timplifier.dokka.presentation.models.FooUI
import com.timplifier.dokka.presentation.models.toUI
import kotlinx.coroutines.flow.asStateFlow

/**
 * [FooViewModel] is the viewModel for [FooFragment],derived from [BaseViewModel]
 * main purpose of which is to fetch foo and expose it in fragment.
 * @property fetchFooUseCase is used for fetching the foo from the network
 * @property searchFooUseCase is used for fetching the foo from the network by the given search query
 *
 * @property _fooState is a MutableStateFlow containing [FooUI], wrapped into [com.timplifier.dokka.presentation.ui.state.UIState]
 * @property fooState is a StateFlow derived from [_fooState]
 */
class FooViewModel(
    private val fetchFooUseCase: FetchFooUseCase,
    private val searchFooUseCase: SearchFooUseCase
) : BaseViewModel() {
    private val _fooState = mutableUiStateFlow<FooUI>()
    val fooState = _fooState.asStateFlow()

    /** [fetchFoo] function is invoked in the init block
     * allowing us to skip invoking it in the fragment
     * [fetchFooUseCase] is invoked and gathered into [_fooState],
     * also mapped [com.timplifier.dokka.domain.models.FooModel] to [FooUI]
     * @return [FooUI]
     */
    private fun fetchFoo() = fetchFooUseCase().gatherRequest(_fooState) { it.toUI() }

    /**
     * [searchFoo] function is used for searching for [FooUI]
     * @param searchQuery is required to fetch certain [FooUI]
     * @return [FooUI]
     */
    fun searchFoo(searchQuery: String) =
        searchFooUseCase(searchQuery).gatherRequest(_fooState) { it.toUI() }

    init {
        fetchFoo()
    }
}