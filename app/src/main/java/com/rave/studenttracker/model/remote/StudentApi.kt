package com.rave.studenttracker.model.remote

import com.rave.studenttracker.model.dto.StudentDTO

interface StudentApi {

    suspend fun fetchStudentList(): List<StudentDTO>
}
