package com.itrail.mvckot.controller

import com.itrail.mvckot.entity.RecordPatient
import com.itrail.mvckot.rest.IRecordPatient
import com.itrail.mvckot.service.CardPatientService
import com.itrail.mvckot.service.RecordPatientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class RecordPatientController( private val recordPatientService:RecordPatientService ):IRecordPatient {

    override fun addRecordPatient( recordPatient: RecordPatient, idDoctor: Long, idCard: Long ): ResponseEntity<RecordPatient> {
        return ResponseEntity( recordPatientService.saveRecordPatient( recordPatient, idDoctor, idCard ), HttpStatus.OK)
    }

    override fun findByParams( id: Long, dateFrom: LocalDateTime, dateTo: LocalDateTime ): ResponseEntity<List<RecordPatient>> {
        return ResponseEntity( recordPatientService.findByParam( id, dateFrom, dateTo ), HttpStatus.OK)
    }
}