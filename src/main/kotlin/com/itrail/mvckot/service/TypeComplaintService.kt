package com.itrail.mvckot.service

import com.itrail.mvckot.entity.Complaint
import com.itrail.mvckot.entity.TypeComplaint
import com.itrail.mvckot.repository.ComplaintRepository
import com.itrail.mvckot.repository.TypeComplaintRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TypeComplaintService( private val complaintRepository: ComplaintRepository,
                            private val typeComplaintRepository: TypeComplaintRepository ) {

    fun findAll():List<TypeComplaint>{
        return typeComplaintRepository.findAll()
    }

    fun saveTypeComplaint( typeComplaint: TypeComplaint, idComplaint: Long ):TypeComplaint{
        val complaint:Optional<Complaint> = complaintRepository.findById( idComplaint )
        if( complaint.isEmpty ) throw IllegalArgumentException("Неверный параметр, жалоба с таким ИД не существует")
        if( typeComplaintRepository.findByName( typeComplaint.name ).isPresent ) throw IllegalArgumentException("Под жалоба с таким наименованием уже существует")
        if( typeComplaintRepository.findById( typeComplaint.idTypeComplaint ).isPresent ) throw IllegalArgumentException("Под жалоба с таким ИД уже существует")
        typeComplaint.complaint = complaint.get()
        return typeComplaintRepository.save( typeComplaint )
    }

    fun findByIdCompliant( id: Long ):List<TypeComplaint>{
        if( complaintRepository.findById( id ).isEmpty ) throw IllegalArgumentException("Жалобы с таким ИД не существует")
        return typeComplaintRepository.findByIdComplaint( id );
    }
}