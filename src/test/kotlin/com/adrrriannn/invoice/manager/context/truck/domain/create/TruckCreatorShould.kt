package com.adrrriannn.invoice.manager.context.truck.domain.create

import com.adrrriannn.invoice.manager.config.verifyOnce
import com.adrrriannn.invoice.manager.context.truck.domain.map.TruckMapper
import com.adrrriannn.invoice.manager.context.truck.infrastructure.TruckRepository
import com.adrrriannn.invoice.manager.stub.truck.TruckDtoStub
import com.adrrriannn.invoice.manager.stub.truck.TruckStub
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class TruckCreatorShould {

    private val truckMapper: TruckMapper = mockk()
    private val truckRepository: TruckRepository = mockk()
    private val truckCreator = TruckCreator(truckRepository, truckMapper)

    @Test
    fun `create an truck`() {
        val truck = TruckStub.random()
        val truckDto = TruckDtoStub.random()

        every { truckMapper(truckDto) } returns truck
        every { truckRepository.save(truck) } returns truck
        every { truckMapper(truck) } returns truckDto

        truckCreator(truckDto)

        verifyOnce { truckRepository.save(truck) }
    }
}