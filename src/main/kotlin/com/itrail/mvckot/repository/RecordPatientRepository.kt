package com.itrail.mvckot.repository

import com.itrail.mvckot.entity.RecordPatient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface RecordPatientRepository: JpaRepository<RecordPatient, Long> {

    @Query("SELECT rp FROM RecordPatient rp WHERE rp.cardPatientId = :id AND ( (rp.dateRecord >=:fromDate) AND ( rp.dateRecord <=:toDate))")
    fun findByParamTwo( id: Long, fromDate: LocalDateTime, toDate: LocalDateTime ):List<RecordPatient>

    @Query( value = "SELECT r.* FROM Record_patient r left join Card_patient c on c.id_card_patient = card_patient_id left join Patient p on p.id_patient = c.pacient_id where p.id_patient = ?1 and (r.date_record BETWEEN ?2 and ?3 )", nativeQuery = true  )
    fun findByParam( idCardPatient: Long, fromLDT: LocalDateTime, toLDT: LocalDateTime )
 }