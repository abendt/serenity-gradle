plugins {
    kotlin("jvm") version "2.3.0"
    id("net.serenity-bdd.serenity-gradle-plugin") version "5.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("net.serenity-bdd:serenity-junit5:5.1.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}