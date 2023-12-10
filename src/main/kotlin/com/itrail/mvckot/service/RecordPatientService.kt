package com.itrail.mvckot.service

import com.itrail.mvckot.entity.CardPatient
import com.itrail.mvckot.entity.Doctor
import com.itrail.mvckot.entity.RecordPatient
import com.itrail.mvckot.repository.CardPatientRepository
import com.itrail.mvckot.repository.DoctorRepository
import com.itrail.mvckot.repository.RecordPatientRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class RecordPatientService( private val recordPatientRepository: RecordPatientRepository,
                            private val doctorRepository: DoctorRepository,
                            private val cardPatientRepository: CardPatientRepository ) {

    fun findAll():List<RecordPatient>{
        return recordPatientRepository.findAll()
    }

    fun saveRecordPatient( recordPatient: RecordPatient, idDoctor: Long, idCardPatient: Long ):RecordPatient{
        if( recordPatientRepository.findById( recordPatient.idRecord).isPresent ) throw IllegalArgumentException("Запись к врачу с таким ИД уже существует, установите другой ИД записи к врачу")
        val doctor:Doctor = doctorRepository.findById( idDoctor ).orElseThrow { throw IllegalArgumentException("Указан неверный идентификатор доктора")  }
        recordPatient.doctor = doctor
        val cardPatient:CardPatient = cardPatientRepository.findById( idCardPatient ).orElseThrow {  throw IllegalArgumentException("Указан неверный идентификатор карты пациента")}
        recordPatient.cardPatientId = cardPatient.idCardPatient
        return recordPatientRepository.save( recordPatient )
    }

    fun findByParam( id: Long, dateFrom:LocalDateTime, dateTo: LocalDateTime ):List<RecordPatient>{
        return recordPatientRepository.findByParamTwo( id, dateFrom, dateTo )
    }

}