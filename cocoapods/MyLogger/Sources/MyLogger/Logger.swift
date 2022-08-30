import Foundation
import os

public class MyLogger: NSObject {

    private let logger: Logger // struct

    override public init() {
        logger = Logger(subsystem: "com.example", category: "test")
        super.init()
    }

    @objc public func logInfo(msg: String) {
        logger.info("\(msg, privacy: .public)")
    }
    
}
