enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }
}

include(
    ":calculator",
    ":logs",
    ":samples",
)
