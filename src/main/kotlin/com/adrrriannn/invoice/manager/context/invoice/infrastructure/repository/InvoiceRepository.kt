package com.adrrriannn.invoice.manager.context.invoice.infrastructure.repository

import com.adrrriannn.invoice.manager.context.invoice.domain.Invoice
import org.springframework.data.jpa.repository.JpaRepository

interface InvoiceRepository: JpaRepository<Invoice, Long> {

    fun findInvoiceById(id: Long): Invoice? = findById(id).orElse(null)
}
