dependencies {
    api(project(":plugman-core"))
    compileOnly("org.spigotmc:spigot-api:1.21.7-R0.1-SNAPSHOT")
    implementation("com.tcoded:FoliaLib:0.5.1")
    implementation("org.jetbrains:annotations:26.0.2")
}

tasks.processResources {
    filesMatching("**/*.yml") {
        expand("plugman" to mapOf("version" to project.version.toString()))
    }
}
