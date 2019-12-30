package com.adrrriannn.invoice.manager.context.truck.infrastructure

import com.adrrriannn.invoice.manager.context.truck.domain.Truck

interface TruckRepository {
    fun save(truck: Truck): Truck

}
