package com.tc.jpastudy.phase3

import com.tc.jpastudy.repository.base.BaseEntity
import org.hibernate.annotations.Type
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import javax.persistence.CollectionTable
import javax.persistence.ElementCollection
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Table

/**
 * table1
 *
 * id: pk
 * name: varchar
 */

/**
 * table2
 *
 * table1_id: fk
 * name: varchar
 * age: int
 */

@Entity
class Box : BaseEntity<Long>() {
    var name: String = ""

    @ElementCollection
    val things: MutableList<Anything> = mutableListOf()

    @Type(type = "yes_no")
    var isOk: Boolean = false
}

@Embeddable
data class Anything(
    val name: String,
    val size: Int
)

interface BoxRepo : JpaRepository<Box, Long> {
    fun findAllByCreatedAt(createdAt: LocalDateTime): List<Box>
    @Query("SELECT a FROM Box a WHERE a.name = 'aaa'")
    fun findBaegoon(): List<Box>

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("DELETE FROM Box b WHERE b.name = :name")
    fun deleteBaegoon(name: String): Int
}

@Component
@Transactional
class Runner3(
    private val boxRepo: BoxRepo
) : ApplicationRunner {

    @PersistenceContext
    lateinit var em: EntityManager

    override fun run(args: ApplicationArguments?) {
        println("==========================================")

        val box = Box().apply { name = "배군" }

        em.persist(box)

        println("em.contains(box) : ${em.contains(box)}")

        // delete from box where id = 1
        boxRepo.deleteBaegoon("배군")

        println("em.contains(box) : ${em.contains(box)}")
    }
}
