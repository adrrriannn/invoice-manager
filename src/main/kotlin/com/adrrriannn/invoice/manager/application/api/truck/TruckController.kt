package com.adrrriannn.invoice.manager.application.api.truck

import com.adrrriannn.invoice.manager.context.truck.domain.TruckId
import com.adrrriannn.invoice.manager.context.truck.domain.create.TruckCreator
import com.adrrriannn.invoice.manager.context.truck.domain.find.TruckFinder
import com.adrrriannn.invoice.manager.context.truck.infrastructure.TruckDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/trucks")
class TruckController(val truckCreator: TruckCreator, val truckFinder: TruckFinder) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody truckDto: TruckDto) {
        truckCreator(truckDto)
    }

    fun getTruck(id: String): TruckDto {
        return truckFinder(TruckId.of(id))
    }

}
