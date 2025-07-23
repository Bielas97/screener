package com.screener

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greeting")
internal class GreetingController(
    private val greetingService: GreetingService,
    private val mediaService: MediaService,
) {
    @GetMapping("/{name}")
    suspend fun greet(@PathVariable("name") name: String): String {
        mediaService.displayMedia()

        return greetingService.greet(name)
    }
}
