plugins {
    id("com.android.library")
    kotlin("android")
}

val androidCompileSdkVersion: Int by rootProject
val androidMinSdkVersion: Int by rootProject
val kotlinVersion: String by rootProject

android {
    compileSdk = androidCompileSdkVersion

    defaultConfig {
        minSdk = androidMinSdkVersion
        targetSdk = androidCompileSdkVersion
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }

    lint {
        abortOnError = false
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
}
