package com.adrrriannn.invoice.manager.controller

import com.adrrriannn.invoice.manager.dto.AddressDto
import com.adrrriannn.invoice.manager.dto.CustomerDto
import com.adrrriannn.invoice.manager.dto.InvoiceDto
import com.adrrriannn.invoice.manager.dto.InvoiceItemDto
import com.adrrriannn.invoice.manager.service.InvoiceService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class InvoiceControllerTest {

    @Mock
    private lateinit var invoiceService: InvoiceService

    @InjectMocks
    private lateinit var invoiceController: InvoiceController

    private val invoiceId : Long = 1

    private val firstLineAddress = "Customer Address"
    private val secondLineAddress = "Customer Address"
    private val city = "city"
    private val country = "country"
    private val postcode = "postcode"

    private val address = AddressDto(1, firstLineAddress, secondLineAddress, postcode, city, country)

    private val customerDto = CustomerDto(1, "customerName", address)

    private val invoiceItem = InvoiceItemDto(1, "description", 345.23)

    private val invoiceDto = InvoiceDto(invoiceId, customerDto, listOf(invoiceItem))

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        doReturn(invoiceDto).`when`(invoiceService).createInvoice(invoiceDto)
        doReturn(invoiceDto).`when`(invoiceService).get(invoiceId)
    }

    @Test
    fun create_invoice() {
        var invoice = invoiceController.create(invoiceDto)
        assertEquals(invoiceDto, invoice)
        verify(invoiceService).createInvoice(invoiceDto)
    }

    @Test
    fun get_invoice() {
        var invoice = invoiceController.get(invoiceId)
        assertEquals(invoiceDto, invoice)
        verify(invoiceService).get(invoiceId)
    }
}