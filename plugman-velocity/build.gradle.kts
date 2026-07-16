plugins {
    id("com.gradleup.shadow")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(26))
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(25)
}

dependencies {
    implementation(project(":plugman-core"))
    compileOnly("com.velocitypowered:velocity-api:4.0.0-SNAPSHOT")
    annotationProcessor("com.velocitypowered:velocity-api:4.0.0-SNAPSHOT")
    compileOnly(files("temp/velocity-4.0.0-6.jar"))
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.5")
    implementation("com.fasterxml.jackson.core:jackson-core:2.13.5")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.13.5")
    implementation("org.yaml:snakeyaml:2.0")
    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.shadowJar {
    archiveFileName.set("PlugManX-${project.version}.jar")
    relocate("com.fasterxml.jackson", "core.com.rylinaux.plugman.libs.jackson")
    relocate("org.yaml.snakeyaml", "core.com.rylinaux.plugman.libs.snakeyaml")
    exclude("META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA")
}

tasks.build {
    dependsOn(tasks.shadowJar)
}
