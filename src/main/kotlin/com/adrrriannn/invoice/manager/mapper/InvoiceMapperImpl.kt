package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.InvoiceDto
import com.adrrriannn.invoice.manager.entity.Invoice
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
                       items = invoice?.items?.map { item -> invoiceItemMapper.map(item) }?: listOf())

}
