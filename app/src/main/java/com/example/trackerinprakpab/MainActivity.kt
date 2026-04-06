package com.example.trackerinprakpab

import android.os.Bundle
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.trackerinprakpab.ui.theme.TrackerinPrakPabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrackerinPrakPabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

data class UserProfile(
    val nim: String,
    val name: String,
    val major: String,
    val batch: String,
    val description: String,
    val githubUrl: String
)

val users = listOf(
    UserProfile("12345001", "John Doe", "Informatics", "2021", "I love Android development.", "https://github.com/johndoe"),
    UserProfile("12345002", "Jane Smith", "Computer Science", "2020", "Passionate about UI/UX.", "https://github.com/janesmith"),
    UserProfile("12345003", "Alice Johnson", "Information Systems", "2022", "Aspiring backend engineer.", "https://github.com/alicejohnson")
)

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(users) { user ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = user.name, style = MaterialTheme.typography.titleLarge)
                    Text(text = "NIM: ${user.nim}", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        val intent = Intent(context, ProfileActivity::class.java).apply {
                            putExtra("NIM", user.nim)
                            putExtra("NAME", user.name)
                            putExtra("MAJOR", user.major)
                            putExtra("BATCH", user.batch)
                            putExtra("DESC", user.description)
                            putExtra("GITHUB", user.githubUrl)
                        }
                        context.startActivity(intent)
                    }) {
                        Text("Go To Profile")
                    }
                }
            }
        }
    }
}