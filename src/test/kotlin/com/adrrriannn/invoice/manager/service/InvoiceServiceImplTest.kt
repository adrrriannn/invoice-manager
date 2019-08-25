package com.adrrriannn.invoice.manager.service

import com.adrrriannn.invoice.manager.dto.AddressDto
import com.adrrriannn.invoice.manager.dto.CustomerDto
import com.adrrriannn.invoice.manager.dto.InvoiceDto
import com.adrrriannn.invoice.manager.dto.InvoiceItemDto
import com.adrrriannn.invoice.manager.entity.Address
import com.adrrriannn.invoice.manager.entity.Customer
import com.adrrriannn.invoice.manager.entity.Invoice
import com.adrrriannn.invoice.manager.entity.InvoiceItem
import com.adrrriannn.invoice.manager.exception.InvoiceNotFoundException
import com.adrrriannn.invoice.manager.filter.InvoiceSearchFilter
import com.adrrriannn.invoice.manager.mapper.InvoiceMapper
import com.adrrriannn.invoice.manager.repository.InvoiceRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class InvoiceServiceImplTest {

    @Mock
    private lateinit var invoiceRepository: InvoiceRepository

    @Mock
    private lateinit var invoiceMapper: InvoiceMapper

    @InjectMocks
    private lateinit var invoiceServiceImpl : InvoiceServiceImpl

    private val invoiceId : Long = 1

    private val customerName = "customerName"
    private val description = "description"

    private val firstLineAddress = "Customer Address"
    private val secondLineAddress = "Customer Address"
    private val city = "city"
    private val country = "country"
    private val postcode = "postcode"

    private val address = Address(1, firstLineAddress, secondLineAddress, postcode, city, country)
    private val addressDto = AddressDto(1, firstLineAddress, secondLineAddress, postcode, city, country)

    private val customer = Customer(1, customerName, address)
    private val amount = 345.23

    private val invoiceItem = InvoiceItem(1, description, amount)
    private val invoice = Invoice(invoiceId, customer, listOf(invoiceItem))

    private val customerDto = CustomerDto(1, customerName, addressDto)
    private val invoiceItemDto = InvoiceItemDto(1, description, amount)
    private val invoiceDto = InvoiceDto(invoiceId, customerDto, listOf(invoiceItemDto))

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        doReturn(invoice).`when`(invoiceRepository).save(invoice)
        doReturn(invoice).`when`(invoiceRepository).findInvoiceById(invoiceId)
        doReturn(invoice).`when`(invoiceMapper).map(invoiceDto)
        doReturn(invoiceDto).`when`(invoiceMapper).map(invoice)
        doReturn(listOf(invoice)).`when`(invoiceRepository).findAll()
    }

    @Test
    fun create_invoice() {
        var createdInvoiceDto = invoiceServiceImpl.createInvoice(invoiceDto)

        assertEquals(invoiceDto, createdInvoiceDto)

        verify(invoiceMapper).map(invoiceDto)
        verify(invoiceMapper).map(invoice)
        verify(invoiceRepository).save(invoice)
    }

    @Test
    fun get_invoice() {
        doReturn(invoice).`when`(invoiceRepository).findInvoiceById(invoiceId)
        var foundInvoiceDto = invoiceServiceImpl.get(invoiceId)

        assertEquals(invoiceDto, foundInvoiceDto)

        verify(invoiceRepository).findInvoiceById(invoiceId)
        verify(invoiceMapper).map(invoice)

    }

    @Test(expected = InvoiceNotFoundException::class)
    fun get_invoice_not_found() {
        doReturn(null).`when`(invoiceRepository).findInvoiceById(invoiceId)
        invoiceServiceImpl.get(invoiceId)

        verify(invoiceRepository).findInvoiceById(invoiceId)
        verify(invoiceMapper).map(invoice)

    }

    @Test
    fun get_all_invoices() {

        var invoiceSearchFilter = InvoiceSearchFilter()

        val invoices = invoiceServiceImpl.getInvoicesByFilter(invoiceSearchFilter)

        assertEquals(listOf(invoiceDto), invoices)
        verify(invoiceRepository).findAll()
        var invoice = Invoice()
    }
}