plugins {
    id("xyz.jpenilla.run-waterfall") version "3.0.2"
}

dependencies {
    api(project(":plugman-core"))
    compileOnly(libs.net.md.v5.bungeecord.api)
}

description = "PlugMan-BungeeCord"
