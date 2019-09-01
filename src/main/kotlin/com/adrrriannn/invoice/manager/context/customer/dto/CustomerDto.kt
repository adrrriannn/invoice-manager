package com.adrrriannn.invoice.manager.context.customer.dto

import com.adrrriannn.invoice.manager.context.address.dto.AddressDto

data class CustomerDto(val id: Long?, val name: String?, val address: AddressDto?)
