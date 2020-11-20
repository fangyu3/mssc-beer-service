package com.fangyu3.msscbeerservice.bootstrap;


import com.fangyu3.msscbeerservice.domain.Beer;
import com.fangyu3.msscbeerservice.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// This class will run everytime spring context starts
@Component
public class BeerLoader implements CommandLineRunner {

    @Autowired
    private BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        LoadBeerObjects();
    }

    // Seeder that populates Beer table
    private void LoadBeerObjects() {
        // If no data in table
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                                    .beerName("Mango Bobs")
                                    .beerStyle("IPA")
                                    .quantityToBrew(200)
                                    .price(10.0)
                                    .upc(3370100000L)
                                    .minOnHand(10)
                                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("Pale_Ale")
                    .quantityToBrew(200)
                    .price(10.0)
                    .upc(3370100022L)
                    .minOnHand(10)
                    .build());
        }
    }
}
