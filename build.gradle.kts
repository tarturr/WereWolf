plugins {
    id("java")
}

group = "fr.tartur"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
        url = uri("https://mvnrepository.com/artifact/com.zaxxer/HikariCP")
    }
}

dependencies {
    compileOnly("dev.folia:folia-api:1.20.6-R0.1-SNAPSHOT")
    implementation("com.zaxxer:HikariCP:6.0.0")
}