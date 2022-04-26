plugins {
    id("com.android.application")
    kotlin("android")
}

val androidCompileSdkVersion: Int by rootProject
val androidMinSdkVersion: Int by rootProject
val kotlinVersion: String by rootProject

android {
    compileSdk = androidCompileSdkVersion

    defaultConfig {
        applicationId = "io.github.kbiakov.codeviewexample"
        minSdk = androidMinSdkVersion
        targetSdk = androidCompileSdkVersion
        versionCode = 1
        versionName = "1.0"
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
    implementation(project(":codeview"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
}
