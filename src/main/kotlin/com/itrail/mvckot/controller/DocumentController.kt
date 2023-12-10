package com.itrail.mvckot.controller

import com.itrail.mvckot.entity.Document
import com.itrail.mvckot.rest.IDocument
import com.itrail.mvckot.service.DocumentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class DocumentController( private val documentService: DocumentService ): IDocument {

    override fun findAllDocument(): ResponseEntity<List<Document>> {
        return ResponseEntity( documentService.allDocument(), HttpStatus.OK )
    }

    override fun findByIdDocument(id: Long):ResponseEntity<Document> {
        return  ResponseEntity( documentService.getByIdDocument( id ), HttpStatus.OK )
    }

    override fun addDocument(document: Document):ResponseEntity<Document> {
        return ResponseEntity( documentService.addDocument( document ), HttpStatus.OK)
    }

    override fun removeDocument(id: Long):ResponseEntity<String> {
        documentService.removeDocument( id )
        return ResponseEntity( "Success delete document", HttpStatus.CONTINUE )
    }

}