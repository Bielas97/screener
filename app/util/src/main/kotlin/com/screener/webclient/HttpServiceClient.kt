package com.screener.webclient

import org.springframework.web.reactive.function.client.WebClient

abstract class HttpServiceClient(baseUrl: String, builder: WebClient.Builder) {
    protected val client = builder.baseUrl(baseUrl).build()
}
