plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}

kotlin {
    jvm()
    js().browser()
    macosX64()
    macosArm64()
    iosArm64()

    cocoapods {
        ios.deploymentTarget = "14.0"
        osx.deploymentTarget = "11.0"

        summary = "Logs"
        homepage = "https://github.com/davertay/swfit-kotlin-demo"

        version = if (project.version == Project.DEFAULT_VERSION) {
            "0.0.1-dev"
        } else {
            "${project.version}"
        }

        pod("MyLogger") {
            version = "0.0.1"
            source = path(project.file("../cocoapods/MyLogger"))
        }
    }

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
