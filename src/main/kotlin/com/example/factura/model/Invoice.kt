package com.example.factura.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.security.Timestamp

@Entity
@Table(name = "invoice")
class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    @Column(name = "code" , unique = true)
    var code: String? = null
    @Column(name = "create_at" , nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    var createAt: Timestamp? = null
    @Column(name = "total" , precision = 10 , scale = 2)
    var total: BigDecimal? = null
    @Column(name = "client_id")
    var clientId: Long? = null
}