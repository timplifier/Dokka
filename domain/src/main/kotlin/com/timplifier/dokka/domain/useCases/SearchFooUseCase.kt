package com.timplifier.dokka.domain.useCases

import com.timplifier.dokka.domain.repositories.FooRepository

class SearchFooUseCase(private val fooRepository: FooRepository) {
    operator fun invoke(searchQuery: String) = fooRepository.searchFoo(searchQuery)
}