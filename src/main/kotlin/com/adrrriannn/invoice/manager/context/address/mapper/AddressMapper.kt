package com.adrrriannn.invoice.manager.context.address.mapper

import com.adrrriannn.invoice.manager.context.address.dto.AddressDto
import com.adrrriannn.invoice.manager.context.address.domain.Address

interface AddressMapper {
    fun map(addressDto: AddressDto?): Address
    fun map(address: Address?): AddressDto
}
