# This wild WTH is going on

Build project as per normal e.g. `./gradlew assemble`. The CocoaPods plugin will do a bunch of
CocoaPod things including making Xcode projects and compiling the Swift sources.

After building, you can open the ephemeral project in Xcode to edit the Swift sources:
```
open logs/build/cocoapods/synthetic/OSX/*/*.xcworkspace
```

The sources can be found under _Pods -> Development Pods -> MyLogger_ in the navigator pane.
When adding files, be sure to place them in the `cocoapods/MyLogger/Sources/MyLogger` folder.
By default Xcode will plonk them in a completely wrong place so watch out for that.

You can save the files from within Xcode and then re-build to test out the code. Note that
sometimes gradle may cache the compiled pod interface if you change the public API and do not
bump the version number. If this happens you can still force it by doing a `./gradlew clean`,
re-sync the gradle files, and build the project again.

Most of the time the code/save/build/test cycle will "just work", and you can bounce between
the Xcode and IntelliJ IDEs, hacking away without any issue.

# Swift Package

This CocoaPod is also configured as a legit Swift Package (and is the reason for the
torturous folder structure). The package can be built as per normal e.g.
```
swift build
```

_Note: building the Swift Package is orthogonal to building the pod within Gradle._
