plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    js {
        browser()
        binaries.executable()
    }
    macosX64 {
        binaries {
            executable {
                baseName = "logs"
                entryPoint = "main"
            }
            getExecutable("DEBUG").addCocoaPodsRunPath()
            getExecutable("RELEASE").addCocoaPodsRunPath()
        }
    }
    macosArm64 {
        binaries {
            executable {
                baseName = "logs"
                entryPoint = "main"
            }
            getExecutable("DEBUG").addCocoaPodsRunPath()
            getExecutable("RELEASE").addCocoaPodsRunPath()
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":logs"))
            }
        }

        val nativeDarwinMain by creating {
            dependsOn(commonMain)
        }

        val macosX64Main by getting {
            dependsOn(nativeDarwinMain)
        }

        val macosArm64Main by getting {
            dependsOn(nativeDarwinMain)
        }
    }
}

// Workaround from https://youtrack.jetbrains.com/issue/KT-44857/Link-CocoaPods-frameworks-with-iosTest-binary
fun org.jetbrains.kotlin.gradle.plugin.mpp.Executable.addCocoaPodsRunPath() = this.apply {
    val frameworkPath = "${rootDir.absolutePath}/logs/build/cocoapods/synthetic/OSX/build/Release/MyLogger"
    linkerOpts("-F$frameworkPath")
    linkerOpts("-rpath", frameworkPath)
    linkerOpts("-framework", "MyLogger")
}
