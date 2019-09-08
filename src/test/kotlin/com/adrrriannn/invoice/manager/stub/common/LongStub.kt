package com.adrrriannn.invoice.manager.stub.common

import com.adrrriannn.invoice.manager.config.Faker


object LongStub {
    fun random(min: Long = 0, max: Long = Long.MAX_VALUE ) = Faker.instance().number().numberBetween(min, max)
}
