package com.adrrriannn.invoice.manager.exception

import java.lang.RuntimeException

class InvoiceNotFoundException(id: Long) : RuntimeException("Invoice not found for id: $id")
