package com.itrail.mvckot.entity

import io.swagger.v3.oas.annotations.media.Schema
import lombok.Getter
import lombok.Setter
import java.io.Serializable
import javax.persistence.*

@Entity
@Getter
@Setter
@Table( name = "Drug_treatment")
class DrugTreatment: Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_drug")
    @field:Schema(
        name = "idDrugTreatment",
        description = "ИД медикаментозного лечения",
        example = "100",
        type = "int",
    )
    val idDrugTreatment: Long = 0L

    @Column( name = "name")
    @field:Schema(
        name = "name",
        description = "Наименование",
        example = "Кортикостероиды",
        type = "String",
    )
    val name: String = ""
}