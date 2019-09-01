package com.adrrriannn.invoice.manager.context.invoice.mapper

import com.adrrriannn.invoice.manager.context.customer.mapper.CustomerMapper
import com.adrrriannn.invoice.manager.context.address.dto.AddressDto
import com.adrrriannn.invoice.manager.context.customer.dto.CustomerDto
import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto
import com.adrrriannn.invoice.manager.context.invoice.mapper.InvoiceItemMapper
import com.adrrriannn.invoice.manager.context.invoice.mapper.InvoiceMapperImpl
import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceItemDto
import com.adrrriannn.invoice.manager.context.address.domain.Address
import com.adrrriannn.invoice.manager.context.customer.domain.Customer
import com.adrrriannn.invoice.manager.context.invoice.domain.Invoice
import com.adrrriannn.invoice.manager.context.invoice.domain.InvoiceItem
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations

class InvoiceMapperImplTest {

    @Mock
    private lateinit var customerMapper: CustomerMapper

    @Mock
    private lateinit var invoiceItemMapper: InvoiceItemMapper

    @InjectMocks
    private lateinit var invoiceMapperImpl: InvoiceMapperImpl

    private val invoiceId : Long = 1

    private val customerName = "customerName"
    private val description = "description"
    private val otherDescription = "other description"

    private val firstLineAddress = "Customer Address"
    private val secondLineAddress = "Customer Address"
    private val city = "city"
    private val country = "country"
    private val postcode = "postcode"

    private val address = Address(1, firstLineAddress, secondLineAddress, postcode, city, country)

    private val addressDto = AddressDto(1, firstLineAddress, secondLineAddress, postcode, city, country)

    private val customer = Customer(1, customerName, address)

    private val amount = 345.23
    private val otherAmount = 288.8

    private val invoiceItem = InvoiceItem(1, description, amount)
    private val otherInvoiceItem = InvoiceItem(2, otherDescription, otherAmount)

    private val invoice = Invoice(invoiceId, customer, listOf(invoiceItem, otherInvoiceItem))

    private val customerDto = CustomerDto(1, customerName, addressDto)

    private val invoiceItemDto = InvoiceItemDto(1, description, amount)
    private val otherInvoiceItemDto = InvoiceItemDto(2, otherDescription, otherAmount)

    private val invoiceDto = InvoiceDto(invoiceId, customerDto, listOf(invoiceItemDto, otherInvoiceItemDto))

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        doReturn(customer).`when`(customerMapper).map(customerDto)
        doReturn(customerDto).`when`(customerMapper).map(customer)

        doReturn(invoiceItem).`when`(invoiceItemMapper).map(invoiceItemDto)
        doReturn(otherInvoiceItem).`when`(invoiceItemMapper).map(otherInvoiceItemDto)

        doReturn(invoiceItemDto).`when`(invoiceItemMapper).map(invoiceItem)
        doReturn(otherInvoiceItemDto).`when`(invoiceItemMapper).map(otherInvoiceItem)
    }

    @Test
    fun map_to_dto() {
        val mappedDto = invoiceMapperImpl.map(invoice)

        assertEquals(invoiceDto, mappedDto)
    }

    @Test
    fun map_to_entity() {
        val mappedEntity = invoiceMapperImpl.map(invoiceDto)

        assertEquals(invoice, mappedEntity)
    }

}