package com.frokanic.thebeautyofcompose.screen.hotel_booking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowWidthSizeClass
import com.frokanic.thebeautyofcompose.R

private val tags = listOf(
    "City Center",
    "Luxury",
    "Instant Booking",
    "Exclusive Deal",
    "Early Bird Discount",
    "Romantic Gateway",
    "24/7 Support"
)

private val offers = mapOf(
    R.drawable.hotel_bed to "2 Bed",
    R.drawable.hotel_breakfast to "Breakfast",
    R.drawable.hotel_cutlery to "Cutlery",
    R.drawable.hotel_paw to "Pet Friendly",
    R.drawable.hotel_dish to "Dinner",
    R.drawable.hotel_snowflake to "Air Conditioning",
    R.drawable.hotel_television to "TV",
    R.drawable.hotel_wifi to "Wifi",
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun HotelBooking(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(R.drawable.hotel_living_room),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(
                            max = 250.dp
                        )
                )

                FadedHotelBanner(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                )
            }
        }

        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement
                    .spacedBy(
                        space = 8.dp,
                        alignment = Alignment.CenterHorizontally
                    )
            ) {
                tags.forEach { tag ->
                    AssistChip(
                        onClick = {  },
                        label = {
                            Text(
                                text = tag
                            )
                        }
                    )
                }
            }
        }

        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            Text(
                text = """
                    The advertisement features a vibrant and inviting design, showcasing the Hotel California Strawberry nestled in the heart of Los Angeles. Surrounded by the iconic Hollywood Sign, Griffith Park, and stunning beaches, the hotel is perfectly located for guests to explore L.A.’s best attractions.
                    """.trimIndent(),
                fontSize = 13.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            Text(
                text = "What we offer",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement
                    .spacedBy(
                        space = 8.dp,
                        alignment = Alignment.CenterHorizontally
                    )
            ) {
                items(offers.entries.toList()) { (drawableResId, label) ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(Color.Gray.copy(0.3f))
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(drawableResId),
                            contentDescription = null,
                            modifier = Modifier
                                .size(36.dp)
                        )

                        Text(
                            text = label,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }

        item {
            Button(
                onClick = {  },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .widthIn(max = 400.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Book now!"
                )
            }
        }
    }
}

@Composable
fun FadedHotelBanner(
    modifier: Modifier = Modifier
) {
    val windowClass = currentWindowAdaptiveInfo().windowSizeClass
    Row(
        modifier = modifier
            .background(Color.White.copy(0.7f))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            verticalArrangement = Arrangement
                .spacedBy(4.dp),
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "Hotel California Strawberry",
                fontWeight = FontWeight.Bold,
                fontSize = when (windowClass.windowWidthSizeClass) {
                    WindowWidthSizeClass.COMPACT -> 18.sp
                    WindowWidthSizeClass.MEDIUM -> 24.sp
                    WindowWidthSizeClass.EXPANDED -> 32.sp
                    else -> 18.sp
                },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            LabeledIcon(
                text = "Los Angeles, California",
                icon = {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        tint = Color.DarkGray,
                        contentDescription = null
                    )
                }
            )

            LabeledIcon(
                text = "4.9 (14K reviews)",
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        tint = Color.Yellow,
                        contentDescription = null
                    )
                }
            )
        }

        Text(
            text = buildAnnotatedString {
                val multiplier = when (windowClass.windowWidthSizeClass) {
                    WindowWidthSizeClass.COMPACT -> 1f
                    WindowWidthSizeClass.MEDIUM -> 1.2f
                    WindowWidthSizeClass.EXPANDED -> 1.5f
                    else -> 1f
                }

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp * multiplier
                    )
                ) {
                    append("$420/")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp * multiplier
                    )
                ) {
                    append("night")
                }
            }
        )
    }
}

@Composable
fun LabeledIcon(
    text: String,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        icon()

        Text(
            text = text
        )
    }
}

@Preview
@Composable
private fun HotelBookingPreview() {
    HotelBooking()
}

@Preview(
    device = Devices.NEXUS_10
)
@Composable
private fun HotelBookingTabletPreview() {
    HotelBooking()
}