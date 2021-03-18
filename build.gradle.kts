
plugins {
    kotlin("jvm") version "1.4.31"
    id("application")
}

val gradleScripts = properties["gradleScripts"]
val hexagonVersion = properties["hexagonVersion"]

apply(from = "$gradleScripts/kotlin.gradle")
apply(from = "$gradleScripts/application.gradle")

extensions.configure<JavaApplication> {
    mainClass.set("org.example.GradleStarterKt")
}

dependencies {
    "implementation"("com.hexagonkt:http_server_jetty:$hexagonVersion")
    "implementation"("com.hexagonkt:logging_logback:$hexagonVersion")

    "testImplementation"("com.hexagonkt:http_client_ahc:$hexagonVersion")
}

//tasks.test {
//    jvmArgs(
//        listOf(
//            "-agentlib:native-image-agent=config-output-dir=build/resources/main/META-INF/native-image"
//        )
//    )
//}

/*
$h/Software/graalvm_21_jdk11/bin/native-image \
  --initialize-at-run-time=com.hexagonkt \
  --initialize-at-run-time=org.example \
  --initialize-at-run-time=kotlin.jvm.internal \
  --initialize-at-run-time=kotlin.text.Regex \
  --enable-https \
  -jar build/libs/gradle_starter-all-0.1.0.jar
 */
