package com.adrrriannn.invoice.manager.stub.invoice

import com.adrrriannn.invoice.manager.config.Faker
import com.adrrriannn.invoice.manager.context.invoice.domain.InvoiceItem
import com.adrrriannn.invoice.manager.stub.common.IntStub
import com.adrrriannn.invoice.manager.stub.common.LongStub
import com.adrrriannn.invoice.manager.stub.common.MoneyStub

object InvoiceItemStub {
    fun random(id: Long = LongStub.random(),
               description: String = Faker.instance().superhero().name(),
               quantity: Int = IntStub.random(),
               price: Double = MoneyStub.random()) : InvoiceItem {
        return InvoiceItem(id = id,
                description = description,
                quantity = quantity,
                price = price)
    }

    fun randomList(min: Int = 1, max: Int = 100): List<InvoiceItem> {
        val invoiceItemList = ArrayList<InvoiceItem>()
        repeat(Faker.instance().number().numberBetween(min, max)) {
            invoiceItemList.add(random())
        }

        return invoiceItemList
    }
}
