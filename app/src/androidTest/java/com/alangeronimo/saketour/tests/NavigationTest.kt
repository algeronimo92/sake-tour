package com.alangeronimo.saketour.tests

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.alangeronimo.domain.model.SakeShop
import com.alangeronimo.saketour.presentation.screens.NavHostGenerator
import com.alangeronimo.saketour.presentation.state.SakeUiState
import com.alangeronimo.saketour.presentation.viewmodel.ISakeShopViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertEquals

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    lateinit var navController: TestNavHostController

    @Before
    fun setupNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            val fakeViewModel = FakeSakeShopViewModel()
            NavHostGenerator(
                navController = navController,
                viewModel = fakeViewModel
            )
        }
    }

    @Test
    fun verify_StartDestinationIsSakeShopListScreen() {
        composeTestRule
            .onNodeWithText("Sake Shops")
            .assertIsDisplayed()
    }

    @Test
    fun verify_NavigateToDetailScreenAndShowRightShopInfo() {
        composeTestRule.onNodeWithText("Sakura Sake")
            .performClick()

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, "detail/{name}")
        composeTestRule.onNodeWithText("Shop Details")
            .assertIsDisplayed()
        composeTestRule.onNodeWithText("Sakura Sake")
            .assertIsDisplayed()
        composeTestRule.onNodeWithText("Seasonal floral sake.")
            .assertIsDisplayed()
        composeTestRule.onNodeWithText("4.8")
            .assertIsDisplayed()
    }

    class FakeSakeShopViewModel : ISakeShopViewModel {
        private val fakeShops = listOf(
            SakeShop("Kyoto Sake", "Traditional sake crafted in Kyoto.", null, 4.7f, "123 Kyoto Street, Japan", "https://maps.google.com/kyoto_sake", "https://kyotosake.jp"),
            SakeShop("Tokyo Brew", "A fusion of modern and traditional techniques.", null, 4.3f, "5-7 Tokyo Ave, Japan", "https://maps.google.com/tokyo_brew", "https://tokyobrew.jp"),
            SakeShop("Osaka Spirits", "Specialists in artisanal sake.", null, 4.1f, "88 Osaka Rd, Japan", "https://maps.google.com/osaka_spirits", "https://osakaspirits.jp"),
            SakeShop("Sakura Sake", "Seasonal floral sake.", null, 4.8f, "11 Cherry Blossom Lane, Kyoto", "https://maps.google.com/sakura_sake", "https://sakurasake.jp"),
            SakeShop("Nara Heritage", "Recipes passed down for over 100 years.", null, 4.6f, "10 Ancient Way, Nara", "https://maps.google.com/nara_heritage", "https://naraheritage.jp"),
            SakeShop("Fukuoka Ferment", "Smooth flavors with body.", null, 4.2f, "55 Market St, Fukuoka", "https://maps.google.com/fukuoka_ferment", "https://fukuokaferment.jp"),
            SakeShop("Hokkaido Snow", "Cool and refreshing sake from the north.", null, 4.5f, "1 Glacier Ave, Hokkaido", "https://maps.google.com/hokkaido_snow", "https://hokkaidosnow.jp"),
            SakeShop("Shizuoka Selections", "Premium sake tasting experience.", null, 4.0f, "20 Sake Plaza, Shizuoka", "https://maps.google.com/shizuoka_selections", "https://shizuokasake.jp"),
            SakeShop("Kobe Classics", "Elegance in every bottle.", null, 4.4f, "77 Harbor Rd, Kobe", "https://maps.google.com/kobe_classics", "https://kobesake.jp"),
            SakeShop("Nagoya Sake House", "Tradition and certified quality.", null, 4.3f, "3 Heritage Lane, Nagoya", "https://maps.google.com/nagoya_sake", "https://nagoyasake.jp")
        )

        override val state = MutableStateFlow(
            SakeUiState(isLoading = false, sakeShops = fakeShops)
        )

        override fun findShopByName(name: String): SakeShop? {
            return fakeShops.find { it.name == name }
        }
    }
}
