package com.itrail.mvckot.entity

import io.swagger.v3.oas.annotations.media.Schema
import lombok.Getter
import lombok.Setter
import java.io.Serializable
import javax.persistence.*

@Entity
@Getter
@Setter
@Table
class Complaint: Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_complaint")
    @field:Schema(
        name = "idComplaint",
        description = "ИД жалобы",
        example = "100",
        type = "int",
    )
    val idComplaint: Long = 0L


    @Column( name = "functional_impairment")
    @field:Schema(
        name = "functionImpairment",
        description = "Наименование жалобы",
        example = "Симптомы поражения пирамидного тракта",
        type = "string",
    )
    val functionImpairment: String = ""
}