package com.rave.studenttracker.viewmodel

import com.rave.studenttracker.model.StudentRepo
import com.rave.studenttracker.model.entity.Student
import com.rave.studenttracker.utilTest.CoroutinesTestExtension
import com.rave.studenttracker.view.student.StudentListState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

internal class StudentListViewModelTest {

    @RegisterExtension
    private val coroutinesTestExtension = CoroutinesTestExtension()
    private val repo = mockk<StudentRepo>()

    @Test
    @DisplayName("Testing that viewModel Factory has been set correctly")
    fun testViewModel() = runTest(coroutinesTestExtension.dispatcher) {
        // Given
        val students = listOf(
            Student(
                avatar = "",
                id = 0,
                firstName = "",
                lastName = "",
                university = "",
                email = ""
            )
        )
        coEvery { repo.getStudentList() } coAnswers { students }

        // When
        val vm = StudentListViewModel(repo)
        val state = vm.studentListState.value

        // Then
        Assertions.assertTrue(state.students.isNotEmpty())
        Assertions.assertFalse(state.isLoading)
        Assertions.assertEquals(students, state.students)
    }

    @Test
    @DisplayName("Testing viewModel State")
    fun testViewModelState() = runTest(coroutinesTestExtension.dispatcher) {
        // Given
        val students = listOf(
            Student(
                avatar = "",
                id = 0,
                firstName = "",
                lastName = "",
                university = "",
                email = ""
            )
        )
        coEvery { repo.getStudentList() } coAnswers { students }
        val stateUpdates = mutableListOf<StudentListState>()

        // When
        val vm = StudentListViewModel(repo)
        val job = launch { vm.studentListState.toList(stateUpdates) }

        // Then
        val (initState, loadingState, successState) = stateUpdates
//        val stud
// can also be written as stateUpdates[0], stateUpdates[1], etc

        Assertions.assertFalse(initState.isLoading)
        Assertions.assertTrue(initState.students.isEmpty())

        Assertions.assertTrue(loadingState.isLoading)
        Assertions.assertTrue(loadingState.students.isEmpty())

        Assertions.assertFalse(successState.isLoading)
        Assertions.assertTrue(successState.students.isNotEmpty())
        job.cancel()
    }
}
