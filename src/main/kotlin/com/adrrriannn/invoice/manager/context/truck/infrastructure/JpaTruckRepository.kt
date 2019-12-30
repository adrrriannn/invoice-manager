package com.adrrriannn.invoice.manager.context.truck.infrastructure

import com.adrrriannn.invoice.manager.context.truck.domain.Truck
import com.adrrriannn.invoice.manager.context.truck.domain.TruckId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
class JpaTruckRepositoryImpl internal constructor(private val jpaTruckRepository: JpaTruckPersistenceRepository): TruckRepository {
    override fun save(truck: Truck): Truck {
        return jpaTruckRepository.save(truck)
    }

}

@Repository
internal interface JpaTruckPersistenceRepository: JpaRepository<Truck, TruckId>