package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.InvoiceItemDto
import com.adrrriannn.invoice.manager.entity.InvoiceItem
import org.junit.Assert.assertEquals
import org.junit.Test

class InvoiceItemMapperImplTest {

    private val invoiceItemMapperImpl = InvoiceItemMapperImpl()
    private val description = "description"

    private val amount = 345.23

    private val invoiceItem = InvoiceItem(1, description, amount)

    private val invoiceItemDto = InvoiceItemDto(1, description, amount)

    @Test
    fun map_to_dto() {
        val mappedDto = invoiceItemMapperImpl.map(invoiceItem)

        assertEquals(invoiceItemDto, mappedDto)
    }

    @Test
    fun map_to_entity() {
        val mappedEntity = invoiceItemMapperImpl.map(invoiceItemDto)

        assertEquals(invoiceItem, mappedEntity)
    }
}