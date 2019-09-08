package com.adrrriannn.invoice.manager.stub.invoice

import com.adrrriannn.invoice.manager.context.customer.dto.CustomerDto
import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto
import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceItemDto
import com.adrrriannn.invoice.manager.stub.common.LongStub
import com.adrrriannn.invoice.manager.stub.customer.CustomerDtoStub

object InvoiceDtoStub {
    fun random(id: Long = LongStub.random(),
               customer: CustomerDto = CustomerDtoStub.random(),
               items: List<InvoiceItemDto> = InvoiceItemDtoStub.randomList()): InvoiceDto {
        return InvoiceDto(id, customer, items)
    }

}
