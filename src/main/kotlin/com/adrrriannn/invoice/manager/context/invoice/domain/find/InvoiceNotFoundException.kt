package com.adrrriannn.invoice.manager.context.invoice.domain.find

import java.lang.RuntimeException

class InvoiceNotFoundException(id: Long) : RuntimeException("Invoice not found for id: $id")
