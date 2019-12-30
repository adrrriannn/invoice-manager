package com.adrrriannn.invoice.manager.context.truck.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class PlateNumber(@Column(name = "plate_number") val value: String? = null)
