package com.alangeronimo.saketour.tests

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.alangeronimo.data.common.MyLogger
import com.alangeronimo.data.dto.SakeShopDto
import com.alangeronimo.data.network.SakeShopApi
import com.alangeronimo.data.repository.SakeShopRepositoryImpl
import com.alangeronimo.domain.model.SakeShop
import com.alangeronimo.domain.repository.SakeShopRepository
import com.google.gson.Gson
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SakeShopRepositoryImplFallbackTest {
    class FakeFailingApi : SakeShopApi {
        override suspend fun getSakeShops(): List<SakeShopDto> {
            throw RuntimeException("Simulated API failure")
        }
    }

    class TestLogger : MyLogger {
        override fun logError(
            tag: String,
            message: String,
            throwable: Throwable?,
        ) {
            println("[$tag] $message")
        }
    }

    @Test
    fun fallback_json_is_loaded_when_api_fails() =
        runTest {
            val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
            val api = FakeFailingApi()
            val gson = Gson()
            val logger = TestLogger()

            val repository: SakeShopRepository =
                SakeShopRepositoryImpl(
                    api = api,
                    context = context,
                    gson = gson,
                    logger = logger,
                )

            val result: List<SakeShop> = repository.getSakeShops()

            assertTrue("Should return a list from the json backup", result.isNotEmpty())
            println("Fallback works correctly with ${result.size} sake shops.")
        }
}
