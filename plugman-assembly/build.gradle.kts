plugins {
    id("buildlogic.java-conventions")
}

dependencies {
    api(project(":plugman-core"))
    api(project(":plugman-bukkit"))
    api(project(":plugman-paper"))
    api(project(":plugman-bungee"))
    api(libs.com.fasterxml.jackson.core.jackson.core)
    api(libs.com.fasterxml.jackson.core.jackson.annotations)
}

description = "PlugManX Assembly"

java {
    withJavadocJar()
}
