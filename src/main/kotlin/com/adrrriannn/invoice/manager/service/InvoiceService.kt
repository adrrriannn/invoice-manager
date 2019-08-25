package com.adrrriannn.invoice.manager.service

import com.adrrriannn.invoice.manager.dto.InvoiceDto
import com.adrrriannn.invoice.manager.filter.InvoiceSearchFilter

interface InvoiceService {
    fun createInvoice(invoiceDto: InvoiceDto): InvoiceDto
    fun get(id: Long): InvoiceDto
    fun getInvoicesByFilter(invoiceSearchFilter: InvoiceSearchFilter): List<InvoiceDto>
}
