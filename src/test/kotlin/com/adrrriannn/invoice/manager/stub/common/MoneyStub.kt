package com.adrrriannn.invoice.manager.stub.common

import com.adrrriannn.invoice.manager.config.Faker

object MoneyStub {
    fun random(min: Int = 0, max: Int = Int.MAX_VALUE): Double {
        return Faker.instance().number().randomDouble(2, min, max)
    }
}
