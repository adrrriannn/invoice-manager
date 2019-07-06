package com.adrrriannn.invoice.manager.controller

import com.adrrriannn.invoice.manager.dto.InvoiceDto
import com.adrrriannn.invoice.manager.service.InvoiceService
import java.lang.UnsupportedOperationException

class InvoiceController(private val invoiceService: InvoiceService) {
    fun create(invoiceDto: InvoiceDto): InvoiceDto {
        return invoiceService.createInvoice(invoiceDto)
    }

    fun get(id: Int): InvoiceDto {
        return invoiceService.get(id)
    }


}
