plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.heytap.openid"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        targetSdk = 35
        versionCode = 2
        versionName = "2.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        aidl = true
        viewBinding = true
    }
    flavorDimensions += "default"
    productFlavors {
        // for oppo device
        register("oppo") {
            applicationId = "com.heytap.openid"
            manifestPlaceholders["APP_NAME"] = "OPPOID"
        }
        // for oplus device with msa sdk lower version
        register("oplus") {
            applicationId = "com.coloros.mcs"
            manifestPlaceholders["APP_NAME"] = "OPLUSID"
        }
    }
}

dependencies {
}