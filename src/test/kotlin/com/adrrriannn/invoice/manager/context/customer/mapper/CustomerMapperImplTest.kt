package com.adrrriannn.invoice.manager.context.customer.mapper

import com.adrrriannn.invoice.manager.context.address.mapper.AddressMapper
import com.adrrriannn.invoice.manager.context.customer.mapper.CustomerMapperImpl
import com.adrrriannn.invoice.manager.context.address.dto.AddressDto
import com.adrrriannn.invoice.manager.context.customer.dto.CustomerDto
import com.adrrriannn.invoice.manager.context.address.domain.Address
import com.adrrriannn.invoice.manager.context.customer.domain.Customer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations

class CustomerMapperImplTest {

    @Mock
    private lateinit var addressMapper: AddressMapper

    @InjectMocks
    private lateinit var customerMapperImpl: CustomerMapperImpl

    private val customerName = "customerName"
    private val firstLineAddress = "Customer Address"
    private val secondLineAddress = "Customer Address"
    private val city = "city"
    private val country = "country"
    private val postcode = "postcode"

    private val address = Address(1, firstLineAddress, secondLineAddress, postcode, city, country)

    private val addressDto = AddressDto(1, firstLineAddress, secondLineAddress, postcode, city, country)

    private val customerDto = CustomerDto(1, customerName, addressDto)
    private val customer = Customer(1, customerName, address)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        doReturn(address).`when`(addressMapper).map(addressDto)
        doReturn(addressDto).`when`(addressMapper).map(address)
    }

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