package com.jay.myfirstapp.ui.mysafaricomscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.ui.draw.scale
import androidx.compose.material3.CardDefaults
import androidx.compose.animation.core.*
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.jay.myfirstapp.R


private val Black = Color(0xFF0F0F0F)
private val DarkCard = Color(0xFF1C1C1C)
private val Red = Color(0xFFE53935)
private val White = Color.White

@Composable
fun HeaderSection() {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    modifier = Modifier.size(55.dp),
                    shape = CircleShape,
                    color = Red
                ) {

                    Box(
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = White
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {

                    Text(
                        text = "Good Morning",
                        color = Color.Gray
                    )

                    Text(
                        text = "Julius 👋",
                        color = White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            IconButton(onClick = {}) {

                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    tint = White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = DarkCard
            )
        ) {

            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.Gray
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "Search services...",
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun BalanceCardsSection() {

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {

        items(listOf(1, 2, 3)) {

            Card(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .width(330.dp)
                    .height(190.dp),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = DarkCard
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "M-PESA Wallet",
                        color = Red
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Ksh 1,441.30",
                        color = White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Available Balance",
                        color = Color.Gray
                    )
                }
            }
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        repeat(3) {

            Surface(
                modifier = Modifier
                    .padding(4.dp)
                    .size(8.dp),
                shape = CircleShape,
                color = if (it == 0) Red else Color.Gray
            ) {}
        }
    }
}

@Composable
fun AppsTabsSection() {

    val tabs = listOf(
        "Apps",
        "Send",
        "Pay",
        "Bundles",
        "Services"
    )

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {

        items(tabs) { tab ->

            AssistChip(
                onClick = {},
                label = {
                    Text(
                        text = tab,
                        color = White
                    )
                },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = Red
                ),
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}

@Composable
fun QuickActionsSection() {

    val actions = listOf(
        "Send",
        "Withdraw",
        "Airtime",
        "Bundles",
        "Loans",
        "Pay",
        "Bills",
        "More"
    )

    val icons = listOf(
        Icons.Default.Search,
        Icons.Default.Person,
        Icons.Default.Notifications,
        Icons.Default.Search,
        Icons.Default.Person,
        Icons.Default.Notifications,
        Icons.Default.Search,
        Icons.Default.Person
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = DarkCard
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Quick Actions",
                color = White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier.height(220.dp)
            ) {

                items(actions.size) { index ->

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(8.dp)
                    ) {

                        Surface(
                            modifier = Modifier.size(60.dp),
                            shape = CircleShape,
                            color = Red
                        ) {

                            Box(
                                contentAlignment = Alignment.Center
                            ) {

                                Icon(
                                    imageVector = icons[index],
                                    contentDescription = actions[index],
                                    tint = White
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = actions[index],
                            color = White,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FinanceSection() {

    Column {

        Text(
            text = "Featured Apps",
            color = White,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {

            items(listOf(1, 2, 3, 4, 5, 6)) {

                Card(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(120.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = DarkCard
                    )
                ) {

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "App",
                            color = White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FeatureCardsSection() {

    Column {

        Text(
            text = "Featured Offers",
            color = White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {

            items(listOf(1, 2, 3, 4)) {

                Card(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .width(280.dp)
                        .height(160.dp),
                    shape = RoundedCornerShape(24.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Red
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "SPECIAL OFFER",
                            color = White,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Get exclusive discounts and rewards.",
                            color = White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CategoriesSection() {

    val categories = listOf(
        "Finance",
        "Business",
        "Travel",
        "Health",
        "Education",
        "Shopping"
    )

    Column {

        Text(
            text = "Categories",
            color = White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(16.dp)
        ) {

            items(categories) { category ->

                AssistChip(
                    onClick = {},
                    label = {
                        Text(
                            text = category,
                            color = White
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = DarkCard
                    ),
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }
    }
}

@Composable
fun PromotionalBanner() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = DarkCard
        ),
        shape = RoundedCornerShape(20.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(
                    id = R.drawable.promo_banner
                ),
                contentDescription = "Promo Banner",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.Black.copy(alpha = 0.35f)
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {

                Text(
                    text = "SPECIAL OFFER",
                    color = White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                Text(
                    text = "Tap to learn more",
                    color = White
                )
            }
        }
    }
}

@Composable
fun ServicesGridSection() {

    val services = listOf(
        "Finance",
        "Payments",
        "Travel",
        "Shopping",
        "Business",
        "Insurance",
        "Health",
        "Government",
        "Education",
        "Entertainment",
        "News",
        "More"
    )

    Column {

        Text(
            text = "Explore",
            color = White,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.height(600.dp)
        ) {

            items(services) { service ->

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .height(120.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = DarkCard
                    )
                ) {

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = service,
                            color = White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AnimatedScannerButton() {

    val infiniteTransition =
        rememberInfiniteTransition(label = "scanner")

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.08f,
        animationSpec = infiniteRepeatable(
            animation = tween(800),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scannerScale"
    )

    ExtendedFloatingActionButton(
        onClick = {},
        modifier = Modifier.scale(scale),
        containerColor = Red,
        contentColor = White
    ) {
        Text("Scan QR")
    }
}