package com.itrail.mvckot.controller

import com.itrail.mvckot.entity.Drug
import com.itrail.mvckot.entity.DrugTreatment
import com.itrail.mvckot.rest.IDrugTreatment
import com.itrail.mvckot.service.DrugService
import com.itrail.mvckot.service.DrugTreatmentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class DrugTreatmentController( private val serviceDrugTreatment:DrugTreatmentService,
                               private val  drugService: DrugService):IDrugTreatment {

    override fun findAll(): ResponseEntity<List<DrugTreatment>> {
        return ResponseEntity( serviceDrugTreatment.findAll(), HttpStatus.OK );
    }

    override fun findById(id: Long): ResponseEntity<List<Drug>> {
        return ResponseEntity( drugService.findByIdDrugTreatment( id ), HttpStatus.OK );
    }

    override fun addDrugTreatment(drugTreatment: DrugTreatment): ResponseEntity<DrugTreatment> {
        return ResponseEntity( serviceDrugTreatment.addDrugTreatment( drugTreatment ), HttpStatus.OK );
    }

    override fun saveDrug(drug: Drug, idDrugTreatment: Long): ResponseEntity<Drug> {
        return ResponseEntity( drugService.saveDrug( drug, idDrugTreatment ), HttpStatus.OK );
    }
}