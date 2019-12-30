package com.adrrriannn.invoice.manager.application.api.truck

import com.adrrriannn.invoice.manager.config.verifyOnce
import com.adrrriannn.invoice.manager.context.truck.domain.create.TruckCreator
import com.adrrriannn.invoice.manager.context.truck.domain.find.TruckFinder
import com.adrrriannn.invoice.manager.stub.truck.TruckDtoStub
import com.adrrriannn.invoice.manager.stub.truck.TruckIdStub
import com.adrrriannn.invoice.manager.stub.truck.TruckStub
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class TruckControllerShould {


    private val truckFinder: TruckFinder = mockk()
    private val truckCreator: TruckCreator = mockk()
    private val truckController = TruckController(truckCreator, truckFinder)


    @Test
    fun `create a new truck`() {
        val truckDto = TruckDtoStub.random()

        every { truckCreator(truckDto) } returns truckDto

        truckController.create(truckDto)

        verifyOnce { truckCreator(truckDto) }
    }

    @Test
    fun `find truck by id`() {
        val truckId = TruckIdStub.random()
        val truckDto = TruckDtoStub.random()
        every { truckFinder(truckId) } returns truckDto

        val foundTruck = truckController.getTruck(truckId.asString())

        assertThat(foundTruck).isEqualTo(truckDto)

        verifyOnce { truckFinder(truckId) }
    }
}