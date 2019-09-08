package com.adrrriannn.invoice.manager.context.invoice.domain.find

class InvoiceNotFoundException(id: Long) : RuntimeException("Invoice not found for id: $id")
