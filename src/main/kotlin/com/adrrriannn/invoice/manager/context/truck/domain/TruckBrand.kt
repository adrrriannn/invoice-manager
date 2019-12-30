package com.adrrriannn.invoice.manager.context.truck.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class TruckBrand(@Column(name = "brand") val name: String? = null)
