package com.glebus.pingus.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
internal class PingControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `ping controller works`() {
        mockMvc.perform(get("/api/ping"))
                .andExpect(status().is2xxSuccessful)
                .andExpect(content().string("pong"))
    }

}