plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "ar.edu.unicen.seminario"
    compileSdk = 34

    defaultConfig {
        applicationId = "ar.edu.unicen.seminario"//id unico de cada app
        minSdk = 26
        targetSdk = 34
        versionCode = 1//version de la app debe incrementar
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    //permite que el enlace entre los elementos de la pantalla sea mas sencillo(inflate)haciendo referencias
    //por medio de una clase que crea para cada layout.
    buildFeatures{
        viewBinding = true
    }
}

dependencies {//dependencias a incluir

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.activityktx)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.retrofit)//libererias de consumo de api
    implementation(libs.retrofit.gson)
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
    implementation(libs.glide)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}