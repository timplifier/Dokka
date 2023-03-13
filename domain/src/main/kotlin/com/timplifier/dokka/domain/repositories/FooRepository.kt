package com.timplifier.dokka.domain.repositories

import com.timplifier.dokka.domain.either.Either
import com.timplifier.dokka.domain.models.FooModel
import kotlinx.coroutines.flow.Flow

/**
 * [FooRepository] interface to interact with [FooModel]
 */
interface FooRepository {

    /**
     * [fetchFoo] method to fetch [FooModel]
     */
    fun fetchFoo(): Flow<Either<String, FooModel>>

    /**
     * [searchFoo]
     * @param searchQuery to fetch [FooModel] by some query
     */
    fun searchFoo(searchQuery: String): Flow<Either<String, FooModel>>
}