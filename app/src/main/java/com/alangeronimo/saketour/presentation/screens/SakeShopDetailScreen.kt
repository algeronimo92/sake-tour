package com.alangeronimo.saketour.presentation.screens

import android.content.Intent
import com.alangeronimo.saketour.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.alangeronimo.designsystem.components.AddressRow
import com.alangeronimo.designsystem.components.MyToolbar
import com.alangeronimo.designsystem.components.StarRating
import com.alangeronimo.designsystem.ui.theme.Dimens
import com.alangeronimo.designsystem.ui.theme.SakeTourTheme
import com.alangeronimo.domain.model.SakeShop
import androidx.core.net.toUri
import com.alangeronimo.designsystem.components.PrimaryTextButton
import com.alangeronimo.designsystem.components.ShopImageLoader

@Composable
fun SakeShopDetailScreen(shop: SakeShop, onBackClick: () -> Unit) {
    val context = LocalContext.current

    SakeTourTheme {
        Scaffold(
            topBar = {
                MyToolbar(
                    title = "Shop Details",
                    hasBackIcon = true,
                    onBackClick = onBackClick,
                )
            },
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ShopImageLoader(
                        imageUrl = shop.picture,
                        placeholder = R.drawable.img_placeholder_horizontal,
                        errorImage = R.drawable.img_error_image_horizontal,
                        contentDescription = "Sake Shop image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(Dimens.ImageHeight)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(Dimens.PaddingMedium)
                    ) {
                        Spacer(modifier = Modifier.height(Dimens.PaddingMedium))
                        Text(
                            shop.name,
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Start
                        )
                        Spacer(modifier = Modifier.height(Dimens.PaddingSmall))
                        Text(
                            shop.description,
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Start
                        )
                        Spacer(modifier = Modifier.height(Dimens.PaddingMedium))
                        Text(
                            "${shop.rating}",
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Center
                        )
                        StarRating(shop.rating, Modifier.align(Alignment.CenterHorizontally), 5)
                        Spacer(modifier = Modifier.height(Dimens.PaddingMedium))
                    }
                    AddressRow(
                        shop.address, onClick = {
                            context.startActivity(
                                Intent(
                                    Intent.ACTION_VIEW, shop.googleMapsLink.toUri()
                                )
                            )
                        })
                    Spacer(modifier = Modifier.height(Dimens.PaddingMedium))
                }

                PrimaryTextButton(
                    "Visit Website",
                    onClick = {
                        context.startActivity(
                            Intent(
                                Intent.ACTION_VIEW, shop.website.toUri()
                            )
                        )
                    },
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(Dimens.PaddingMedium)
                )
            }

        }
    }
}
