plugins {
    id("com.android.library")
    kotlin("android")
    id("maven-publish")
}

val androidCompileSdkVersion: Int by rootProject
val androidMinSdkVersion: Int by rootProject
val kotlinVersion: String by rootProject

android {
    namespace = "io.github.kbiakov.codeview"
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    lint {
        abortOnError = false
    }

    publishing {
        singleVariant("release")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.kbiakov"
                artifactId = "CodeView-Android"
                version = "1.3.2"
            }
        }
    }
}
