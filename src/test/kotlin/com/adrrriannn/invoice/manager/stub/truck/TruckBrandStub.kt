package com.adrrriannn.invoice.manager.stub.truck

import com.adrrriannn.invoice.manager.config.Faker
import com.adrrriannn.invoice.manager.context.truck.domain.TruckBrand

object TruckBrandStub {
    fun random(): TruckBrand {
        return TruckBrand(name = Faker.instance().superhero().name())
    }

}
