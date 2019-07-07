package com.adrrriannn.invoice.manager.service

import com.adrrriannn.invoice.manager.dto.InvoiceDto

interface InvoiceService {
    fun createInvoice(invoiceDto: InvoiceDto): InvoiceDto
    fun get(id: Long): InvoiceDto
}
