package com.adrrriannn.invoice.manager.context.invoice.domain.create

import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto
import com.adrrriannn.invoice.manager.context.invoice.infrastructure.repository.InvoiceRepository
import com.adrrriannn.invoice.manager.context.invoice.mapper.InvoiceMapper
import org.springframework.stereotype.Service

@Service
class InvoiceCreatorImpl(private val invoiceRepository: InvoiceRepository, private val invoiceMapper: InvoiceMapper) : InvoiceCreator {
    override fun invoke(invoice: InvoiceDto): InvoiceDto {
        return invoiceMapper.map(invoice)
                .let { invoiceRepository.save(it) }
                .let { invoiceMapper.map(it) }
    }

}
