package com.itrail.mvckot.rest

import com.itrail.mvckot.entity.RecordPatient
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

@Tag(name = "5. Records Patients", description = "Записи пациентов:")
@RequestMapping("patients" )
@ApiResponses(value = [
    ApiResponse( responseCode = "200", description = "Успешно",        content = [Content( mediaType = "application/json", schema = Schema(implementation = RecordPatient::class ))]),
    ApiResponse( responseCode = "400", description = "Плохой запрос",  content = [Content( mediaType = "application/json", schema = Schema(implementation = BaseResponse::class ))]),
    ApiResponse( responseCode = "500", description = "Ошибка сервера", content = [Content( mediaType = "application/json", schema = Schema(implementation = BaseResponse::class ))])
])
interface IRecordPatient {

    @PostMapping("/add/{idDoctor}/{idCard}")
    @Operation( description = "Добавить запись пациента к врачу", summary = "Добавить запись пациента к врачу")
    fun addRecordPatient( @RequestBody recordPatient:RecordPatient, @Parameter( description = "Ид доктора", example = "1")  idDoctor:Long,
                          @Parameter( description = "Ид карты пациента", example = "1" )  idCard: Long ):ResponseEntity<RecordPatient>

    @GetMapping( "/find/{id}{from}{to}" )
    @Operation( description = "Список всех записей пациентов к врачу по параметрам", summary = "Список всех записей пациентов к врачу по параметрам ")
    fun findByParams(@Parameter(description = "ИД карты пациента", example = "1")  id:Long,
                     @Parameter(description = "Дата записи с:", example = "2023-02-19T12:47:07.605")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) dateFrom:LocalDateTime,
                     @Parameter(description = "Дата записи по:", example = "2023-05-19T12:47:07.605") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) dateTo:LocalDateTime ):ResponseEntity<List<RecordPatient>>
}