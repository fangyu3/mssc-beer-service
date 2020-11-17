package com.fangyu3.msscbeerservice.service;

import com.fangyu3.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

public class BeerServiceImpl implements BeerService{

    @Override
    public BeerDto getBeerById(UUID beerId) {

        // TODO: add data layer in future
        return BeerDto.builder()
                .id(beerId)
                .build();
    }
}
