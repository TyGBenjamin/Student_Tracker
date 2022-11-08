package com.rave.studenttracker.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.rave.studenttracker.model.StudentRepo
import com.rave.studenttracker.model.mapper.student.StudentMapper
import com.rave.studenttracker.model.remote.StudentApi
import com.rave.studenttracker.model.remote.StudentApiImpl
import com.rave.studenttracker.ui.theme.StudentTrackerTheme
import com.rave.studenttracker.view.student.ProgressIndicator
import com.rave.studenttracker.view.student.StudentListScreen
import com.rave.studenttracker.viewmodel.StudentListViewModel

class MainActivity : ComponentActivity() {


    private val studentViewModel by viewModels<StudentListViewModel>() {
        val fakeJsonString = assets.open("studentList.json")
            .bufferedReader()
            .use { reader -> reader.readText() }
        val studentApi: StudentApi = StudentApiImpl(fakeJsonString)
        val studentMapper = StudentMapper()
        val studentRepo = StudentRepo(studentApi = studentApi, studentMapper = studentMapper)
        StudentListViewModel.newInstance(studentRepo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentTrackerTheme {
                val studentListState by studentViewModel.studentListState.collectAsState()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (studentListState.isLoading) {
                        false ->  StudentListScreen(students = studentListState.students)
                        else -> ProgressIndicator()
                    }
                }
            }
        }
    }
}
