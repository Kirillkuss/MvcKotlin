package com.itrail.mvckot.service

import com.itrail.mvckot.entity.RehabilitationSolution
import com.itrail.mvckot.repository.RehabilitationSolutionRepository
import org.springframework.stereotype.Service

@Service
class RehabilitationSolutionService( private val rehabilitationSolutionRepository: RehabilitationSolutionRepository ) {

    fun findAll():List<RehabilitationSolution>{
        return rehabilitationSolutionRepository.findAll()
    }

    fun findByName( name:String ):RehabilitationSolution{
        return rehabilitationSolutionRepository.findByName( name )
                                               .orElseThrow { throw IllegalArgumentException("Ребилитационное лечение c таким наименованием не существует") }
    }

    fun saveRehabilitationSolution( solution: RehabilitationSolution ):RehabilitationSolution{
        if( rehabilitationSolutionRepository.findByName( solution.name ).isPresent ) throw IllegalArgumentException("Ребилитационное лечение с таким наименованием уже существует")
        if( rehabilitationSolutionRepository.findById( solution.idRehabilitationSolution ).isPresent ) throw IllegalArgumentException("Ребилитационное лечение с таким ИД уже существует")
        return rehabilitationSolutionRepository.save( solution )
    }



}