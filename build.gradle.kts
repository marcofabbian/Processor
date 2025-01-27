plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.marcofabbian"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("commons-io:commons-io:2.7")

	//Xml
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	//Logback
	implementation("ch.qos.logback:logback-core:1.5.12")
	implementation("ch.qos.logback:logback-classic:1.5.12")
	implementation("ch.qos.logback:logback-access:1.5.12")

	//Mongo DB
	implementation("org.springframework.data:spring-data-mongodb:4.4.1")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	//Json
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.7.3")
	//implementation("com.google.code.gson:gson:2.11.0")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
