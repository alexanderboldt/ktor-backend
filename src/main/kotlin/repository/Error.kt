package com.alex.main.kotlin.repository

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Error(val message: String)