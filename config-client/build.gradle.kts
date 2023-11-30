plugins {
    java
    id("com.ms.gradle.application").version("2.0.1")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2021.0.7"))
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.7.18"))

    constraints {
        implementation("org.apache.curator:curator-x-discovery:5.5.0")
        implementation("org.apache.zookeeper:zookeeper:3.9.1")
    }

    implementation("org.springframework.cloud:spring-cloud-starter-zookeeper-discovery")
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.springframework.boot:spring-boot-starter-web")
}

applications.main {
    mainClass.set("com.example.config.client.ConfigClientApplication")
}
