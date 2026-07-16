# Gradle preparation

This directory is a separate Gradle preparation of PlugManX. The Maven POMs
are intentionally retained as a migration reference.

## Build

Use JDK 22 to run Gradle. The standard Bukkit/Paper/Bungee assembly still
targets Java 21:

```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-22"
.\gradlew.bat build
```

The assembled server plugin is written to
`build/libs/PlugManX-<version>.jar`, for example `PlugManX-3.1.0.jar`.

## Local Paper server

```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-22"
.\gradlew.bat :plugman-paper:runServer
```

The run task uses Paper 1.21.8 and loads the assembly JAR automatically.

## Velocity status

Velocity remains included as a module and is compiled/tested by `build`.
The current Velocity 4 snapshot requires a Java 25 compatible target, so this
module uses the locally installed JDK 26 compiler with `--release 25`.

The normal build also creates the standalone Velocity JAR at
`plugman-velocity/build/libs/PlugManX-3.1.0.jar`. Shadow 8.3.10 is used because
its bytecode tooling supports the Java 25/26 classes required by the current
Velocity snapshot.
