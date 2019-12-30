package com.adrrriannn.invoice.manager.context.truck.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class TruckModel(@Column(name = "model") val name: String? = null)
