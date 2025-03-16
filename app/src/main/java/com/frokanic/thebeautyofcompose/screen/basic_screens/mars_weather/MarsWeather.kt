package com.frokanic.thebeautyofcompose.screen.basic_screens.mars_weather

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frokanic.thebeautyofcompose.R

@Composable
fun MarsWeather(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color(0xFF120327)
            )
    ) {
        Image(
            painter = painterResource(R.drawable.mars_surface),
            contentDescription = null,
            modifier = Modifier
                .scale(2f)
                .align(Alignment.BottomCenter)
        )

        MarsDataCard(
            modifier = Modifier
                .padding(48.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun MarsDataCard(
    modifier: Modifier = Modifier
) {
    Card(
        shape = CutCornerShape(
            topEnd = 20.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            LabeledIcon(
                text = "Olympus Mons",
                textStyle = TextStyle(
                    color = Color(0xFF9E83C5),
                    fontSize = 14.sp
                ),
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.vector),
                        contentDescription = null,
                        tint = Color(0xFF9E83C5)
                    )
                }
            )

            Spacer(modifier = Modifier.height(48.dp))

            LabeledIcon(
                text = "Dust Storm",
                textStyle = TextStyle(
                    color = Color(0xFFCD533C),
                    fontSize = 14.sp
                ),
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.wind),
                        contentDescription = null,
                        tint = Color(0xFFCD533C)
                    )
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            TempInfoRow(
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            MarsInfoCards()
        }
    }
}

@Composable
fun TempInfoRow(
    modifier: Modifier = Modifier
) {
    // The alignment in the current temp is incorrect. A solution can be seen below, but will not be used, since I do not yet fully understand it.
    // https://stackoverflow.com/questions/70531951/align-two-texts-by-fonts-ascent-instead-of-baseline-in-jetpack-compose

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {

        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(
                space = 4.dp
            )
        ) {
            Text(
                text = "-63",
                style = TextStyle(
                    fontSize = 64.sp,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    ),
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.FirstLineTop
                    )
                )
            )

            Text(
                text = "°C",
                style = TextStyle(
                    fontSize = 24.sp,

                )
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(
                space = 4.dp
            )
        ) {
            Text(
                text = "H:-52°C",
                color = Color(0xFF474F63),
                fontSize = 14.sp
            )
            Text(
                text = "L:-73°C",
                color = Color(0xFF474F63),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun MarsInfoCards(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 8.dp
        ),
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                space = 8.dp
            ),
            modifier = Modifier
        ) {
            MarsSingleInfoCard(
                name = "Wind Speed",
                data = "27km/h NW",
                modifier = Modifier
                    .weight(1f)
            )
            MarsSingleInfoCard(
                name = "Pressure",
                data = "600 Pa",
                modifier = Modifier
                    .weight(1f)
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(
                space = 8.dp
            ),
            modifier = Modifier
        ) {
            MarsSingleInfoCard(
                name = "UV Radiation",
                data = "0.5 mSv/day",
                modifier = Modifier
                    .weight(1f)
            )

            MarsSingleInfoCard(
                name = "Martian date",
                data = "914 Sol",
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Composable
fun MarsSingleInfoCard(
    modifier: Modifier = Modifier,
    name: String,
    data: String
) {
    Box(
        modifier = modifier
            .background(
                color = Color(0xFFF9E8E5)
            )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 8.dp
            ),
            modifier = Modifier
                .padding(
                    vertical = 16.dp,
                    horizontal = 8.dp
                )
        ) {
            Text(
                text = name,
                color = Color(0xFFCD533C),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            )
            Text(
                text = data,
                color = Color(0xFF14171E),
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                )
            )
        }
    }
}

@Composable
private fun LabeledIcon(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle,
    icon: @Composable () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = 4.dp
        ),
        modifier = modifier
    ) {
        icon()

        Text(
            text = text,
            style = textStyle
        )
    }
}

@Preview
@Composable
private fun MarsWeatherPreview() {
    MarsWeather()
}