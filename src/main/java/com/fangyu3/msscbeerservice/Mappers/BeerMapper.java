package com.fangyu3.msscbeerservice.Mappers;

import com.fangyu3.msscbeerservice.domain.Beer;
import com.fangyu3.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses={DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto beerDto);
}
