package com.adrrriannn.invoice.manager.context.invoice.domain.create

import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto

interface InvoiceCreator {
    operator fun invoke(invoice: InvoiceDto): InvoiceDto
}
