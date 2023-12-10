package com.itrail.mvckot.rest

import com.itrail.mvckot.entity.Complaint
import com.itrail.mvckot.entity.TypeComplaint
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


@Tag(name = "6. Сomplaint", description = "Справочник: Жалобы и под жалобы ")
@RequestMapping( "complaints")
@ApiResponses(value = [
    ApiResponse( responseCode = "200", description = "Успешно", content = [Content( mediaType = "application/json", schema = Schema(implementation =  Complaint::class ))]),
    ApiResponse( responseCode = "400", description = "Плохой запрос", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))]),
    ApiResponse( responseCode = "500", description = "Ошибка сервера", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))])
])
interface IComplaint {

    @GetMapping(value = ["/list"])
    @Operation(description = "Получение справочника жалобы", summary = "Получение справочника жалобы")
    fun findAll(): ResponseEntity<*>

    @Operation(description = "Добавление справочника жалобы", summary = "Добавление справочника жалобы")
    @PostMapping(value = ["/complaint/{request}"])
    fun saveСomplaint( @RequestBody complaint: Complaint): ResponseEntity<*>

    @Operation(description = "Добавление под жалобы", summary = "Добавление под жалобы")
    @PostMapping(value = ["/typecomplaint/{request}{id-complaint}"])
    fun saveTypeComplaint( @RequestBody request: TypeComplaint, @Parameter(description = "ИД жалобы", example = "1") idcomplaint: Long
    ): ResponseEntity<*>?

    @Operation(description = "Получение жалобы с под жалобами", summary = "Получение жалобы с под жалобами")
    @GetMapping("/type/{id}")
    fun listComplaintWithTypeComplaints(@Parameter( description = "Ид жалобы", example = "1") id: Long ): ResponseEntity<*>

}