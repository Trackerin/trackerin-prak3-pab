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
import androidx.compose.ui.unit.em
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
    val githubUrl: String,
    val imageRes: Int
)

val users = listOf(
    UserProfile("L0124103", "Kevin Ananda Putra", "Informatics", "2024", "Hi, I'm Kevin!\n" +
            "\n" +
            "An Informatics student at UNS '24 currently deep-diving into backend development and VPS infrastructure. Besides my role as Menko Medtek at BEM FATISDA, my main focus right now is building Trackerin, an AI-powered learning platform with my team.\n" +
            "\n" +
            "Di luar urusan coding dan teka-teki error yang kadang bikin pusing, I usually unwind by exploring open-world games or just chilling with some Anime series. Always down for a chat about dev-talk, system architecture, or any creative ideas. Let's connect!", "https://github.com/KevinAnandaP", R.drawable.foto_kevin),
    UserProfile("L0124104", "Majeeda Athaya Nashwanaira Ali", "Informatics", "2024", "Hi, Aku Nashwa ! \uD83D\uDE06\n" +
            "Mahasiswa Informatika FATISDA UNS yang hobi eksplorasi dan sesekali terjebak dalam teka-teki error saat ngoding. Saat ini sedang fokus mengembangkan Trackerin bersama teman-temanku ^^. Biasanya aku berenang ketika luang atau maraton serial Netflix. Let’s connect and share ideas on dev talk, design, or whatever’s fun to discuss!", "https://github.com/nashwanairaath", R.drawable.foto_majeeda),
    UserProfile("L0124105", "Muhammad Alfin Hasan", "Informatics", "2024", "Hi, I'm Alfin! \uD83D\uDC4B\n" +
            "\n" +
            "Mahasiswa Informatika yang hobi ngulik program error dan sesekali terjebak dalam barisan kode java. Saat ini sedang fokus mengembangkan Trackerin.\n" +
            "\n" +
            "Kalau tidak sedang di depan layar, biasanya saya sedang Tidur. Let’s talk about tech, design, or anything in between!", "https://github.com/malfinh", R.drawable.foto_muhammad),
    UserProfile("L0124117", "Rafif Adyatma Setyawan", "Informatics", "2024", "Hi, I'm Rafif Adyatma Setyawan! \uD83D\uDC4B\uD83D\uDE0B\n" +
            "\n" +
            "Mahasiswa Informatika yang hobi ngulik logic dan sesekali \"bertarung\" dengan error di terminal. Saat ini sedang fokus mengeksplorasi dunia pengembangan perangkat lunak dan kecerdasan buatan.\n" +
            "\n" +
            "Kalau tidak sedang di depan layar, biasanya saya sedang mencari keringat di lapangan olahraga, mendaki jalur baru di alam, atau berburu kuliner tersembunyi di sudut kota. Let’s talk about tech, travel, or the best food spots!", "https://github.com/rapipapipupp", R.drawable.foto_rafif)
)

val geistFamily = FontFamily(
    Font(R.font.geist_regular, FontWeight.Normal),
    Font(R.font.geist_medium, FontWeight.Medium),
    Font(R.font.geist_semibold, FontWeight.SemiBold),
    Font(R.font.geist_bold, FontWeight.Bold)
)

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val textColor = Color(0xFF040E14)
    val grayColor = Color(0xFF6B7280)
    val bgColor = Color(0xFFF1F3F5)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Trackerin",
                color = textColor,
                fontFamily = geistFamily,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge.copy(letterSpacing = (-0.04).em)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_logo_trackerin),
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Master Your Learning with\nAI Precision",
                color = textColor,
                fontFamily = geistFamily,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium.copy(letterSpacing = (-0.04).em),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Redefining how you learn through AI-driven insights.\nDesign your custom curriculum, monitor every milestone,\nand take control of your knowledge development\nin one seamless platform.",
                color = grayColor,
                fontFamily = geistFamily,
                style = MaterialTheme.typography.bodyMedium.copy(letterSpacing = (-0.04).em),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Our Team",
                color = textColor,
                fontFamily = geistFamily,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.bodyLarge.copy(letterSpacing = (-0.04).em)
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 32.dp)
            ) {
                items(users) { user ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(50))
                            .background(Color.White)
                            .clickable {
                                val intent = Intent(context, ProfileActivity::class.java).apply {
                                    putExtra("NIM", user.nim)
                                    putExtra("NAME", user.name)
                                    putExtra("MAJOR", user.major)
                                    putExtra("BATCH", user.batch)
                                    putExtra("DESC", user.description)
                                    putExtra("GITHUB", user.githubUrl)
                                    putExtra("IMAGE_RES", user.imageRes)
                                }
                                context.startActivity(intent)
                            }
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = user.imageRes),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = user.name,
                                color = textColor,
                                fontFamily = geistFamily,
                                fontWeight = FontWeight.Medium,
                                style = MaterialTheme.typography.bodyLarge.copy(letterSpacing = (-0.04).em)
                            )
                            Text(
                                text = "\"${user.description}\"",
                                color = grayColor,
                                fontFamily = geistFamily,
                                style = MaterialTheme.typography.bodySmall.copy(letterSpacing = (-0.04).em),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = "Go to Profile",
                            tint = textColor,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}