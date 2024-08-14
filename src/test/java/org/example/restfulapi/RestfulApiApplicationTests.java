package org.example.restfulapi;

import org.example.restfulapi.Entiry.Information;
import org.example.restfulapi.Repository.InfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
class RestfulApiApplicationTests {


    @Autowired
    InfoRepository repository;

    @Test
    void Register() {

        Information information = Information.builder()
                .ny(21)
                .nx(22)
                .category("LGT")
                .baseDate(20240814)
                .baseTime(1200).build();
        System.out.println(repository.save(information));
    }

    @Test
    @Transactional
    void getInformation() {

        Long id = 1L;
        Optional<Information> information  = repository.findById(id);
        information.ifPresent(info -> {
            System.out.println("Category: " + info.getCategory());
            System.out.println("Base Date: " + info.getBaseDate());
            System.out.println("Base Time: " + info.getBaseTime());
        });
        System.out.println("Info======================" + information);

    }
}
