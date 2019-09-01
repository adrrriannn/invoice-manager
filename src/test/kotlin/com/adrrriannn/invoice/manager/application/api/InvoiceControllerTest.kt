package com.adrrriannn.invoice.manager.application.api

import com.adrrriannn.invoice.manager.application.api.invoice.InvoiceController
import com.adrrriannn.invoice.manager.context.address.dto.AddressDto
import com.adrrriannn.invoice.manager.context.customer.dto.CustomerDto
import com.adrrriannn.invoice.manager.context.invoice.domain.create.InvoiceCreator
import com.adrrriannn.invoice.manager.context.invoice.domain.find.InvoiceFinder
import com.adrrriannn.invoice.manager.context.invoice.domain.search.InvoiceSearchFilter
import com.adrrriannn.invoice.manager.context.invoice.domain.search.InvoiceSearcher
import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto
import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceItemDto
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class InvoiceControllerTest {

    @Mock
    private lateinit var invoiceCreator: InvoiceCreator

    @Mock
    private lateinit var invoiceFinder: InvoiceFinder

    @Mock
    private lateinit var invoiceSearcher: InvoiceSearcher

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
    }

    @Test
    fun create_invoice() {
        doReturn(invoiceDto).`when`(invoiceCreator).invoke(invoiceDto)
        var invoice = invoiceController.create(invoiceDto)
        assertEquals(invoiceDto, invoice)
        verify(invoiceCreator).invoke(invoiceDto)
    }

    @Test
    fun get_invoice() {
        doReturn(invoiceDto).`when`(invoiceFinder).invoke(invoiceId)
        var invoice = invoiceController.get(invoiceId)
        assertEquals(invoiceDto, invoice)
        verify(invoiceFinder).invoke(invoiceId)
    }

    @Test
    fun get_all_invoices() {
        val filter = InvoiceSearchFilter()

        doReturn(listOf(invoiceDto)).`when`(invoiceSearcher).invoke(filter)

        var invoices = invoiceController.getAll(filter)
        assertEquals(listOf(invoiceDto), invoices)
        verify(invoiceSearcher).invoke(filter)
    }
}