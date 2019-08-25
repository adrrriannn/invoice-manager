package com.adrrriannn.invoice.manager.controller

import com.adrrriannn.invoice.manager.dto.InvoiceDto
import com.adrrriannn.invoice.manager.filter.InvoiceSearchFilter
import com.adrrriannn.invoice.manager.service.InvoiceService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoices")
@CrossOrigin("http://localhost:3000")
class InvoiceController(private val invoiceService: InvoiceService) {

    @PostMapping
    fun create(@RequestBody invoiceDto: InvoiceDto): InvoiceDto = invoiceService.createInvoice(invoiceDto)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): InvoiceDto = invoiceService.get(id)

    @GetMapping
    fun getAll(): List<InvoiceDto> = invoiceService.getInvoicesByFilter(InvoiceSearchFilter())

}
