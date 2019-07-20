package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.AddressDto
import com.adrrriannn.invoice.manager.entity.Address
import org.junit.Test

import org.junit.Assert.*

class AddressMapperImplTest {

    private val addressMapperImpl = AddressMapperImpl()

    private val firstLineAddress = "Customer Address"
    private val secondLineAddress = "Customer Address"
    private val city = "city"
    private val country = "country"
    private val postcode = "postcode"

    private val address = Address(1, firstLineAddress, secondLineAddress, postcode, city, country)
    private val addressDto = AddressDto(1, firstLineAddress, secondLineAddress, postcode, city, country)

    @Test
    fun map_to_dto() {
        val mappedAddress = addressMapperImpl.map(address)
        assertEquals(addressDto, mappedAddress)
    }

    @Test
    fun map_to_entity() {
        val mappedAddress = addressMapperImpl.map(addressDto)

        assertEquals(address, mappedAddress)
    }
}