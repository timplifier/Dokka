package com.timplifier.dokka.data.utils

interface DataMapper<T> {
    fun toDomain(): T
}