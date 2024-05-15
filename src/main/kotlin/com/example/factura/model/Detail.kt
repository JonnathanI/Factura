package com.example.factura.model

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
    @Column(name = "price", precision = 10 , scale = 2)
    var price: BigDecimal? = null
    @Column(name = "invoice_id")
    var invoiceId: String? = null
    @Column(name = "product_id")
    var productId: String? = null


}