package com.rave.studenttracker.model


import com.rave.studenttracker.model.entity.Student
import com.rave.studenttracker.model.mapper.student.StudentMapper
import com.rave.studenttracker.model.remote.StudentApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StudentRepo(
    private val studentApi: StudentApi,
    private val studentMapper: StudentMapper,
) {

    suspend fun getStudentList(): List<Student> {
        return withContext(Dispatchers.IO) {
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

