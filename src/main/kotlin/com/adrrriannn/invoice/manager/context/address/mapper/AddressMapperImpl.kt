package com.adrrriannn.invoice.manager.context.address.mapper

import com.adrrriannn.invoice.manager.context.address.dto.AddressDto
import com.adrrriannn.invoice.manager.context.address.domain.Address
import org.springframework.stereotype.Component

@Component
class AddressMapperImpl: AddressMapper {
    override fun map(addressDto: AddressDto?): Address = Address(id = addressDto?.id,
            firstLine = addressDto?.firstLine,
            secondLine = addressDto?.secondLine,
            postcode = addressDto?.postcode,
            city = addressDto?.city,
            country = addressDto?.country)

    override fun map(address: Address?): AddressDto = AddressDto(id = address?.id,
            firstLine = address?.firstLine,
            secondLine = address?.secondLine,
            postcode = address?.postcode,
            city = address?.city,
            country = address?.country)
}