package com.adrrriannn.invoice.manager.context.invoice.domain.search

import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto

interface InvoiceSearcher {
    operator fun invoke(filter: InvoiceSearchFilter): List<InvoiceDto>
}
