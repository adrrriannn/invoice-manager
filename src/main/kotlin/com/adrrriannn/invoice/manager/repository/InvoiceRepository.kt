package com.adrrriannn.invoice.manager.repository

import com.adrrriannn.invoice.manager.entity.Invoice
import org.springframework.data.jpa.repository.JpaRepository

interface InvoiceRepository: JpaRepository<Invoice, Long> {

    fun findInvoiceById(id: Long): Invoice? = findById(id).orElse(null)
}
