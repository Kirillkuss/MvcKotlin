package com.itrail.mvckot.repository

import com.itrail.mvckot.entity.TypeComplaint
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TypeComplaintRepository: JpaRepository<TypeComplaint, Long> {

    @Query("SELECT tp FROM TypeComplaint tp WHERE tp.name = :name")
    fun findByName( name:String ): Optional<TypeComplaint>

    @Query("SELECT tp FROM TypeComplaint tp WHERE tp.complaint.idComplaint = :id")
    fun findByIdComplaint( id: Long ): List<TypeComplaint>
}