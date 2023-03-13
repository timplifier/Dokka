package com.timplifier.dokka.data.remote.apiservices

import com.timplifier.dokka.data.remote.dtos.FooDto
import retrofit2.http.GET
import retrofit2.http.Query

interface FooApiService {
    @GET("foo/")
    suspend fun fetchFoo(@Query("search") searchQuery: String? = null): FooDto
}