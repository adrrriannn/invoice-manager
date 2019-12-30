package com.adrrriannn.invoice.manager.application.api.invoice

import com.adrrriannn.invoice.manager.application.api.invoice.InvoiceController
import com.adrrriannn.invoice.manager.context.invoice.domain.create.InvoiceCreator
import com.adrrriannn.invoice.manager.context.invoice.domain.find.InvoiceFinder
import com.adrrriannn.invoice.manager.context.invoice.domain.search.InvoiceSearcher
import com.adrrriannn.invoice.manager.stub.InvoiceSearchFilterStub
import com.adrrriannn.invoice.manager.stub.common.LongStub
import com.adrrriannn.invoice.manager.stub.invoice.InvoiceDtoStub
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class InvoiceControllerTest {

    private val invoiceCreator: InvoiceCreator = mockk()

    private val invoiceFinder: InvoiceFinder = mockk()

    private val invoiceSearcher: InvoiceSearcher = mockk()

    private val invoiceController: InvoiceController = InvoiceController(invoiceCreator, invoiceFinder, invoiceSearcher)

    @Test
    fun create_invoice() {
        val invoiceDto = InvoiceDtoStub.random()
        every { invoiceCreator(invoiceDto) } returns invoiceDto

        val result = invoiceController.create(invoiceDto)

        assertThat(result).isEqualTo(invoiceDto)

        verify(exactly = 1) {invoiceCreator(invoiceDto) }
    }

    @Test
    fun get_invoice() {
        val invoiceId = LongStub.random()
        val invoiceDto = InvoiceDtoStub.random()

        every { invoiceFinder(invoiceId) } returns invoiceDto

        val result = invoiceController.get(invoiceId)

        assertThat(result).isEqualTo(invoiceDto)
        verify(exactly = 1) { invoiceFinder(invoiceId) }
    }

    @Test
    fun get_all_invoices() {
        val filter = InvoiceSearchFilterStub.random()
        val invoiceDto = InvoiceDtoStub.random()
        every { invoiceSearcher(filter) } returns listOf(invoiceDto)

        val result = invoiceController.getAll(filter)
        assertThat(result).isEqualTo(listOf(invoiceDto))

        verify(exactly = 1) { invoiceSearcher(filter) }
    }
}