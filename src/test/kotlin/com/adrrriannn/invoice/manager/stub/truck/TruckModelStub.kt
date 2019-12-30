package com.adrrriannn.invoice.manager.stub.truck

import com.adrrriannn.invoice.manager.config.Faker
import com.adrrriannn.invoice.manager.context.truck.domain.TruckModel

object TruckModelStub {
    fun random(): TruckModel {
        return TruckModel(name = Faker.instance().superhero().name())
    }

}
