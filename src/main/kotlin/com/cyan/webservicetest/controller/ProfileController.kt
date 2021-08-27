package com.cyan.webservicetest.controller

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfileController(
    private val env: Environment
) {
    @GetMapping("/server/profile")
    fun profile(): String {
        val profiles = env.activeProfiles.toList()
        val realProfiles = listOf("prod", "prod1", "prod2")
        val defaultProfile = if (profiles.isEmpty()) "default" else profiles[0]

        return profiles.find(realProfiles::contains) ?: defaultProfile
    }
}
