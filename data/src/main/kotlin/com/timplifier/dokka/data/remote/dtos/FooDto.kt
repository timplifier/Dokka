package com.timplifier.dokka.data.remote.dtos

import com.google.gson.annotations.SerializedName
import com.timplifier.dokka.data.utils.DataMapper
import com.timplifier.dokka.domain.models.FooModel

data class FooDto(
    @SerializedName("foo")
    val foo: Any
) : DataMapper<FooModel> {
    override fun toDomain() = FooModel(foo)
}