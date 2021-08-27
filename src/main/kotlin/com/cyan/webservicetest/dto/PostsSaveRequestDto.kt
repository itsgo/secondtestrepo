package com.cyan.webservicetest.dto

import com.cyan.webservicetest.domain.Posts

data class PostsSaveRequestDto(
    val title: String,
    val author: String,
    val content: String?
) {
    fun toEntity(): Posts {
        return Posts(
            title = title,
            author = author,
            content = content
        )
    }
}
