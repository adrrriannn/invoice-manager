package com.adrrriannn.invoice.manager.context.customer.mapper

import com.adrrriannn.invoice.manager.context.address.mapper.AddressMapper
import com.adrrriannn.invoice.manager.stub.address.AddressDtoStub
import com.adrrriannn.invoice.manager.stub.address.AddressStub
import com.adrrriannn.invoice.manager.stub.customer.CustomerDtoStub
import com.adrrriannn.invoice.manager.stub.customer.CustomerStub
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class CustomerMapperImplTest {

    private val addressMapper: AddressMapper = mockk()

    private val customerMapperImpl = CustomerMapperImpl(addressMapper)

    @Before
    fun setUp() {
    }

    @Test
    fun map_to_dto() {

        val address = AddressStub.random()
        val addressDto = AddressDtoStub.random()

        every { addressMapper.map(address) } returns addressDto

        val customer = CustomerStub.random(address = address)

        val result = customerMapperImpl.map(customer)

        assertThat(result.id).isEqualTo(customer.id)
        assertThat(result.name).isEqualTo(customer.name)
        assertThat(result.address).isEqualTo(addressDto)
    }

    @Test
    fun map_to_entity() {
        val addressDto = AddressDtoStub.random()
        val address = AddressStub.random()

        every { addressMapper.map(addressDto) } returns address

        val customerDto = CustomerDtoStub.random(address = addressDto)

        val result = customerMapperImpl.map(customerDto)

        assertThat(result.id).isEqualTo(customerDto.id)
        assertThat(result.name).isEqualTo(customerDto.name)
        assertThat(result.address).isEqualTo(address)
    }
}