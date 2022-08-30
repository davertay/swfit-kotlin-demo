package com.example.logs

import cocoapods.MyLogger.MyLogger

private val logger = MyLogger()

public actual fun logInfo(msg: String) = logger.logInfoWithMsg(msg)
