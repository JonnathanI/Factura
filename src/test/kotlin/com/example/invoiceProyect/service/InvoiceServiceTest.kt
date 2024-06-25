package com.example.invoiceProyect.service

import com.example.invoiceProyect.model.Client
import com.example.invoiceProyect.model.Invoice
import com.example.invoiceProyect.repository.ClientRepository
import com.example.invoiceProyect.repository.InvoiceRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class InvoiceServiceTest {

    @InjectMocks
    lateinit var invoiceService: InvoiceService

    @Mock
    lateinit var invoiceRepository: InvoiceRepository

    @Mock
    lateinit var clientRepository: ClientRepository

    val jsonString = File("./src/test/resources/invoice.json").readText(Charsets.UTF_8)
    val invoiceMock = Gson().fromJson(jsonString, Invoice::class.java)

    val clientMock = Client().apply {
        id=1
        nui="0301707030"
        fullName="Juan"
        address= "Ceunca"
    }

    @Test
    fun saveInvoiceWhenIsCorrect(){
        Mockito.`when`(clientRepository.findById(invoiceMock.Client)).thenReturn(clientMock)
        Mockito.`when`(invoiceRepository.save(Mockito.any(Invoice::class.java))).thenReturn(invoiceMock)
        val actualResponse = invoiceService.save(invoiceMock)
        Assertions.assertEquals(actualResponse.id, invoiceMock.id)
    }



}
