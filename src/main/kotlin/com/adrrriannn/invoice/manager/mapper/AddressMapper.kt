package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.AddressDto
import com.adrrriannn.invoice.manager.entity.Address

interface AddressMapper {
    fun map(addressDto: AddressDto?): Address
    fun map(address: Address?): AddressDto
}
