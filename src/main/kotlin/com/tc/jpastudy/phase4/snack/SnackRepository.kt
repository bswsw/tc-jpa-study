package com.tc.jpastudy.phase4.snack

import org.springframework.data.jpa.repository.JpaRepository

interface SnackRepository : JpaRepository<Snack, Long>