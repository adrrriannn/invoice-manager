package com.adrrriannn.invoice.manager.entity

import javax.persistence.*

@Entity
@Table(name = "address")
data class Address(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,
                   @Column(name = "first_line") val firstLine: String,
                   @Column(name = "second_line") val secondLine: String,
                   @Column(name = "postcode") val postcode: String,
                   @Column(name = "city") val city: String,
                   @Column(name = "country") val country: String)
