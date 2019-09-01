package com.adrrriannn.invoice.manager.context.invoice.mapper

import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceItemDto
import com.adrrriannn.invoice.manager.context.invoice.domain.InvoiceItem

interface InvoiceItemMapper {
    fun map(invoiceItem: InvoiceItem?): InvoiceItemDto
    fun map(invoiceItemDto: InvoiceItemDto?): InvoiceItem
}
