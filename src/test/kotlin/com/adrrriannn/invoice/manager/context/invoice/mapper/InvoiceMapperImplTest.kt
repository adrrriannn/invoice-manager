package com.adrrriannn.invoice.manager.context.invoice.mapper

import com.adrrriannn.invoice.manager.context.customer.mapper.CustomerMapper
import com.adrrriannn.invoice.manager.stub.customer.CustomerDtoStub
import com.adrrriannn.invoice.manager.stub.customer.CustomerStub
import com.adrrriannn.invoice.manager.stub.invoice.InvoiceDtoStub
import com.adrrriannn.invoice.manager.stub.invoice.InvoiceItemDtoStub
import com.adrrriannn.invoice.manager.stub.invoice.InvoiceItemStub
import com.adrrriannn.invoice.manager.stub.invoice.InvoiceStub
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class InvoiceMapperImplTest {

    private val customerMapper: CustomerMapper = mockk()

    private val invoiceItemMapper: InvoiceItemMapper = mockk()

    private val invoiceMapperImpl = InvoiceMapperImpl(customerMapper, invoiceItemMapper)

    @Test
    fun map_to_dto() {
        val customer = CustomerStub.random()
        val invoiceItem = InvoiceItemStub.random()
        val invoice = InvoiceStub.random(customer = customer, items = listOf(invoiceItem))

        val invoiceItemDto = InvoiceItemDtoStub.random()
        every { invoiceItemMapper.map(invoiceItem) } returns invoiceItemDto

        val customerDto = CustomerDtoStub.random()
        every { customerMapper.map(customer) } returns customerDto

        val result = invoiceMapperImpl.map(invoice)

        assertThat(result.id).isEqualTo(invoice.id)
        assertThat(result.customer).isEqualTo(customerDto)
        assertThat(result.items).isEqualTo(listOf(invoiceItemDto))

        verify(exactly = 1) { customerMapper.map(customer) }
        verify(exactly = 1) { invoiceItemMapper.map(invoiceItem) }
    }

    @Test
    fun map_to_entity() {
        val customerDto = CustomerDtoStub.random()
        val invoiceItemDto = InvoiceItemDtoStub.random()
        val invoiceDto = InvoiceDtoStub.random(customer = customerDto, items = listOf(invoiceItemDto))

        val invoiceItem = InvoiceItemStub.random()
        every { invoiceItemMapper.map(invoiceItemDto) } returns invoiceItem

        val customer = CustomerStub.random()
        every { customerMapper.map(customerDto) } returns customer

        val result = invoiceMapperImpl.map(invoiceDto)

        assertThat(result.id).isEqualTo(invoiceDto.id)
        assertThat(result.customer).isEqualTo(customer)
        assertThat(result.items).isEqualTo(listOf(invoiceItem))

        verify(exactly = 1) { customerMapper.map(customerDto) }
        verify(exactly = 1) { invoiceItemMapper.map(invoiceItemDto) }
    }

}