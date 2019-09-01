package com.adrrriannn.invoice.manager.context.invoice.mapper

import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceItemDto
import com.adrrriannn.invoice.manager.context.invoice.domain.InvoiceItem
import org.springframework.stereotype.Component

@Component
class InvoiceItemMapperImpl: InvoiceItemMapper {
    override fun map(invoiceItemDto: InvoiceItemDto?): InvoiceItem = InvoiceItem(id = invoiceItemDto?.id,
            description = invoiceItemDto?.description,
            amount = invoiceItemDto?.amount)


    override fun map(invoiceItem: InvoiceItem?): InvoiceItemDto = InvoiceItemDto(id = invoiceItem?.id,
            description = invoiceItem?.description,
            amount = invoiceItem?.amount)

}
