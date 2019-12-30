package com.adrrriannn.invoice.manager.context.truck.domain.map

import com.adrrriannn.invoice.manager.context.truck.domain.PlateNumber
import com.adrrriannn.invoice.manager.context.truck.domain.Truck
import com.adrrriannn.invoice.manager.context.truck.domain.TruckBrand
import com.adrrriannn.invoice.manager.context.truck.domain.TruckModel
import com.adrrriannn.invoice.manager.context.truck.infrastructure.TruckDto
import org.springframework.stereotype.Component

@Component
class TruckMapper {

    operator fun invoke(truckDto: TruckDto): Truck {
        return Truck(brand = TruckBrand(truckDto.brand),
                     model = TruckModel(truckDto.model),
                     plateNumber = PlateNumber(truckDto.plateNumber))
    }

    operator fun invoke(truck: Truck): TruckDto{
        return TruckDto(id = truck.id!!.asString(),
                        brand = truck.brand!!.name!!,
                        model = truck.model!!.name!!,
                        plateNumber = truck.plateNumber!!.value!!)
    }
}
