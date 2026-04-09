package com.example.trackerinprakpab

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
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
    val context = LocalContext.current as? ComponentActivity
    val shareInfo = "Name: $name\nNIM: $nim\nMajor: $major\nBatch: $batch\nDescription: $desc"

    val textColor = Color(0xFF040E14)
    val grayColor = Color(0xFF6B7280)
    val bgColor = Color(0xFFF1F3F5)
    val buttonColor = Color(0xFF22425E)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // App Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 16.dp, horizontal = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "Back",
                tint = textColor,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterStart)
                    .clickable {
                        context?.finish()
                    }
            )
            Text(
                text = "Profile",
                color = textColor,
                fontFamily = geistFamily,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge.copy(letterSpacing = (-0.04).em),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            // Profile Picture
            Image(
                painter = painterResource(id = R.drawable.foto_kevin),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(160.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(24.dp))

            // NIM
            Text(
                text = "NIM",
                color = grayColor,
                fontFamily = geistFamily,
                style = MaterialTheme.typography.bodyMedium.copy(letterSpacing = (-0.04).em)
            )
            Text(
                text = nim,
                color = textColor,
                fontFamily = geistFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.titleLarge.copy(letterSpacing = (-0.04).em)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nama Lengkap
            Text(
                text = "Nama Lengkap",
                color = grayColor,
                fontFamily = geistFamily,
                style = MaterialTheme.typography.bodyMedium.copy(letterSpacing = (-0.04).em)
            )
            Text(
                text = name,
                color = textColor,
                fontFamily = geistFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.titleLarge.copy(letterSpacing = (-0.04).em)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Jurusan & Angkatan
            Text(
                text = "Jurusan & Angkatan",
                color = grayColor,
                fontFamily = geistFamily,
                style = MaterialTheme.typography.bodyMedium.copy(letterSpacing = (-0.04).em)
            )
            Text(
                text = "$major - $batch",
                color = textColor,
                fontFamily = geistFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.titleLarge.copy(letterSpacing = (-0.04).em)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Description Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(20.dp)
            ) {
                Text(
                    text = desc,
                    color = textColor,
                    fontFamily = geistFamily,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium.copy(letterSpacing = (-0.04).em),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = {
                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(github))
                        context?.startActivity(browserIntent)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_github),
                        contentDescription = "GitHub",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "GitHub",
                        color = Color.White,
                        fontFamily = geistFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        letterSpacing = (-0.04).em
                    )
                }

                Button(
                    onClick = {
                        val shareIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, shareInfo)
                            type = "text/plain"
                        }
                        context?.startActivity(Intent.createChooser(shareIntent, "Share with:"))
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = "Share",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Share",
                        color = Color.White,
                        fontFamily = geistFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        letterSpacing = (-0.04).em
                    )
                }
            }
        }
    }
}
