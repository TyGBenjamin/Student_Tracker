package com.rave.studenttracker.model.remote

import com.rave.studenttracker.model.dto.StudentDTO
import com.rave.studenttracker.util.Constants
import kotlinx.coroutines.delay
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

internal class StudentApiImpl(fakeJsonString: String) : StudentApi {

    private val fakeStudents: List<StudentDTO> by lazy { Json.decodeFromString(fakeJsonString) }

    override suspend fun fetchStudentList(): List<StudentDTO> {
        delay(Constants.timeInMilis)
        return fakeStudents
    }
}
