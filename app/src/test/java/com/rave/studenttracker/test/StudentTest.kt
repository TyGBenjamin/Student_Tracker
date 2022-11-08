package com.rave.studenttracker.test

import androidx.activity.viewModels
import androidx.compose.material3.CircularProgressIndicator
import androidx.lifecycle.ViewModelProvider
import com.rave.studenttracker.model.StudentRepo
import com.rave.studenttracker.model.dto.StudentDTO
import com.rave.studenttracker.model.mapper.student.StudentMapper
import com.rave.studenttracker.model.remote.StudentApi
import com.rave.studenttracker.utilTest.CoroutinesTestExtension
import com.rave.studenttracker.viewmodel.StudentListViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension


@OptIn(ExperimentalCoroutinesApi::class)
internal class StudentTest {


    @RegisterExtension
    private val coroutinesTestExtension = CoroutinesTestExtension()
    private val mockServer = mockk<StudentApi>()
    private val studentMapper = StudentMapper()
    private val repo = StudentRepo(mockServer, studentMapper)
    private val studentViewModel = StudentListViewModel.newInstance(repo)



    @Test
    @DisplayName("Testing that a list of images is returned")
    fun testGetStudents() = runTest(coroutinesTestExtension.dispatcher) {
        // Given
        val result = listOf<StudentDTO>()
        coEvery { mockServer.fetchStudentList() } coAnswers { result}

        // When
        val list = repo.getStudentList()

        // Then
        Assertions.assertEquals(result, list)
    }

}

