plugins {
    id("xyz.jpenilla.run-velocity") version "3.0.2"
}

dependencies {
    compileOnly(project(":plugman-core"))
    compileOnly("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
}

tasks {
    runVelocity {
        velocityVersion("4.0.0-SNAPSHOT")
    }
}