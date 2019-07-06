package com.adrrriannn.invoice.manager.controller

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

    private val invoiceId : Int = 1

    private val customerDto = CustomerDto(1, "customerName", "Customer Address")

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