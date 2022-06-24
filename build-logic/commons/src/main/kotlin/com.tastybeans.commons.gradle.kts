plugins {
    id("java")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(platform("com.tastybeans.platform:product-platform"))
    testImplementation(platform("com.tastybeans.platform:test-platform"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}