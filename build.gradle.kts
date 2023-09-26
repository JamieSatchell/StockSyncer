plugins {
	java
	id("org.springframework.boot") version "3.1.3"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.9.10"

	//for implementing lombok
	kotlin("kapt") version "1.9.10"


	id("io.freefair.lombok") version "8.3"

	kotlin("plugin.lombok") version "1.8.10"




}

kapt {
	keepJavacAnnotationProcessors = true
}

group = "com.JamieSatchell"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}



repositories {
	mavenCentral()
}

dependencies {





	//Added as JPA's Javax.persistence doesn't seam to work.
	implementation("jakarta.persistence:jakarta.persistence-api")

	// Adds JPA that includes ORM tools such as hybernate.
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")


	// JUnit Jupiter (JUnit 5) API and TestEngine Implementation
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
	testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

	// Spring Boot Test Starter (might already be included in your Spring Boot project)
	testImplementation("org.springframework.boot:spring-boot-starter-test")


	// Spring Boot Web Starter

	implementation("org.springframework.boot:spring-boot-starter-web")

	// Spring Boot Data JPA Starter
	// implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// Spring Boot Test Starter
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// H2 Database Driver
	runtimeOnly("com.h2database:h2")

	// Uncomment if you're using MySQL:
	//implementation("mysql:mysql-connector-java:6.0.6")

	// Spring Boot Actuator
	implementation("org.springframework.boot:spring-boot-starter-actuator")

	// Lombok
	compileOnly("org.projectlombok:lombok")


	// Google Guice (Optional if you're using it)
	implementation("com.google.inject:guice:5.0.1")
	implementation(kotlin("stdlib-jdk8"))

	implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.10")

	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

	//compileOnly("org.projectlombok:lombok:1.18.10")




}

tasks.withType<Test> {
	useJUnitPlatform()
}
kotlin {
	jvmToolchain(17)
}

