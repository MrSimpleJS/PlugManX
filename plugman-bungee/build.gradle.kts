dependencies {
    api(project(":plugman-core"))
    compileOnly("net.md-5:bungeecord-api:1.21-R0.3")
}

tasks.processResources {
    filesMatching("**/*.yml") {
        expand(
            "plugman" to mapOf("version" to project.version.toString()),
            "jackson" to mapOf("version" to "2.13.5"),
        )
    }
}
