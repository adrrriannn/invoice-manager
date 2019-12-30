package com.adrrriannn.invoice.manager.context.invoice.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class InvoiceItemDto(@JsonProperty(access = JsonProperty.Access.READ_ONLY) val id: Long?,
                          val description: String?,
                          val price: Double?,
                          val quantity: Int?)
