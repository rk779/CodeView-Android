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
