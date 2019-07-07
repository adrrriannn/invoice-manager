package com.adrrriannn.invoice.manager.exception

import java.lang.RuntimeException

class InvoiceNotFoundException(id: Long) : RuntimeException(String.format(errorMessage, id)) {

    companion object {
        private const val errorMessage = "Invoice not found for id: %s"
    }

}
