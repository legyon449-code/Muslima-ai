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
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MuslimaApp() }
    }
}

private val Night = Color(0xFF030711)
private val Panel = Color(0xFF091827)
private val Cyan = Color(0xFF64E8FF)
private val Blue = Color(0xFF287BFF)
private val Pale = Color(0xFFE8F9FF)
private val Muted = Color(0xFF7895AC)

@Composable
private fun MuslimaApp() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Night) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color(0xFF0A1D31), Night, Color(0xFF02040A))
                        )
                    )
            ) {
                BackgroundGrid()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 22.dp, vertical = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Header()
                    Spacer(Modifier.weight(0.65f))
                    HudCore(Modifier.size(292.dp))
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = "M U S L I M A",
                        color = Pale,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 5.sp
                    )
                    Spacer(Modifier.height(7.dp))
                    Text(
                        text = "SHAXSIY SUN’IY INTELLEKT",
                        color = Cyan,
                        fontSize = 9.sp,
                        letterSpacing = 2.6.sp
                    )
                    Spacer(Modifier.height(9.dp))
                    Text(
                        text = "Sizning raqamli yordamchingiz",
                        color = Muted,
                        fontSize = 12.sp
                    )
                    Spacer(Modifier.height(22.dp))
                    VoiceWaveform()
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "VIZUAL DEMO REJIMI",
                        color = Color(0xFF64839B),
                        fontSize = 9.sp,
                        letterSpacing = 2.sp
                    )
                    Spacer(Modifier.weight(0.8f))
                    StatusPanel()
                    Spacer(Modifier.height(18.dp))
                    Text(
                        text = "MUSLIMA  •  NEXT-GEN AI INTERFACE",
                        color = Color(0xFF45647B),
                        fontSize = 8.sp,
                        letterSpacing = 1.5.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                "MUSLIMA",
                color = Pale,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 3.sp
            )
            Spacer(Modifier.height(4.dp))
            Text(
                "PERSONAL AI SYSTEM",
                color = Muted,
                fontSize = 8.sp,
                letterSpacing = 1.8.sp
            )
        }
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFF0B2637))
                .padding(horizontal = 11.dp, vertical = 7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Cyan)
            )
            Text(
                "  UI PREVIEW",
                color = Cyan,
                fontSize = 8.sp,
                letterSpacing = 1.2.sp
            )
        }
    }
}

@Composable
private fun BackgroundGrid() {
    Canvas(Modifier.fillMaxSize()) {
        val step = 42.dp.toPx()
        var x = 0f
        while (x <= size.width) {
            drawLine(Color(0x0D65CFFF), androidx.compose.ui.geometry.Offset(x, 0f),
                androidx.compose.ui.geometry.Offset(x, size.height), 0.6.dp.toPx())
            x += step
        }
        var y = 0f
        while (y <= size.height) {
            drawLine(Color(0x0D65CFFF), androidx.compose.ui.geometry.Offset(0f, y),
                androidx.compose.ui.geometry.Offset(size.width, y), 0.6.dp.toPx())
            y += step
        }
        drawCircle(
            brush = Brush.radialGradient(
                listOf(Color(0x1830BFFF), Color.Transparent),
                center = androidx.compose.ui.geometry.Offset(size.width / 2f, size.height * 0.43f),
                radius = size.minDimension * 0.58f
            ),
            radius = size.minDimension * 0.58f,
            center = androidx.compose.ui.geometry.Offset(size.width / 2f, size.height * 0.43f)
        )
    }
}

@Composable
private fun HudCore(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "muslima-core")
    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(24000, easing = FastOutSlowInEasing)),
        label = "rotation"
    )
    val reverseRotation by transition.animateFloat(
        initialValue = 360f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(tween(17000, easing = FastOutSlowInEasing)),
        label = "reverse-rotation"
    )
    val pulse by transition.animateFloat(
        initialValue = 0.94f,
        targetValue = 1.055f,
        animationSpec = infiniteRepeatable(
            tween(1900, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )
    val scan by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(5200, easing = FastOutSlowInEasing)),
        label = "scan"
    )

    Canvas(modifier = modifier) {
        val c = center
        val unit = size.minDimension * 0.29f
        val outer = unit * 1.52f
        drawCircle(
            brush = Brush.radialGradient(
                listOf(Color(0x6655DFFF), Color(0x22287BFF), Color.Transparent),
                center = c,
                radius = outer * 1.48f
            ),
            radius = outer * 1.48f,
            center = c
        )

        // Layered HUD rings
        drawCircle(Color(0x6655DFFF), outer, c, style = Stroke(1.dp.toPx()))
        drawCircle(Color(0x332D8BFF), outer * 1.12f, c, style = Stroke(0.7.dp.toPx()))
        drawArc(
            color = Cyan,
            startAngle = rotation,
            sweepAngle = 78f,
            useCenter = false,
            topLeft = androidx.compose.ui.geometry.Offset(c.x - outer * 1.16f, c.y - outer * 1.16f),
            size = androidx.compose.ui.geometry.Size(outer * 2.32f, outer * 2.32f),
            style = Stroke(2.dp.toPx())
        )
        drawArc(
            color = Color(0xAA287BFF),
            startAngle = reverseRotation,
            sweepAngle = 112f,
            useCenter = false,
            topLeft = androidx.compose.ui.geometry.Offset(c.x - outer * 1.27f, c.y - outer * 1.27f),
            size = androidx.compose.ui.geometry.Size(outer * 2.54f, outer * 2.54f),
            style = Stroke(1.4.dp.toPx())
        )
        drawArc(
            color = Color(0x7755E6FF),
            startAngle = scan,
            sweepAngle = 32f,
            useCenter = false,
            topLeft = androidx.compose.ui.geometry.Offset(c.x - outer * 1.36f, c.y - outer * 1.36f),
            size = androidx.compose.ui.geometry.Size(outer * 2.72f, outer * 2.72f),
            style = Stroke(1.dp.toPx())
        )

        // Rotating technical ticks
        rotate(rotation * 0.35f, pivot = c) {
            for (i in 0 until 72) {
                val angle = Math.toRadians(i * 5.0)
                val innerR = outer * 1.02f
                val outerR = if (i % 6 == 0) outer * 1.13f else outer * 1.075f
                val sx = c.x + cos(angle).toFloat() * innerR
                val sy = c.y + sin(angle).toFloat() * innerR
                val ex = c.x + cos(angle).toFloat() * outerR
                val ey = c.y + sin(angle).toFloat() * outerR
                drawLine(
                    if (i % 6 == 0) Cyan.copy(alpha = 0.8f) else Blue.copy(alpha = 0.45f),
                    androidx.compose.ui.geometry.Offset(sx, sy),
                    androidx.compose.ui.geometry.Offset(ex, ey),
                    if (i % 6 == 0) 1.5.dp.toPx() else 0.7.dp.toPx()
                )
            }
        }

        // Orbital nodes
        for (i in 0 until 3) {
            val angle = Math.toRadians((rotation + i * 120f).toDouble())
            val r = outer * 1.19f
            val p = androidx.compose.ui.geometry.Offset(
                c.x + cos(angle).toFloat() * r,
                c.y + sin(angle).toFloat() * r
            )
            drawCircle(Color(0x4455E6FF), 8.dp.toPx(), p)
            drawCircle(Cyan, 2.7.dp.toPx(), p)
        }

        // Volumetric glowing energy sphere
        val sphere = unit * pulse
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color(0xFFE5FCFF),
                    Color(0xFF8DEEFF),
                    Color(0xFF26A9F4),
                    Color(0xFF07529D),
                    Color(0xFF04152D)
                ),
                center = c - androidx.compose.ui.geometry.Offset(sphere * 0.34f, sphere * 0.39f),
                radius = sphere * 1.48f
            ),
            radius = sphere,
            center = c
        )
        drawCircle(
            color = Color(0xAA9CF4FF),
            radius = sphere * 0.91f,
            center = c,
            style = Stroke(1.dp.toPx())
        )
        drawArc(
            color = Color(0xCCFFFFFF),
            startAngle = 205f + scan * 0.25f,
            sweepAngle = 72f,
            useCenter = false,
            topLeft = androidx.compose.ui.geometry.Offset(c.x - sphere * 0.78f, c.y - sphere * 0.78f),
            size = androidx.compose.ui.geometry.Size(sphere * 1.56f, sphere * 1.56f),
            style = Stroke(2.dp.toPx())
        )
        drawCircle(
            brush = Brush.radialGradient(
                listOf(Color(0x99FFFFFF), Color(0x22FFFFFF), Color.Transparent),
                center = c - androidx.compose.ui.geometry.Offset(sphere * 0.35f, sphere * 0.48f),
                radius = sphere * 0.55f
            ),
            radius = sphere * 0.55f,
            center = c - androidx.compose.ui.geometry.Offset(sphere * 0.35f, sphere * 0.48f)
        )
        drawCircle(Color(0xAA55E6FF), sphere * 1.34f, c, style = Stroke(1.dp.toPx()))
    }
}

@Composable
private fun VoiceWaveform() {
    val transition = rememberInfiniteTransition(label = "waveform")
    val phase by transition.animateFloat(
        initialValue = 0f,
        targetValue = (Math.PI * 2.0).toFloat(),
        animationSpec = infiniteRepeatable(
            tween(1700, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "wave-phase"
    )
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(42.dp)
    ) {
        val count = 43
        val gap = 3.dp.toPx()
        val barWidth = (size.width - gap * (count - 1)) / count
        for (i in 0 until count) {
            val wave = (sin(phase + i * 0.37f) + 1f) / 2f
            val envelope = 0.25f + 0.75f * sin((i.toFloat() / count) * Math.PI).toFloat()
            val h = (4.dp.toPx() + wave * envelope * 29.dp.toPx()).coerceAtLeast(3.dp.toPx())
            val x = i * (barWidth + gap)
            drawRoundRect(
                brush = Brush.verticalGradient(listOf(Color(0xFFB5F7FF), Cyan, Blue)),
                topLeft = androidx.compose.ui.geometry.Offset(x, (size.height - h) / 2f),
                size = androidx.compose.ui.geometry.Size(barWidth, h),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(barWidth, barWidth)
            )
        }
    }
}

@Composable
private fun StatusPanel() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        StatusTile("INTERFEYS", "Faol", Modifier.weight(1f))
        StatusTile("OVOZ MODI", "Demo", Modifier.weight(1f))
        StatusTile("PLATFORMA", "Android", Modifier.weight(1f))
    }
}

@Composable
private fun StatusTile(title: String, value: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(13.dp))
            .background(
                Brush.verticalGradient(listOf(Color(0xCC10263A), Color(0xCC071321)))
            )
            .padding(horizontal = 10.dp, vertical = 12.dp)
    ) {
        Text(title, color = Muted, fontSize = 7.sp, letterSpacing = 0.8.sp)
        Spacer(Modifier.height(6.dp))
        Text(value, color = Pale, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
    }
}
