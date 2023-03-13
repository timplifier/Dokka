package com.timplifier.dokka.data.repositories

import com.timplifier.dokka.data.base.makeNetworkRequest
import com.timplifier.dokka.data.remote.apiservices.FooApiService
import com.timplifier.dokka.data.remote.dtos.FooDto
import com.timplifier.dokka.domain.models.FooModel
import com.timplifier.dokka.domain.repositories.FooRepository

class FooRepositoryImpl(private val fooApiService: FooApiService) : FooRepository {

    /**
     * [fetchFoo] makes network request
     * to fetch [FooDto] and map it to [FooModel]
     * @return [FooModel]
     * @since 1.0
     * @author Timur
     * @see (https://habr.com/ru/post/667026/)
     */
    override fun fetchFoo() = makeNetworkRequest {
        fooApiService.fetchFoo().toDomain()
    }

    /**
     * [searchFoo] makes network request
     * to search among [FooDto] and map it to [FooModel] via [FooDto.toDomain] method
     * @return [FooModel]
     * @since 1.0
     * @author Timur
     * @see (https://habr.com/ru/post/667026/)
     */
    override fun searchFoo(searchQuery: String) = makeNetworkRequest {
        fooApiService.fetchFoo(searchQuery).toDomain()
    }
}