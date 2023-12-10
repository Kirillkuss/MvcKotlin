package com.itrail.mvckot.service

import com.itrail.mvckot.entity.*
import com.itrail.mvckot.repository.*
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class TreatmentService( private val treatmentRepository: TreatmentRepository,
                        private val drugRepository: DrugRepository,
                        private val rehabilitationSolutionRepository: RehabilitationSolutionRepository,
                        private val cardPatientRepository: CardPatientRepository,
                        private val doctorRepository: DoctorRepository ) {

    fun findAll():List<Treatment>{
        return treatmentRepository.findAll()
    }

    fun addTreatment( treatment: Treatment, idDrug:Long, idCardPatient: Long ,
                      idRehabilitationSolution: Long, idDoctor:Long ):Treatment{
        val drug:Optional<Drug> = drugRepository.findById( idDrug )
        val doctor:Optional<Doctor> = doctorRepository.findById( idDoctor )
        val rehabilitationSolution: Optional<RehabilitationSolution> = rehabilitationSolutionRepository.findById( idRehabilitationSolution )
        val cardPatient: Optional<CardPatient> = cardPatientRepository.findById( idCardPatient )
        if( drug.isEmpty ) throw IllegalArgumentException("Указано неверное значение медикаментозного лечения, укажите другой")
        if( treatmentRepository.findById( treatment.idTreatment).isPresent ) throw IllegalArgumentException("Лечение с таким ИД уже существует, используйте другой")
        if( rehabilitationSolution.isEmpty ) throw IllegalArgumentException("Указано неверное значение реабилитационного лечения, укажите другой")
        if( cardPatient.isEmpty ) throw IllegalArgumentException("Указано неверное значение карты пациента, укажите другой")
        if( doctor.isEmpty ) throw IllegalArgumentException("Указано неверное значение ид доктора, укажите другой")
        treatment.cardPatientId = cardPatient.get().idCardPatient
        treatment.rehabilitationSolution = rehabilitationSolution.get()
        treatment.doctor = doctor.get()
        treatment.drug = drug.get()
        return treatmentRepository.save( treatment )
    }

    fun findByParamIdCardAndDateStart( id: Long, dateFrom: LocalDateTime, dateTo: LocalDateTime ):List<Treatment>{
        val treatments: List<Treatment> = treatmentRepository.findParamByIdCardAndDateStart( id, dateFrom, dateTo )
        if( treatments.isEmpty() ) throw IllegalArgumentException("По данному запросу ничего не найдено")
        return treatments
    }

    fun findByParamIdCardAndIdRh( idCard: Long, idReSol: Long ):List<Treatment>{
        val treatments: List<Treatment> = treatmentRepository.findByParamIdCardAndIdRh( idCard, idReSol )
        if( treatments.isEmpty() ) throw IllegalArgumentException("По данному запросу ничего не найдено")
        return treatments
    }
}