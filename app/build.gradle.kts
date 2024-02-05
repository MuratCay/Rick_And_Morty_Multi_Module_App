plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.serialization)
    alias(libs.plugins.android.safeArgs)
}

android {
    namespace = "com.muratcay.rick_and_morty_multi_module_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.muratcay.rick_and_morty_multi_module_app"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"" + "https://rickandmortyapi.com/api/" + "\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"" + "https://rickandmortyapi.com/api/" + "\"")
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
        buildConfig = true
    }
}

configurations {
    create("cleanedAnnotations")
    implementation {
        exclude(group = "org.jetbrains", module = "annotations")
    }
}

dependencies {
    implementation(project(":presentation"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":database"))
    implementation(project(":remote"))
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.glide)

    implementation(libs.timber)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    implementation(libs.kotlinx.serialization)
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit.gson.converter)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}