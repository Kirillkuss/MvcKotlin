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
@Table( name = "drug")
class Drug: Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_dr")
    @field:Schema(
        name = "idDrug",
        description = "ИД лекарства",
        example = "100",
        type = "int",
    )
    val idDrug: Long = 0L

    @Column( name = "name")
    @field:Schema(
        name = "name",
        description = "Препараты",
        example = "Карвалол 2 чайные ложки в день",
        type = "String",
    )
    val name:String = ""

    @Hidden
    @OneToOne( cascade = arrayOf(CascadeType.ALL))
    @JoinColumn( name = "drug_id")
    var drugTreatment:DrugTreatment = DrugTreatment()
}