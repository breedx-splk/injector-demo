plugins {
    war
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.1.0")
    implementation("com.google.code.gson:gson:2.13.2")
}