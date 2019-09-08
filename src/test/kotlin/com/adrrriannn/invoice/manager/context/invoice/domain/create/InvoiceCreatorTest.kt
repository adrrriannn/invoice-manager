package com.adrrriannn.invoice.manager.context.invoice.domain.create

import com.adrrriannn.invoice.manager.context.invoice.infrastructure.repository.InvoiceRepository
import com.adrrriannn.invoice.manager.context.invoice.mapper.InvoiceMapper
import com.adrrriannn.invoice.manager.stub.invoice.InvoiceDtoStub
import com.adrrriannn.invoice.manager.stub.invoice.InvoiceStub
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class InvoiceCreatorTest {

    private val invoiceRepository: InvoiceRepository = mockk()

    private val invoiceMapper: InvoiceMapper = mockk()

    private val invoiceCreator = InvoiceCreatorImpl(invoiceRepository, invoiceMapper)

    @Test
    fun create_invoice() {

        val invoiceDto = InvoiceDtoStub.random()
        val invoice = InvoiceStub.random()

        every { invoiceRepository.save(invoice) } returns invoice
        every { invoiceMapper.map(invoiceDto) } returns invoice
        every { invoiceMapper.map(invoice) } returns invoiceDto

        var result = invoiceCreator(invoiceDto)

        assertThat(result).isEqualTo(invoiceDto)

        verify(exactly = 1) { invoiceRepository.save(invoice) }
        verify(exactly = 1){ invoiceMapper.map(invoiceDto) }
        verify(exactly = 1) { invoiceMapper.map(invoice) }
    }
}