package com.alangeronimo.saketour.presentation.screens

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.core.net.toUri
import com.alangeronimo.designsystem.components.AddressRow
import com.alangeronimo.designsystem.components.MyToolbar
import com.alangeronimo.designsystem.components.PrimaryTextButton
import com.alangeronimo.designsystem.components.ShopImageLoader
import com.alangeronimo.designsystem.components.StarRating
import com.alangeronimo.designsystem.ui.theme.Dimens
import com.alangeronimo.designsystem.ui.theme.SakeTourTheme
import com.alangeronimo.domain.model.SakeShop
import com.alangeronimo.saketour.R

@Composable
fun SakeShopDetailScreen(
    shop: SakeShop,
    onBackClick: () -> Unit,
) {
    val context = LocalContext.current

    SakeTourTheme {
        Scaffold(
            topBar = {
                MyToolbar(
                    title = stringResource(id = R.string.detail_screen_title),
                    hasBackIcon = true,
                    onBackClick = onBackClick,
                )
            },
        ) { paddingValues ->
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
            ) {
                Column(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ShopImageLoader(
                        imageUrl = shop.picture,
                        placeholder = R.drawable.img_placeholder_horizontal,
                        errorImage = R.drawable.img_error_image_horizontal,
                        contentDescription = "Sake Shop image",
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .height(Dimens.ImageHeight),
                    )
                    Column(
                        modifier =
                            Modifier
                                .fillMaxSize()
                                .padding(Dimens.PaddingMedium),
                    ) {
                        Spacer(modifier = Modifier.height(Dimens.PaddingMedium))
                        Text(
                            shop.name,
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Start,
                        )
                        Spacer(modifier = Modifier.height(Dimens.PaddingSmall))
                        Text(
                            shop.description,
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Start,
                        )
                        Spacer(modifier = Modifier.height(Dimens.PaddingMedium))
                        Text(
                            "${shop.rating}",
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Center,
                        )
                        StarRating(shop.rating, Modifier.align(Alignment.CenterHorizontally), 5)
                        Spacer(modifier = Modifier.height(Dimens.PaddingMedium))
                    }
                    AddressRow(
                        shop.address,
                        onClick = {
                            context.startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    shop.googleMapsLink.toUri(),
                                ),
                            )
                        },
                    )
                    Spacer(modifier = Modifier.height(Dimens.PaddingMedium))
                }

                PrimaryTextButton(
                    stringResource(id = R.string.visit_website_button),
                    onClick = {
                        context.startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                shop.website.toUri(),
                            ),
                        )
                    },
                    modifier =
                        Modifier
                            .align(Alignment.BottomStart)
                            .padding(Dimens.PaddingMedium),
                )
            }
        }
    }
}
