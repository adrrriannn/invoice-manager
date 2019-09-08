package com.adrrriannn.invoice.manager.context.invoice.domain.find

import com.adrrriannn.invoice.manager.context.invoice.infrastructure.repository.InvoiceRepository
import com.adrrriannn.invoice.manager.context.invoice.mapper.InvoiceMapper
import com.adrrriannn.invoice.manager.stub.common.LongStub
import com.adrrriannn.invoice.manager.stub.invoice.InvoiceDtoStub
import com.adrrriannn.invoice.manager.stub.invoice.InvoiceStub
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class InvoiceFinderTest {
    private val invoiceRepository: InvoiceRepository = mockk()

    private val invoiceMapper: InvoiceMapper = mockk()

    private val invoiceFinder = InvoiceFinderImpl(invoiceRepository, invoiceMapper)

    @Test
    fun get_invoice() {
        val invoiceId = LongStub.random()
        val invoice = InvoiceStub.random()

        every { invoiceRepository.findInvoiceById(invoiceId) } returns invoice

        val invoiceDto = InvoiceDtoStub.random()
        every { invoiceMapper.map(invoice) } returns invoiceDto

        var result = invoiceFinder(invoiceId)


        assertThat(result).isEqualTo(invoiceDto)

        verify { invoiceRepository.findInvoiceById(invoiceId) }
        verify { invoiceMapper.map(invoice) }

    }

    @Test(expected = InvoiceNotFoundException::class)
    fun get_invoice_not_found() {
        val invoiceId = LongStub.random()
        every { invoiceRepository.findInvoiceById(invoiceId) } returns null

        invoiceFinder(invoiceId)
    }
}