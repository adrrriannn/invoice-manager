package com.adrrriannn.invoice.manager.context.truck.domain

import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "truck")
data class Truck(@EmbeddedId val id: TruckId? = TruckId.create(),
                 @Column @Embedded val brand: TruckBrand? = null,
                 @Column @Embedded val model: TruckModel? = null,
                 @Column @Embedded val plateNumber: PlateNumber? = null)