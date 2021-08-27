package com.cyan.webservicetest.domain.base

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
class BaseEntity() {
    @CreatedDate
    @Column(updatable = false)
    lateinit var createdDate: LocalDateTime
        protected set

    @LastModifiedDate
    lateinit var updatedDate: LocalDateTime
        protected set
}
