package com.adrrriannn.invoice.manager.context.customer.mapper

import com.adrrriannn.invoice.manager.context.customer.dto.CustomerDto
import com.adrrriannn.invoice.manager.context.customer.domain.Customer

interface CustomerMapper {
    fun map(customerDto: CustomerDto?): Customer
    fun map(customer: Customer?): CustomerDto
}
