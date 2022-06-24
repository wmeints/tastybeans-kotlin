plugins {
    id("java-platform")
}

group = "com.tastybeans.platform"

javaPlatform.allowDependencies()

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:2.7.1"))
}
