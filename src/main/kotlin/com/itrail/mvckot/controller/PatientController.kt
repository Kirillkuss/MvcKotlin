package com.itrail.mvckot.controller

import com.itrail.mvckot.entity.Patient
import com.itrail.mvckot.rest.IPatient
import com.itrail.mvckot.service.PatientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class PatientController( private val patientService: PatientService ):IPatient {

    override fun findByFio( word: String ): ResponseEntity<List<Patient>> {
        return ResponseEntity<List<Patient>>( patientService.findPatientByFio( word ), HttpStatus.OK );
    }

    override fun findByIdDocument(id: Long ): ResponseEntity<Patient> {
        return ResponseEntity<Patient>( patientService.findPatientByIdDocument( id ), HttpStatus.OK );
    }

    override fun addPatient(patient: Patient, id: Long ): ResponseEntity<Patient> {
        return ResponseEntity<Patient>( patientService.addPatient( patient, id ), HttpStatus.OK );
    }

    override fun getLazyPatients( page: Int, size: Int ): ResponseEntity<List<Patient>>{
        return ResponseEntity<List<Patient>>( patientService.getLazyPatients( page, size), HttpStatus.OK );
    }

}