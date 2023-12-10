package com.itrail.mvckot.controller

import com.itrail.mvckot.entity.RehabilitationSolution
import com.itrail.mvckot.rest.IRehabilitationSolution
import com.itrail.mvckot.service.RehabilitationSolutionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class RehabilitationSolutionController( private val rehabilitationSolutionService: RehabilitationSolutionService):IRehabilitationSolution {

    override fun getAllRehabilitationSolution(): ResponseEntity<List<RehabilitationSolution>> {
        return ResponseEntity( rehabilitationSolutionService.findAll(), HttpStatus.OK )
    }

    override fun findByName(name: String): ResponseEntity<RehabilitationSolution> {
        return ResponseEntity( rehabilitationSolutionService.findByName( name ), HttpStatus.OK )
    }

    override fun save(rehabilitationSolution: RehabilitationSolution): ResponseEntity<RehabilitationSolution> {
        return ResponseEntity( rehabilitationSolutionService.saveRehabilitationSolution( rehabilitationSolution ), HttpStatus.OK)
    }
}