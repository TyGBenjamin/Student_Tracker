package com.rave.studenttracker.model

import com.rave.studenttracker.model.entity.Student
import com.rave.studenttracker.model.remote.StudentApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Student repo responsible for implementing [studentApi] and [dispatcher].
 *
 * @property studentApi
 * @property dispatcher
 * @constructor Create empty Student repo
 */
class StudentRepo(
    private val studentApi: StudentApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    /**
     * This method fetches list of students using [StudentRepo] and updates [studentList].
     *
     * @return
     */
    suspend fun getStudentList(): List<Student> {
        return withContext(dispatcher) {
            val studentList = studentApi.fetchStudentList()
            val studentDetail = studentList.map { studentDTO ->
                Student(
                    id = studentDTO.id,
                    avatar = studentDTO.avatar,
                    email = studentDTO.email,
                    firstName = studentDTO.firstName,
                    lastName = studentDTO.lastName,
                    university = studentDTO.university
                )
            }
            studentDetail
        }
    }
}
