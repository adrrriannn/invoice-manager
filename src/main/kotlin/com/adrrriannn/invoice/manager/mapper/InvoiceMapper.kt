package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.InvoiceDto
import com.adrrriannn.invoice.manager.entity.Invoice

interface InvoiceMapper {
    fun map(invoiceDto: InvoiceDto): Invoice
    fun map(invoice: Invoice): InvoiceDto

}
