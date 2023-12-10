package com.itrail.mvckot.repository

import com.itrail.mvckot.entity.Complaint
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ComplaintRepository:JpaRepository<Complaint, Long> {

    @Query( "SELECT u from Complaint u WHERE u.functionImpairment = :name")
    fun findByName( name:String ): Optional<Complaint>
}