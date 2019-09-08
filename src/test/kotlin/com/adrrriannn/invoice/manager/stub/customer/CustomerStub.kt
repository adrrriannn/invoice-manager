package com.adrrriannn.invoice.manager.stub.customer

import com.adrrriannn.invoice.manager.config.Faker
import com.adrrriannn.invoice.manager.context.address.domain.Address
import com.adrrriannn.invoice.manager.context.customer.domain.Customer
import com.adrrriannn.invoice.manager.stub.address.AddressStub
import com.adrrriannn.invoice.manager.stub.common.LongStub

object CustomerStub {
    fun random(id: Long = LongStub.random(),
               name: String = Faker.instance().superhero().name(),
               address:Address = AddressStub.random()): Customer {
        return Customer(id = id,
                        name = name,
                        address = address)
    }
}
