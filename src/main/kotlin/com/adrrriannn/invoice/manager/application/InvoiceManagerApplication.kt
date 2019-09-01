package com.adrrriannn.invoice.manager.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InvoiceManagerApplication

fun main(args: Array<String>) {
	runApplication<InvoiceManagerApplication>(*args)
}
