package com.adrrriannn.invoice.manager.context.invoice.dto

import com.adrrriannn.invoice.manager.context.customer.dto.CustomerDto

data class InvoiceDto(val id: Long?,
                      val customer: CustomerDto?,
                      val items: List<InvoiceItemDto>)