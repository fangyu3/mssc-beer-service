package com.fangyu3.msscbeerservice.service;

import com.fangyu3.msscbeerservice.Mappers.BeerMapper;
import com.fangyu3.msscbeerservice.domain.Beer;
import com.fangyu3.msscbeerservice.repositories.BeerRepository;
import com.fangyu3.msscbeerservice.web.controller.NotFoundException;
import com.fangyu3.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService{

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerMapper.beerToBeerDto(
//                beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
                beerRepository.findById(beerId).orElse(null));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        Beer savedBeer = beerRepository.save(beerMapper.BeerDtoToBeer(beerDto));
        return beerMapper.beerToBeerDto(savedBeer);
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
