package com.rave.studenttracker.model

import com.rave.studenttracker.model.entity.Student
import com.rave.studenttracker.model.mapper.student.StudentMapper
import com.rave.studenttracker.model.remote.StudentApi

class StudentRepo(
    private val studentApi: StudentApi,
    private val studentMapper: StudentMapper,
) {

    suspend fun getStudentList(): List<Student> {
        TODO()
    }
}
