package com.adrrriannn.invoice.manager.dto

data class AddressDto(val id: Long,
                      val firstLine: String,
                      val secondLine: String,
                      val postcode: String,
                      val city: String,
                      val country: String)
