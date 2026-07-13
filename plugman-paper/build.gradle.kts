plugins {
    id("xyz.jpenilla.run-paper") version "3.0.2"
}

dependencies {
    api(project(":plugman-bukkit"))
    api(libs.com.tcoded.folialib)
    testImplementation(libs.org.junit.jupiter.junit.jupiter)
    compileOnly(libs.io.papermc.paper.paper.api)
}

description = "PlugMan-Paper"

tasks {
    runServer {
        minecraftVersion("26.2")
    }
}