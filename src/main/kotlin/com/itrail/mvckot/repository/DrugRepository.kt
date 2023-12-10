package com.itrail.mvckot.repository

import com.itrail.mvckot.entity.Drug
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DrugRepository: JpaRepository<Drug, Long> {

    @Query("SELECT d FROM Drug d WHERE d.name = :name")
    fun findByName( name: String ): Optional<Drug>

    @Query("SELECT d FROM Drug d  WHERE d.drugTreatment.idDrugTreatment = :id")
    fun findByIdDrugTreatment( id: Long ): List<Drug>
}