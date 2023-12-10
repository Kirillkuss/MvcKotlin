package com.itrail.mvckot.repository

import com.itrail.mvckot.entity.RehabilitationSolution
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RehabilitationSolutionRepository: JpaRepository<RehabilitationSolution, Long> {

    @Query("SELECT rs FROM RehabilitationSolution rs WHERE rs.name = :name")
    fun findByName( name: String ):Optional<RehabilitationSolution>
}