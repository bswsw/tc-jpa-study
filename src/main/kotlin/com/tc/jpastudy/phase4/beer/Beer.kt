package com.tc.jpastudy.phase4.beer

import com.tc.jpastudy.phase4.BaseEntity
import javax.persistence.Entity
import javax.persistence.PostLoad
import javax.persistence.PostPersist
import javax.persistence.PostRemove
import javax.persistence.PostUpdate
import javax.persistence.PrePersist
import javax.persistence.PreRemove
import javax.persistence.PreUpdate

@Entity
class Beer : BaseEntity() {

    var name: String = ""
    var maker: String = ""

    @PrePersist
    fun onPrePersist() {
        println("onPrePersist : $this")
        println("========================")
    }

    @PostPersist
    fun onPostPersist() {
        println("onPostPersist : $this")
        println("========================")
    }

    @PreUpdate
    fun onPreUpdate() {
        println("onPreUpdate : $this")
        println("========================")
    }

    @PostUpdate
    fun onPostUpdate() {
        println("onPostUpdate : $this")
        println("========================")
    }

    @PreRemove
    fun onPreRemove() {
        println("onPreRemove : $this")
        println("========================")
    }

    @PostRemove
    fun onPostRemove() {
        println("onPostRemove : $this")
        println("========================")
    }

    @PostLoad
    fun onPostLoad() {
        println("onPostLoad : $this")
        println("========================")
    }

    override fun toString(): String {
        return "Beer(id=$id, name='$name', maker='$maker')"
    }
}
