package com.adrrriannn.invoice.manager.dto

data class InvoiceDto(val id: Long?, val customer: CustomerDto?, val items: List<InvoiceItemDto>)