//https://kotlindays.com/2019/12/06/multi-module-spring-boot-in-kotlin-dsl/index.html
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") version "1.3.72" apply false
    kotlin("plugin.spring") version "1.3.72"
    id("org.springframework.boot") version "2.3.1.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

allprojects {
    group = "com.glebus.pingus"
    version = "1.0.0"

    repositories {
        mavenCentral()
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}

subprojects {
    apply {
        plugin("io.spring.dependency-management")
    }

    dependencyManagement {
        dependencies {
            val junit5 = "1.6.2" to "5.6.2"
            dependency("org.junit.platform:junit-platform-launcher:${junit5.first}")
            dependency("org.junit.jupiter:junit-jupiter-engine:${junit5.second}")
            dependency("org.junit.vintage:junit-vintage-engine:${junit5.second}")
        }
    }
}
