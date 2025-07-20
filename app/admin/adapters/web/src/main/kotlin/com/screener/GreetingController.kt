package com.screener

import com.screener.client.HttpYodeckMediaService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/greeting")
internal class GreetingController(
    private val greetingService: GreetingService,
    private val mediaService: MediaService,
    private val a: HttpYodeckMediaService,
    private val b: CustomService
) {
    @GetMapping("/{name}")
    suspend fun greet(@PathVariable("name") name: String): String {
        mediaService.displayMedia()

        return greetingService.greet(name)
    }
}
