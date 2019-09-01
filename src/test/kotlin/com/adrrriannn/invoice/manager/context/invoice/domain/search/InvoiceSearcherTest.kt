package com.adrrriannn.invoice.manager.context.invoice.domain.search

import com.adrrriannn.invoice.manager.context.address.domain.Address
import com.adrrriannn.invoice.manager.context.address.dto.AddressDto
import com.adrrriannn.invoice.manager.context.customer.domain.Customer
import com.adrrriannn.invoice.manager.context.customer.dto.CustomerDto
import com.adrrriannn.invoice.manager.context.invoice.domain.Invoice
import com.adrrriannn.invoice.manager.context.invoice.domain.InvoiceItem
import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto
import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceItemDto
import com.adrrriannn.invoice.manager.context.invoice.infrastructure.repository.InvoiceRepository
import com.adrrriannn.invoice.manager.context.invoice.mapper.InvoiceMapper
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class InvoiceSearcherTest {
    @Mock
    private lateinit var invoiceRepository: InvoiceRepository

    @Mock
    private lateinit var invoiceMapper: InvoiceMapper

    @InjectMocks
    private lateinit var invoiceSearcher: InvoiceSearcherImpl
    
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
        Mockito.doReturn(invoice).`when`(invoiceRepository).save(invoice)
        Mockito.doReturn(invoice).`when`(invoiceRepository).findInvoiceById(invoiceId)
        Mockito.doReturn(invoice).`when`(invoiceMapper).map(invoiceDto)
        Mockito.doReturn(invoiceDto).`when`(invoiceMapper).map(invoice)
        Mockito.doReturn(listOf(invoice)).`when`(invoiceRepository).findAll()
    }

    @Test
    fun get_all_invoices() {

        var invoiceSearchFilter = InvoiceSearchFilter()

        val invoices = invoiceSearcher(invoiceSearchFilter)

        Assert.assertEquals(listOf(invoiceDto), invoices)
        Mockito.verify(invoiceRepository).findAll()
    }
}