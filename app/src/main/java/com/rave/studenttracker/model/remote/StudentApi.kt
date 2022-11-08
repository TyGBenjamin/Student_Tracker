package com.rave.studenttracker.model.remote

import com.rave.studenttracker.model.dto.StudentDTO

/**
 * Abstract shell for [StudentApi].
 *
 * @constructor Create empty Student api
 */
interface StudentApi {

    /**
     * Abstract holder that will be implemented by [StudentApiImpl].
     *
     * @return
     */
    suspend fun fetchStudentList(): List<StudentDTO>
}
