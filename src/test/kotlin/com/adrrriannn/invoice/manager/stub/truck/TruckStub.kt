package com.adrrriannn.invoice.manager.stub.truck

import com.adrrriannn.invoice.manager.context.truck.domain.Truck
import com.adrrriannn.invoice.manager.context.truck.domain.TruckBrand
import com.adrrriannn.invoice.manager.context.truck.domain.TruckId
import com.adrrriannn.invoice.manager.context.truck.domain.TruckModel

object TruckStub {
    fun random(id: TruckId = TruckIdStub.random(),
               brand: TruckBrand = TruckBrandStub.random(),
               model: TruckModel = TruckModelStub.random()): Truck {
        return Truck(id = id, brand = brand, model = model)
    }

}
