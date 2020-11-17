package com.fangyu3.msscbeerservice.service;

import com.fangyu3.msscbeerservice.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface BeerService {
    public BeerDto getBeerById(UUID beerId);
}
