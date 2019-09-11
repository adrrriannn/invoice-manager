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
        assertThat(result.quantity).isEqualTo(invoiceItem.quantity)
        assertThat(result.price).isEqualTo(invoiceItem.price)
    }

    @Test
    fun map_to_entity() {
        val invoiceItemDto = InvoiceItemDtoStub.random()
        val result = invoiceItemMapperImpl.map(invoiceItemDto)

        assertThat(result.id).isEqualTo(invoiceItemDto.id)
        assertThat(result.description).isEqualTo(invoiceItemDto.description)
        assertThat(result.quantity).isEqualTo(invoiceItemDto.quantity)
        assertThat(result.price).isEqualTo(invoiceItemDto.price)
    }
}