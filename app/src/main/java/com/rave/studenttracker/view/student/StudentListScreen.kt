package com.rave.studenttracker.view.student

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rave.studenttracker.model.entity.Student
import com.rave.studenttracker.ui.theme.StudentTrackerTheme

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
    Card(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
        Row(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp,
                    start = 10.dp
                )
        ) {
            Image(
                painter = rememberAsyncImagePainter(student.avatar),
                contentDescription = null,
                modifier = Modifier.size(145.dp)
            )
            Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {
                Text(text = student.firstName + " " + student.lastName)
                Text(text = "University: ${student.university}")
                Text(text = "Email: ${student.email}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StudentTrackerTheme {
        StudentCard(
            student = Student(
                id = 1,
                avatar = "pic",
                email = "",
                firstName = "ty",
                lastName = "Gandy",
                university = "PhillyU"
            )
        )
    }
}

@Composable
fun ProgressIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
