package com.itrail.mvckot.entity

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.media.Schema
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.io.Serializable
import javax.persistence.*

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name ="rehabilitation_solution")
class RehabilitationSolution: Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_rehabilitation_solution")
    @field:Schema(
        name = "idRehabilitationSolution",
        description = "ИД реабилитационного лечения",
        example = "100",
        type = "int",
    )
    @Hidden
    val idRehabilitationSolution: Long = 0L

    @Column( name = "name")
    @field:Schema(
        name = "name",
        description = "Наименование",
        example = "Кинезитерапия",
        type = "String",
    )
    val name:String = ""

    @Column( name = "survey_plan")
    @field:Schema(
        name = "surveyPlan",
        description = "План обследования",
        example = "План реабилитационного лечения",
        type = "String",
    )
    val surveyPlan: String =""
}