package com.adrrriannn.invoice.manager.stub.customer

import com.adrrriannn.invoice.manager.config.Faker
import com.adrrriannn.invoice.manager.context.address.dto.AddressDto
import com.adrrriannn.invoice.manager.context.customer.dto.CustomerDto
import com.adrrriannn.invoice.manager.stub.address.AddressDtoStub
import com.adrrriannn.invoice.manager.stub.common.LongStub

object CustomerDtoStub {
    fun random(id: Long = LongStub.random(),
               name: String = Faker.instance().superhero().name(),
               address: AddressDto = AddressDtoStub.random()): CustomerDto {
        return CustomerDto(id = id,
                name = name,
                address = address)
    }
}
