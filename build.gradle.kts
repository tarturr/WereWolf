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
    }

    maven {
        url = uri("https://mvnrepository.com/artifact/com.zaxxer/HikariCP")
    }
}

dependencies {
    compileOnly("dev.folia:folia-api:1.20.6-R0.1-SNAPSHOT")

    implementation("com.zaxxer:HikariCP:6.0.0")

    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")

    testCompileOnly("org.projectlombok:lombok:1.18.34")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.34")
}