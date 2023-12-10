package com.itrail.mvckot.rest

import com.itrail.mvckot.entity.Patient
import com.itrail.mvckot.response.BaseResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag( name = "2. Patient", description = "Пациент")
@RequestMapping("patients" )
@ApiResponses(value = [
    ApiResponse( responseCode = "200", description = "Успешно", content = [Content( mediaType = "application/json", schema = Schema(implementation =  Patient::class ))]),
    ApiResponse( responseCode = "400", description = "Плохой запрос", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))]),
    ApiResponse( responseCode = "500", description = "Ошибка сервера", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))])
])
interface IPatient {

    @GetMapping( "/find-by-fio/{word}")
    @Operation( description = "Поиск пациента по ФИО", summary = "Поиск пациента по ФИО")
    fun findByFio(  @Parameter( name="word", description = "ФИО пациента", example = "Петрович" ) word: String ): ResponseEntity<List<Patient>>

    @GetMapping( "/find-by-id-document/{id}")
    @Operation( description = "Поиск пациента по документу", summary = "Поиск пациента по документу")
    fun findByIdDocument( @Parameter( description = "Ид документа", example = "1") id: Long ): ResponseEntity<Patient>

    @PostMapping("/add-patient")
    @Operation( description = "Добавить пациента", summary = "Добавить пациента")
    fun addPatient( @RequestBody  patient: Patient,
                    @RequestParam( name = "Ид документа") @Parameter( name = "Ид документа", example = "1") id: Long  ): ResponseEntity<Patient>;
}