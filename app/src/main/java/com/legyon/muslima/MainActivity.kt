package com.legyon.muslima

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MuslimaApp() }
    }
}

private val Background = Color(0xFF050A12)
private val Cyan = Color(0xFF55E6FF)
private val Blue = Color(0xFF287BFF)
private val Muted = Color(0xFF8296AD)

@Composable
private fun MuslimaApp() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color(0xFF0B1B2D), Background, Color(0xFF03060B))
                        )
                    )
                    .padding(horizontal = 24.dp, vertical = 22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "M U S L I M A",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 3.sp
                        )
                        Text(
                            text = "PERSONAL AI SYSTEM",
                            color = Muted,
                            fontSize = 9.sp,
                            letterSpacing = 2.sp
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(Color(0xFF10283A))
                            .padding(horizontal = 12.dp, vertical = 7.dp)
                    ) {
                        Text("●  ONLINE", color = Cyan, fontSize = 10.sp, letterSpacing = 1.sp)
                    }
                }

                Spacer(Modifier.weight(1f))
                AiCore()
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "SIZNI TINGLAYAPMAN",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 2.sp
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "MUSLIMA yordam berishga tayyor",
                    color = Muted,
                    fontSize = 13.sp
                )
                Spacer(Modifier.height(30.dp))
                VoiceWaveform()
                Spacer(Modifier.weight(1f))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    StatusTile("AI HOLATI", "Tayyor", Modifier.weight(1f))
                    StatusTile("OVOZ", "Kutmoqda", Modifier.weight(1f))
                    StatusTile("TIZIM", "Himoyalangan", Modifier.weight(1f))
                }
                Spacer(Modifier.height(18.dp))
                Text(
                    text = "BOSHLASH UCHUN OVOZLI BUYRUQ BERING",
                    color = Muted,
                    fontSize = 9.sp,
                    letterSpacing = 1.5.sp
                )
            }
        }
    }
}

@Composable
private fun AiCore() {
    val transition = rememberInfiniteTransition(label = "core")
    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(14000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )
    val pulse by transition.animateFloat(
        initialValue = 0.92f,
        targetValue = 1.06f,
        animationSpec = infiniteRepeatable(
            animation = tween(1900, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )

    Canvas(modifier = Modifier.size(286.dp)) {
        val c = center
        val base = size.minDimension * 0.31f * pulse
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Color(0x6655E6FF), Color(0x22287BFF), Color.Transparent),
                center = c,
                radius = base * 2.2f
            ),
            radius = base * 2.2f,
            center = c
        )
        drawCircle(Color(0x6655E6FF), radius = base * 1.48f, center = c, style = Stroke(1.2.dp.toPx()))
        drawCircle(Color(0xAA287BFF), radius = base * 1.27f, center = c, style = Stroke(2.dp.toPx()))
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Color(0xFFB8F8FF), Color(0xFF38BFEF), Color(0xFF0752A7), Color(0xFF06172B)),
                center = c - androidx.compose.ui.geometry.Offset(base * 0.28f, base * 0.34f),
                radius = base * 1.45f
            ),
            radius = base,
            center = c
        )
        for (i in 0 until 4) {
            val radius = base * (1.62f + i * 0.17f)
            drawCircle(
                color = if (i % 2 == 0) Color(0x9955E6FF) else Color(0x66287BFF),
                radius = radius,
                center = c,
                style = Stroke(width = if (i == 0) 1.5.dp.toPx() else 0.7.dp.toPx())
            )
        }
        val orbitRadius = base * 1.72f
        val angle = Math.toRadians(rotation.toDouble())
        val point = androidx.compose.ui.geometry.Offset(
            c.x + kotlin.math.cos(angle).toFloat() * orbitRadius,
            c.y + kotlin.math.sin(angle).toFloat() * orbitRadius
        )
        drawCircle(Cyan, radius = 4.dp.toPx(), center = point)
        drawCircle(Color(0x6655E6FF), radius = 9.dp.toPx(), center = point)
    }
}

@Composable
private fun VoiceWaveform() {
    val transition = rememberInfiniteTransition(label = "wave")
    val levels = (0 until 31).map { index ->
        val phase by transition.animateFloat(
            initialValue = 0f,
            targetValue = 6.283f,
            animationSpec = infiniteRepeatable(
                animation = tween(850 + index * 13, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Restart
            ),
            label = "wave-$index"
        )
        kotlin.math.abs(kotlin.math.sin(phase + index * 0.43f)).toFloat()
    }
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
    ) {
        val gap = 5.dp.toPx()
        val barWidth = (size.width - gap * (levels.size - 1)) / levels.size
        levels.forEachIndexed { index, level ->
            val h = 9.dp.toPx() + level * 34.dp.toPx()
            val x = index * (barWidth + gap)
            drawRoundRect(
                brush = Brush.verticalGradient(listOf(Cyan, Blue)),
                topLeft = androidx.compose.ui.geometry.Offset(x, (size.height - h) / 2),
                size = androidx.compose.ui.geometry.Size(barWidth, h),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(barWidth, barWidth)
            )
        }
    }
}

@Composable
private fun StatusTile(title: String, value: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(Color(0xFF0D1B2B))
            .padding(horizontal = 10.dp, vertical = 12.dp)
    ) {
        Text(title, color = Muted, fontSize = 8.sp, letterSpacing = 1.sp)
        Spacer(Modifier.height(5.dp))
        Text(value, color = Color(0xFFE8F8FF), fontSize = 11.sp, fontWeight = FontWeight.Medium)
    }
}
