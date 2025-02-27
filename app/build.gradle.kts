plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.thesocialnetwork"
    compileSdk = 35

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.example.thesocialnetwork"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        buildFeatures {
            buildConfig = true
        }
        debug {
            isDebuggable = true
        }
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

}

dependencies {

    // View Model
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.extensions)
    implementation (libs.androidx.activity)
    implementation (libs.androidx.lifecycle.viewmodel.ktx.v220)
    // Glide, Ksp
    implementation (libs.glide)
    implementation (libs.ksp)

    // Retrofit Implementation

    //implementation(libs.retrofit.v2110)
    //implementation("com.squareup.retrofit2:converter-gson")
    //implementation (libs.retrofit.v240)
    //implementation (libs.gson)
    implementation ("com.squareup.retrofit2:retrofit:(2.11.0)")
    implementation(libs.retrofit2.converter.gson)
    //implementation (libs.retrofit)
    //implementation (libs.converter.gson)

    implementation(libs.squareup.okhttp)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}