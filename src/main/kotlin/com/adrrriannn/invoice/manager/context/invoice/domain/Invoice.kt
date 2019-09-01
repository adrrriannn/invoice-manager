package com.adrrriannn.invoice.manager.context.invoice.domain

import com.adrrriannn.invoice.manager.context.customer.domain.Customer
import javax.persistence.*

@Entity
@Table(name = "invoice")
data class Invoice(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
                   @JoinColumn @ManyToOne(cascade = [CascadeType.ALL]) val customer: Customer? = null,
                   @OneToMany(cascade = [CascadeType.ALL], mappedBy = "invoice") val items: List<InvoiceItem>? = listOf())