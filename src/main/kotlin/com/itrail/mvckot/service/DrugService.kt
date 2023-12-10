package com.itrail.mvckot.service

import com.itrail.mvckot.entity.Drug
import com.itrail.mvckot.entity.DrugTreatment
import com.itrail.mvckot.repository.DrugRepository
import com.itrail.mvckot.repository.DrugTreatmentRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class DrugService( private val drugRepository: DrugRepository,
                   private val drugTreatmentRepository: DrugTreatmentRepository) {

    fun findAll(): List<Drug>{
        return drugRepository.findAll()
    }

    fun saveDrug( drug: Drug, idDrugTreatment: Long ):Drug{
        val drugTreatment: Optional<DrugTreatment> = drugTreatmentRepository.findById( idDrugTreatment )
        if( drugTreatment.isEmpty ) throw IllegalArgumentException("Медикаментозное лечение с таким ИД не существует")
        if( drugRepository.findById( drug.idDrug).isPresent ) throw IllegalArgumentException("Препарат с такми ИД уже существует")
        if( drugRepository.findByName( drug.name ).isPresent) throw IllegalArgumentException("Препарат с такми наименованием уже существует")
        drug.drugTreatment = drugTreatment.get()
        return drugRepository.save( drug )
    }

    fun findByIdDrugTreatment( id:Long ):List<Drug>{
        val drugs: List<Drug> = drugRepository.findByIdDrugTreatment( id )
        if( drugs.isEmpty() ) throw IllegalArgumentException("По данному запросу ничего не найдено")
        return drugs
    }

}