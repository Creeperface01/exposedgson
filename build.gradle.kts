import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.0-rc-146"
}

group = "com.rnett.exposedgson"
version = "1.0-SNAPSHOT"

repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    maven("https://dl.bintray.com/kotlin/exposed")
    maven("https://jitpack.io")
    jcenter()
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")

    implementation("org.jetbrains.exposed:exposed:0.10.5")
    implementation("com.google.code.gson:gson:2.8.0")

    testCompile("org.slf4j:slf4j-simple:1.7.25")
    testCompile("org.postgresql:postgresql:42.2.5")
    testCompile("commons-dbcp:commons-dbcp:1.4")
    testCompile("com.github.salomonbrys.kotson:kotson:2.5.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}