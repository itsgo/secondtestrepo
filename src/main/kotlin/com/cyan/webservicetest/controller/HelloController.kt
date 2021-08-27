package com.cyan.webservicetest.controller

import com.cyan.webservicetest.dto.PostsSaveRequestDto
import com.cyan.webservicetest.repository.PostsRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val postsRepository: PostsRepository
) {
    @RequestMapping("/")
    fun hello() = "Hello"

    @PostMapping("/posts")
    fun savePosts(@RequestBody dto: PostsSaveRequestDto): String {
        postsRepository.save(dto.toEntity())
        return "ok"
    }
}
