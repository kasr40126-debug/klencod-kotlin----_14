package com.kaser.kaserapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KaserAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChatScreen()
                }
            }
        }
    }
}

data class Chat(val name: String, val lastMessage: String, val time: String)

@Composable
val sampleChats = listOf(
    Chat("أحمد محمد", "السلام عليكم، كيف المشروع؟", "٠٨:٢٥ ص"),
    Chat("محمد علي", "تم إرسال الكود بنجاح", "٠٨:١٠ ص"),
    Chat("ياسين شايع", "جاهز للاجتماع القادم؟", "أمس")
)

@Composable
fun ChatScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121B22)) // لون خلفية داكن فخم
    ) {
        // شريط العنوان العلوي
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1F2C34))
                .padding(16.dp)
        ) {
            Text(
                text = "KASER APP",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // قائمة المحادثات
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(sampleChats) { chat ->
                ChatItem(chat = chat)
            }
        }
    }
}

@Composable
fun ChatItem(chat: Chat) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* انتقل لشاشة الدردشة */ }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // صورة الملف الشخصي الوهمية
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = chat.name.take(1), color = Color.White, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = chat.name,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = chat.lastMessage,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }

        Text(
            text = chat.time,
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}

@Composable
fun KaserAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFF00A884),
            background = Color(0xFF121B22)
        ),
        content = content
    )
}
