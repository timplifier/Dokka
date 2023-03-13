package com.timplifier.dokka.domain.useCases

import com.timplifier.dokka.domain.repositories.FooRepository

class FetchFooUseCase(
    private val fooRepository: FooRepository
) {
    operator fun invoke() = fooRepository.fetchFoo()
}