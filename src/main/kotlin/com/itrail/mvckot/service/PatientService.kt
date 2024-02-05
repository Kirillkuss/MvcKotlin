package com.itrail.mvckot.service

import com.itrail.mvckot.entity.Patient
import com.itrail.mvckot.repository.PatientRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import org.slf4j.LoggerFactory

@Service
class PatientService( private val patientRepository: PatientRepository,
                      private val documentService: DocumentService,
                      private val entityManager: EntityManager ) {

    private val logger = LoggerFactory.getLogger(PatientService::class.java)

    fun findAllPatient(): List<Patient>{
        logger.info( "findAllPatient => " )
        return patientRepository.findAll()
    }

    fun findByIdPatient( idPatient: Long ): Patient{
        logger.info( "findByIdPatient => " )
        return patientRepository.findById( idPatient )
                                .orElseThrow { NoSuchElementException( "Пациента с таким ИД нет") }
    }

    fun findPatientByIdDocument( idDocument: Long ):Patient{
        logger.info( "findPatientByIdDocument => " )
        return patientRepository.findPatientByIdDocument( idDocument )
                                .orElseThrow { NoSuchElementException("Пациента с таким ИД документа не существет") }
    }

    fun findPatientByFio( word: String ):List<Patient>{
        logger.info( "findPatientByFio => " )
        return  patientRepository.findByWordPatient( word );
    }

    fun addPatient( patient: Patient, id: Long ):Patient{
        logger.info( "addPatient => ")
        patient.document = documentService.getByIdDocument( id )
        if( patientRepository.findById( patient.idPatient ).isPresent ) throw IllegalArgumentException( "Пациент с ткаим ИД пациента существует" )
        if( patientRepository.findPatientByIdDocument( id ).isPresent ) throw IllegalArgumentException( "Пациент с ткаим ИД доумента существует" )
        if( patientRepository.findByPhone( patient.phone).isPresent ) throw IllegalArgumentException( "Пациент с ткаим номером тел существует" )
        return patientRepository.save( patient );
    }

    fun getLazyPatients( page: Int, size: Int): List<Patient>{
        logger.info( "getLazyPatients => page: " + page + " size: " + size )
        val query = entityManager.createNativeQuery("select * from Patient", Patient::class.java)
        query.firstResult = (page - 1) * size
        query.maxResults = size
        return query.resultList.map { it as Patient }
    }




}