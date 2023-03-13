package com.timplifier.dokka.presentation.models

import com.timplifier.dokka.domain.models.FooModel

data class FooUI(
    val foo: Any
)

fun FooModel.toUI() = FooUI(foo)