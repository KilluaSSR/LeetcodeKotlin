import org.jetbrains.kotlin.gradle.idea.proto.com.google.protobuf.GeneratedCodeInfoKt.annotation

plugins {
    kotlin("jvm") version "1.9.22"
    id("org.jetbrains.kotlinx.benchmark") version "0.4.10"
    kotlin("plugin.allopen") version "1.9.20"
}
allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}
benchmark {
    targets {
        register("main")
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.10")

}

kotlin {
    jvmToolchain(19)
}