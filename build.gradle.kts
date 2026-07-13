plugins {
    id("java")
}

description = "Plugin manager for Bukkit servers."

allprojects {
    apply(plugin = "java")
    apply(plugin = "buildlogic.java-conventions")


    tasks {
        processResources {
            expand("version" to project.version)
        }
    }

}
