package com.rave.studenttracker.model.mapper.student

import com.rave.studenttracker.model.dto.StudentDTO
import com.rave.studenttracker.model.entity.Student
import com.rave.studenttracker.model.mapper.DtoToEntityMapper

/**
 * Student mapper to convert [StudentDTO] to [Student] entity.
 *
 * @constructor Create empty Student mapper.
 */
class StudentMapper : DtoToEntityMapper<StudentDTO, Student> {

    override fun invoke(dto: StudentDTO): Student {
        TODO()
    }
}
