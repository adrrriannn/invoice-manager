package com.adrrriannn.invoice.manager.application.api.invoice

import com.adrrriannn.invoice.manager.context.invoice.domain.create.InvoiceCreator
import com.adrrriannn.invoice.manager.context.invoice.domain.find.InvoiceFinder
import com.adrrriannn.invoice.manager.context.invoice.dto.InvoiceDto
import com.adrrriannn.invoice.manager.context.invoice.domain.search.InvoiceSearchFilter
import com.adrrriannn.invoice.manager.context.invoice.domain.search.InvoiceSearcher
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoices")
@CrossOrigin("http://localhost:3000")
class InvoiceController(val invoiceCreator: InvoiceCreator, val invoiceFinder: InvoiceFinder, val invoiceSearcher: InvoiceSearcher) {

    @PostMapping
    fun create(@RequestBody invoiceDto: InvoiceDto): InvoiceDto = invoiceCreator(invoiceDto)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): InvoiceDto = invoiceFinder(id)

    @PostMapping("/search")
    fun getAll(@RequestBody(required = false) filter: InvoiceSearchFilter? = InvoiceSearchFilter()): List<InvoiceDto> = invoiceSearcher(filter!!)

}
