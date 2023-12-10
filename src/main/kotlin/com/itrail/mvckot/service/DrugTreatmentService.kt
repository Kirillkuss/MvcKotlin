package com.itrail.mvckot.service

import com.itrail.mvckot.entity.DrugTreatment
import com.itrail.mvckot.repository.DrugTreatmentRepository
import org.springframework.stereotype.Service

@Service
class DrugTreatmentService( private val drugTreatmentRepository: DrugTreatmentRepository ) {

    fun findAll():List<DrugTreatment>{
        return drugTreatmentRepository.findAll()
    }

    fun addDrugTreatment( drugTreatment: DrugTreatment ):DrugTreatment{
        if( drugTreatmentRepository.findById( drugTreatment.idDrugTreatment ).isPresent ) throw IllegalArgumentException("Медикаментозное лечение с таким ИД уже существует")
        if( drugTreatmentRepository.findByName( drugTreatment.name ).isPresent ) throw IllegalArgumentException("Медикаментозное лечение с таким наименование уже существует")
        return drugTreatmentRepository.save( drugTreatment )
    }

}