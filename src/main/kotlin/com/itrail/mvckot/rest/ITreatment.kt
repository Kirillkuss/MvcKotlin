package com.itrail.mvckot.rest

import com.itrail.mvckot.entity.Treatment
import com.itrail.mvckot.response.BaseResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDateTime

@Tag(name = "7. Treatment", description = "Лечение пациентов:")
@RequestMapping( "treatments")
@ApiResponses(value = [
    ApiResponse( responseCode = "200", description = "Успешно", content = [Content( mediaType = "application/json", schema = Schema(implementation =  Treatment::class ))]),
    ApiResponse( responseCode = "400", description = "Плохой запрос", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))]),
    ApiResponse( responseCode = "500", description = "Ошибка сервера", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))])
])
interface ITreatment {

    @PostMapping( "/treatment/add/{request}{id-rug}{id-card}{id-rehabilitation-solution}{id-doctor}")
    @Operation( description = "Добавить лечение для пациента", summary = "Добавить лечение для пациента")
    fun addTreatment(@RequestBody treatment:Treatment,
                     @Parameter( description = "ИД медикаментозного лечения (Препарата):", example = "1") idDrug: Long,
                     @Parameter( description = "Ид карты пациента:",                       example = "1") idCard: Long,
                     @Parameter( description = "Ид реабилитационного лечения:",            example = "1") idRehabilitationSolution: Long,
                     @Parameter( description = "Ид доктор:",                               example = "1") idDoctor: Long ):ResponseEntity<Treatment>

    @GetMapping( "/find/treat/{id-card}{from}{to}")
    @Operation( description = "Получение списка лечений по параметрам", summary = "Получение списка лечений по параметрам")
    fun findByParamIdCardAndDateStart( @Parameter( description = "Ид карты",                example = "1") idCard: Long,
                                       @Parameter( description = "Время начала лечения с:", example = "2023-01-20T12:47:07.605") @DateTimeFormat( iso = DateTimeFormat.ISO.DATE_TIME )  from: LocalDateTime,
                                       @Parameter( description = "Время начала лечения по", example = "2023-09-20T12:47:07.605") @DateTimeFormat( iso = DateTimeFormat.ISO.DATE_TIME )  to: LocalDateTime ):ResponseEntity<List<Treatment>>

    @GetMapping( "/find/treatment/{id-card}{id-rehabilitation-solution}")
    @Operation( description = "Получение списка лечений по параметрам", summary = "Получение списка лечений по параметрам")
    fun findByParamIdCardAndIdRh( @Parameter( description = "Ид карты пациента",            example = "1")  idCard: Long,
                                  @Parameter( description = "Ид реабилитационного лечения", example = "1")  idRehabilitationSolution: Long ):ResponseEntity<List<Treatment>>
}