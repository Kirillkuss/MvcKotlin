package com.itrail.mvckot.service

import com.itrail.mvckot.entity.Document
import com.itrail.mvckot.repository.DocumentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class DocumentService( private val documentRepository: DocumentRepository) {

    fun allDocument(): List<Document> = documentRepository.findAll()

    fun getByIdDocument( id: Long ): Document{
        return documentRepository.findById( id ).orElseThrow{ NoSuchElementException("Документа с таким ИД не существует") }
    }

    fun addDocument( document: Document ): Document{
        if ( documentRepository.findById( document.idDocument ).isPresent ) throw IllegalArgumentException( "Документ с таким ИД уже существует" )
        if ( documentRepository.findDocumentByNumar( document.numar ).isPresent ) throw IllegalArgumentException( "Документ с таким номером уже существует" )
        if ( documentRepository.findDocumentByPolis( document.polis ).isPresent ) throw IllegalArgumentException( "Документ с таким полисом уже существует" )
        if ( documentRepository.findDocumentBySnils( document.snils ).isPresent ) throw IllegalArgumentException( "Документ с таким снилсом уже существует" )
        return documentRepository.save( document )
    }

    fun removeDocument( id: Long ){
        if ( documentRepository.findById( id ).isEmpty ) throw IllegalArgumentException( "Документ с таким ИД не существует" )
        documentRepository.deleteById( id )
    }

}