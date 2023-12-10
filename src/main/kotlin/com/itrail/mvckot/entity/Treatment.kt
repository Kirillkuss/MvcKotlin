package com.itrail.mvckot.entity

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.media.Schema
import lombok.Getter
import lombok.Setter
import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Getter
@Setter
@Table( name = "Treatment")
class Treatment: Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_treatment")
    @field:Schema(
        name = "idTreatment",
        description = "ИД лечения",
        example = "100",
        type = "int"
    )
    val idTreatment: Long = 0L

    @Column( name = "time_start_treatment")
    @field:Schema(
        name = "timeStartTreatment",
        description = "Дата и время начала лечения",
        example = "2023-01-19T12:00:00.000Z"
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val timeStartTreatment: LocalDateTime = LocalDateTime.now()

    @Column( name = "end_time_treatment")
    @field:Schema(
        name = "endTimeTreatment",
        description = "Дата и время окончание лечения",
        example = "2023-07-19T12:00:00.000Z"
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val endTimeTreatment: LocalDateTime = LocalDateTime.now()

    @Hidden
    @OneToOne( cascade = arrayOf(CascadeType.ALL))
    @JoinColumn( name = "drug_id" )
    var drug:Drug = Drug()

    @Hidden
    @OneToOne( cascade = arrayOf(CascadeType.ALL))
    @JoinColumn( name = "rehabilitation_solution_id" )
    var rehabilitationSolution:RehabilitationSolution = RehabilitationSolution()

    @Column( name = "card_patient_id")
    @field:Schema(
        name = "cardPatientId",
        description = "ИД карты пациента",
        example = "1",
        type = "int"
    )
    var cardPatientId: Long = 0L

    @Hidden
    @OneToOne( cascade = arrayOf(CascadeType.ALL))
    @JoinColumn( name = "doctor_id" )
    var doctor:Doctor = Doctor()

}