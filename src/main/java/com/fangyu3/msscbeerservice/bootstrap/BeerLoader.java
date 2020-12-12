package com.fangyu3.msscbeerservice.bootstrap;


import com.fangyu3.msscbeerservice.domain.Beer;
import com.fangyu3.msscbeerservice.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// This class will run everytime spring context starts
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

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
                                    .upc(BEER_1_UPC)
                                    .minOnHand(10)
                                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("ALE")
                    .quantityToBrew(200)
                    .price(10.0)
                    .upc(BEER_2_UPC)
                    .minOnHand(10)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("No Hammers On the Bar")
                    .beerStyle("ALE")
                    .quantityToBrew(200)
                    .price(12.0)
                    .upc(BEER_3_UPC)
                    .minOnHand(10)
                    .build());
        }
    }
}
