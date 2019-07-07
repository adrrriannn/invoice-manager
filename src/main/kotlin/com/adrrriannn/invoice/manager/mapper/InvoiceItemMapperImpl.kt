package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.InvoiceItemDto
import com.adrrriannn.invoice.manager.entity.InvoiceItem
import org.springframework.stereotype.Component

@Component
class InvoiceItemMapperImpl: InvoiceItemMapper {
    override fun map(invoiceItemDto: InvoiceItemDto): InvoiceItem {
        return InvoiceItem(id = invoiceItemDto.id, description = invoiceItemDto.description, amount = invoiceItemDto.amount)
    }

    override fun map(invoiceItem: InvoiceItem): InvoiceItemDto {
        return InvoiceItemDto(id = invoiceItem.id, description = invoiceItem.description, amount = invoiceItem.amount)
    }

}
