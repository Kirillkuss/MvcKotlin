package com.itrail.mvckot.repository

import com.itrail.mvckot.entity.Treatment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface TreatmentRepository: JpaRepository<Treatment, Long> {

    @Query("SELECT t FROM Treatment  t WHERE t.cardPatientId =:id AND ((t.timeStartTreatment >=:from) AND (t.timeStartTreatment <=:to))")
    fun findParamByIdCardAndDateStart( id: Long, from: LocalDateTime, to:LocalDateTime ): List<Treatment>

    @Query("SELECT t FROM Treatment t WHERE t.cardPatientId =:idCard AND t.rehabilitationSolution.idRehabilitationSolution = :idReSol")
    fun findByParamIdCardAndIdRh( idCard: Long, idReSol: Long ): List<Treatment>
}