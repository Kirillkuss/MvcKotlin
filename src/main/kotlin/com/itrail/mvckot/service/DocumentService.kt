package com.itrail.mvckot.service

import com.itrail.mvckot.entity.Document
import com.itrail.mvckot.repository.DocumentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import org.slf4j.LoggerFactory

@Service
class DocumentService( private val documentRepository: DocumentRepository,
                       private val entityManager: EntityManager ) {
    
    val logger = LoggerFactory.getLogger(DocumentService::class.java)

    fun allDocument(): List<Document> = documentRepository.findAll()

    fun getByIdDocument( id: Long ): Document{
        logger.info( "getByIdDocument => id: "  )
        return documentRepository.findById( id ).orElseThrow{ NoSuchElementException("Документа с таким ИД не существует") }
    }

    fun addDocument( document: Document ): Document{
        logger.info( "addDocument => " + document )
        if ( documentRepository.findById( document.idDocument ).isPresent ) throw IllegalArgumentException( "Документ с таким ИД уже существует" )
        if ( documentRepository.findDocumentByNumar( document.numar ).isPresent ) throw IllegalArgumentException( "Документ с таким номером уже существует" )
        if ( documentRepository.findDocumentByPolis( document.polis ).isPresent ) throw IllegalArgumentException( "Документ с таким полисом уже существует" )
        if ( documentRepository.findDocumentBySnils( document.snils ).isPresent ) throw IllegalArgumentException( "Документ с таким снилсом уже существует" )
        return documentRepository.save( document )
    }

    fun removeDocument( id: Long ){
        logger.info( "removeDocument => id: " + id)
        if ( documentRepository.findById( id ).isEmpty ) throw IllegalArgumentException( "Документ с таким ИД не существует" )
        documentRepository.deleteById( id )
    }

    fun getLazyDocuments(page: Int, size: Int): List<Document> {
        logger.info( "getLazyDocuments => page: " + page + " size: " + size )
        val query = entityManager.createNativeQuery("select * from Document", Document::class.java)
        query.firstResult = (page - 1) * size
        query.maxResults = size
        return query.resultList.map { it as Document }
    }

}