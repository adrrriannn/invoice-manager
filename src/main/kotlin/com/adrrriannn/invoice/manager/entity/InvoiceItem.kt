package com.adrrriannn.invoice.manager.entity

import javax.persistence.*

@Entity
@Table(name = "invoice_item")
data class InvoiceItem(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
                       @Column val description: String? = null,
                       @Column val amount: Double? = null,
                       @ManyToOne @JoinColumn(name="invoice_id") val invoice: Invoice? = null)