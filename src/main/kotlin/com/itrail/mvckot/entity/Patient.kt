package com.itrail.mvckot.entity

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.media.Schema
import lombok.EqualsAndHashCode
import lombok.Getter
import lombok.Setter
import lombok.ToString
import java.io.Serializable
import javax.persistence.*

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table
class Patient(): Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_patient")
    @field:Schema(
        name = "idPatient",
        description = "idPatient",
        example = "100",
        type = "int",
    )
    @Hidden
    val idPatient: Long = 0L

    @Column( name = "surname")
    @field:Schema(
        name = "surname",
        description = "surname",
        example = "Петров",
        type = "string",
    )
    val surname: String = ""

    @Column( name = "name")
    @field:Schema(
        name = "name",
        description = "name",
        example = "Петр",
        type = "string",
    )
    val name: String = ""

    @Column( name = "full_name")
    @field:Schema(
        name = "fullname",
        description = "fullname",
        example = "Петрович",
        type = "string",
    )
    val fullname: String = ""

    @Column( name = "gender")
    @field:Schema(
        name = "gender",
        description = "gender",
        example = "MAN"
    )
    var  gender: Gender = Gender.MAN

    @Column( name = "phone")
    @field:Schema(
        name = "phone",
        description = "phone",
        example = "89934545",
        type = "string",
    )
    val phone: String = ""

    @Column( name = "address")
    @field:Schema(
        name = "address",
        description = "address",
        example = "Незаивисмоси 5",
        type = "string",
    )
    val address: String = ""

    @field:Schema(
        name = "document",
        description = "document"
    )
    @Hidden
    @OneToOne( cascade = arrayOf(CascadeType.ALL))
    @JoinColumn( name = "document_id" )
    var document: Document = Document()
}