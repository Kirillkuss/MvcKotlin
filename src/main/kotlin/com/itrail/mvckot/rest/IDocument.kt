package com.itrail.mvckot.rest

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
import org.springframework.web.bind.annotation.*

@Tag( name = "3. Documents", description = "Документ пациента")
@RequestMapping("documents" )
@ApiResponses(value = [
    ApiResponse( responseCode = "200", description = "Успешно", content = [Content( mediaType = "application/json", schema = Schema(implementation =  Document::class ))]),
    ApiResponse( responseCode = "400", description = "Плохой запрос", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))]),
    ApiResponse( responseCode = "500", description = "Ошибка сервера", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))])
])
interface IDocument {

    @GetMapping("/find-all" )
    @Operation( description = "Список всех документов", summary = "Список всех документов")
    fun findAllDocument(): ResponseEntity<List<Document>>

    @GetMapping("/find-by-id{id}" )
    @Operation( description = "Поиск документа по ИД", summary = "Поиск документа по ИД")
    fun findByIdDocument( @PathVariable @Parameter( description = "ИД документа", example = "1") id: Long ):ResponseEntity<Document>

    @PostMapping("/add")
    @Operation( description = "Добавить документ", summary = "Добавить документ")
    fun addDocument( @RequestBody document: Document ):ResponseEntity<Document>

    @DeleteMapping( "/delete{id}")
    @Operation( description = "Удалить документ", summary = "Удалить документ")
    fun removeDocument( @PathVariable @Parameter( description = "ИД документа", example = "1") id: Long ): ResponseEntity<String>
}