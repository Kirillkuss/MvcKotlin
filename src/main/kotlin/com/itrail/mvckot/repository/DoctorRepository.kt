package com.itrail.mvckot.repository

import com.itrail.mvckot.entity.Doctor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DoctorRepository:JpaRepository<Doctor, Long> {

    @Query( "SELECT u FROM Doctor u WHERE u.surname = :word or u.name = :word or u.fullName = :word ")
    fun findByFIO( word: String ):List<Doctor>
}