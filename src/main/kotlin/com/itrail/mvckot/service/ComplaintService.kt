package com.itrail.mvckot.service

import com.itrail.mvckot.entity.Complaint
import com.itrail.mvckot.repository.ComplaintRepository
import org.springframework.stereotype.Service

@Service
class ComplaintService( private val complaintRepository: ComplaintRepository) {

    fun listComplaints():List<Complaint>{
        return  complaintRepository.findAll();
    }

    fun saveComplaint( complaint: Complaint ):Complaint{
        if( complaintRepository.findById( complaint.idComplaint ).isPresent ) throw IllegalArgumentException("Справочник жалоба с таким ИД уже существует")
        if ( complaintRepository.findByName( complaint.functionImpairment ).isPresent ) throw IllegalArgumentException("Справочник жалоба с таким наименованием уже существует")
        return complaintRepository.save( complaint )
    }


}