plugins {
    id("com.android.library")
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.alangeronimo.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 29
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    sourceSets["main"].assets.srcDirs("src/main/assets")
}

dependencies {
    implementation(project(":domain"))
    //retrofit
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)
    //koin
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)
    //test
    testImplementation(kotlin("test"))
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockito.core)
    implementation(libs.kotlinx.coroutines.core)
}
