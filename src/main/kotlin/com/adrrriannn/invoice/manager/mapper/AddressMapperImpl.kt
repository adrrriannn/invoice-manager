package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.AddressDto
import com.adrrriannn.invoice.manager.entity.Address

class AddressMapperImpl: AddressMapper {
    override fun map(addressDto: AddressDto): Address {
        return Address(addressDto.id,
                addressDto.firstLineAddress,
                addressDto.secondLineAddress,
                addressDto.postcode,
                addressDto.city,
                addressDto.country)
    }

    override fun map(address: Address): AddressDto {
        return AddressDto(address.id,
                address.firstLineAddress,
                address.secondLineAddress,
                address.postcode,
                address.city,
                address.country)
    }
}