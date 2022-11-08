package com.rave.studenttracker.model.entity

/**
 * data class structure for [Student].
 *
 * @property avatar user avater
 * @property email user email
 * @property firstName user firstNAme
 * @property id user id
 * @property lastName user lastName
 * @property university user University
 * @constructor Create empty Student
 */
data class Student(
    val avatar: String,
    val email: String,
    val firstName: String,
    val id: Int,
    val lastName: String,
    val university: String
)
