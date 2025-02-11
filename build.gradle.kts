plugins {
    id("com.android.application") version "8.7.3" apply false
}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.google.gms:google-services:4.4.2") // ✅ Add this line
    }
}

subprojects {
    configurations.all {
        resolutionStrategy {
            force ("org.jetbrains.kotlin:kotlin-stdlib:1.8.22")
            force ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.22")
        }
    }
}