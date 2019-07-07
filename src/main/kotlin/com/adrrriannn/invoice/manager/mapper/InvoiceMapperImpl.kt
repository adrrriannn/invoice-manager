package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.InvoiceDto
import com.adrrriannn.invoice.manager.entity.Invoice
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class InvoiceMapperImpl(val customerMapper: CustomerMapper, val invoiceItemMapper: InvoiceItemMapper): InvoiceMapper {
    override fun map(invoiceDto: InvoiceDto): Invoice {
        return Invoice(
                id = invoiceDto.id,
                customer = customerMapper.map(invoiceDto.customer),
                items = invoiceDto.items.stream().map { item -> invoiceItemMapper.map(item) }.collect(Collectors.toList())
        )

    }

    override fun map(invoice: Invoice): InvoiceDto {
        return InvoiceDto(
                id = invoice.id,
                customer = customerMapper.map(invoice.customer),
                items = invoice.items.stream().map { item -> invoiceItemMapper.map(item) }.collect(Collectors.toList())
        )
    }

}
