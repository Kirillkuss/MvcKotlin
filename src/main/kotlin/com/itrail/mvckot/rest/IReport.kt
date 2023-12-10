package com.itrail.mvckot.rest

import com.itrail.mvckot.entity.Patient
import com.itrail.mvckot.response.BaseResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/reports")
@Tag(name = "Report", description = "Отчеты:")
@ApiResponses(value = [
    ApiResponse( responseCode = "200", description = "Успешно", content = [Content( mediaType = "application/json", schema = Schema(implementation =  Patient::class ))]),
    ApiResponse( responseCode = "400", description = "Плохой запрос", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))]),
    ApiResponse( responseCode = "500", description = "Ошибка сервера", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))])
])
interface IReport {

   // @Operation( description = "Отчет по виду ребилитационного лечения за период времени", summary = "Отчет по виду ребилитационного лечения за период времени")
   // @GetMapping("/rehabilitation-treatments/{from}{to}")
}