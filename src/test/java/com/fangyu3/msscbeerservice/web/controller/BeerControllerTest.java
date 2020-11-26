package com.fangyu3.msscbeerservice.web.controller;

import com.fangyu3.msscbeerservice.service.BeerService;
import com.fangyu3.msscbeerservice.web.model.BeerDto;
import com.fangyu3.msscbeerservice.web.model.BeerStyleEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    private BeerDto beerDto;

    @BeforeEach
    private void setup() {
        beerDto = BeerDto.builder()
                        .beerName("Galaxy Cat")
                        .beerStyle(BeerStyleEnum.ALE)
                        .price(100.0)
                        .upc(123123123123L)
                        .build();
    }


    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());

    }

    @Test
    void saveNewBeer() throws Exception {

        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {

        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }
}