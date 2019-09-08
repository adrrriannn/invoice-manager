package com.adrrriannn.invoice.manager.stub.address

import com.adrrriannn.invoice.manager.config.Faker
import com.adrrriannn.invoice.manager.context.address.domain.Address
import com.adrrriannn.invoice.manager.stub.common.LongStub

object AddressStub {
    fun random(id: Long? = LongStub.random(),
               firstLine: String? = Faker.instance().address().streetName(),
               secondLine: String? = Faker.instance().address().streetAddressNumber(),
               postcode: String? = Faker.instance().address().zipCode(),
               city: String? = Faker.instance().address().city(),
               country: String? = Faker.instance().address().country()): Address {
        return Address(id = id,
                       firstLine = firstLine,
                       secondLine = secondLine,
                       postcode = postcode,
                       city = city,
                       country =  country)
    }

}
