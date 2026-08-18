package com.example.cleanwave01

import com.example.cleanwave01.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CardItem(
    val imageRes: Int,
    val hcoRes: Int,
    val title: String,
    val description: String
)

@Composable
fun DonationAndSupportScreen() {
    val scrollState = rememberScrollState()

    val cards = listOf(
        CardItem(R.drawable.img1, R.drawable.hco1, "Cleaner Oceans", "Lorem ipsum dolor sit amet consectetur. Malesuada habitant aliquam enim a."),
        CardItem(R.drawable.img2, R.drawable.hco2, "Cleaner Oceans", "Lorem ipsum dolor sit amet consectetur. Malesuada habitant aliquam enim a."),
        CardItem(R.drawable.img3, R.drawable.hco3, "Cleaner Oceans", "Lorem ipsum dolor sit amet consectetur. Malesuada habitant aliquam enim a."),
        CardItem(R.drawable.img4, R.drawable.hco4, "Cleaner Oceans", "Lorem ipsum dolor sit amet consectetur. Malesuada habitant aliquam enim amet."),
        CardItem(R.drawable.img5, R.drawable.hco5, "Cleaner Oceans", "Lorem ipsum dolor sit amet consectetur. Malesuada habitant aliquam enim amet."),
        CardItem(R.drawable.img6, R.drawable.hco6, "Cleaner Oceans", "Lorem ipsum dolor sit amet consectetur. Malesuada habitant aliquam enim amet.")
    )

    val sideIcons = listOf(
        R.drawable.ico1, R.drawable.ico2, R.drawable.ico3, R.drawable.ico4,
        R.drawable.ico5, R.drawable.ico6
    )

    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF4F7F9))
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Header Image Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.donate),
                    contentDescription = "Header Banner",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Donation & Support",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 40.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "YOUR SUPPORT CAN MAKE A DIFFERENCE",
                color = Color(0xFF1B365D),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 6 Grid Cards (3 rows of 2 cards)
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                for (row in 0..2) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        for (col in 0..1) {
                            val index = row * 2 + col
                            if (index < cards.size) {
                                Box(modifier = Modifier.weight(1f)) {
                                    CleanerOceanCard(item = cards[index])
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Side List + Donation Form Container
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Left side: Icon items list
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    sideIcons.forEach { icoRes ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Image(
                                painter = painterResource(id = icoRes),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp)
                            )
                            Text(
                                text = "Lorem ipsum dolor sit amet consectetur.consectetur.",
                                fontSize = 9.sp,
                                color = Color(0xFF1B365D),
                                lineHeight = 11.sp
                            )
                        }
                    }
                }

                // Right side: Donation Form Card
                DonationFormCard(modifier = Modifier.weight(1.2f))
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Bottom Banner Quote Image
            Image(
                painter = painterResource(id = R.drawable.donateandsupportbanner),
                contentDescription = "Ocean Banner Quote",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(110.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun CleanerOceanCard(item: CardItem) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(6.dp)) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(id = item.hcoRes),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = item.title,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1B365D)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.description,
                fontSize = 8.sp,
                color = Color.Gray,
                lineHeight = 10.sp
            )
        }
    }
}

@Composable
fun DonationFormCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0052A5))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "MAKE A DONATION",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
            Text(
                text = "Every contribution counts!",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 9.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            val amounts = listOf("$10", "$10", "$10", "$10", "$10", "$10")
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                for (i in 0..1) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        for (j in 0..2) {
                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(30.dp),
                                contentPadding = PaddingValues(0.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                shape = RoundedCornerShape(4.dp)
                            ) {
                                Text(
                                    text = amounts[i * 3 + j],
                                    color = Color(0xFF0052A5),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .background(Color.White, RoundedCornerShape(4.dp))
                    .padding(horizontal = 8.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = "One Time Donation", fontSize = 10.sp, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(34.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008000)),
                shape = RoundedCornerShape(4.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = "DONATE NOW ♥", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "OR", color = Color.White, fontSize = 10.sp)

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(34.dp),
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(1.dp, Color.White),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = "MONTHLY SUPPORT ♥", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Vitae faucibus id non mi vi.",
                color = Color.White,
                fontSize = 8.sp,
                textAlign = TextAlign.Center,
                lineHeight = 10.sp
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "Home",
                modifier = Modifier.size(28.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.compass),
                contentDescription = "Explore",
                modifier = Modifier.size(28.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ico3),
                contentDescription = "Donate",
                modifier = Modifier.size(28.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.members),
                contentDescription = "Community",
                modifier = Modifier.size(28.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier.size(28.dp)
            )
        }
    }
}