package com.adrrriannn.invoice.manager.stub.truck

import com.adrrriannn.invoice.manager.context.truck.domain.TruckId

object TruckIdStub {
    fun random(): TruckId {
        return TruckId.create()
    }

}
