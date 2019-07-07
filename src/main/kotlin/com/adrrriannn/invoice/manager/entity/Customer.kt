package com.adrrriannn.invoice.manager.entity

import javax.persistence.*

@Entity
@Table(name = "customer")
data class Customer(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long?, @Column val name: String, @Column val address: String)
