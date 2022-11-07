package com.rave.studenttracker.model.entity

data class Student(
    val avatar: String,
    val email: String,
    val firstName: String,
    val id: Int,
    val lastName: String,
    val university: String
)