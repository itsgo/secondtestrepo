package com.cyan.webservicetest.repository

import com.cyan.webservicetest.domain.Posts
import org.springframework.data.jpa.repository.JpaRepository

interface PostsRepository : JpaRepository<Posts, Long>
