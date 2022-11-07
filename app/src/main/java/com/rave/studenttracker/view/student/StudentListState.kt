package com.rave.studenttracker.view.student

import com.rave.studenttracker.model.entity.Student

data class StudentListState(
    val isLoading: Boolean = false,
    val students: List<Student> = emptyList()
)
