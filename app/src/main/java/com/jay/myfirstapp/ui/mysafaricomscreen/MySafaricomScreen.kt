package com.jay.myfirstapp.ui.mysafaricomscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


private val Black = Color(0xFF0F0F0F)
private val DarkCard = Color(0xFF1C1C1C)
private val Red = Color(0xFFE53935)
private val White = Color.White

@Composable
fun MySafaricomScreen() {

    val services = listOf(
        "Financial Services",
        "Global Payments",
        "Business",
        "Travel",
        "Shopping",
        "Government",
        "Insurance",
        "Health",
        "Entertainment",
        "Education"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(16.dp)
    ) {

        // Header from Components.kt
        item {
            HeaderSection()
        }

        item {

            Spacer(modifier = Modifier.height(10.dp))

            LazyRow {

                items(3) {

                    Card(
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .width(300.dp)
                            .height(170.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = DarkCard
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {

                            Text(
                                text = "Main Wallet",
                                color = Red
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "Ksh 1,441.30",
                                color = White,
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Red
                                )
                            ) {
                                Text(
                                    text = "View Statement",
                                    color = White
                                )
                            }
                        }
                    }
                }
            }
        }

        item {

            Spacer(modifier = Modifier.height(20.dp))

            AppsTabsSection()

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {

            QuickActionsSection()

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {

            LazyRow {

                items(3) {

                    PromotionalBanner()
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {

            FinanceSection()

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {

            BalanceCardsSection()

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {

            ServicesGridSection()

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {

            FeatureCardsSection()

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {

            CategoriesSection()

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {

            AnimatedScannerButton()

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {

            Text(
                text = "Explore Services",
                color = White,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))
        }

        items(services.chunked(2)) { rowItems ->

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                rowItems.forEach { service ->

                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .height(120.dp)
                            .padding(6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = DarkCard
                        )
                    ) {

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
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

        item {

            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}