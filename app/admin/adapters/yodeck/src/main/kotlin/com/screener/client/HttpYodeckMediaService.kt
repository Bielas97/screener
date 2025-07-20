package com.screener.client

import com.screener.MediaService
import com.screener.config.YodeckProperties
import com.screener.webclient.HttpServiceClient
import com.screener.webclient.awaitResult
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

private val logger = KotlinLogging.logger {}

@Service
class HttpYodeckMediaService(clientBuilder: WebClient.Builder, yodeckProperties: YodeckProperties) :
    HttpServiceClient(yodeckProperties.baseUrl, clientBuilder), MediaService {
    override suspend fun displayMedia() {
        val result = client.get().awaitResult<Any>()
        logger.info { "Media displayed successfully: $result" }
    }
}

@Service
internal class CustomService() {
    fun hello(): String = "asdasdasd";
}
