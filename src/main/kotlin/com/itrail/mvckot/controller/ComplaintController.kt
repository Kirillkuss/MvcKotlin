package com.itrail.mvckot.controller

import com.itrail.mvckot.entity.Complaint
import com.itrail.mvckot.entity.TypeComplaint
import com.itrail.mvckot.rest.IComplaint
import com.itrail.mvckot.service.ComplaintService
import com.itrail.mvckot.service.TypeComplaintService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ComplaintController ( private val serviceComplaint:ComplaintService,
                            private val serviceTypeComplaint: TypeComplaintService ):IComplaint {

    override fun findAll(): ResponseEntity<*> {
        return ResponseEntity( serviceComplaint.listComplaints(), HttpStatus.OK )
    }

    override fun saveСomplaint(complaint: Complaint): ResponseEntity<*> {
        return ResponseEntity( serviceComplaint.saveComplaint( complaint ), HttpStatus.OK )
    }

    override fun saveTypeComplaint(request: TypeComplaint, idcomplaint: Long): ResponseEntity<*>? {
        return ResponseEntity( serviceTypeComplaint.saveTypeComplaint( request, idcomplaint ),  HttpStatus.OK )
    }

    override fun listComplaintWithTypeComplaints(id: Long): ResponseEntity<*> {
        return ResponseEntity( serviceTypeComplaint.findByIdCompliant( id ), HttpStatus.OK )
    }
}