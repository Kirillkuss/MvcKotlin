package com.itrail.mvckot.entity

import io.swagger.v3.oas.annotations.Hidden
import io.swagger.v3.oas.annotations.media.Schema
import lombok.*
import java.io.Serializable
import javax.persistence.*

@Entity
@Getter
@Setter
@Table
@Schema(description = "Entity Document")
class Document(): Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @field:Schema(
        name = "idDocument",
        description = "idDocument",
        example = "1",
        type = "int",
    )
    @Hidden
    val idDocument: Long = 0L

    @field:Schema(
        name = "typeDocument",
        description = "typeDocument",
        example = "Passport",
        type = "string",
    )
    val typeDocument: String = ""

    @field:Schema(
        name = "seria",
        description = "seria",
        example = "DM",
        type = "string",
    )
    val seria: String = ""

    @field:Schema(
        name = "numar",
        description = "numar",
        example = "123456789",
        type = "string",
    )
    val numar: String = ""

    @field:Schema(
        name = "snils",
        description = "snils",
        example = "111-222-333-444",
        type = "string",
    )
    val snils: String = ""

    @field:Schema(
        name = "polis",
        description = "polis",
        example = "0000 0000 0000 0000",
        type = "string",
    )
    val polis: String = ""

}