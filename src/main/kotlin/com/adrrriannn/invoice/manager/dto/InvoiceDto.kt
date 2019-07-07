package com.adrrriannn.invoice.manager.dto

class InvoiceDto(val id: Long, val customerDto: CustomerDto, val items: List<InvoiceItemDto>)