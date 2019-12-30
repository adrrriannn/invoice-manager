package com.adrrriannn.invoice.manager.context.truck.domain.find

import com.adrrriannn.invoice.manager.context.truck.domain.TruckId
import com.adrrriannn.invoice.manager.context.truck.infrastructure.TruckDto
import org.springframework.stereotype.Service

@Service
class TruckFinder {

    operator fun invoke(truckId: TruckId): TruckDto {
        throw UnsupportedOperationException()
    }
}
