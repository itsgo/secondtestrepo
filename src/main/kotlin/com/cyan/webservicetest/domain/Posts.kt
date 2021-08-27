package com.cyan.webservicetest.domain

import com.cyan.webservicetest.domain.base.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Posts(
    @Column(length = 500, nullable = false)
    var title: String,

    val author: String,

    var content: String?

) : BaseEntity() {
    @Id
    @GeneratedValue
    @Column(name = "posts_id")
    val id: Long = 0
}
