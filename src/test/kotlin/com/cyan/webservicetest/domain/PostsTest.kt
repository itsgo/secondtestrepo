package com.cyan.webservicetest.domain

import com.cyan.webservicetest.repository.PostsRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@DataJpaTest
internal class PostsTest() {

    @Autowired
    private lateinit var postsRepository: PostsRepository

    @AfterEach
    fun cleanup() {
        postsRepository.deleteAll()
    }

    @Test
    fun `게시물 작성 등록 테스트`() {
        // given
        val posts = Posts(
            title = "게시물 테스트",
            author = "윤하",
            content = "블라블라블라"
        )
        postsRepository.save(posts)

        // when
        val savedPost = postsRepository.findAll()

        // then
        assertEquals(savedPost[0].title, "게시물 테스트")
        assertEquals(savedPost[0].author, "윤하")
    }

    @Test
    fun `게시물 작성 날짜 확인`() {
        // given
        val now = LocalDateTime.now()
        val posts = Posts(
            title = "게시물 테스트",
            author = "윤하",
            content = "블라블라블라"
        )
        postsRepository.save(posts)

        // when
        val savedPost = postsRepository.findAll()

        // then
        assertTrue { savedPost[0].createdDate.isAfter(now) }
        assertTrue { savedPost[0].updatedDate.isAfter(now) }
    }
}
