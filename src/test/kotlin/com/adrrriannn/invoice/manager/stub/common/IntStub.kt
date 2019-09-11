package com.adrrriannn.invoice.manager.stub.common

import com.github.javafaker.Faker

object IntStub {
    fun random(min: Int = 0, max: Int = Int.MAX_VALUE ) = Faker.instance().number().numberBetween(min, max)
}
