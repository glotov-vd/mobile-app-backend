plugins {
	java
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "edu.drive_rent"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.liquibase:liquibase-core:4.23.1")
	implementation("org.liquibase.ext:liquibase-postgresql:4.23.1")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("io.jsonwebtoken:jjwt-api:0.11.2")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.2")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.2")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
