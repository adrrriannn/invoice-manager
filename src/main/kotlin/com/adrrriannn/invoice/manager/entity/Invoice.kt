package com.adrrriannn.invoice.manager.entity

import javax.persistence.*

@Entity
@Table(name = "invoice")
data class Invoice(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long?, @JoinColumn @ManyToOne(cascade = [CascadeType.ALL]) val customer: Customer, @JoinColumn @OneToMany(cascade = [CascadeType.ALL])  val items: List<InvoiceItem>)
