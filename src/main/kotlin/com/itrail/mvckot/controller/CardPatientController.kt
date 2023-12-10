package com.itrail.mvckot.controller

import com.itrail.mvckot.entity.CardPatient
import com.itrail.mvckot.response.BaseResponse
import com.itrail.mvckot.rest.ICardPatient
import com.itrail.mvckot.service.CardPatientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class CardPatientController( private val cardPatientService: CardPatientService ):ICardPatient {


    override fun findByDocumentPatient(word: String): ResponseEntity<CardPatient> {
        return ResponseEntity( cardPatientService.findByNPS( word ), HttpStatus.OK )
    }

    override fun getByIdCard(id: Long): ResponseEntity<CardPatient> {
        return ResponseEntity( cardPatientService.findByIdCard( id ), HttpStatus.OK )
    }

    override fun getByIdPatient(id: Long): ResponseEntity<CardPatient> {
        return ResponseEntity( cardPatientService.findByPatientId( id ), HttpStatus.OK )
    }

    override fun saveCardPatient(card: CardPatient, idPatient: Long): ResponseEntity<CardPatient> {
        return ResponseEntity( cardPatientService.saveCardPatient( card, idPatient ),HttpStatus.OK  )
    }

    override fun saveComplaintToCardPatient(idCard: Long, idComplaint: Long): ResponseEntity<BaseResponse> {
        cardPatientService.addCardPatientComplaint(idCard, idComplaint )
        return ResponseEntity( BaseResponse( 200, "success"),HttpStatus.OK )
    }
}