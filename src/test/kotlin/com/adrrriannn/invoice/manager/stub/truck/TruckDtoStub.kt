package com.adrrriannn.invoice.manager.stub.truck

import com.adrrriannn.invoice.manager.config.Faker
import com.adrrriannn.invoice.manager.context.truck.infrastructure.TruckDto

object TruckDtoStub {

    fun random(plateNumber: String = Faker.instance().number().digits(10),
               brand: String = Faker.instance().superhero().name(),
               model: String = Faker.instance().superhero().name()): TruckDto {
        return TruckDto(plateNumber = plateNumber,
                        brand = brand,
                        model = model)
    }
}
