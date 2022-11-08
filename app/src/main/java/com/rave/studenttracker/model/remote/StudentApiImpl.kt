package com.rave.studenttracker.model.remote

import com.rave.studenttracker.model.dto.StudentDTO
import kotlinx.coroutines.delay
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

internal class StudentApiImpl(fakeJsonString: String) : StudentApi {

    private val fakeStudents: List<StudentDTO> by lazy { Json.decodeFromString(fakeJsonString) }

    override suspend fun fetchStudentList(): List<StudentDTO> {
        delay(3000)
        return fakeStudents
    }
}
