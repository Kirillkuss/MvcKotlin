package com.itrail.mvckot

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition( info = Info(
    title = "API on Kotlin",
    version = "1.0.0",
    description = "API on Kotlin", contact = Contact( name = "Kirill"),
    termsOfService = "index"
))
class MvcKotApplication
    fun main(args: Array<String>) {
         val logger = LoggerFactory.getLogger(MvcKotApplication::class.java)
         runApplication<MvcKotApplication>(*args)
         logger.info( "MvcKotApplication START!")
    }
