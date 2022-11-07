package com.rave.studenttracker.view.student

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.rave.studenttracker.model.entity.Student

@Composable
fun StudentListScreen(students: List<Student>) {
    LazyColumn {
        items(
            items = students,
            key = { student: Student -> student.id }
        ) { student: Student ->
            StudentCard(student = student)
        }
    }
}

@Composable
fun StudentCard(student: Student) {
    Text(text = student.firstName)
}
