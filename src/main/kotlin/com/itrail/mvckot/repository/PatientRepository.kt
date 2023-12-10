package com.itrail.mvckot.repository

import com.itrail.mvckot.entity.Patient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PatientRepository: JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE (p.name = :word) or ( p.surname = :word) or (p.fullname = :word)")
    fun findByWordPatient( word: String ): List<Patient>

    @Query( "SELECT p FROM Patient p WHERE p.document.idDocument = :idDocument" )
    fun findPatientByIdDocument( idDocument: Long): Optional<Patient>

    @Query("SELECT p FROM Patient p WHERE p.phone = :phone")
    fun findByPhone( phone: String ): Optional<Patient>

}