package com.adrrriannn.invoice.manager.context.invoice.domain.search

import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto
import com.adrrriannn.invoice.manager.context.invoice.infrastructure.repository.InvoiceRepository
import com.adrrriannn.invoice.manager.context.invoice.mapper.InvoiceMapper

class InvoiceSearcherImpl(private val invoiceRepository: InvoiceRepository, private val invoiceMapper: InvoiceMapper) : InvoiceSearcher {

    override fun invoke(filter: InvoiceSearchFilter): List<InvoiceDto> {
        return invoiceRepository.findAll()
                .map { invoiceMapper.map(it) }
    }

}
