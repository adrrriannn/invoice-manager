package com.adrrriannn.invoice.manager.context.invoice.mapper

import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto
import com.adrrriannn.invoice.manager.context.invoice.domain.Invoice

interface InvoiceMapper {
    fun map(invoiceDto: InvoiceDto?): Invoice
    fun map(invoice: Invoice?): InvoiceDto

}
