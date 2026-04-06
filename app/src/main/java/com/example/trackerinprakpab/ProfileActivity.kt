package com.example.trackerinprakpab

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.trackerinprakpab.ui.theme.TrackerinPrakPabTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val nim = intent.getStringExtra("NIM") ?: ""
        val name = intent.getStringExtra("NAME") ?: ""
        val major = intent.getStringExtra("MAJOR") ?: ""
        val batch = intent.getStringExtra("BATCH") ?: ""
        val desc = intent.getStringExtra("DESC") ?: ""
        val github = intent.getStringExtra("GITHUB") ?: ""

        setContent {
            TrackerinPrakPabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        nim = nim,
                        name = name,
                        major = major,
                        batch = batch,
                        desc = desc,
                        github = github,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(
    nim: String, name: String, major: String, batch: String, desc: String, github: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val shareInfo = "Name: $name\nNIM: $nim\nMajor: $major\nBatch: $batch\nDescription: $desc"

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Profile Activity", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("NIM: $nim")
        Text("Name: $name")
        Text("Major: $major")
        Text("Batch: $batch")
        Text("Description: $desc")
        Spacer(modifier = Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, shareInfo)
                    type = "text/plain"
                }
                context.startActivity(Intent.createChooser(shareIntent, "Share with:"))
            }) {
                Text("Share")
            }

            Button(onClick = {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(github))
                context.startActivity(browserIntent)
            }) {
                Text("Go To My Github")
            }
        }
    }
}

