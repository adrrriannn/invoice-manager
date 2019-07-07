package com.adrrriannn.invoice.manager.service

import com.adrrriannn.invoice.manager.dto.InvoiceDto
import com.adrrriannn.invoice.manager.exception.InvoiceNotFoundException
import com.adrrriannn.invoice.manager.mapper.InvoiceMapper
import com.adrrriannn.invoice.manager.repository.InvoiceRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class InvoiceServiceImpl(private val invoiceMapper: InvoiceMapper, private val invoiceRepository: InvoiceRepository): InvoiceService {

    override fun get(id: Long): InvoiceDto {
        val invoice = invoiceRepository.findByIdOrNull(id) ?: throw InvoiceNotFoundException(id)

        return invoiceMapper.map(invoice)

    }

    override fun createInvoice(invoiceDto: InvoiceDto): InvoiceDto {

        return invoiceMapper.map(invoiceDto)
                .let { invoice ->  invoiceRepository.save(invoice) }
                .let { invoice -> invoiceMapper.map(invoice) }
    }

}
