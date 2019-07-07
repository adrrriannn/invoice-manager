package com.adrrriannn.invoice.manager.mapper

import com.adrrriannn.invoice.manager.dto.CustomerDto
import com.adrrriannn.invoice.manager.entity.Customer

class CustomerMapperImpl: CustomerMapper {
    override fun map(customerDto: CustomerDto): Customer {
        return Customer(id = customerDto.id, name = customerDto.name, address = customerDto.address)
    }

    override fun map(customer: Customer): CustomerDto {
        return CustomerDto(id = customer.id, name = customer.name, address = customer.address)
    }

}
