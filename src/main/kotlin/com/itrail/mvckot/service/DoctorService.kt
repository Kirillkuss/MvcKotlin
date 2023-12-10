package com.itrail.mvckot.service

import com.itrail.mvckot.entity.Doctor
import com.itrail.mvckot.repository.DoctorRepository
import org.springframework.stereotype.Service

@Service
class DoctorService( private val doctorRepository: DoctorRepository) {

    fun findAllDoctor():List<Doctor>{
        return doctorRepository.findAll()
    }

    fun findByFIO( name:String ):List<Doctor>{
        val doctors:List<Doctor> = doctorRepository.findByFIO( name )
        if( doctors.isEmpty() ) throw IllegalArgumentException("По данному запросу ничего не найдено")
        return doctors;
    }

    fun saveDoctor( doctor: Doctor ):Doctor{
        if( doctorRepository.findById( doctor.idDoctor ).isPresent ) throw IllegalArgumentException("Доктор с таким ИД уще существует")
        return doctorRepository.save( doctor )
    }
}