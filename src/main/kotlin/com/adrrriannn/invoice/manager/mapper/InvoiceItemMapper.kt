package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.InvoiceItemDto
import com.adrrriannn.invoice.manager.entity.InvoiceItem

interface InvoiceItemMapper {
    fun map(invoiceItem: InvoiceItem): InvoiceItemDto
    fun map(invoiceItemDto: InvoiceItemDto): InvoiceItem
}
