import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
}

kotlin {
    val xcf = XCFramework("Lib") // framework name

    macosArm64 {
        binaries {
            framework {
                baseName = "Calc" // import name
                xcf.add(this)
            }
        }
    }

    jvm()
    js().browser()
    macosX64()
    iosArm64()


    sourceSets {
        val commonMain by getting {
            dependencies {
            }
        }

        val commonTest by getting {
            dependencies {
            }
        }

        val jvmMain by getting {
            dependencies {
            }
        }

        val jvmTest by getting {
            dependencies {
            }
        }

        val jsMain by getting {
            dependencies {
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }

        val nativeDarwinMain by creating {
            dependsOn(commonMain)
        }

        val nativeDarwinTest by creating {
            dependsOn(commonTest)
        }

        val macosX64Main by getting {
            dependsOn(nativeDarwinMain)
        }

        val macosX64Test by getting {
            dependsOn(nativeDarwinTest)
        }

        val macosArm64Main by getting {
            dependsOn(nativeDarwinMain)
        }

        val macosArm64Test by getting {
            dependsOn(nativeDarwinTest)
        }

        val iosArm64Main by getting {
            dependsOn(nativeDarwinMain)
        }

        val iosArm64Test by getting {
            dependsOn(nativeDarwinTest)
        }
    }
}
