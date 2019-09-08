package com.adrrriannn.invoice.manager.context.invoice.mapper

import com.adrrriannn.invoice.manager.stub.invoice.InvoiceItemDtoStub
import com.adrrriannn.invoice.manager.stub.invoice.InvoiceItemStub
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class InvoiceItemMapperImplTest {

    private val invoiceItemMapperImpl = InvoiceItemMapperImpl()

    @Test
    fun map_to_dto() {
        val invoiceItem = InvoiceItemStub.random()
        val result = invoiceItemMapperImpl.map(invoiceItem)

        assertThat(result.id).isEqualTo(invoiceItem.id)
        assertThat(result.description).isEqualTo(invoiceItem.description)
        assertThat(result.amount).isEqualTo(invoiceItem.amount)
    }

    @Test
    fun map_to_entity() {
        val invoiceItemDto = InvoiceItemDtoStub.random()
        val result = invoiceItemMapperImpl.map(invoiceItemDto)

        assertThat(result.id).isEqualTo(invoiceItemDto.id)
        assertThat(result.description).isEqualTo(invoiceItemDto.description)
        assertThat(result.amount).isEqualTo(invoiceItemDto.amount)
    }
}