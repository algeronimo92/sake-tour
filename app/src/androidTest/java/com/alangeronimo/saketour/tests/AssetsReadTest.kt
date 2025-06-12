package com.alangeronimo.saketour.tests

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.alangeronimo.data.dto.SakeShopDto
import com.alangeronimo.data.utils.readBackupJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AssetsReadTest {

    private val gson = Gson()

    @Test
    fun reads_and_parses_sake_shops_backup_json_successfully() {
        val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

        val json = context.readBackupJson("sake_shops_backup.json")
        assertTrue("JSON has data", json.isNotBlank())

        val type = object : TypeToken<List<SakeShopDto>>() {}.type
        val dtoList: List<SakeShopDto> = gson.fromJson(json, type)

        assertTrue("List should not be empty", dtoList.isNotEmpty())
        val first = dtoList.first()
        assertNotNull("name should be not null", first.name)
        assertNotNull("address should be not null", first.address)

        println("read and parsed correctly: ${dtoList.size} elements.")
    }
}
