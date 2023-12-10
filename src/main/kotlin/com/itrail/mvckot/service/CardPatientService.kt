package com.itrail.mvckot.service

import com.itrail.mvckot.entity.CardPatient
import com.itrail.mvckot.repository.CardPatientRepository
import com.itrail.mvckot.repository.PatientRepository
import com.itrail.mvckot.repository.TypeComplaintRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Service
class CardPatientService( private val typeComplaintRepository: TypeComplaintRepository,
                          private val cardPatientRepository: CardPatientRepository,
                          private val patientRepository: PatientRepository ) {
    @PersistenceContext
    lateinit var em: EntityManager

    fun saveCardPatient( cardPatient: CardPatient, idPatient: Long ):CardPatient{
        if(cardPatientRepository.findByPatientId( idPatient ).isPresent ) throw IllegalArgumentException("Карта пациента с таким ИД пациента уже существует")
        if(cardPatientRepository.findById( cardPatient.idCardPatient ).isPresent ) throw IllegalArgumentException("Карта с таким ИД уже существует")
        cardPatient.patient = patientRepository.findById( idPatient ).orElseThrow {  NoSuchElementException("Пациента с таким ИД не существует") }
        return cardPatientRepository.save( cardPatient );
    }

    fun findByPatientId( id: Long ):CardPatient{
        return cardPatientRepository.findByPatientId( id )
                                    .orElseThrow { NoSuchElementException("Карты с таким ИД пациента не существует") }
    }

    fun findByIdCard( id : Long ):CardPatient{
        return  cardPatientRepository.findById( id )
                                     .orElseThrow { NoSuchElementException("Карты с таким ИД карты не существует") }
    }

    @Transactional
    fun addCardPatientComplaint( idCard: Long, idComplaint: Long ){
        if( cardPatientRepository.findById( idCard ).isEmpty ) throw IllegalArgumentException("Карта с таким ИД не существует")
        if( typeComplaintRepository.findById( idComplaint ).isEmpty ) throw IllegalArgumentException("Под жалобы с таким ИД не существует")
        if( cardPatientRepository.findByIdCardAndIdComplaint( idCard, idComplaint ).isPresent ) throw  IllegalArgumentException("Под жалоба с таким ИД уже добавлена в карту пацинета")
        em.createNativeQuery( "INSERT INTO Card_patient_Complaint(card_patient_id, type_complaint_id) VALUES (?,?)")
            .setParameter(1, idCard)
            .setParameter( 2, idComplaint)
            .executeUpdate();
    }

    fun findByNPS( param: String ): CardPatient{
        return cardPatientRepository.findByNPS( param )
            .orElseThrow { NoSuchElementException("Карта не найдена")  }
    }
}