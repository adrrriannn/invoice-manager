package com.adrrriannn.invoice.manager.stub.invoice

import com.adrrriannn.invoice.manager.config.Faker
import com.adrrriannn.invoice.manager.context.invoice.domain.InvoiceItem
import com.adrrriannn.invoice.manager.stub.common.LongStub
import com.adrrriannn.invoice.manager.stub.common.MoneyStub

object InvoiceItemStub {
    fun random(id: Long = LongStub.random(),
               description: String = Faker.instance().superhero().name(),
               amount: Double = MoneyStub.random()) : InvoiceItem {
        return InvoiceItem(id, description, amount)
    }

    fun randomList(min: Int = 1, max: Int = 100): List<InvoiceItem> {
        val invoiceItemList = ArrayList<InvoiceItem>()
        repeat(Faker.instance().number().numberBetween(min, max)) {
            invoiceItemList.add(random())
        }

        return invoiceItemList
    }
}
