plugins {
    id("xyz.jpenilla.run-paper")
}

dependencies {
    api(project(":plugman-bukkit"))
    compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")
    implementation("com.tcoded:FoliaLib:0.5.1")
    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.processResources {
    filesMatching("**/*.yml") {
        expand("plugman" to mapOf("version" to project.version.toString()))
    }
}

tasks.runServer {
    minecraftVersion("1.21.8")
    pluginJars.from(project(":plugman-assembly").tasks.named("shadowJar"))
}
