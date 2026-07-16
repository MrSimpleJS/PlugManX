plugins {
    id("com.gradleup.shadow")
}

dependencies {
    implementation(project(":plugman-core"))
    implementation(project(":plugman-bukkit"))
    implementation(project(":plugman-paper"))
    implementation(project(":plugman-bungee"))
    implementation("com.tcoded:FoliaLib:0.5.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.5")
    implementation("com.fasterxml.jackson.core:jackson-core:2.13.5")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.13.5")
    implementation("org.yaml:snakeyaml:2.0")
}

tasks.shadowJar {
    archiveFileName.set("PlugManX.jar")
    relocate("com.tcoded", "com.rylinaux.folia")
    relocate("com.fasterxml.jackson", "core.com.rylinaux.plugman.libs.jackson")
    relocate("org.yaml.snakeyaml", "core.com.rylinaux.plugman.libs.snakeyaml")
    exclude("META-INF/**")
}

tasks.jar {
    enabled = false
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

val copyReleaseJar by tasks.registering(Copy::class) {
    dependsOn(tasks.shadowJar)
    from(tasks.shadowJar.flatMap { it.archiveFile })
    into(rootProject.layout.buildDirectory.dir("libs"))
}

tasks.build {
    finalizedBy(copyReleaseJar)
}
