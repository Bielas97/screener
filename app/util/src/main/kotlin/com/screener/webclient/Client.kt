package com.screener.webclient

import kotlinx.coroutines.reactor.awaitSingleOrNull
import mu.KotlinLogging
import org.springframework.http.HttpRequest
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.awaitExchange

val logger = KotlinLogging.logger {}

suspend inline fun <reified Response : Any> WebClient.RequestHeadersSpec<*>.awaitResult(): Response =
    awaitExchange { response ->
        val request: HttpRequest = response.request()
        response.handleResponse {
            it.awaitBody<Response>().also {
                logger.debug {
                    "Client request, [${request.method}]: [${request.uri}" +
                        "succeeded with result: [${response.statusCode()}] [$it]"
                }
            }
        }
    }

suspend inline fun WebClient.RequestHeadersSpec<*>.awaitResultNoBody(): Unit = awaitExchange { response ->
    val request: HttpRequest = response.request()
    response.handleResponse {
        logger.debug {
            "Client request, [${request.method}]: [${request.uri}" + "succeeded with result: [${response.statusCode()}]"
        }
    }
}

suspend inline fun <T> ClientResponse.handleResponse(onSuccess: (ClientResponse) -> T): T =
    if (this.statusCode().is2xxSuccessful) {
        onSuccess(this)
    } else if (this.statusCode() == HttpStatus.NOT_FOUND) {
        val request: HttpRequest = this.request()
        logger.error {
            "Not found error. Client request, ${request.method}: ${request.uri}" +
                " failed with status=[${this.statusCode().value()}]"
        }
        throw NotFoundError("No resource found error")
    } else if (this.statusCode().is4xxClientError) {
        val request: HttpRequest = this.request()
        val body = this.bodyToMono((String::class.java)).awaitSingleOrNull() ?: ""
        logger.error {
            "Client error. Client request, ${request.method}: ${request.uri}" +
                " failed with status=[${this.statusCode().value()}]], body=[$body]"
        }
        throw ClientError("Error response from the client")
    } else {
        val request: HttpRequest = this.request()
        logger.error {
            "Server error. Client request, ${request.method}: ${request.uri}" +
                " failed with status=[${this.statusCode().value()}]"
        }
        throw UnexpectedServerError("Error response from the client")
    }
