package com.adrrriannn.invoice.manager.context.address.mapper

import com.adrrriannn.invoice.manager.stub.address.AddressDtoStub
import com.adrrriannn.invoice.manager.stub.address.AddressStub
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class AddressMapperImplTest {

    private val addressMapperImpl = AddressMapperImpl()
    @Test
    fun map_to_dto() {

        val address = AddressStub.random()

        val mappedAddress = addressMapperImpl.map(address)
        assertThat(mappedAddress.id).isEqualTo(address.id)
        assertThat(mappedAddress.firstLine).isEqualTo(address.firstLine)
        assertThat(mappedAddress.secondLine).isEqualTo(address.secondLine)
        assertThat(mappedAddress.city).isEqualTo(address.city)
        assertThat(mappedAddress.postcode).isEqualTo(address.postcode)
        assertThat(mappedAddress.country).isEqualTo(address.country)
    }

    @Test
    fun map_to_entity() {
        val addressDto = AddressDtoStub.random()

        val mappedAddress = addressMapperImpl.map(addressDto)

        assertThat(mappedAddress.id).isEqualTo(addressDto.id)
        assertThat(mappedAddress.firstLine).isEqualTo(addressDto.firstLine)
        assertThat(mappedAddress.secondLine).isEqualTo(addressDto.secondLine)
        assertThat(mappedAddress.city).isEqualTo(addressDto.city)
        assertThat(mappedAddress.postcode).isEqualTo(addressDto.postcode)
        assertThat(mappedAddress.country).isEqualTo(addressDto.country)
    }
}