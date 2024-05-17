package com.example.invoiceProyect.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "detail")
class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var quantity: Int = 0
    var price: Double? = null
    @Column(name = "subtotal")
    var subTotal: Double? = null
    @Column(name = "invoice_id")
    var invoiceId: Long? = null
    @Column(name = "product_id")
    var productId: Long? = null
}