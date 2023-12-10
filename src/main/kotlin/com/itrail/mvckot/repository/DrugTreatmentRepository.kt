package com.itrail.mvckot.repository

import com.itrail.mvckot.entity.DrugTreatment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DrugTreatmentRepository: JpaRepository<DrugTreatment, Long > {

    @Query(" SELECT dt FROM DrugTreatment dt WHERE dt.name = :name")
    fun findByName( name: String ):Optional<DrugTreatment>

}