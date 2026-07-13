rootProject.name = "PlugManX"
include(":plugman-bungee")
include(":plugman-assembly")
include(":plugman-paper")
include(":plugman-core")
include(":plugman-bukkit")
include(":plugman-velocity")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven{
            name = "Bytecode"
            url = uri("https://repo.bytecode.space/repository/maven-public/")
        }
    }
}