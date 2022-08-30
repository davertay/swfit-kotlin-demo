// swift-tools-version:5.3

import PackageDescription

let package = Package(
    name: "MyLogger",
    platforms: [
        .macOS(.v11), .iOS(.v14),
    ],
    products: [
        .library(name: "MyLogger", targets: ["MyLogger"]),
    ],
    targets: [
        .target(name: "MyLogger", dependencies: []),
    ],
    swiftLanguageVersions: [.v5]
)
