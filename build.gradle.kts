plugins {
    java
    id("com.gradleup.shadow") version "8.3.10" apply false
    id("xyz.jpenilla.run-paper") version "2.3.1" apply false
}

allprojects {
    group = rootProject.group
    version = rootProject.version

    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://repo.nexomc.com/releases/")
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
}

subprojects {
    apply(plugin = "java-library")

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(22))
        withSourcesJar()
    }

    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        options.release.set(21)
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }

    dependencies {
        "compileOnly"("org.projectlombok:lombok:1.18.38")
        "annotationProcessor"("org.projectlombok:lombok:1.18.38")
        "compileOnly"("systems.manifold:manifold-rt:2025.1.31")
        "compileOnly"("com.fasterxml.jackson.core:jackson-databind:2.13.5")
        "compileOnly"("org.yaml:snakeyaml:2.0")
    }
}
