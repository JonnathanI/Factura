package com.example.invoiceProyect.service

import com.example.invoiceProyect.model.Client
import com.example.invoiceProyect.repository.ClientRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ClientServiceTest {

    @InjectMocks
    lateinit var clientService: ClientService // clase que se va a probar

    @Mock   // objeto simulado
    lateinit var clientRepository: ClientRepository

    val clientMock = Client().apply {
        id = 1
        nui = "0301707030"
        fullName = "Juan"
        address = "Cuenca"
    }

    @Test
    fun saveClientCorrect() {
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.save(clientMock)
        assertEquals(response.id, clientMock.id)
    }

    @Test
    fun saveClientWhenFullNameIsBlank() {
        assertThrows(Exception::class.java) {
            clientMock.apply { fullName = " " }
            Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
            clientService.save(clientMock)
        }
    }
}
