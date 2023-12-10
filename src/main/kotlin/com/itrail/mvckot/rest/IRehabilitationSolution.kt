package com.itrail.mvckot.rest

import com.itrail.mvckot.entity.RehabilitationSolution
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

@RequestMapping( "rehabilitation-treatments")
@Tag(name = "9. Rehabilitation Treatment", description = "Справочник: Реабилитационное лечение")
@ApiResponses(value = [
    ApiResponse( responseCode = "200", description = "Успешно", content = [Content( mediaType = "application/json", schema = Schema(implementation =  RehabilitationSolution::class ))]),
    ApiResponse( responseCode = "400", description = "Плохой запрос", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))]),
    ApiResponse( responseCode = "500", description = "Ошибка сервера", content = [Content( mediaType = "application/json", schema = Schema(implementation =  BaseResponse::class ))])
])
interface IRehabilitationSolution {

    @GetMapping( "/all")
    @Operation( description = "Список всех реабилитационных лечений", summary = "Список всех Реабилитационных лечений")
    fun getAllRehabilitationSolution():ResponseEntity<List<RehabilitationSolution>>

    @GetMapping( "/find/{name}")
    @Operation( description = "Поиск по названию лечения", summary = "Поиск по названию лечения")
    fun findByName( @Parameter( description = "Наименование лечения")  name:String):ResponseEntity<RehabilitationSolution>

    @Operation( description = "Добавить способ лечения", summary = "Добавить способ лечения")
    @PostMapping( "/add/{solution}")
    fun save( @RequestBody rehabilitationSolution:RehabilitationSolution ):ResponseEntity<RehabilitationSolution>
}