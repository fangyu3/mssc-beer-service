package com.fangyu3.msscbeerservice.service;

import com.fangyu3.msscbeerservice.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService{

    @Override
    public BeerDto getBeerById(UUID beerId) {

        // TODO: add data layer in future
        return BeerDto.builder()
                .id(beerId)
                .build();
    }
}
