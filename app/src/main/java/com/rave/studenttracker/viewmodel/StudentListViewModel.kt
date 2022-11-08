package com.rave.studenttracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.rave.studenttracker.model.StudentRepo
import com.rave.studenttracker.view.student.StudentListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Student list view model holds logic for all student related data.
 *
 * @constructor Create new instance of [StudnetListViewModel]
 *
 * @param repo Repository to fetch Student data [studentRepo]
 */
class StudentListViewModel(repo: StudentRepo) : ViewModel() {

    private val _studentListState = MutableStateFlow(StudentListState())
    val studentListState: StateFlow<StudentListState> get() = _studentListState

    init {
        _studentListState.update { state -> state.copy(isLoading = true) }
        viewModelScope.launch {
            val students = repo.getStudentList()
            _studentListState.update { state -> state.copy(isLoading = false, students = students) }
        }
    }

    companion object {
        /**
         * New instance of [ViewModelFactory].
         *
         * @param repo [StudentRepo] to create [StudentListViewModel]
         */
        fun newInstance(repo: StudentRepo) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return StudentListViewModel(repo) as T
            }
        }
    }
}
