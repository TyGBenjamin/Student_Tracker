package com.rave.studenttracker.model


import com.rave.studenttracker.model.entity.Student
import com.rave.studenttracker.model.mapper.student.StudentMapper
import com.rave.studenttracker.model.remote.StudentApi

class StudentRepo(
    private val studentApi: StudentApi,
    private val studentMapper: StudentMapper,
) {

    suspend fun getStudentList(): List<Student> {
//        listOf(studentMapper.invoke(studentApi.fetchStudentList()))
        val studentList =  studentApi.fetchStudentList()
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
        return studentDetail
    }

}

