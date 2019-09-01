package com.adrrriannn.invoice.manager.context.invoice.mapper

import com.adrrriannn.invoice.manager.context.customer.mapper.CustomerMapper
import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto
import com.adrrriannn.invoice.manager.context.invoice.domain.Invoice
import org.springframework.stereotype.Component

@Component
class InvoiceMapperImpl(val customerMapper: CustomerMapper, val invoiceItemMapper: InvoiceItemMapper): InvoiceMapper {

    override fun map(invoiceDto: InvoiceDto?): Invoice =
            Invoice(id = invoiceDto?.id,
                    customer = customerMapper.map(invoiceDto?.customer),
                    items = invoiceDto?.items?.map { invoiceItemMapper.map(it) })


    override fun map(invoice: Invoice?): InvoiceDto =
            InvoiceDto(id = invoice?.id,
                    customer = customerMapper.map(invoice?.customer),
                    items = invoice?.items?.map { item -> invoiceItemMapper.map(item) } ?: listOf())

}
