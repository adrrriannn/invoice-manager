package com.adrrriannn.invoice.manager.context.customer.mapper

import com.adrrriannn.invoice.manager.context.address.mapper.AddressMapper
import com.adrrriannn.invoice.manager.context.customer.dto.CustomerDto
import com.adrrriannn.invoice.manager.context.customer.domain.Customer
import org.springframework.stereotype.Component

@Component
class CustomerMapperImpl(private val addressMapper: AddressMapper): CustomerMapper {
    override fun map(customerDto: CustomerDto?): Customer = Customer(id = customerDto?.id,
            name = customerDto?.name,
            address = addressMapper.map(customerDto?.address))

    override fun map(customer: Customer?): CustomerDto = CustomerDto(id = customer?.id,
            name = customer?.name,
            address = addressMapper.map(customer?.address))

}
