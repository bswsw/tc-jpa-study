package com.tc.jpastudy.phase4.beer

import org.springframework.data.jpa.repository.JpaRepository

interface BeerRepository : JpaRepository<Beer, Long>