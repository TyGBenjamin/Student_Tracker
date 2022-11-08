package com.rave.studenttracker.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StudentDTO(
    val avatar: String,
    val email: String,
    @SerialName("first_name")
    val firstName: String,
    val id: Int,
    @SerialName("last_name")
    val lastName: String,
    val university: String
)
