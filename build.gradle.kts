plugins {
    kotlin("jvm") version "1.3.72"
}

group = "com.glebus.pingus"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}



allprojects {
    tasks.register("hello") {
        doLast {
            println("I'm ${this.project.name}")
        }

    }
}

subprojects {
    tasks.named("hello") {
        doLast {
            println("- I depend on water")
        }
    }
}
