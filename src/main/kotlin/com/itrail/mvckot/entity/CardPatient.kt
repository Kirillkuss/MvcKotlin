package com.itrail.mvckot.entity

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.media.Schema
import lombok.Getter
import lombok.Setter
import java.io.Serializable
import javax.persistence.*

@Entity
@Getter
@Setter
@Table( name = "card_patient")
class CardPatient:Serializable  {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_card_patient")
    @field:Schema(
        name = "idCardPatient",
        description = "ИД карты пациента",
        example = "100",
        type = "int",
    )
    val idCardPatient: Long = 0L

    @Column( name = "diagnosis")
    @field:Schema(
        name = "diagnosis",
        description = "Диагноз пациента",
        example = "Рассеянный склероз",
        type = "string",
    )
    val diagnosis: String = ""

    @Column( name = "allergy")
    @field:Schema(
        name = "allergy",
        description = "Аллергия на препараты",
        example = "true",
        type = "string",
    )
    val allergy: Boolean  = true

    @Column( name = "note")
    @field:Schema(
        name = "note",
        description = "Примечание",
        example = "Есть аллергия на цитрамон",
        type = "string",
    )
    val note: String = ""

    @Column( name = "сonclusion")
    @field:Schema(
        name = "сonclusion",
        description = "Заключение",
        example = "Болен",
        type = "string",
    )
    val сonclusion  : String = ""

    @Hidden
    @OneToMany( fetch = FetchType.EAGER )
    @JoinTable( name                = "Card_patient_Complaint",
                joinColumns         = [JoinColumn(name = "card_patient_id", referencedColumnName = "id_card_patient")],
                inverseJoinColumns  = [JoinColumn(name = "type_complaint_id", referencedColumnName = "id_type_complaint")] )
    val typeComplaint: List<TypeComplaint> = ArrayList()

    @Hidden
    @OneToOne( cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "pacient_id")
    var patient:Patient = Patient()
}