package com.adrrriannn.invoice.manager.stub.invoice

import com.adrrriannn.invoice.manager.config.Faker
import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceItemDto
import com.adrrriannn.invoice.manager.stub.common.IntStub
import com.adrrriannn.invoice.manager.stub.common.LongStub
import com.adrrriannn.invoice.manager.stub.common.MoneyStub

object InvoiceItemDtoStub {
    fun random(id: Long = LongStub.random(),
               description: String = Faker.instance().superhero().name(),
               quantity: Int = IntStub.random(),
               amount: Double = MoneyStub.random()) : InvoiceItemDto {
        return InvoiceItemDto(id = id,
                description = description,
                quantity = quantity,
                price = amount)
    }

    fun randomList(min: Int = 1, max: Int = 100): List<InvoiceItemDto> {
        val invoiceItemDtoList = ArrayList<InvoiceItemDto>()
        repeat(Faker.instance().number().numberBetween(min, max)) {
            invoiceItemDtoList.add(random())
        }

        return invoiceItemDtoList
    }

}
