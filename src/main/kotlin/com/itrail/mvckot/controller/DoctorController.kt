package com.itrail.mvckot.controller

import com.itrail.mvckot.entity.Doctor
import com.itrail.mvckot.rest.IDoctor
import com.itrail.mvckot.service.DoctorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class DoctorController( private val doctorService: DoctorService ):IDoctor {

    override fun findAll(): ResponseEntity<List<Doctor>> {
        return ResponseEntity( doctorService.findAllDoctor(), HttpStatus.OK )
    }

    override fun findByFIO(word: String): ResponseEntity<List<Doctor>> {
        return ResponseEntity( doctorService.findByFIO( word ), HttpStatus.OK )
    }

    override fun addDoctor(doctor: Doctor): ResponseEntity<Doctor> {
        return ResponseEntity( doctorService.saveDoctor( doctor ), HttpStatus.OK )
    }
}