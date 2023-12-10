package com.itrail.mvckot.rest

import com.itrail.mvckot.entity.Document
import com.itrail.mvckot.entity.Drug
import com.itrail.mvckot.entity.DrugTreatment
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

@Tag(name = "8. Drug Treatment", description = "Справочник: Медикаментозное лечение и препараты")
@RequestMapping("drug-treatments" )
@ApiResponses(value = [
    ApiResponse( responseCode = "200", description = "Успешно", content = [Content( mediaType = "application/json", schema = Schema(implementation =  DrugTreatment::class ))]),
    ApiResponse( responseCode = "400", description = "Плохой запрос", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))]),
    ApiResponse( responseCode = "500", description = "Ошибка сервера", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))])
])
interface IDrugTreatment {

    @GetMapping( "/list")
    @Operation( description = "Список всех медикаментозных лечений", summary = "Список всех медикаментозных лечений")
    fun findAll():ResponseEntity<List<DrugTreatment>>

    @GetMapping( "/drug-treatment/{id}")
    @Operation( description = "Поиск по ИД медикаментозного лечения c препаратами", summary = "Поиск по ИД медикаментозного лечения с препаратами")
    fun findById(  @Parameter(description = "ИД медикаментозного лечения",example = "1") id:Long ):ResponseEntity<List<Drug>>

    @Operation( description = "Добавить медикаментозного лечения", summary = "Добавить медикаментозного лечения")
    @PostMapping( "/add/drug-treatment/{drug-treatment}")
    fun addDrugTreatment( @RequestBody drugTreatment: DrugTreatment ):ResponseEntity<DrugTreatment>

    @Operation( description = "Добавить препарат для медикаментозного лечения", summary = "Добавить препарат для медикаментозного лечения")
    @PostMapping("/add/drug/{request}{id-drug-treatment}")
    fun saveDrug( @RequestBody drug:Drug, @Parameter( description = "ИД мед. лечения", example = "1" ) idDrugTreatment:Long ):ResponseEntity<Drug>
}