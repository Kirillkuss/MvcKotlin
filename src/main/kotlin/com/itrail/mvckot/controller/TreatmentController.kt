package com.itrail.mvckot.controller

import com.itrail.mvckot.entity.Treatment
import com.itrail.mvckot.rest.ITreatment
import com.itrail.mvckot.service.TreatmentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class TreatmentController( private val treatmentService: TreatmentService ):ITreatment {

    override fun addTreatment( treatment: Treatment,
                               idDrug: Long,
                               idCard: Long,
                               idRehabilitationSolution: Long,
                               idDoctor: Long ): ResponseEntity<Treatment> {
        return ResponseEntity( treatmentService.addTreatment( treatment,
                                                              idDrug,
                                                              idCard,
                                                              idRehabilitationSolution,
                                                              idDoctor), HttpStatus.OK )
    }

    override fun findByParamIdCardAndDateStart( idCard: Long,
                                                from: LocalDateTime,
                                                to: LocalDateTime ): ResponseEntity<List<Treatment>> {
        return ResponseEntity( treatmentService.findByParamIdCardAndDateStart( idCard, from, to ), HttpStatus.OK )
    }

    override fun findByParamIdCardAndIdRh( idCard: Long,
                                           idRehabilitationSolution: Long ): ResponseEntity<List<Treatment>> {
        return ResponseEntity( treatmentService.findByParamIdCardAndIdRh( idCard, idRehabilitationSolution ), HttpStatus.OK )
    }
}