package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.CustomerDto
import com.adrrriannn.invoice.manager.entity.Customer

interface CustomerMapper {
    fun map(customerDto: CustomerDto): Customer
    fun map(customer: Customer): CustomerDto
}
