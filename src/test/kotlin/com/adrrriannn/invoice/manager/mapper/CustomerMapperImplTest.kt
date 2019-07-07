package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.CustomerDto
import com.adrrriannn.invoice.manager.entity.Customer
import org.junit.Assert.assertEquals
import org.junit.Test

class CustomerMapperImplTest {

    private val customerMapperImpl = CustomerMapperImpl()

    private val customerName = "customerName"
    private val address = "Customer Address"

    private val customerDto = CustomerDto(1, customerName, address)
    private val customer = Customer(1, customerName, address)

    @Test
    fun map_to_dto() {
        val mappedDto = customerMapperImpl.map(customer)

        assertEquals(customerDto, mappedDto)
    }

    @Test
    fun map_to_entity() {
        val mappedEntity = customerMapperImpl.map(customerDto)

        assertEquals(customer, mappedEntity)
    }
}