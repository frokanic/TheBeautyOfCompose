package com.frokanic.thebeautyofcompose.screen.basic_screens.dawn_and_dusk

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frokanic.thebeautyofcompose.R

// Though a theme would be the best approach here, I did not go with it due to the nature of the project
@Composable
fun DawnAndDusk(
    modifier: Modifier = Modifier
) {
    val isLightTheme = !isSystemInDarkTheme()
    
    val backgroundColor = if (isLightTheme)
        Brush.linearGradient(
            colors = listOf(
                Color(0xFFC6ECFE),
                Color(0xFF6689F9)
            )
        )
    else
        Brush.linearGradient(
            colors = listOf(
                Color(0xFF120327),
                Color(0xFF210A41)
            )
        )

    Box(
//        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = backgroundColor
            )
            .padding(
                horizontal = 32.dp
            )
    ) {
        SunMoonRow(
            isLightTheme = isLightTheme,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 80.dp
                )
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "How was your day?",
                style = TextStyle(
                    fontSize = 32.sp,
                    color = if (isLightTheme)
                        Color(0xFF14042B)
                    else
                        Color(0xFFE6E5FE),
                    fontWeight = FontWeight.SemiBold
                )
            )

            StarRow(
                isLightTheme = isLightTheme,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 16.dp
                    )
            )
        }
    }
}

@Composable
private fun SunMoonRow(
    modifier: Modifier = Modifier,
    isLightTheme: Boolean
) {
    val arrangement = if (isLightTheme) Arrangement.Start else Arrangement.End
    val painterId = if (isLightTheme) R.drawable.sun else R.drawable.moon

    Row(
        horizontalArrangement = arrangement,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(painterId),
            contentDescription = null
        )
    }
}

@Composable
private fun StarRow(
    modifier: Modifier = Modifier,
    isLightTheme: Boolean
) {
    var selectedRating by rememberSaveable { mutableIntStateOf(-1) }
    val backgroundColor = if (isLightTheme) Color(0xFFFFFFFF) else Color(0xFF2C144D)

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(32.dp)
            )
            .padding(
                horizontal = 24.dp,
                vertical = 12.dp
            )
    ) {
        repeat(5) { index ->
            Icon(
                painter = painterResource(R.drawable.dnd_star),
                contentDescription = null,
                tint = if (selectedRating < index) Color(0xFFD7E4F7) else Color(0xFFFF9334),
                modifier = Modifier
                    .weight(1f)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                    ) {
                        if (selectedRating != index) {
                            selectedRating = index
                        } else {
                            selectedRating--
                        }
                    }

            )
        }
    }
}

@PreviewLightDark
@Composable
private fun DawnAndDuskPreview() {
    DawnAndDusk()
}