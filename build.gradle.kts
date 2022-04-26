import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    // Extra Properties
    val androidCompileSdkVersion by extra(32)
    val androidMinSdkVersion by extra(15)
    val kotlinVersion by extra("1.6.21")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }
}

allprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            // Treat all warnings as errors
            allWarningsAsErrors = true

            // Require OptIn
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-opt-in=kotlin.Experimental",
                "-opt-in=kotlin.RequiresOptIn"
            )

            // Set JVM target to 11
            jvmTarget = JavaVersion.VERSION_11.toString()

            // Set kotlin language version
            languageVersion = "1.6"
        }
    }
}
