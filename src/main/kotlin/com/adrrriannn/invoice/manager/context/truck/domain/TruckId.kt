package com.adrrriannn.invoice.manager.context.truck.domain

import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class TruckId(@Column(name = "id", columnDefinition = "uuid") val id: UUID = UUID.randomUUID()): Serializable {

    companion object {
        fun of(id: String): TruckId {
            return TruckId(UUID.fromString(id))
        }

        fun create(): TruckId {
            return TruckId()
        }
    }

    fun asString(): String {
        return id.toString()
    }
}