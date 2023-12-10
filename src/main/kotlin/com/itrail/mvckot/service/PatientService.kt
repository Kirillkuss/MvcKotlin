    package com.itrail.mvckot.service

import com.itrail.mvckot.entity.Patient
import com.itrail.mvckot.repository.PatientRepository
import org.springframework.stereotype.Service

@Service
class PatientService( private val patientRepository: PatientRepository,
                      private val documentService: DocumentService ) {

    fun findAllPatient(): List<Patient>{
        return patientRepository.findAll()
    }

    fun findByIdPatient( idPatient: Long ): Patient{
        return patientRepository.findById( idPatient )
                                .orElseThrow { NoSuchElementException( "Пациента с таким ИД нет") }
    }

    fun findPatientByIdDocument( idDocument: Long ):Patient{
        return patientRepository.findPatientByIdDocument( idDocument )
                                .orElseThrow { NoSuchElementException("Пациента с таким ИД документа не существет") }
    }

    fun findPatientByFio( word: String ):List<Patient>{
        return  patientRepository.findByWordPatient( word );
    }

    fun addPatient( patient: Patient, id: Long ):Patient{
        patient.document = documentService.getByIdDocument( id )
        if( patientRepository.findById( patient.idPatient ).isPresent ) throw IllegalArgumentException( "Пациент с ткаим ИД пациента существует" )
        if( patientRepository.findPatientByIdDocument( id ).isPresent ) throw IllegalArgumentException( "Пациент с ткаим ИД доумента существует" )
        if( patientRepository.findByPhone( patient.phone).isPresent ) throw IllegalArgumentException( "Пациент с ткаим номером тел существует" )
        return patientRepository.save( patient );
    }





}