package com.itrail.mvckot.repository

import com.itrail.mvckot.entity.Document
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DocumentRepository: JpaRepository<Document, Long> {

    @Query("SELECT d FROM Document d WHERE d.polis = :polis")
    fun findDocumentByPolis( polis:String ):Optional<Document>

    @Query( "SELECT d FROM Document d WHERE d.snils = :snils")
    fun findDocumentBySnils( snils:String):Optional<Document>

    @Query( "SELECT d FROM Document d WHERE d.numar = :numar")
    fun findDocumentByNumar( numar: String ): Optional<Document>

}