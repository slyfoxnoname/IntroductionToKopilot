plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "HM3"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.calculator"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

        buildFeatures {
            viewBinding = true
        }

        compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }

    sourceSets.getByName("main") {
        kotlin.srcDir("../src/part2/HM3")
        kotlin.include("2.3.1.kt", "2.3.2.kt")
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.1")
}
