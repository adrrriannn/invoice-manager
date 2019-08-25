package com.adrrriannn.invoice.manager.entity

import javax.persistence.*

@Entity
@Table(name = "address")
data class Address(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
                   @Column(name = "first_line") val firstLine: String? = null,
                   @Column(name = "second_line") val secondLine: String? = null,
                   @Column(name = "postcode") val postcode: String? = null,
                   @Column(name = "city") val city: String? = null,
                   @Column(name = "country") val country: String? = null)
