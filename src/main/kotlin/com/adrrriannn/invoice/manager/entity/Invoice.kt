package com.adrrriannn.invoice.manager.entity

data class Invoice(val id: Long, val customer: Customer, val items: List<InvoiceItem>) {

}
