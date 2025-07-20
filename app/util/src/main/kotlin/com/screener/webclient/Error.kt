package com.screener.webclient

data class UnexpectedServerError(override val message: String) : RuntimeException(message)

open class ClientError(override val message: String) : RuntimeException(message)

data class NotFoundError(override val message: String) : ClientError(message)
