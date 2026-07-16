dependencies {
    compileOnly("com.google.guava:guava:33.3.1-jre")
    compileOnly("com.google.code.gson:gson:2.13.1")
    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
