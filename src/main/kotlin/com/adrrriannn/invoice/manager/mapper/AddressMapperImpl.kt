package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.AddressDto
import com.adrrriannn.invoice.manager.entity.Address
import org.springframework.stereotype.Component

@Component
class AddressMapperImpl: AddressMapper {
    override fun map(addressDto: AddressDto): Address {
        return Address(addressDto.id,
                addressDto.firstLine,
                addressDto.secondLine,
                addressDto.postcode,
                addressDto.city,
                addressDto.country)
    }

    override fun map(address: Address): AddressDto {
        return AddressDto(address.id,
                address.firstLine,
                address.secondLine,
                address.postcode,
                address.city,
                address.country)
    }
}