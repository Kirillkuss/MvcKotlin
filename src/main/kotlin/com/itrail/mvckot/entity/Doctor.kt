package com.itrail.mvckot.entity

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.media.Schema
import lombok.*
import java.io.Serializable
import javax.persistence.*

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table( name = "doctor")
class Doctor: Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_doctor")
    @field:Schema(
        name = "idDoctor",
        description = "ИД доктора",
        example = "100",
        type = "int",
    )
    @Hidden
    val idDoctor: Long = 0L

    @Column( name = "surname")
    @field:Schema(
        name = "surname",
        description = "Фимилия",
        example = "Рыбкин",
        type = "String",
    )
    val surname: String = ""

    @Column( name = "name")
    @field:Schema(
        name = "name",
        description = "Имя",
        example = "Тузик",
        type = "String",
    )
    val name: String = ""

    @Column( name = "full_name")
    @field:Schema(
        name = "fullName",
        description = "Отчество",
        example = "Владимирович",
        type = "String",
    )
    val fullName = ""

}