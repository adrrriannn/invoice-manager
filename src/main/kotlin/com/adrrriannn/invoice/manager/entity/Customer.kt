package com.adrrriannn.invoice.manager.entity

import javax.persistence.*

@Entity
@Table(name = "customer")
data class Customer(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
                    @Column val name: String? = null,
                    @JoinColumn @ManyToOne val address: Address? = null)

