package com.adrrriannn.invoice.manager.context.truck.domain.create

import com.adrrriannn.invoice.manager.context.truck.domain.map.TruckMapper
import com.adrrriannn.invoice.manager.context.truck.infrastructure.TruckDto
import com.adrrriannn.invoice.manager.context.truck.infrastructure.TruckRepository
import org.springframework.stereotype.Service

@Service
class TruckCreator(val truckRepository: TruckRepository, val truckMapper: TruckMapper) {
    operator fun invoke(truckDto: TruckDto): TruckDto {
        return truckMapper(truckDto)
                .also {truckRepository.save(it) }
                .let { truckMapper(it) }
    }

}
