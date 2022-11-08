package com.rave.studenttracker.view.student

import com.rave.studenttracker.model.entity.Student

/**
 * This dataclass is used to track [StudentListState] which observes if the student list is being.
 * loaded or is fully added to our state flow.
 *
 * @property isLoading
 * @property students
 * @constructor Create empty Student list state
 */
data class StudentListState(
    val isLoading: Boolean = false,
    val students: List<Student> = emptyList()
)
