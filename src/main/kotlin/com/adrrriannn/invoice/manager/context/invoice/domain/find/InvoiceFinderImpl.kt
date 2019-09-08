package com.adrrriannn.invoice.manager.context.invoice.domain.find

import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto
import com.adrrriannn.invoice.manager.context.invoice.infrastructure.repository.InvoiceRepository
import com.adrrriannn.invoice.manager.context.invoice.mapper.InvoiceMapper
import org.springframework.stereotype.Service

@Service
class InvoiceFinderImpl(private val invoiceRepository: InvoiceRepository, private val invoiceMapper: InvoiceMapper) : InvoiceFinder {

    override fun invoke(id: Long): InvoiceDto {
        val invoice = invoiceRepository.findInvoiceById(id)?: throw InvoiceNotFoundException(id)

        return invoiceMapper.map(invoice)
    }

}
