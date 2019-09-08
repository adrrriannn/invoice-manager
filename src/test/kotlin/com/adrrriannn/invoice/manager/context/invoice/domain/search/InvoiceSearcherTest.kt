package com.adrrriannn.invoice.manager.context.invoice.domain.search

import com.adrrriannn.invoice.manager.context.invoice.infrastructure.repository.InvoiceRepository
import com.adrrriannn.invoice.manager.context.invoice.mapper.InvoiceMapper
import com.adrrriannn.invoice.manager.stub.InvoiceSearchFilterStub
import com.adrrriannn.invoice.manager.stub.invoice.InvoiceDtoStub
import com.adrrriannn.invoice.manager.stub.invoice.InvoiceStub
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class InvoiceSearcherTest {
    private val invoiceRepository: InvoiceRepository = mockk()

    private val invoiceMapper: InvoiceMapper = mockk()

    private val invoiceSearcher = InvoiceSearcherImpl(invoiceRepository, invoiceMapper)
    
    @Test
    fun get_all_invoices() {

        val invoiceSearchFilter = InvoiceSearchFilterStub.random()

        val invoice = InvoiceStub.random()
        every { invoiceRepository.findAll() } returns listOf(invoice)

        val invoiceDto = InvoiceDtoStub.random()
        every { invoiceMapper.map(invoice) } returns invoiceDto

        val result = invoiceSearcher(invoiceSearchFilter)

        assertThat(result).isEqualTo(listOf(invoiceDto))

        verify(exactly = 1) { invoiceRepository.findAll() }
        verify(exactly = 1) { invoiceMapper.map(invoice) }

    }
}