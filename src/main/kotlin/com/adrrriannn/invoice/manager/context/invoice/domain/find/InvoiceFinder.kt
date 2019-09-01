package com.adrrriannn.invoice.manager.context.invoice.domain.find

import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto

interface InvoiceFinder {
    operator fun invoke(id: Long): InvoiceDto
}
