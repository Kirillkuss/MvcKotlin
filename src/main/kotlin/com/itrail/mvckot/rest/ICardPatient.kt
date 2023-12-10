package com.itrail.mvckot.rest

import com.itrail.mvckot.entity.CardPatient
import com.itrail.mvckot.response.BaseResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Tag( name = "4. Card Patient", description = "Карта пациента")
@RequestMapping("card-patinets" )
@ApiResponses(value = [
    ApiResponse( responseCode = "200", description = "Успешно",        content = [Content( mediaType = "application/json", schema = Schema(implementation = CardPatient::class ))]),
    ApiResponse( responseCode = "400", description = "Плохой запрос",  content = [Content( mediaType = "application/json", schema = Schema(implementation = BaseResponse::class ))]),
    ApiResponse( responseCode = "500", description = "Ошибка сервера", content = [Content( mediaType = "application/json", schema = Schema(implementation = BaseResponse::class ))])
])
interface ICardPatient {

    @GetMapping( "/document")
    @Operation( description = "Поиск карты пациента по документу пациента (СНИЛС, номер документа, ПОЛИС)", summary = "Поиск карты пациента по документу пациента")
    fun findByDocumentPatient( @Parameter( description = "Параметр поиска:", example = "123243453") word:String):ResponseEntity<CardPatient>

    @GetMapping( "/card/{id}")
    @Operation( description = "Поиск карты пациента по ИД карты", summary = "Поиск карты пациента по ИД карты")
    fun getByIdCard( @Parameter( description = "ИД карты пациента", example ="1") id: Long ):ResponseEntity<CardPatient>

    @GetMapping( "/patient/{id}")
    @Operation( description = "Поиск карты пациента по ИД пациента", summary = "Поиск карты пациента по ИД пациента")
    fun getByIdPatient( @Parameter( description = "ИД Пациента", example = "1") id: Long ):ResponseEntity<CardPatient>

    @PostMapping("/add")
    @Operation( description = "Добавить карту пациента", summary = "Добавить карту пациента")
    fun saveCardPatient(@RequestBody card:CardPatient, @Parameter( description = "ИД пациента:", example = "1") idPatient:Long ):ResponseEntity<CardPatient>

    @PostMapping ( "/complaint")
    @Operation( description = "Добавление жалобы пациенту", summary = "Добавление жалобы пациенту")
    fun saveComplaintToCardPatient( @Parameter( description = "ИД карты пациента:", example = "1") idCard:Long,
                                    @Parameter( description = "ИД Под жалобы:" , example =  "1")  idComplaint:Long):ResponseEntity<BaseResponse>
}