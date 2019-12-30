package com.adrrriannn.invoice.manager.context.truck.infrastructure

import com.fasterxml.jackson.annotation.JsonProperty

data class TruckDto(@JsonProperty(access = JsonProperty.Access.READ_ONLY) val id: String? = null,
                    val plateNumber: String,
                    val brand: String,
                    val model: String)
