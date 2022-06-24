package com.example.demo;

import com.example.demo.entities.Boisson;
import com.example.demo.entities.Fruit;
import com.example.demo.entities.Legume;
import com.example.demo.entities.Viand;
import com.example.demo.repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaSpringResaurantApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringResaurantApplication.class, args);
    }

/*
    @Bean
    CommandLineRunner commandLineRunner(BoissonRepository boissonRepository,
                                        ViandRepository viandRepository,
                                        FruitRepository fruitRepository,
                                        LegumeRepository legumeRepository) {
        return args -> {
            boissonRepository.save(new Boisson("Boisson", "Coca", 20));
            boissonRepository.save(new Boisson("Eau", "Sidi Ali", 100));
            boissonRepository.save(new Boisson("Boisson", "7up", 70));
            boissonRepository.save(new Boisson("Jus", "Jus Oranges", 20));
            boissonRepository.save(new Boisson("Cafe", "Cappuccino", 20));


            viandRepository.save(new Viand("Cheval", 30));
            viandRepository.save(new Viand("Oiseau", 50));
            viandRepository.save(new Viand("Mouton", 90));

            fruitRepository.save(new Fruit("Fraise", 20));
            fruitRepository.save(new Fruit("Orange", 40));
            fruitRepository.save(new Fruit("Banane", 20));
            fruitRepository.save(new Fruit("Pome", 50));


            legumeRepository.save(new Legume("Concombre",10));
            legumeRepository.save(new Legume("Echalote",5));
            legumeRepository.save(new Legume("Pomme de terre",20));
            legumeRepository.save(new Legume("Ail",30));


        };
    }

 */

}
