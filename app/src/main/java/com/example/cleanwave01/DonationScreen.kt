package com.example.cleanwave01

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cleanwave01.ui.theme.CleanWaveBlue
import com.example.cleanwave01.ui.theme.CleanWaveCardBg
import com.example.cleanwave01.ui.theme.CleanWaveDarkBlue
import com.example.cleanwave01.ui.theme.CleanWaveGreen
import com.example.cleanwave01.ui.theme.Cleanwave01Theme

@Composable
fun DonationScreen() {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {
            item { HeaderSection() }
            item { SupportTitleSection() }
            item { GridCardsSection() }
            item { DonationAndInfoSection() }
            item { BottomBannerSection() }
            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        // Wavy background clip to match the screenshot
        val wavyShape = GenericShape { size, _ ->
            moveTo(0f, 0f)
            lineTo(size.width, 0f)
            lineTo(size.width, size.height * 0.75f)
            cubicTo(
                size.width * 0.8f, size.height * 0.65f,
                size.width * 0.6f, size.height * 0.95f,
                size.width * 0.4f, size.height * 0.85f
            )
            cubicTo(
                size.width * 0.2f, size.height * 0.75f,
                0f, size.height * 0.95f,
                0f, size.height * 0.8f
            )
            close()
        }

        Image(
            painter = painterResource(id = R.drawable.donateandsupportbanner),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .clip(wavyShape),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Donation & Support",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Circular Logo in the middle
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = CircleShape,
                color = Color.White,
                shadowElevation = 4.dp,
                modifier = Modifier.size(75.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ico1),
                    contentDescription = null,
                    modifier = Modifier.padding(15.dp)
                )
            }
            Text(
                text = "Clean wave",
                color = CleanWaveBlue,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SupportTitleSection() {
    Text(
        text = "YOUR SUPPORT CAN MAKE A DIFFERENCE",
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 16.dp),
        textAlign = TextAlign.Center,
        color = CleanWaveDarkBlue,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp
    )
}

@Composable
fun GridCardsSection() {
    val items = listOf(
        Triple(R.drawable.img1, R.drawable.ico1, "Cleaner Oceans"),
        Triple(R.drawable.img2, R.drawable.ico2, "Cleaner Oceans"),
        Triple(R.drawable.img3, R.drawable.ico3, "Cleaner Oceans"),
        Triple(R.drawable.img4, R.drawable.ico4, "Cleaner Oceans"),
        Triple(R.drawable.img5, R.drawable.ico5, "Cleaner Oceans"),
        Triple(R.drawable.img6, R.drawable.ico6, "Cleaner Oceans")
    )

    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
        for (i in 0 until 2) {
            Row(modifier = Modifier.fillMaxWidth()) {
                for (j in 0 until 3) {
                    val index = i * 3 + j
                    SupportCard(
                        modifier = Modifier.weight(1f),
                        imgRes = items[index].first,
                        icoRes = items[index].second,
                        title = items[index].third
                    )
                }
            }
        }
    }
}

@Composable
fun SupportCard(modifier: Modifier, imgRes: Int, icoRes: Int, title: String) {
    Card(
        modifier = modifier.padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = CleanWaveCardBg),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = imgRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                contentScale = ContentScale.Crop
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(6.dp)
            ) {
                Icon(
                    painter = painterResource(id = icoRes),
                    contentDescription = null,
                    tint = CleanWaveBlue,
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = title,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = CleanWaveDarkBlue
                )
            }
            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Malesuada habitant aliquam enim a.",
                fontSize = 8.sp,
                lineHeight = 10.sp,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                color = Color.DarkGray
            )
        }
    }
}

@Composable
fun DonationAndInfoSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Left Column: List of Info items
        Column(modifier = Modifier.weight(0.45f)) {
            val icons = listOf(
                R.drawable.hco1, R.drawable.hco2, R.drawable.hco3, R.drawable.hco4,
                R.drawable.hco5, R.drawable.hco6, R.drawable.hco7, R.drawable.hco1
            )
            icons.forEach { icon ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(26.dp)
                            .border(1.dp, CleanWaveBlue, CircleShape)
                            .padding(5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = null,
                            tint = CleanWaveBlue,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Lorem ipsum dolor sit amet consectetur.",
                        fontSize = 9.sp,
                        lineHeight = 11.sp,
                        color = CleanWaveDarkBlue
                    )
                }
            }
        }

        // Right Column: Blue Donation Card
        Card(
            modifier = Modifier.weight(0.55f),
            colors = CardDefaults.cardColors(containerColor = CleanWaveBlue),
            shape = RoundedCornerShape(15.dp)
        ) {
            Column(
                modifier = Modifier.padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    tint = CleanWaveGreen,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "MAKE A DONATION",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = "Every contribution counts!",
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 10.sp
                )
                Spacer(modifier = Modifier.height(10.dp))

                // Donation Amounts Grid
                Column {
                    repeat(2) {
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            repeat(3) {
                                Button(
                                    onClick = { },
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(30.dp),
                                    contentPadding = PaddingValues(0.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Text(text = "$10", color = CleanWaveBlue, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                    }
                }

                // Dropdown mock
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    shape = RoundedCornerShape(6.dp),
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "One Time Donation", fontSize = 10.sp, color = Color.Gray)
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(18.dp))
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(38.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = CleanWaveGreen),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "DONATE NOW", fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = null, modifier = Modifier.size(14.dp))
                    }
                }

                Text(text = "OR", color = Color.White, fontSize = 10.sp, modifier = Modifier.padding(vertical = 4.dp))

                OutlinedButton(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(38.dp),
                    border = BorderStroke(1.dp, Color.White),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "MONTHLY SUPPORT", fontSize = 11.sp, color = Color.White)
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = null, modifier = Modifier.size(14.dp))
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(verticalAlignment = Alignment.Top) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Lorem ipsum dolor sit amet consectetur. Vitae faucibus id ean mi vi.",
                        fontSize = 8.sp,
                        color = Color.White,
                        lineHeight = 10.sp
                    )
                }
            }
        }
    }
}

@Composable
fun BottomBannerSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(110.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.img1),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Black.copy(alpha = 0.45f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "\" Our oceans need our protection today for a better tomorrow \"",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 10.dp,
        modifier = Modifier.height(80.dp)
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(painterResource(id = R.drawable.home), contentDescription = null, modifier = Modifier.size(26.dp)) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(painterResource(id = R.drawable.compass), contentDescription = null, modifier = Modifier.size(26.dp)) }
        )
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(CleanWaveBlue.copy(alpha = 0.1f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.donate),
                        contentDescription = null,
                        modifier = Modifier.size(34.dp),
                        tint = CleanWaveBlue
                    )
                }
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(painterResource(id = R.drawable.members), contentDescription = null, modifier = Modifier.size(26.dp)) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(painterResource(id = R.drawable.profile), contentDescription = null, modifier = Modifier.size(26.dp)) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DonationScreenPreview() {
    Cleanwave01Theme {
        DonationScreen()
    }
}
