package com.itrail.mvckot.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.media.Schema
import lombok.*
import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table( name = "record_patient")
class RecordPatient: Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_record")
    @field:Schema(
        name = "idRecord",
        description = "idRecord",
        example = "100",
        type = "int"
    )
    @Hidden
    val idRecord: Long = 0L

    @Column( name = "date_record")
    @field:Schema(
        name = "dateRecord",
        description = "Дата и время записи",
        example = "2023-01-19T12:00:00.000Z"
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val dateRecord: LocalDateTime = LocalDateTime.now()

    @Column( name = "date_appointment")
    @field:Schema(
        name = "dateAppointment",
        description = "Дата и время приема",
        example = "2023-02-01T14:00:00.605Z"
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val dateAppointment: LocalDateTime = LocalDateTime.now()

    @Column( name = "number_room")
    @field:Schema(
        name = "numberRoom",
        description = "Номер кабинета",
        example = "103"
    )
    val numberRoom: Long = 0L

    @Hidden
    // cascade = arrayOf( CascadeType.ALL )
    @OneToOne()
    @JoinColumn( name = "doctor_id" )
    var doctor:Doctor = Doctor()

    @Hidden
    @Column( name = "card_patient_id")
    @field:Schema(
        name = "cardPatientId",
        description = "ИД карты",
        example = "103"
    )
    @JsonIgnore
    var cardPatientId: Long = 0L
}
