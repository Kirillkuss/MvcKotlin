package com.itrail.mvckot.rest

import com.itrail.mvckot.entity.Doctor
import com.itrail.mvckot.entity.Document
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


@Tag(name = "1. Doctors", description = "Доктора:")
@RequestMapping( "doctors")
@ApiResponses(value = [
    ApiResponse( responseCode = "200", description = "Успешно", content = [Content( mediaType = "application/json", schema = Schema(implementation =  Doctor::class ))]),
    ApiResponse( responseCode = "400", description = "Плохой запрос", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))]),
    ApiResponse( responseCode = "500", description = "Ошибка сервера", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))])
])
interface IDoctor {

    @GetMapping( "/all")
    @Operation( description = "Список всех докторов", summary = "Список всех докторов")
    fun findAll():ResponseEntity<List<Doctor>>

    @GetMapping( "/fio/{word}")
    @Operation( description = "Поиск врача по ФИО", summary = "Поиск врача по ФИО")
    fun findByFIO( @Parameter( description = "ФИО врача")  word:String ):ResponseEntity<List<Doctor>>

    @PostMapping(  "/add")
    @Operation( description = "Добавить доктора", summary = "Добавить доктора")
    fun addDoctor( @RequestBody doctor: Doctor): ResponseEntity<Doctor>
}