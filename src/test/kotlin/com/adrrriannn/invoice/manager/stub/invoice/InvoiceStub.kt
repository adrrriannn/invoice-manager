package com.adrrriannn.invoice.manager.stub.invoice

import com.adrrriannn.invoice.manager.context.customer.domain.Customer
import com.adrrriannn.invoice.manager.context.invoice.domain.Invoice
import com.adrrriannn.invoice.manager.context.invoice.domain.InvoiceItem
import com.adrrriannn.invoice.manager.stub.common.LongStub
import com.adrrriannn.invoice.manager.stub.customer.CustomerStub

object InvoiceStub {
    fun random(id: Long = LongStub.random(),
               customer: Customer = CustomerStub.random(),
               items: List<InvoiceItem> = InvoiceItemStub.randomList()): Invoice {
        return Invoice(id, customer, items)
    }

}
