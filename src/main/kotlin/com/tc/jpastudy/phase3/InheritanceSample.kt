package com.tc.jpastudy.phase3

import com.tc.jpastudy.repository.base.BaseEntity
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "collateral_type")
abstract class Sofam : BaseEntity<Long>() {
    var insurerReceiptId: Long = 0
}

@Entity
@DiscriminatorValue("baegoons")
class Baegoon : Sofam() {
    var name: String = ""
}

@Entity
@DiscriminatorValue("bugss")
class Bugs : Sofam() {
    var gender: String = "MAN"
}

interface SofamRepository : JpaRepository<Sofam, Long>

@Component
class SofamRunner(
    private val sofamRepository: SofamRepository
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val baegoon = Baegoon()
        val bugs = Bugs()

        sofamRepository.save(baegoon)
        sofamRepository.save(bugs)
    }
}
