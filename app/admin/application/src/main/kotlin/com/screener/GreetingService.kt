package com.screener

import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class GreetingService {
    suspend fun greet(name: String = "World"): String = runBlocking {
        logger.info { "This is log fromGreetingService" }
        Greeting.greet(name)
    }
}
