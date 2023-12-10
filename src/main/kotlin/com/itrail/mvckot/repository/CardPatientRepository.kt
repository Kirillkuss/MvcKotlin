package com.itrail.mvckot.repository

import com.itrail.mvckot.entity.CardPatient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CardPatientRepository: JpaRepository<CardPatient, Long> {

    @Query("SELECT u FROM CardPatient u where u.patient.idPatient = :id")
    fun findByPatientId(id: Long): Optional<CardPatient>

    @Query("SELECT cp FROM CardPatient cp where cp.patient.document.numar = :parametr or cp.patient.document.snils = :parametr or cp.patient.document.polis = :parametr")
    fun findByNPS(parametr: String): Optional<CardPatient>

    @Query( value = "SELECT * FROM Card_patient cp left join Card_patient_Complaint cpc on cpc.card_patient_id = cp.id_card_patient left join Type_complaint tc on tc.id_type_complaint = cpc.type_complaint_id WHERE cp.id_card_patient = ?1 and tc.id_type_complaint = ?2",
        nativeQuery = true
    )
    fun findByIdCardAndIdComplaint(idCard: Long, idTypeComplaint: Long): Optional<CardPatient>
}