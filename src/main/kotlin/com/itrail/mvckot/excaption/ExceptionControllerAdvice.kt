package com.itrail.mvckot.excaption

import com.itrail.mvckot.response.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler
    fun handNoSuchElementException( ex: NoSuchElementException ):ResponseEntity<BaseResponse>{
        return  ResponseEntity( BaseResponse( 404, ex.localizedMessage ), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handException( ex: Exception ):ResponseEntity<BaseResponse>{
        ex.printStackTrace(System.err)
        return  ResponseEntity( BaseResponse( 500, ex.localizedMessage ), HttpStatus.INTERNAL_SERVER_ERROR )
    }

    @ExceptionHandler
    fun hundIlligalArgumentException( ex: IllegalArgumentException ):ResponseEntity<BaseResponse>{
        return ResponseEntity( BaseResponse( 400, ex.localizedMessage), HttpStatus.BAD_REQUEST )
    }
}