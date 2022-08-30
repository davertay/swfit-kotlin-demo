// swift-tools-version: 5.6

import PackageDescription

let package = Package(
    name: "calculator",
    dependencies: [],
    targets: [
        .executableTarget(
            name: "calculator",
            dependencies: ["Lib"]),
        .binaryTarget(
            name: "Lib",
            path: "build/XCFrameworks/debug/Lib.xcframework"),
    ]
)
